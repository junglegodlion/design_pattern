package com.geely.design.principle.dependenceinversion.positive;


//==========================作者=======================================

interface Animal {
    void eat();
}

class Person2 {

    public void feed(Animal a) {
        System.out.println("开始喂养。。。");
        a.eat();
    }
}

class Dog2 implements Animal{

    public void eat() {
        System.out.println("狗啃骨头");
    }
}


//===========================用户===========================================


/**
 * 变化来了:客户端不仅仅需要喂狗,还需要喂猫!
 * 客户端自己定义一个猫类
 */

class Cat implements Animal{
    public void eat() {
        System.out.println("猫吃鱼");
    }
}


class Tiger implements Animal {

    @Override
    public void eat() {
        System.out.println("老虎吃鸡");
    }
}

public class AppTest2 {

    public static void main(String[] args) {
        Person2 p = new Person2();
        Dog2 d = new Dog2();
        Cat c = new Cat();
        Tiger t = new Tiger();

        p.feed(d);
        p.feed(c);
        p.feed(t);


    }
}
