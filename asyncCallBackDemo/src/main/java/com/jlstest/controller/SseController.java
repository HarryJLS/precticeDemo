package com.jlstest.controller;

import java.io.IOException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author JLS
 * @description:
 * @since 2023-09-08 16:45
 */
@RestController
@RequestMapping("/sse")
public class SseController {

    // private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @GetMapping("/test")
    @CrossOrigin
    public String test() {

        // // 客户端关闭连接时移除 emitter
        // emitter.onCompletion(() -> emitters.remove(emitter));
        asyncMethod();

        return "success";
    }

    @Async
    protected void asyncMethod() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SseEmitter emitter = new SseEmitter();
        try {
            emitter.send("异步方法执行完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // // 用于向所有连接的客户端发送消息
    // public void sendToClients(String message) {
    // emitters.forEach(emitter -> {
    // try {
    // emitter.send(SseEmitter.event().data(message));
    // } catch (IOException e) {
    // emitter.complete();
    // emitters.remove(emitter);
    // }
    // });
    // }
}
