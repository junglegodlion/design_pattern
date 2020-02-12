package com.geely.design.pattern.structural.proxy.b;

/**
 * 有以下功能:能做加减乘除的类
 */
interface ICalc {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}

class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        System.out.println("add方法开始，参数是："+a+"," +b);
        int r =a+b;
        System.out.println("add方法结束，结果是： " + r);
        return r;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub方法开始，参数是："+a+"," +b);
        int r =a-b;
        System.out.println("sub方法结束，结果是： " + r);
        return r;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul方法开始，参数是："+a+"," +b);
        int r =a*b;
        System.out.println("mul方法结束，结果是： " + r);
        return r;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div方法开始，参数是："+a+"," +b);
        int r =a/b;
        System.out.println("div方法结束，结果是： " + r);
        return r;
    }
}

/**
 * 目前,需求已经解决。但是,有问题:
 * 1.代码在重复。
 * 2.如果需求再次变化,使用英文输日志,就要改好多地方
 * 3.代码急剧膨胀,核心业务代码,与非核心业务代码,耦合在一起
 * 4.需求要求加入求余,开方立方。
 * 所以这种做法,太2了!
 */
public class AppTest {
    public static void main(String[] args) {
        CalcImpl c = new CalcImpl();
        c.add(1,2);
        c.sub(1,2);
        c.mul(1,2);
        c.div(1,2);

    }
}
