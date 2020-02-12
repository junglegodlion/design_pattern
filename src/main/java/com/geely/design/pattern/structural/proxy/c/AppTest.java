package com.geely.design.pattern.structural.proxy.c;

import java.util.Arrays;

/**
 * 针对于b包中的问题,我们提高代码的重用性:
 */
interface ICalc {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}

class CalcImpl implements ICalc {

    private void begin(String methodName,Object... params) {
        System.out.println(methodName +"方法开始，参数是："+ Arrays.toString(params));
    }

    private void end(Object r) {
        System.out.println("方法结束，结果是： " + r);
    }
    @Override
    public int add(int a, int b) {

        begin("add",a,b);
        int r =a+b;
        end(r);
        return r;
    }

    @Override
    public int sub(int a, int b) {
        begin("sub",a,b);
        int r =a-b;
        end(r);
        return r;
    }

    @Override
    public int mul(int a, int b) {
        begin("mul",a,b);
        int r =a*b;
        end(r);
        return r;
    }

    @Override
    public int div(int a, int b) {
        begin("div",a,b);
        int r =a/b;
        end(r);
        return r;
    }
}

/**
 * 目前的优点:
 * 1.提高代码重用
 * 2.如果需求再次变化,只需要该一个地方即可。
 * 没有解决:工
 * 1.代码急剧膨胀,核心业务代码,与非核心业务代码,耦合在一起!
 * 2.需求要求加入求余,开方立方.还必须在每个加入的新方法中,都手动调用一下 begin和end方法。
 *
 * 其是碰到这样的需求:早上6-12之间,不要日志,下午14-18之间要日志
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
