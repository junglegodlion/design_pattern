package com.geely.design.pattern.behavioral.templatemethod.b;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试 ArrayListLinkedList的增加效率,和查询效率
 *
 * 使用模板方法模式,解决a包中的问题:
 */

// 模板必须有方法体，所以这里使用抽象类
abstract class Template {

    public void template() {

        System.out.println("开始");
        long start = System.currentTimeMillis();

        code();
        long end = System.currentTimeMillis();
        System.out.println("结束："+ (end-start));
    }

    public abstract void code();
}

// ===========================================================

class A extends Template {

    @Override
    public void code() {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            list.add(0,1);

        }
    }
}

class B extends Template {

    @Override
    public void code() {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 10000; i++) {
            list.add(0,1);

        }
    }
}

public class AppTest {
    public static void main(String[] args) {

        Template t = new A();
        t.template();

        Template t2 = new B();
        t2.template();
    }
}
