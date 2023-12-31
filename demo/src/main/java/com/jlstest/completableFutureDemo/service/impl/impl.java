package com.jlstest.completableFutureDemo.service.impl;



import com.google.common.collect.Lists;
import com.jlstest.completableFutureDemo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<CompletableFuture<List<String>>> futureList = new ArrayList<>();
        for (List<String> splitList : orderGroup) {
            try {
                CompletableFuture<List<String>> future = asyncService.test(splitList);
                futureList.add(future);
            } catch (Exception e) {
                LOG.error("", e);
            }
        }

        CompletableFuture.allOf(sequence(futureList)).join();
    }




    private <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        return allDoneFuture.thenApply(v -> futures.stream().map(future -> future.join()).collect(Collectors.toList()));
    }
}
