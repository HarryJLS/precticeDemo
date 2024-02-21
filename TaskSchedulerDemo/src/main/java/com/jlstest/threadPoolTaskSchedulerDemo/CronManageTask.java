//package com.jlstest.threadPoolTaskSchedulerDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.jlstest.threadPoolTaskSchedulerDemo.service.CronService;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author JLS
// * @description:
// * @since 2023-02-03 09:45
// */
//@Component
//@Slf4j
//public class CronManageTask {
//
//    @Autowired
//    private CronService cronService;
//
//    @Scheduled(cron = "0 0 3 * * ?")
//    public void cronManage() {
////        暂未设置mybatisplus，先注释掉
////        // 获取数据库中所有的定时任务
////        List<Cron> list = cronService.list();
////        list.forEach(c -> {
////            if (LocalDate.now().isAfter(c.getDeadTime())) {
////                cronService.stopCron(c);
////                // 删除定时任务
////                cronService.removeById(c.getId());
////                log.info("删除过期定时任务成功，任务id:{}，任务标题：{}，任务提醒时刻：{}，任务开始时间：{}，任务截止时间：{}", c.getId(), c.getTitle(), c.getExecuteTime(), c.getStartTime(),
////                        c.getDeadTime());
////            } else {
////                log.info("尝试启动尚未start的定时任务，任务id:{}，任务标题：{}，任务提醒时刻：{}，任务开始时间：{}，任务截止时间：{}", c.getId(), c.getTitle(), c.getExecuteTime(), c.getStartTime(),
////                        c.getDeadTime());
////                cronService.startCron(c);
////            }
////        });
//    }
//}
