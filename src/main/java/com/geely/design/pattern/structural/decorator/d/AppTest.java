package com.geely.design.pattern.structural.decorator.d;

/**
 * 业务场景:星巴克卖咖啡,一开始,只有4种咖啡:
 *  Decaf Espresso DrakRoast HouseBlend
 * 因为所有咖啡都有共性,所有开发人员,把它们的共性上提到一个父类中: Beverage
 *
 * 针对于c包的问题,我们,要使用“装饰器设计模式”来解救我们!
 */

abstract class Beverage {
    private String description;



    public Beverage(String description) {
        this.description = description;
    }

    public abstract double cost() ;

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

// 调料类
/**
 * 判断两个类之间能不能有继承关系,
 * 主要看这两个类之间有没有“is a”关系。并且还要符合里氏替换原则
 * 以上只是原则,不是语法强制的!也就是说,在特定情况下,
 * 可以违反这个规则,必须在装饰器模式中就是这样:
 * 尽管调料不是饮料,但是为了制作出装饰器模式,我们也只能让调料去继承饮料!
 */
abstract class Condiment extends Beverage{

    // 让调料类,关联饮料类
    // 使用protected是为了让子类也能使用
    protected Beverage beverage;
    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }
}

class Decaf extends Beverage {

    public Decaf() {
        super("无咖啡因咖啡");
    }

    @Override
    public double cost() {

        // 咖啡本身价格 + 调料价格
        return 1;
    }
}

class Espresso extends Beverage {

    public Espresso() {
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 2;
    }
}

class DrakRoast extends Beverage {

    public DrakRoast() {
        super("焦炒咖啡");
    }

    @Override
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 1.5;
    }
}

class HouseBlend extends Beverage {

    public HouseBlend() {
        super("混合咖啡");
    }

    @Override
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 3 ;
    }
}

class Milk extends Condiment {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() +0.2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 牛奶";
    }
}

class Soy extends Condiment {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() +0.3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 豆浆";
    }
}

class Mocha extends Condiment {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() +0.4;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 摩卡";
    }
}

class Bubble extends Condiment {

    public Bubble(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() +0.1;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 泡沫";
    }
}

// =======================================================================

class Tea extends Beverage {

    public Tea() {
        super("茶");
    }

    @Override
    public double cost() {
        return 2;
    }
}

class GouQi extends Condiment {

    public GouQi(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 1;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " 枸杞";
    }
}

/**
 * 优点:
 * 1.加一个新的饮料,不会违反开闭原则
 * 2.加一个新的调料,也不会违反开闭原则
 *
 * 缺点:
 * 1.类还是优点多,但是我们已经尽力了
 */
public class AppTest {
    public static void main(String[] args) {
        Beverage b = new Tea();
//        Milk m = new Milk(b);
//        Mocha mc = new Mocha(m);

        Beverage b2 = new Milk(b);
        Beverage b3 = new Mocha(b2);
        Beverage b4 = new GouQi(b3);
        System.out.println(b4.getDescription() + ":" + b4.cost());

    }
}
