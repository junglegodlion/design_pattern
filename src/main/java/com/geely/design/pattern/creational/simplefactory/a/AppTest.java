package com.geely.design.pattern.creational.simplefactory.a;

// 抽象产品
interface Food {
    void eat();
}

// 具体产品
class Hamburger implements Food {

    @Override
    public void eat() {
        System.out.println("吃汉堡包！！！");
    }
}


//=======================================================

/**
 * 这种设计相当脆弱!为什么呢?因为,只要作者修改了具体产品的类名,那么客户端代码,也要随之一起改变。
 * 这样服务器端代码,和客户端代码就是耦合的!
 * 我们希望的效果是,无论服务器端代码如何修改,客户端代码都应该不知道,不用修改客户端代码!
 */
public class AppTest {

    public static void main(String[] args) {
        Food f = new Hamburger();
        f.eat();
    }
}
