package com.jlstest.threadPoolTaskSchedulerDemo.service;

import com.jlstest.threadPoolTaskSchedulerDemo.entity.CronEntity;

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
    void startCron(CronEntity cron);

    /**
     * 结束定时任务
     * 
     * @param cron
     *            定时任务信息
     */
    void stopCron(CronEntity cron);

    /**
     * 修改定时任务
     */
    void changeCron(CronEntity cron);
}
