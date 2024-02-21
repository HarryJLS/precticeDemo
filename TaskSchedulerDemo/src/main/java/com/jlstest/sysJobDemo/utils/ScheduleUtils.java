package com.jlstest.sysJobDemo.utils;

import com.jlstest.sysJobDemo.entity.SysJob;
import com.jlstest.sysJobDemo.task.Task1Job;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 14:46
 */
public class ScheduleUtils {

    /**
     * 创建定时任务
     * 
     * @param scheduler
     *            调度器
     * @param job
     *            定时任务信息
     * @throws SchedulerException
     */
    public static void createScheduleJob(Scheduler scheduler, SysJob job) throws SchedulerException {
        // 构建定时任务的触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression())).build();

        // 构建定时任务的JobDetail 如果有多种任务选择，则根据不同任务创建不同的JobDetail
        JobDetail jobDetail = JobBuilder.newJob(Task1Job.class).withIdentity(job.getJobId().toString(), job.getJobGroup()).build();

        // 将任务信息设置到JobDataMap中，传递给任务的执行方法
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put("job", job);

        // 调度器中添加触发器和JobDetail
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 根据任务ID和任务组名创建唯一的JobKey
     * 
     * @param jobId
     *            任务ID
     * @param jobGroup
     *            任务组名
     * @return 创建的JobKey对象
     */
    public static JobKey getJobKey(Long jobId, String jobGroup) {
        return new JobKey(String.valueOf(jobId), jobGroup);
    }
}
