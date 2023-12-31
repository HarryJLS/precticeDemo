package com.jlstest;

import cn.hutool.core.lang.id.NanoId;
import lombok.val;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author JLS
 * @description:
 * @since 2023-10-13 17:06
 */
public class Application {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + ":" + threadInfo.getThreadName());
        }
        String nanoId = NanoId.randomNanoId();

        System.out.println(nanoId);
    }
}
