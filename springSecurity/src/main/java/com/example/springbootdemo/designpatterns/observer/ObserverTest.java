package com.example.springbootdemo.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JLS
 * @description: 观察者模式  定义了对象之间的一对多依赖，让多个观察者对象发生变化时，
 * 它的所有依赖者都会收到通知并更新
 * @since 2023-05-14 14:54
 */
public class ObserverTest {
    public static void main(String[] args) {

        Subject subject = new Subject();
        Task1 task1 = new Task1();
        subject.addObserver(task1);
        Task2 task2 = new Task2();
        subject.addObserver(task2);

        subject.notifyObserver("xxxx");
    }
}

class Subject {
    // 容器
    private List<Observer> container = new ArrayList<>();
    // add
    public void addObserver(Observer observer) {
        container.add(observer);
    }
    // remove
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }
    public void notifyObserver(Object object) {
        for(Observer item : container) {
            item.update(object);
        }
    }
}
interface Observer {
    void update(Object object);
}

class Task1 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("task1 received:" + object);
    }
}
class Task2 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("task2 received : " + object);
    }
}
