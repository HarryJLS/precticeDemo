package com.jlstest.sysJobDemo.utils;

import org.quartz.CronExpression;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 15:17
 */
public class CronUtils {

    /**
     * 验证给定的CRON表达式是否有效
     * 
     * @param cronExpression
     *            CRON表达式
     * @return 如果有效返回true，否则返回false
     */
    public static boolean isValid(String cronExpression) {
        try {
            // 使用Quartz提供的CronExpression类解析CRON表达式
            new CronExpression(cronExpression);
            return true;
        } catch (Exception e) {
            // 解析失败则说明不是有效的CRON表达式
            return false;
        }
    }
}
