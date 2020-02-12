package com.geely.design.pattern.behavioral.strategy.b;

/**
 * 游戏公司的老总们开会,得出一个提高本公司游戏竞争力的方案:
 *    要求让游戏中的鸭子能飞起来!
 * 把其他竞争者远远甩在身后!
 *
 * 程序猿就会想,是时候展现我们面向对象程序猿的威力了!
 * 我只需在父类Duck中,添加一个fly方法,那么所有Duck的子类,也都具备了f1y方法。
 */

abstract class Duck {

    // 鸭子叫
    public void quack() {
        System.out.println("嘎嘎");
    }

    public void swim() {
        System.out.println("游泳。。。。");
    }

    public void fly() {
        System.out.println("我飞。。。。");
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

class RubberDuck extends Duck {

    // 因为橡皮鸭不会想真实的鸭子一样叫,所有模拟了一下橡皮鸭特有的叫声
    // 所以重写了父类的 quack方法
    @Override
    public void quack() {
        System.out.println("吱吱叫。。。。");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }

    // 因为橡皮鸭不会飞。却又继承了Duck中的fy方法,所以我们可以像
    //重写 quack方法那样,去重写fy方法。

    @Override
    public void fly() {
        System.out.println("你行你上（橡皮鸭没有飞起来）");
    }
}

/**
 * 此时,问题看似解决了,但实际上出现了更麻烦的问题:所有Duck的子类鸭子,
 * 统统都会飞了!要知道,父类中的方法,并不是所有子类都能通用的!!
 * 比如:橡皮鸭!橡皮鸭是没有生命的,不能飞。
 * 结果因为继承了Duck,搞得橡皮鸭也能飞了!这样程序猿就会背锅,被老总批评
 */
public class AppTest {

    public static void main(String[] args) {
        MallardDuck d = new MallardDuck();
        d.quack();
        d.swim();
        d.fly();
        d.display();
    }
}
/**
 * 看起来,问题好像解决了,但是并没有,问题是,变化不断的出现,
 * 一会加个木头鸭子,一会加个鸭子超人,一会加个怪鸭伯爵
 * 程序猿就要在每次添加新的鸭子角色时,都会判断,新的鸭子角色不会不叫,会不会飞,
 * 针对于不同鸭子,要有不同的处理方法。
 * 这样也很麻烦,只不过是从一个噩梦跳入了另一个噩梦。
 */
