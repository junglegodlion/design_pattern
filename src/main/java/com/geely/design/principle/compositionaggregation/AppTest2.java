package com.geely.design.principle.compositionaggregation;

import java.util.Collection;
import java.util.HashSet;

/**
 * 需求：制作一个集合，要求该集合能记录曾今加过多少个元素(不是统计某一时刻集合中有多少个元素。)
 * 针对于以上问题, MySet必须依赖于这样一个事实: addAll必须回调add,但是jdk未来的版本,不会做这个保证!
 * 修改代码如下:我们自己亲自重写addA1,这次重写 addAl1,不再让 count累加c.size()了,
 * 而是保证addA11一定会调用add
 */

class Myset2 extends HashSet {

    private int count = 0;

    // 重写add方法
    @Override
    public boolean add(Object o) {

        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {

        // 照着源码去写
        boolean bb = false;
        for (Object o : c) {
            if (add(o)) {
                bb = true;
            }
        }
        return bb;
    }

    public int getCount() {
        return count;
    }
}




/**
 * 此时,这个代码看起来好像很完美,已经满足了需求了。
 *
 *问题是:
 * 1.如果在新的jdk版本中, HashSet突然多了一个元素加入集合的入口方法: addSome,
 *  这个 addSome是我们始料未及的,我们的 MySet根本没有重写
 *  新版本中出现的 addSome方法。这样,在新版本中,
 *  我们的 MySetaddSome也继承了方法当使用 addSome方法添加元素时,
 *  根本不会去统计元素的数量。
 * 2.我们重写了adda11方法,和add方法,要知道,在 HashSet的所有方法中,难免有一些其他方法,会依赖于 addAll方法和add方法的.我们没头没脑
 * 地重写了别人类中的某些方法,就会导致其他依赖于些方法的方法,出现问题!
 */
public class AppTest2 {

    public static void main(String[] args) {

        Myset2 myset = new Myset2();

        HashSet<Object> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        myset.addAll(set);
        System.out.println(myset.getCount());
    }
}
