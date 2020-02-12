package com.geely.design.principle.compositionaggregation;

import java.util.Collection;
import java.util.HashSet;

/**
 * 需求：制作一个集合，要求该集合能记录曾今加过多少个元素(不是统计某一时刻集合中有多少个元素。)
 * 针对于之前提出的2个问题
 * 修改代码如下:
 * 1.我们不再重写add和addA11方法了。
 * 2.我们额外制作2个代替add和addAl的方法:add2，addall2
 *  还要在类的API文档中说明,每当使用add和adda11的时候,都去调用dd2和addall2
 */

class Myset3 extends HashSet {

    private int count = 0;

    // 重写add方法
    public boolean add2(Object o) {

        count++;
        return super.add(o);
    }

    public boolean addAll2(Collection c) {

        // 照着源码去写
        boolean bb = false;
        for (Object o : c) {
            if (add2(o)) {
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
 *此时,这个代码看起来好像很勉强,但是也是满足了需求了。
 * 问题是:
 * 1.目前这种情况对用户要求优点过分,用户必须看类的api文档,看完了还要乖乖地使用add2和addA112.不能写错
 * 2.更致命的问题是:就是那么寸,在jdk新版本中, HashSet恰恰多了一个api,叫add2和adda112.
 *
 * 继承,已经尽忠了
 */
public class AppTest3 {

    public static void main(String[] args) {

        Myset3 myset = new Myset3();

        HashSet<Object> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        myset.addAll2(set);
        System.out.println(myset.getCount());
    }
}
