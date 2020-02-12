package com.geely.design.pattern.creational.factorymethod;

/**
 *针对于简单工厂的问题:
 * 修改代码如下,使用工厂方法设计模式。
 */

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

// 具体产品
class RiceNoodle implements Food {

    @Override
    public void eat() {
        System.out.println("吃过桥米线！！！");
    }
}


interface FoodFactory {
    public Food getFood();
}

class HamburgerFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new Hamburger();
    }
}

class RiceNoodleFactory implements FoodFactory {

    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
}

class Bussiness {
    public static void taste(FoodFactory ff) {
        Food f = ff.getFood();
        System.out.println("评委1，品尝");
        f.eat();

        Food f2 = ff.getFood();
        System.out.println("评委2，品尝");
        f2.eat();

        Food f3 = ff.getFood();
        System.out.println("评委3，品尝");
        f3.eat();
    }
}


//=======================================================

class Lp implements Food {

    @Override
    public void eat() {
        System.out.println("从小就吃凉皮");
    }
}

class LpFactory implements FoodFactory {

    @Override
    public Food getFood() {

        return new Lp();
    }
}

/**
 * 工厂方法
 * 优点:
 *  1.仍然具有简单工厂的优点:服务器端修改了具体产品的类名以后,客户端不知道!
 *  2.当客户端需要扩展一个新的产品时,不需要修改作者原来的代码,只是扩展一个新的工厂而已!
 * 杠点:
 *  1.我们已经知道,简单工厂也好,工厂方法也好,都有一个优点,就是服务器端的具体产品类名变化了以后,客户端不知道!
 *  但是,反观我们现在的代码,客户端仍然依赖于具体的工厂的类名呀!此时,如果服务器端修改了具体工厂的类名,
 *  那么客户端也要随之一起修改!感觉折腾了一圈,又回到了原点!!!
 *      解释:
 *          工厂的名字,是为视为接口的。作者有责任,有义务,保证工厂的名字是稳定的。
 *          也就是说,虽然客户端依赖于工厂的具体类名,可是在工T业内,
 *          所有工厂的名字都是趋向于稳定(并不是100%不会变)。至少工厂类的名字,
 *          要比具体产品类的名字更加稳定!
 *   2.既然产品是我们自己客户端扩展出来的,那为什么不直接自己实例化呢?
 *   毕竟这个扩展出来的Lp这个产品,我们自己就是作者。我们想怎么改类名
 *    自己都能把控!为什么还要为自己制作的产品做工厂呢?
 *      解释:
 *          因为,作者在开发功能时,不仅仅只会开发一些抽象产品、具体产品、对应的工厂,还会配套地搭配一些提前做好的框架。
 *
 *   3.现在制作出 LpFactory,是为了能把 LpFactory传入给. taste方法,所以,必须定义这个 LpFactory.那为什么不从一开始,
 *   就让 Bussiness. taste方法就直接接受Food参数呢?而不是现在的 FoodFactory作为参数。
 *      解释：如果这样做的话，又会回到一开始的问题，当服务端修改一个类的名字的时候。客户端的代码可能用不了
 * 缺点:
 *      如果有多个产品等级,那么工厂类的数量,就会爆炸式增长!
 */
public class AppTest {

    public static void main(String[] args) {

        FoodFactory ff = new HamburgerFactory();
//        Food food = ff.getFood();
//        food.eat();

        Bussiness.taste(ff);

    }
}
