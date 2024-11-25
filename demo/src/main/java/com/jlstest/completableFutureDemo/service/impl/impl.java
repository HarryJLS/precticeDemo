package com.jlstest.completableFutureDemo.service.impl;


import com.google.common.collect.Lists;
import com.jlstest.completableFutureDemo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


/**
 * @author JLS
 * @description:
 * @since 2023-10-13 16:42
 */
@Service
public class impl {

    private static final Logger LOG = LoggerFactory.getLogger(impl.class);

    @Resource
    private AsyncService asyncService;

    public void demo() {
        List<String> list = new ArrayList<>();
        List<List<String>> orderGroup = Lists.partition(list, 6);
//        List<CompletableFuture<List<String>>> futureList = new ArrayList<>();
//        for (List<String> splitList : orderGroup) {
//            try {
//                CompletableFuture<List<String>> future = asyncService.test(splitList);
//                futureList.add(future);
//            } catch (Exception e) {
//                LOG.error("", e);
//            }
//        }

        List<CompletableFuture<List<String>>> futureList = orderGroup.stream()
                .map(splitList -> asyncService.test(splitList)
                        .exceptionally(ex -> {
                            LOG.error("Error processing list: " + splitList, ex);
                            return Collections.emptyList(); // Return an empty list on error
                        }))
                .collect(Collectors.toList());

        // 等待线程执行结束，并结束的时候打印执行结果
        sequence(futureList).thenAccept(results -> {
            // Process combined results here
            results.forEach(result -> System.out.println("Processed result: " + result));
        }).join();
//        CompletableFuture.allOf(sequence(futureList)).join();
    }




    /**
     * 将一组 CompletableFuture 转换为一个 CompletableFuture，该 CompletableFuture 在所有的 CompletableFuture 完成时完成，
     * 并返回一个包含所有 CompletableFuture 结果的列表。
     *
     * @param futures 一个 CompletableFuture 对象的列表
     * @return 一个新的 CompletableFuture，当所有的 CompletableFuture 完成时完成，返回一个包含所有 CompletableFuture 结果的列表
     */
    private <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        return allDoneFuture.thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }
}
