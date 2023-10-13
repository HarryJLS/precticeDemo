package com.jlstest.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @className: AsyncService
 * @Description: TODO
 * @author: JLS
 * @date: 2023/10/13 16:53
 */
public interface AsyncService {

    CompletableFuture<List<String>> test(List<String> list);
}
