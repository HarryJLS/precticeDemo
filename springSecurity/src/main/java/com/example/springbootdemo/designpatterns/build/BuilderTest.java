package com.example.springbootdemo.designpatterns.build;

/**
 * @author JLS
 * @description: 建造者模式
 * @since 2023-05-13 16:31
 */
public class BuilderTest {
    public static void main(String[] args) {
        Product product = new Product();


    }
}

interface  ProductBuilder {
    void builderProductName(String productName);
    void buildercompanyName(String companyName);
    void builderpart1(String part1);
    void builderpart2(String part2);
    void builderpart3(String part3);
    void builderpart4(String part4);
    Product build();
}
class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildercompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderpart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderpart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void builderpart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void builderpart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName, this.companyName, this.part1, this.part2, this.part3, this.part4);
    }
}
class Director {
    private ProductBuilder builder;
    public Product makeProduct(String productName, String companyName, String part1, String part2,
                               String part3, String part4) {
        builder.builderProductName(productName);
        builder.buildercompanyName(companyName);
        builder.builderpart1(part1);
        builder.builderpart2(part2);
        builder.builderpart3(part3);
        builder.builderpart4(part4);
        return builder.build();
    }
}

class Product {
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product() {}

    public Product(String productName, String companyName, String part1, String part2,
                   String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }
}
