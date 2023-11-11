package com.jlstest.service.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * @author JLS
 * @description:
 * @since 2023-10-18 16:38
 */
public class implTest {

    @Test
    public void demo() {
        // 准备测试数据
        long a = 2;
        long b = 3;

        // 执行要测试的代码

        int result = 2 + 3;

        // 定义模拟的 UserRepository 的行为
//        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // 验证是否为null
        Assert.assertNotNull(result);
        // 验证结果
        Assert.assertEquals(5, result);
        // 验证 UserRepository 中的方法是否被调用
//        verify(userRepository, times(1)).findById(1L);
    }
}
