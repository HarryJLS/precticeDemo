package com.jlstest.threadPoolTaskSchedulerDemo.scheduledtask.service;

import com.jlstest.threadPoolTaskSchedulerDemo.scheduledtask.Cron;

/**
 * @className: CronService
 * @Description: TODO
 * @author: JLS
 * @date: 2023/2/3 9:39
 */
public interface CronService {

    /**
     * 开始定时任务
     * 
     * @param cron
     *            定时任务信息
     */
    void startCron(Cron cron);

    /**
     * 结束定时任务
     * 
     * @param cron
     *            定时任务信息
     */
    void stopCron(Cron cron);

    void changeCron(Cron cron);
}
