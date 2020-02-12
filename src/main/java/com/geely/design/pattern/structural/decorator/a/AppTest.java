package com.geely.design.pattern.structural.decorator.a;

/**
 * 业务场景:星巴克卖咖啡,一开始,只有4种咖啡:
 *  Decaf Espresso DrakRoast HouseBlend
 * 因为所有咖啡都有共性,所有开发人员,把它们的共性上提到一个父类中: Beverage
 */

abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Decaf extends Beverage {

    public Decaf() {
        super("无咖啡因咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

class Espresso extends Beverage {

    public Espresso() {
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 2;
    }
}

class DrakRoast extends Beverage {

    public DrakRoast() {
        super("焦炒咖啡");
    }

    @Override
    public double cost() {
        return 1.5;
    }
}

class HouseBlend extends Beverage {

    public HouseBlend() {
        super("混合咖啡");
    }

    @Override
    public double cost() {
        return 3;
    }
}

// =======================================================================

/**
 * 目前,这段代码,看起来是没有问题的。
 * 问题是,变化来了:
 * 星巴克的老板为了提高自身的竞争力,想出了一个新的业务:调料。也就是可以给咖啡中放调料:牛奶、豆浆、摩卡、泡沫(只是为了好玩)
 * 如何设计,以应对这种变化呢???
 */
public class AppTest {
    public static void main(String[] args) {
        Beverage b = new Decaf();
        System.out.println(b.getDescription() + ":" + b.cost());
    }
}
