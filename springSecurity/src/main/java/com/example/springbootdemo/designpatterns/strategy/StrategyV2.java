package com.example.springbootdemo.designpatterns.strategy;

/**
 * @author JLS
 * @description:
 * @since 2023-05-14 13:57
 */
public class StrategyV2 {
    public static void main(String[] args) {

        Zombie zombie = new NormalZombie();
        zombie.display();
        zombie.attack();
        zombie.move();
    }
}

interface Moveable {
    void move();
}
interface Attackable {
    void attack();
}

abstract class Zombie {
    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    abstract public void display();
    Moveable moveable;
    Attackable attackable;
    abstract  void move();
    abstract  void attack();

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

class StepByStep implements Moveable {
    @Override
    public void move() {
        System.out.println("一步一步移动");
    }
}

class BiteAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("咬");
    }
}



class NormalZombie extends  Zombie {

    public NormalZombie() {
        super(new StepByStep(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println(" 我是普通僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

class FlagZombie extends Zombie {

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    public FlagZombie() {
        super(new StepByStep(), new BiteAttack());
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}
