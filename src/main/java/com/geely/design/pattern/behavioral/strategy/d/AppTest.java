package com.geely.design.pattern.behavioral.strategy.d;

/**
 * 针对于c包中的问题,修改代码如下:
 * 是时候,把飞行和叫方法,从鸭子类中分离出来了!(注意,这里的分离,与c包中分离不一样
 */

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }
}

class FlyWithRocket implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("背上绑个窜天猴，飞");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}

interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}

class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

abstract class Duck {

    // 使用protected，子类就能使用
    protected FlyBehavior fb;
    protected QuackBehavior qb;

    public void performFly() {
        fb.fly();
    }

    public void performQuack() {
        qb.quack();
    }

    public void swim() {
        System.out.println("游泳。。。。");
    }

    public abstract void display();

    public FlyBehavior getFb() {
        return fb;
    }

    public void setFb(FlyBehavior fb) {
        this.fb = fb;
    }

    public QuackBehavior getQb() {
        return qb;
    }

    public void setQb(QuackBehavior qb) {
        this.qb = qb;
    }
}

class MallardDuck extends Duck {

    public MallardDuck() {
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }
    @Override
    public void display() {
        System.out.println("外观是野鸭！！");
    }

}

class RedHeadDuck extends Duck  {

    public RedHeadDuck() {
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是红头鸭！！");
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        this.fb = new FlyNoWay();
        this.qb = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }

}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        this.fb = new FlyNoWay();
        this.qb = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("外观是诱饵鸭");
    }
}
// ======================================================================

class FlyWithCat implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("头上顶个猫飞");
    }
}

/**
 *此时,针对于48种鸭子,有12种飞行方法而言,每种飞行方法,写1次!
 * 这就是传说中的策略模式:
 */
public class AppTest {

    public static void main(String[] args) {
        MallardDuck d = new MallardDuck();
        d.swim();
        d.display();
        d.performFly();
        d.performQuack();

        RubberDuck rd = new RubberDuck();
        rd.display();
        rd.performFly();

        // 可以运行改变策略
        rd.setFb(new FlyWithWings());
        rd.performFly();
        rd.setFb(new FlyWithCat());
        rd.performFly();

    }
}
/**
 */
