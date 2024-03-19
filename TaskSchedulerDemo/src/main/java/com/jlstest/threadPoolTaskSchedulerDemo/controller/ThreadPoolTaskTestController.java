package com.jlstest.threadPoolTaskSchedulerDemo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.response.JlsTestResponse;
import com.jlstest.threadPoolTaskSchedulerDemo.entity.CronEntity;
import com.jlstest.threadPoolTaskSchedulerDemo.service.CronService;

/**
 * @author JLS
 * @description:
 * @since 2024-02-20 10:16
 */
@RestController
@RequestMapping("/threadPoolTaskTest")
public class ThreadPoolTaskTestController {

    @Resource
    private CronService cronService;

    /**
     * 新建定时任务
     */
    @PutMapping("/addCron")
    public JlsTestResponse<Object> addCron(@RequestBody CronEntity cronEntity) {
        // 新建定时任务
        cronService.startCron(cronEntity);
        return JlsTestResponse.sendSuccess("新建定时任务成功");
    }

    /**
     * 停止定时任务
     */
    @DeleteMapping("/stopCron")
    public JlsTestResponse<Object> stopCron(@RequestBody CronEntity cronEntity) {
        // 停止定时任务
        cronService.stopCron(cronEntity);
        return JlsTestResponse.sendSuccess("停止定时任务成功");
    }

    /**
     * 修改定时任务
     */
    @PostMapping("/updateCron")
    public JlsTestResponse<Object> updateCron(@RequestBody CronEntity cronEntity) {
        // 修改定时任务
        cronService.changeCron(cronEntity);
        return JlsTestResponse.sendSuccess("修改定时任务成功");
    }
}
