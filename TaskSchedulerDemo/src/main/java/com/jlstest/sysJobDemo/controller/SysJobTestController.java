package com.jlstest.sysJobDemo.controller;

import javax.annotation.Resource;

import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.response.JlsTestResponse;
import com.jlstest.sysJobDemo.entity.SysJob;
import com.jlstest.sysJobDemo.service.SysJobService;

/**
 * @author JLS
 * @description:
 * @since 2024-02-20 10:16
 */
@RestController
@RequestMapping("/sysJobTest")
public class SysJobTestController {

    @Resource
    private SysJobService sysJobService;

    /**
     * 新增任务
     */
    @PutMapping("/insertJob")
    public JlsTestResponse<Object> insertJob(@RequestBody SysJob job) throws SchedulerException {
        int i = sysJobService.insertJob(job);
        if (i > 0) {
            return JlsTestResponse.sendSuccess("新增成功");
        } else {
            return JlsTestResponse.sendFailure("新增失败");
        }
    }

    /**
     * 暂停任务
     */
    @PostMapping("/pauseJob")
    public JlsTestResponse<Object> pauseJob(@RequestBody SysJob job) throws SchedulerException {
        int i = sysJobService.pauseJob(job);
        if (i > 0) {
            return JlsTestResponse.sendSuccess("暂停成功");
        } else {
            return JlsTestResponse.sendFailure("暂停失败");
        }
    }

    /**
     * 恢复任务
     */
    @PostMapping("/resumeJob")
    public JlsTestResponse<Object> resumeJob(@RequestBody SysJob job) throws SchedulerException {
        int i = sysJobService.resumeJob(job);
        if (i > 0) {
            return JlsTestResponse.sendSuccess("恢复成功");
        } else {
            return JlsTestResponse.sendFailure("恢复失败");
        }
    }

    /**
     * 删除任务
     */
    @DeleteMapping("/deleteJob")
    public JlsTestResponse<Object> deleteJob(@RequestBody SysJob job) throws SchedulerException {
        int i = sysJobService.deleteJob(job);
        if (i > 0) {
            return JlsTestResponse.sendSuccess("删除成功");
        } else {
            return JlsTestResponse.sendFailure("删除失败");
        }
    }

}
