package com.roy.shardingDemo;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.apache.shardingsphere.sharding.cosid.algorithm.keygen.CosIdKeyGenerateAlgorithm;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @auth roykingw
 */
public class InfraTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(NanoIdUtils.randomNanoId(ThreadLocalRandom.current(), NanoIdUtils.DEFAULT_ALPHABET, 21));
        }
    }
}
