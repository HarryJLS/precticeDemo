package com.roy.springboot.config;

import com.roy.springboot.util.MyConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author roy
 * @desc 声明Stream队列
 */
@Configuration
public class StreamConfig {

    @Bean
    public Queue streamQueue() {
        Map<String,Object> params = new HashMap<>();
        params.put("x-queue-type","stream");
        params.put("x-max-length-bytes", 20_000_000_000L); // maximum stream size: 20 GB
        params.put("x-stream-max-segment-size-bytes", 100_000_000); // size of segment files: 100 MB

        return new Queue(MyConstants.QUEUE_STREAM,true,false,false,params);
    }
}
