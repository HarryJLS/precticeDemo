//package com.example.springbootdemo.designpatterns.strategy;
//
///**
// * @author JLS
// * @description: 策略模式，定义了算法族，分别封装起来，让它们之间可以相互替换，
// * 此模式的变化独立于算法的使用者，案例，植物大僵尸游戏
// * @since 2023-05-13 22:42
// */
//public class StrategyTest {
//
//    public static void main(String[] args) {
//        AbstractZombie normalZombie = new NormalZombie();
//        AbstractZombie flagZombie = new FlagZombie();
//
//        normalZombie.display();
//        normalZombie.move();
//        normalZombie.attack();
//
//        System.out.println("==================");
//
//        flagZombie.display();
//        flagZombie.move();
//        flagZombie.attack();
//    }
//
//}
//
//abstract  class AbstractZombie {
//    public abstract void display();
//
//    public void attack() {
//        System.out.println("咬");
//    }
//
//    public void move() {
//        System.out.println("一步一步移动");
//    }
//}
//
//class NormalZombie extends AbstractZombie {
//    public void display() {
//        System.out.println("我是普通僵尸");
//    }
//}
//
//class FlagZombie extends AbstractZombie {
//    public void display() {
//        System.out.println("我是旗手僵尸");
//    }
//}
//
//class BigHeadZombie extends AbstractZombie {
//
//    public void display() {
//        System.out.println("大头");
//    }
//
//    @Override
//    public void attack() {
//        System.out.println("头撞");
//    }
//}