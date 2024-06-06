package com.prectice.pollingDemo.controller;

import com.prectice.pollingDemo.service.PollingDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JLS
 * @description:
 * @since 2024-04-19 23:41
 */
@RestController
@RequestMapping("/polling")
public class PollingDemoController {

    private PollingDemoService pollingDemoService;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

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

    @GetMapping("/test11")
    public String stop() throws InterruptedException {
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement % 3 == 0) {
            return "fail";
        }
        Thread.sleep(1000);
        System.out.println("stop");
        return "success";
    }
}
