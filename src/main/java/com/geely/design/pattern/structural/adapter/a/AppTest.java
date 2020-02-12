package com.geely.design.pattern.structural.adapter.a;

/**
 * 适配器
 * 一个类的接口转换成客户希望的另一个接口。
 * 适配器模式让那些接口不兼容的类可以一起工作
 *
 * 通俗一点的解释:
 * 根据已有接口,生成想要的接口!
 */

class Calc {
    public int add(int a,int b) {
        return a+b;
    }
}


// =============================================================

// 变化来了,客户端希望计算3个数的和,而alc的add方法只能接受2个参数!

// 做一个适配器
//class CalcAdapter extends Calc {
//    public int add(int a,int b,int c) {
//        return super.add(a,add(b,c));
//    }
//}

class CalcAdapter {
    private Calc calc;

    public CalcAdapter(Calc calc) {
        this.calc = calc;
    }

    public int add(int a,int b,int c) {
        return calc.add(a,calc.add(b,c));
    }
}


public class AppTest {
    public static void main(String[] args) {

        Calc c = new Calc();
        CalcAdapter ca = new CalcAdapter(c);
        int r = ca.add(1, 2,3);
        System.out.println(r);
    }
}
