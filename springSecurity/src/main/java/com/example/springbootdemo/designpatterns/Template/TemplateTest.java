package com.example.springbootdemo.designpatterns.Template;

/**
 * @author JLS
 * @description: 模板方法
 * @since 2023-05-14 14:40
 */
public class TemplateTest {
    public static void main(String[] args) {

        AbstractClass abstractClass = new SubClass();
        abstractClass.operation();

    }
}

abstract class AbstractClass {
    public void operation() {
        System.out.println("pre。。");
        System.out.println("step1");
        templateMethod();
    }
    abstract protected  void templateMethod();
}

class SubClass extends  AbstractClass {
    @Override
    protected void templateMethod() {
        System.out.println("SubClass executed.......");
    }
}
