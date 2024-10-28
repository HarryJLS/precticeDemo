package com.jlstest.optionalDemo;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author JLS
 * @description:
 * @since 2024-10-28 11:36
 */
public class OpetionalDemo {

    @Getter
    @Setter
    static class test {
        private String name;
        private String value;
    }
    public static void main(String[] args) {
        OpetionalDemo.test test = new OpetionalDemo.test();
        test.setName("name");
        test.setValue("value");
        Optional<OpetionalDemo.test> optional = Optional.ofNullable(test);
        System.out.println(optional.map(OpetionalDemo.test::getName).orElse("null"));
        System.out.println(optional.map(OpetionalDemo.test::getValue).orElse("null"));
    }
}
