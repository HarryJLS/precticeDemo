package com.jlstest.threadPoolTaskSchedulerDemo.scheduledtask.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.jlstest.threadPoolTaskSchedulerDemo.scheduledtask.Cron;
import com.jlstest.threadPoolTaskSchedulerDemo.scheduledtask.service.CronService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JLS
 * @description:
 * @since 2023-02-03 09:40
 */
@Service
@Slf4j
public class CronServiceImpl implements CronService {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    private Map<String, ScheduledFuture<?>> futureMap = new HashMap<>();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    /**
     * 开始定时任务
     *
     * @param cron
     *            定时任务信息
     */
    @Override
    public void startCron(Cron cron) {
        if (futureMap.containsKey(cron.getId())) {
            log.warn("已经存在重复任务，任务id:{}，任务标题：{}，任务提醒时刻：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getExecuteTime(), cron.getStartTime(),
                    cron.getDeadTime());
            return;
        }
        if (LocalDate.now().isEqual(cron.getStartTime()) || LocalDate.now().isEqual(cron.getDeadTime())
                || (LocalDate.now().isAfter(cron.getStartTime()) && LocalDate.now().isBefore(cron.getDeadTime()))) {
            LocalTime executeTime = cron.getExecuteTime();
            // 生成cron表达式
            // String cronExp =
            // StringUtils.join(Integer.valueOf(executeTime.getSecond()).toString(), " ",
            // Integer.valueOf(executeTime.getMinute()).toString(),
            // " ", Integer.valueOf(executeTime.getHour()).toString(), " * * ?");
            String cronExp = "0/1 * * * * ? ";
            ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(new MyRunnable(cron), new CronTrigger(cronExp));
            futureMap.put(cron.getId(), future);
            log.info("启动定时任务成功，任务id:{}，任务标题：{}，任务提醒时刻：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getExecuteTime(), cron.getStartTime(),
                    cron.getDeadTime());
        }
    }

    /**
     * 结束定时任务
     *
     * @param cron
     *            定时任务信息
     */
    @Override
    public void stopCron(Cron cron) {
        ScheduledFuture<?> future = futureMap.get(cron.getId());
        if (future != null) {
            future.cancel(true);
            futureMap.remove(cron.getId());
            log.info("关闭定时任务成功，任务id:{}，任务标题：{}，任务提醒时刻：{}，任务开始时间：{}，任务截止时间：{}", cron.getId(), cron.getTitle(), cron.getExecuteTime(), cron.getStartTime(),
                    cron.getDeadTime());
        }
    }

    @Override
    public void changeCron(Cron cron) {
        stopCron(cron);// 先停止，在开启.
        startCron(cron);
    }

    private class MyRunnable implements Runnable {
        private Cron cron;

        public MyRunnable(Cron cron) {
            this.cron = cron;
        }

        @Override
        public void run() {
            // 定义任务要做的事，完成任务逻辑
            log.info("定时任务测试，定时任务id：{}", cron.getId());
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }
}
