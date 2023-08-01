package com.prectice.test;

/**
 * @author JLS
 * @description:
 * @since 2023-07-23 15:40
 */

public class Math {
    public static final int initData = 666;

    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }

}