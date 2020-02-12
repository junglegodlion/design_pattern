package com.geely.design.principle.dependenceinversion.negative;


//==========================作者=======================================
class Person {

    public void feed(Dog dog) {
        System.out.println("开始喂养。。。");
        dog.eat();
    }
}

class Dog {

    public void eat() {
        System.out.println("狗啃骨头");
    }
}


//===========================用户===========================================

public class AppTest {

    public static void main(String[] args) {
        Person p = new Person();
        Dog d = new Dog();

        p.feed(d);
    }
}
