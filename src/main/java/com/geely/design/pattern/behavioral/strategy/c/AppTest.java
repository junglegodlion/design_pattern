package com.geely.design.pattern.behavioral.strategy.c;

/**
 *针对于b包中的问题:程序猿需要判断每个鸭子子类,谁不会不会叫,谁会不会飞,不会叫的,就重写 quack方法,不会飞的就重写fly方法。
 * 这个工作量是很大的!!
 * 我们希望那些不会飞鸭子,压根就没有f1y方法,不会叫的鸭子,压根就没有 quack方法
 *
 * 把这2个经常在子类中变化的方法,从父类中分出来,分成两个接口: Quackable, Flyable
 */

interface Flyable {
    void fly();
}

interface Quackable {
    void quack();
}

abstract class Duck {

    public void swim() {
        System.out.println("游泳。。。。");
    }


    // 为什么是抽象类？
    // 因为鸭子的外观不一样
    public abstract void display();

}

class MallardDuck extends Duck implements Flyable,Quackable{

    @Override
    public void display() {
        System.out.println("外观是野鸭！！");
    }

    @Override
    public void fly() {

        System.out.println("我飞");
    }

    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}

class RedHeadDuck extends Duck implements Flyable,Quackable{

    @Override
    public void display() {
        System.out.println("外观是红头鸭！！");
    }

    @Override
    public void fly() {
        System.out.println("我飞");
    }

    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}

class RubberDuck extends Duck implements Quackable{


    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }


    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

class DecoyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("外观是诱饵鸭");
    }
}
/**
 * 思考,这样问题解决了吗?没有!
 * 以前是:每加入一个新的鸭子角色,程序猿就要判断,这个新鸭子角色是否会飞,是否会叫,不会飞的就重写飞方法,不会叫的就重写叫方法。
 * 现在是:每加入一个新的鸭子角色,程序猿就要判断,这个新鸭子角色是否会飞,是否会叫,不会飞的就不实现Flyable接口,不会叫的就不实现 Quackable接口
 * 如此,程序猿仍然没有减少工作量啊?仍然要不断地判断新鸭子角色!
 *
 * 另外一个缺点是,f1y和 quack方法没有重用性可言,比如48种鸭子有8种不会飞,那么飞方法就要在4日个鸭子子类重复4次
 *
 * 此时,应有杠:老师,从jdk1.8开始,接口中的方法就有默认实现
 *     此时,48种鸭子,有8种不会飞,那么飞方法只需要在Flyable中定义一个默认实现即可,只写1次。
 *
 * 解释:对于48种鸭子,有12种飞行方法,又该如何??飞行方法,仍然在子类中重复
 */
public class AppTest {

    public static void main(String[] args) {
        MallardDuck d = new MallardDuck();
        d.swim();
        d.display();

        RubberDuck rd = new RubberDuck();
        rd.display();
    }
}
/**
 */
