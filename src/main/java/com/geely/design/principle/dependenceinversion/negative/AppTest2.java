package com.geely.design.principle.dependenceinversion.negative;


//==========================作者=======================================
class Person2 {

    public void feed(Dog2 dog) {
        System.out.println("开始喂养。。。");
        dog.eat();
    }
}

class Dog2 {

    public void eat() {
        System.out.println("狗啃骨头");
    }
}


//===========================用户===========================================


/**
 * 变化来了:客户端不仅仅需要喂狗,还需要喂猫!
 * 客户端自己定义一个猫类
 */

class Cat {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AppTest2 {

    public static void main(String[] args) {
        Person2 p = new Person2();
        Dog2 d = new Dog2();
        Cat c = new Cat();

        p.feed(d);

        // 这里会报错？喂不了
//        p.feed(c);

        //此时,这种代码违反了依赖倒置,因为,每当下层变动时,上层都要跟着一起变动。
        //我们希望的是,当下层新增一个动物时,上层应该“不知道”,上层代码应该不用改动!
    }
}
