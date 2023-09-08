package com.example.springbootdemo.designpatterns.prototype;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * @author JLS
 * @description:
 * @since 2023-05-13 17:14
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        Product product = new Product("part1", "part2", 3, 4, 5);
        Product product1 = product.clone();

        System.out.println(product);
        System.out.println(product1);



    }

    public static void add(Integer i) {
        i++;
        System.out.println(i);
    }
}
class Product implements Cloneable {
    private String part1;
    private String part2;
    private Integer part3;
    private Integer part4;
    private Integer part5;

    public Product() {

    }
    public Product(String part1, String part2, Integer part3, Integer part4, Integer part5) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.part5 = part5;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Integer getPart3() {
        return part3;
    }

    public void setPart3(Integer part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }

    public Integer getPart5() {
        return part5;
    }

    public void setPart5(Integer part5) {
        this.part5 = part5;
    }


    @Override
    protected Product clone() throws CloneNotSupportedException {

        return (Product)super.clone();

//        // 可用序列化和反序列化实现深拷贝
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3=" + part3 +
                ", part4=" + part4 +
                ", part5=" + part5 +
                '}';
    }



}
