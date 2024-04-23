package com.prectice.pollingDemo.controller;

import com.prectice.pollingDemo.service.PollingDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JLS
 * @description:
 * @since 2024-04-19 23:41
 */
@RestController
@RequestMapping("/polling")
public class PollingDemoController {

    private PollingDemoService pollingDemoService;

    public PollingDemoController(PollingDemoService pollingDemoService) {
        this.pollingDemoService = pollingDemoService;
    }

    @GetMapping("/start")
    public String start() {
        pollingDemoService.startTimer();
        return "success";
    }

    @GetMapping("/test")
    public String test() {
        pollingDemoService.reFresh();
        return "success";
    }
}
