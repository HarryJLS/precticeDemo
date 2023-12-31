package com.jlstest.completableFutureDemo.service.impl;

import com.jlstest.completableFutureDemo.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author JLS
 * @description:
 * @since 2023-10-13 16:53
 */
@Service
public class AsyncServiceImpl implements AsyncService {


    @Override
    @Async("线程池")
    public CompletableFuture<List<String>> test(List<String> list) {
        try {
            // todo 一系列的业务逻辑
            List<String> strList = new ArrayList<>();
            // 进行信息回传
            return CompletableFuture.completedFuture(strList);
        } finally {
            // todo
            System.out.println("示例代码");
        }
    }
}
