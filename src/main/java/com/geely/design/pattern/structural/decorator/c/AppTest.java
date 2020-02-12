package com.geely.design.pattern.structural.decorator.c;

/**
 * 业务场景:星巴克卖咖啡,一开始,只有4种咖啡:
 *  Decaf Espresso DrakRoast HouseBlend
 * 因为所有咖啡都有共性,所有开发人员,把它们的共性上提到一个父类中: Beverage
 *
 * 针对于b包的问题,我们何必为每一种咖啡加每一种调料都创建一个类呢?这样做太2了,太笨了!
 * 我们可以直接在父类 Beverage中,添加4个 boolean属性,分别代表是否加了对应的4种调料啊!
 */

abstract class Beverage {
    private String description;

    private boolean milk,soy,mocha,bubble;

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isBubble() {
        return bubble;
    }

    public void setBubble(boolean bubble) {
        this.bubble = bubble;
    }

    public Beverage(String description) {
        this.description = description;
    }

    public  double cost() {
        double total = 0;
        if (milk) {
            total += 0.2;
        }
        if (soy) {
            total += 0.3;
        }
        if (mocha) {
            total += 0.4;
        }
        if (bubble) {
            total += 0.1;
        }
        return total;
    };

    public String getDescription() {
        String str = description;

        if (milk) {
           str = str + " 牛奶";
        }
        if (soy) {
            str = str + " 豆浆";
        }
        if (mocha) {
            str = str + " 摩卡";
        }
        if (bubble) {
            str = str + " 泡沫";
        }
        return str;
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

        // 咖啡本身价格 + 调料价格
        return 1 + super.cost();
    }
}

class Espresso extends Beverage {

    public Espresso() {
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 2 + super.cost();
    }
}

class DrakRoast extends Beverage {

    public DrakRoast() {
        super("焦炒咖啡");
    }

    @Override
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 1.5 + super.cost();
    }
}

class HouseBlend extends Beverage {

    public HouseBlend() {
        super("混合咖啡");
    }

    @Override
    public double cost() {
        // 咖啡本身价格 + 调料价格
        return 3 + super.cost();
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

/**
 *优点:
 * 1.类没有爆炸,没有出现各种各样的类!
 * 2.星巴克的老板,又加入了一个新的饮料:茶,不会带来什么影响。符合开闭原则的。
 * 缺点:
 * 1.星巴克的老板,又加入了一种新的调料:枸杞,就要重新改写父类 BerveragegetDisecription的cost方法和方法,来把枸杞家进去!
 * 这势必会违反开闭原则!
 */
public class AppTest {
    public static void main(String[] args) {
        Beverage b = new Decaf();
        b.setMilk(true);
        b.setSoy(true);
        System.out.println(b.getDescription() + ":" + b.cost());

        Beverage t = new Tea();
        t.setMilk(true);
        t.setSoy(true);
        t.setBubble(true);
        System.out.println(t.getDescription() + ":" + t.cost());
    }
}
