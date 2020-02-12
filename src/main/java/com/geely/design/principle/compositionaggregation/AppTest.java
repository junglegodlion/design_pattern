package com.geely.design.principle.compositionaggregation;

import java.util.Collection;
import java.util.HashSet;

/**
 * 需求：制作一个集合，要求该集合能记录曾今加过多少个元素(不是统计某一时刻集合中有多少个元素。)
 *
 * 举例：加入3个元素,(a,b,c)
 *      减去2个元素（a）
 *      返回：3（因为加入过3个元素）
 */

class Myset extends HashSet {

    private int count = 0;

    // 重写add方法
    @Override
    public boolean add(Object o) {

        count++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {

        System.out.println(count+"  " +c.size() +"~~~~");
        count += c.size();
        return super.addAll(c);
    }

    public int getCount() {
        return count;
    }
}

//问题是,在执行了 addAll之后, count不是3,而是6,为什么呢?因为 addAll回调了add方法
//所以,这样的代码没有解决需求。
//针对于a包的问题,add11会回调add方法,我们修改代码如下:把addA11删除掉,不要重写父类 HashSet的addA11了
//反正父类的addA11本身就会去回调add.


/**
 * 此时,这个代码看起来好像很完美,已经满足了需求了。
 * 问题是:目前这个代码,必须依赖于这样一个事实:就是 HashSet的addA11方法必须去回调add方法。
 * 万一在将来的jdk版本中, HashSet的addA11实现代码,突然不再回调add方法了,
 * 则在将来的这个jdk版本中,我们自定义的这个 MySet就被“撼动”
 * 比如: HashMap,在jdk1.6 1.7 1.8中,底层实现分别换了3次
 */
public class AppTest {

    public static void main(String[] args) {

        Myset myset = new Myset();

        HashSet<Object> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        myset.addAll(set);
        System.out.println(myset.getCount());
    }
}
