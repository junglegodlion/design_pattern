package com.geely.design.pattern.structural.adapter.d;

import java.util.Arrays;

/**
 * 发现（即别人写的代码）了一组电子滤波器,它们看起来好像适用于 Apply.process方法
 * 即电子滤波器和语句处理器可以共用Apply.process这个逻辑
 */


// 波形
class WaveForm {

    // 静态属性属于整个类，而不是属于某个对象
    // 所以toString()方法中不含有该属性
    // 下面两句是id自增长的逻辑
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "WaveForm{" +
                "id=" + id +
                '}';
    }
}

// 滤波器
class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public WaveForm process(WaveForm input) {
        return input;
    }
}

// 低通滤波器
class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public WaveForm process(WaveForm input) {
        return input;//Dummy processing 虚假处理
    }
}

// 高通滤波器
class HighPass extends Filter {
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public WaveForm process(WaveForm input) {
        return input;//Dummy processing 虚假处理
    }
}

// 带通滤波器
class BandPass extends Filter {
    double lowCutoff,highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    public WaveForm process(WaveForm input) {
        return input;//Dummy processing 虚假处理
    }
}

//===================================================
// 处理器
class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;// 虚假处理（假设处理了）
    }
}

// 将输入变为大写
class Upcase extends Processor {
    // 注意：这里是重写而不是重载
    // Object/String 返回类型可以不一样
    // String是Object的子类
    @Override
    String process(Object input) {
        // 向下转型
        return ((String)input).toUpperCase();
    }
}

// 将输入变为小写
class Downcase extends Processor {
    // 注意：这里是重写而不是重载
    // Object/String 返回类型可以不一样
    // String是Object的子类
    @Override
    String process(Object input) {
        // 向下转型
        return ((String)input).toLowerCase();
    }
}

// 分割
// 按空格分割
class Splitter extends Processor {
    // 注意：这里是重写而不是重载
    // Object/String 返回类型可以不一样
    // String是Object的子类
    @Override
    String process(Object input) {
        // 向下转型
        return Arrays.toString(((String)input).split(" "));
    }
}

// 应用
class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor:" + p.name());
        System.out.println(p.process(s));
    }
}


// 恰好Processor和Filter中有相同的方法
public class AppTest {
    public static void main(String[] args) {
        String str = "how are you";

//        Apply.process(new Upcase(),str);
//        Apply.process(new Downcase(),str);
//        Apply.process(new Splitter(),str);


        /**可以看出下面的代码同样适用于Apply.process这个逻辑*/
        WaveForm wf = new WaveForm();

        Filter f = new LowPass(1);
        System.out.println("Using Processor:" + f.name());
        System.out.println(f.process(wf));

        Filter f2 = new HighPass(1);
        System.out.println("Using Processor:" + f2.name());
        System.out.println(f2.process(wf));

        Filter f3 = new BandPass(1,2);
        System.out.println("Using Processor:" + f3.name());
        System.out.println(f3.process(wf));

    }
}
