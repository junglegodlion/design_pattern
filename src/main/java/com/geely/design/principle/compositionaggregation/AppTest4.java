package com.geely.design.principle.compositionaggregation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 需求：制作一个集合，要求该集合能记录曾今加过多少个元素(不是统计某一时刻集合中有多少个元素。)
 * 针对于之前提出的2个问题
 *  修改代码如下:
 * 1.我们的 MySet,再也不要去继承 HashSet了。
 * 2.取而代之,我们让MySetHashSet和发生关联关系(组合)
 */

class Myset4 extends HashSet {

    private Set set = new HashSet();

    private int count = 0;

    // 重写add方法
    public boolean add(Object o) {

        count++;
        return set.add(o);
    }

    public boolean addAll(Collection c) {

       count += c.size();
       return set.addAll(c);
    }

    public int getCount() {
        return count;
    }
}


/**
 *此时,可以说一声:完美。
 * 组合的优点,我们已经体会到了。
 * 问题是:
 * 1.难道以后都不能使用继承了吗?
 * 2.难道以后都不能进行方法重写了吗?
 * 如果父类作者,和子类的作者,不是同一个人。就别继承。
 * 那么父类作者,不知道,未来的子类,会重写自己的哪个方法。
 * 那么子类作者,不知道,未来的父类,会加入什么新方法,
 * 如果父类作者,和子类的作者,就是同一个人,那就可以放开手脚去使用继承了
 * 自己当然知道,每个方法都是什么作用。作者可以同时控制父类和子类。
 * 我们自己写代码,继承,重写,随便使用。
 * 如果我们仅仅是为了复用代码,而继承别人的类,难免出现“沟通”上的问题。
 */
public class AppTest4 {

    public static void main(String[] args) {

        Myset4 myset = new Myset4();

        HashSet<Object> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        myset.addAll(set);
        myset.add("d");
        System.out.println(myset.getCount());
    }
}
