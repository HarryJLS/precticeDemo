package com.jlstest.sysJobDemo.service;

import com.jlstest.sysJobDemo.entity.SysJob;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 14:43
 */
public interface ISysJobService {

    /**
     * 获取quartz调度器的计划任务列表
     */
    List<SysJob> selectJobList(SysJob job);

    /**
     * 通过调度任务ID查询调度信息
     */
    SysJob selectJobById(Long jobId);

    /**
     * 暂停任务
     */
    int pauseJob(SysJob job) throws SchedulerException;

    /**
     * 恢复任务
     */
    int resumeJob(SysJob job) throws SchedulerException;

    /**
     * 删除任务后，所对应的trigger也将被删除
     */
    int deleteJob(SysJob job) throws SchedulerException;

    /**
     * 批量删除调度信息
     */
    void deleteJobByIds(Long[] jobIds) throws SchedulerException;

    /**
     * 任务调度状态修改
     */
    int changeStatus(SysJob job) throws SchedulerException;

    /**
     * 立即运行任务
     */
    boolean run(SysJob job) throws SchedulerException;

    /**
     * 新增任务
     */
    int insertJob(SysJob job) throws SchedulerException;

    /**
     * 更新任务的时间表达式
     */
    int updateJob(SysJob job) throws SchedulerException;

    /**
     * 更新任务
     */
    void updateSchedulerJob(SysJob job, String jobGroup) throws SchedulerException;

    /**
     * 校验cron表达式是否有效
     */
    boolean checkCronExpressionIsValid(String cronExpression);

}
