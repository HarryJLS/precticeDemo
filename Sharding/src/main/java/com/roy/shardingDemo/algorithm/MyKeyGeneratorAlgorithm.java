package com.roy.shardingDemo.algorithm;

import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @auth roykingw
 */
public class MyKeyGeneratorAlgorithm implements KeyGenerateAlgorithm {

    private AtomicLong atom = new AtomicLong(0);

    private Properties props;

    @Override
    public Comparable<?> generateKey() {
        LocalDateTime ldt = LocalDateTime.now();
        String timestampS = DateTimeFormatter.ofPattern("HHmmssSSS").format(ldt);
        return Long.parseLong(""+timestampS+atom.incrementAndGet());
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    public String getType() {
        return "MYKEY";
    }
    @Override
    public void init(Properties props) {
        this.props = props;
    }
}
