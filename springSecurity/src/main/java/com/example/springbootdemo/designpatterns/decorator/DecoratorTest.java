package com.example.springbootdemo.designpatterns.decorator;

import java.sql.SQLOutput;

/**
 * @author JLS
 * @description: 装饰者模式，在不改变原有对象的基础上，将功能附加到对象上
 * @since 2023-05-13 20:45
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConreteDecorator2(new ConreteDecorator1(new ConcreteComponent()));

        component.operation();

    }
}
interface Component{
    void operation();
}
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

abstract class  Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConreteDecorator1 extends Decorator{

    public ConreteDecorator1 (Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜效果");
        component.operation();
    }
}

class ConreteDecorator2 extends Decorator {

    public ConreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加聚焦效果");
        component.operation();

    }
}
