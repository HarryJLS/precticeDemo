package com.jlstest.sysJobDemo.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 14:50
 */
public class Task1Job implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 编写任务1的具体逻辑
        System.out.println("任务1执行中...");
    }
}
