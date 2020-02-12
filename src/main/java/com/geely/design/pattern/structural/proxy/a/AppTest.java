package com.geely.design.pattern.structural.proxy.a;

/**
 * 有以下功能:能做加减乘除的类
 */
interface ICalc {
    int add(int a,int b);
    int sub(int a,int b);
    int mul(int a,int b);
    int div(int a,int b);
}

class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        int r =a+b;
        return r;
    }

    @Override
    public int sub(int a, int b) {
        int r =a-b;
        return r;
    }

    @Override
    public int mul(int a, int b) {
        int r =a * b;
        return r;
    }

    @Override
    public int div(int a, int b) {
        int r =a/b;
        return r;
    }
}

/**
 * 变化来了:要求,为每个方法,添加日志功能,在方法开始时,和结束时,分别打印出日志信息!
 * 在b包中加入日志功能
 */
public class AppTest {
    public static void main(String[] args) {
        CalcImpl c = new CalcImpl();
        System.out.println(c.add(1,2));
        System.out.println(c.sub(1,2));
        System.out.println(c.mul(1,2));
        System.out.println(c.div(1,2));
    }
}
