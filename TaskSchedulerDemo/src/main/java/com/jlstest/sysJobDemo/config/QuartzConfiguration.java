package com.jlstest.sysJobDemo.config;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JLS
 * @description:
 * @since 2024-02-20 11:18
 */

@Configuration
public class QuartzConfiguration {

    @Bean
    public Scheduler scheduler() throws Exception {
        return StdSchedulerFactory.getDefaultScheduler();
    }
}
