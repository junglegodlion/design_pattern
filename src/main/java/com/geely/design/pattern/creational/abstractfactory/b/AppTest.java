package com.geely.design.pattern.creational.abstractfactory.b;

/**
 * 针对于工厂方法的问题:当有多个产品等级时(食物、饮料、甜品),工厂类就会很多!!
 * 修改代码如下,使用抽象工厂设计模式。
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

interface Drink {
    public void drink();
}

class Cola implements Drink {

    @Override
    public void drink() {
        System.out.println("可口可乐。你值得拥有");
    }
}

class IcePeak implements Drink {

    @Override
    public void drink() {
        System.out.println("从小就喝冰峰");
    }
}

// 抽象工厂
interface Factory {
    public Food getFood();
    public Drink getDrink();
}

class KFCFactory implements Factory {


    @Override
    public Food getFood() {
        return new Hamburger();
    }

    @Override
    public Drink getDrink() {
        return new Cola();
    }
}

class SanQinFactory implements Factory {


    @Override
    public Food getFood() {
        return new RiceNoodle();
    }

    @Override
    public Drink getDrink() {
        return new IcePeak();
    }
}


class Bussiness {
    public static void taste(Factory ff) {
        Food f = ff.getFood();
        Drink d = ff.getDrink();
        System.out.println("评委1，品尝");
        f.eat();
        d.drink();

        Food f2 = ff.getFood();
        Drink d2 = ff.getDrink();
        System.out.println("评委2，品尝");
        f2.eat();
        d2.drink();

        Food f3 = ff.getFood();
        Drink d3 = ff.getDrink();
        System.out.println("评委3，品尝");
        f3.eat();
        d3.drink();
    }
}


//=======================================================

class Lp implements Food {

    @Override
    public void eat() {
        System.out.println("从小就吃凉皮");
    }
}

class Fenta implements Drink {

    @Override
    public void drink() {
        System.out.println("芬达，你值得拥有");
    }
}

class BaoJiFactory implements Factory {


    @Override
    public Food getFood() {
        return new Lp();
    }

    @Override
    public Drink getDrink() {
        return new Fenta();
    }
}


/**
 * 抽象工厂的
 * 优点:
 *      1.仍然有简单工厂和工厂方法的优点
 *      2.更重要的是,抽象工厂把工厂类的数量减少了!无论有多少个产品等级,工厂就一套。
 * 杠点:
 *      1.为什么三秦工厂中,就必须是米线搭配冰峰呢?为什么就不能是米线搭配可乐?
 *
 *      解释:
 *          抽象工厂中,可以生产多个产品,这多个产品之间,必须有内在联系。
 *          同一个工厂中的产品都属于同一个产品簇!!不能把不同产品簇中的产品混合到一个抽象工厂的实现类中。
 *
 * 缺点:
 *      1.当,产品等级发生变化时(增加产品等价、删除产品等价),都要引起所有以前工厂代码的修改,
 *      这就违反了“开闭原则”
 * 结论:
 *      当产品等级比较固定时,可以考虑使用抽象工厂,
 *      如果产品等价经常变化,则不建议使用抽象工厂。
 */
public class AppTest {

    public static void main(String[] args) {

//        Food food = ff.getFood();
//        food.eat();

        Bussiness.taste(new KFCFactory());

    }
}
