package com.geely.design.pattern.behavioral.strategy.a;

/**
 * 有一家游戏公司,制作一款鸭子游戏:在这个鸭子游戏中,
 * 角色都是鸭子,不同的鸭子之间,有共性,所以为了提高代码的重用性,
 * 开发人员,就制作了一个鸭子的父类:Duck,把这些鸭子的共性上提到父类中:
 */

abstract class Duck {

    // 鸭子叫
    public void quack() {
        System.out.println("嘎嘎");
    }

    public void swim() {
        System.out.println("游泳。。。。");
    }

    // 为什么是抽象类？
    // 因为鸭子的外观不一样
    public abstract void display();

}

class MallardDuck extends Duck {

    @Override
    public void display() {
        System.out.println("外观是野鸭！！");
    }
}

class RedHeadDuck extends Duck {

    @Override
    public void display() {
        System.out.println("外观是红头鸭！！");
    }
}

/**
 * 就目前而言,没有什么问题!请看下一个包!
 */
public class AppTest {

    public static void main(String[] args) {
        MallardDuck d = new MallardDuck();
        d.quack();
        d.swim();
        d.display();
    }
}
