package com.geely.design.pattern.behavioral.templatemethod.a;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 ArrayListLinkedList的增加效率,和查询效率
 *
 * 此时,每次要测试的代码发生变化时,都势必要修改原有的代码,
 * 如果修改之后,又需要测试之前的代码,那么又要把之前的代码写回来!
 */
public class AppTest {
    public static void main(String[] args) {

        System.out.println("开始");
        long start = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 1000000; i++) {
            list.add(0,1);

        }
        long end = System.currentTimeMillis();
        System.out.println("结束："+ (end-start));
    }
}
