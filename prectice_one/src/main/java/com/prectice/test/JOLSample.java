package com.prectice.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author JLS
 * @description: 用于查看对象内存布局
 * @since 2023-07-28 19:44
 */
public class JOLSample {

    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());

        System.out.println();
        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());

        System.out.println();
        ClassLayout layout2 = ClassLayout.parseInstance(new A());
        System.out.println(layout2.toPrintable());
    }

    // -XX:+UseCompressedOops           默认开启的压缩所有指针
    // -XX:+UseCompressedClassPointers  默认开启的压缩对象头里的类型指针Klass Pointer
    // Oops : Ordinary Object Pointers
    public static class A {
        //8B mark word
        //4B Klass Pointer   如果关闭压缩-XX:-UseCompressedClassPointers或-XX:-UseCompressedOops，则占用8B
        int id;        //4B
        String name;   //4B  如果关闭压缩-XX:-UseCompressedOops，则占用8B
        byte b;        //1B
        Object o;      //4B  如果关闭压缩-XX:-UseCompressedOops，则占用8B
    }
}
