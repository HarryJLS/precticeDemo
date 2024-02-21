package com.jlstest.sysJobDemo.task;

import com.alibaba.fastjson.JSON;
import com.jlstest.sysJobDemo.constant.ScheduleConstants;
import com.jlstest.sysJobDemo.entity.SysJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 14:50
 */
@Slf4j
public class Task1Job implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
//        log.info("参数：{}", JSON.toJSONString(mergedJobDataMap));

        String jobName = null;
        // 从 JobDataMap 中获取作业对象
        Object jobObject = mergedJobDataMap.get("job");
        if (jobObject instanceof SysJob) {
            SysJob job = (SysJob) jobObject;
            jobName = job.getJobName();

            String status = job.getStatus();
            if (ScheduleConstants.Status.PAUSE.getValue().equals(status)) {
                log.info("任务：{} --已暂停...", jobName);
                return;
            }
        }

        // 编写任务1的具体逻辑
        log.info("任务：{} --执行中...", jobName);
    }
}
