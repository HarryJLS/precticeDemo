package com.jlstest.threadPoolTaskSchedulerDemo.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.example.common.exception.ServiceException;
import com.jlstest.threadPoolTaskSchedulerDemo.dao.CronManagementDao;
import com.jlstest.threadPoolTaskSchedulerDemo.entity.CronEntity;
import com.jlstest.threadPoolTaskSchedulerDemo.service.CronService;
import com.jlstest.threadPoolTaskSchedulerDemo.utils.CronUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JLS
 * @description:
 * @since 2023-02-03 09:40
 */
@Service
@Slf4j
public class CronServiceImpl implements CronService {

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Resource
    private CronManagementDao cronManagementDao;

    private final Map<Long, ScheduledFuture<?>> futureMap = new HashMap<>();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    // 初始化，当服务重启则重启对应的定时任务
    @PostConstruct
    public void init() {
        List<CronEntity> cronEntityList = cronManagementDao.selectCronManagementAll();

        // 校验是否有定时任务，如果有则启动
        if (CollectionUtils.isEmpty(cronEntityList)) {
            return;
        }
        // 遍历每个定时任务
        cronEntityList.forEach(cron -> {
            if (LocalDateTime.now().isAfter(cron.getDeadTime())) {
                cronManagementDao.deleteCronManagement(cron.getId());
                log.info("删除过期定时任务成功，任务id:{}，任务标题：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getStartTime(), cron.getDeadTime());
            } else {
                // 启动任务
                startCron(cron);
            }
        });
    }

    /**
     * 开始定时任务
     *
     * @param cron
     *            定时任务信息
     */
    @Override
    public void startCron(CronEntity cron) {
        if (futureMap.containsKey(cron.getId())) {
            log.warn("已经存在重复任务，任务id:{}，任务标题：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getStartTime(), cron.getDeadTime());
            return;
        }

        // 校验cron表达式是否合法
        if (CronUtils.isValid(cron.getCronExp())) {
            log.error("cron表达式不合法，报文：{}", JSON.toJSONString(cron));
            throw new ServiceException("cron表达式不合法");
        }

        // 校验时间，通过后开始设置定时任务
        if (LocalDateTime.now().isBefore(cron.getDeadTime()) || cron.getDeadTime() == null) {

            // 校验cron表达式是否合法
            CronUtils.isValid(cron.getCronExp());
            ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(new MyRunnable(cron), new CronTrigger(cron.getCronExp()));
            // 插入数据库
            if (cron.getId() == null) {
                cronManagementDao.insertCronManagement(cron);
            }
            futureMap.put(cron.getId(), future);
            log.info("启动定时任务成功，任务id:{}，任务标题：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getStartTime(), cron.getDeadTime());
        }
    }

    /**
     * 结束定时任务
     *
     * @param cron
     *            定时任务信息
     */
    @Override
    public void stopCron(CronEntity cron) {
        ScheduledFuture<?> future = futureMap.get(cron.getId());
        if (future != null) {
            future.cancel(true);
            futureMap.remove(cron.getId());
            log.info("关闭定时任务成功，任务id:{}，任务标题：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getStartTime(), cron.getDeadTime());
            cronManagementDao.deleteCronManagement(cron.getId());
        }
    }

    /**
     * 修改定时任务
     *
     * @param cron
     *            定时任务信息
     */
    @Override
    public void changeCron(CronEntity cron) {
        // 先停止，在开启.
        stopCron(cron);
        cron.setId(null);
        startCron(cron);
    }

    private class MyRunnable implements Runnable {
        private CronEntity cron;

        public MyRunnable(CronEntity cron) {
            this.cron = cron;
        }

        @Override
        public void run() {
            // 检查当前时间是否已经到了任务的截止时间
            if (LocalDateTime.now().isEqual(cron.getDeadTime()) || LocalDateTime.now().isAfter(cron.getDeadTime())) {
                // 如果已经到了截止时间，那么停止任务
                stopCron(cron);
            }
            // 校验当前时间是否已经到了任务指定的开始执行时间,没到则不指定定时任务
            if (LocalDateTime.now().isBefore(cron.getStartTime())) {
                log.info("任务还未到开始时间，任务id：{}", cron.getTitle());
                return;
            }

            // 定义任务要做的事，完成任务逻辑
            log.info("定时任务测试，定时任务id：{}，当前时间为:{}", cron.getTitle(), LocalDateTime.now());
            // todo 可以根据任务id编写对应的定时任务逻辑
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
    }
}
