package com.jlstest.threadPoolTaskSchedulerDemo.scheduledtask;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author JLS
 * @description:
 * @since 2023-02-03 09:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Cron extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 执行时刻
     */
    private LocalTime executeTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 截止时间
     */
    private LocalDate deadTime;

    /**
     * 开始时间
     */
    private LocalDate startTime;
}
