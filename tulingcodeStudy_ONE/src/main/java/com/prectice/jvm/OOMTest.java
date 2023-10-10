package com.prectice.jvm;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author JLS
 * @description:
 * @since 2023-08-04 19:21
 */
public class OOMTest {

    public static List<Object> list = new ArrayList<>();

    // JVM设置    
    // -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvm.dump
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
