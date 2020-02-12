package com.geely.design.pattern.structural.adapter.e;

import java.util.Arrays;

/**
 * 发现（即别人写的代码）了一组电子滤波器,它们看起来好像适用于 Apply.process方法
 * 即电子滤波器和语句处理器可以共用Apply.process这个逻辑
 *
 * 这里使用适配器模式
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

//========================================================================================
// 处理器
interface Processor {
    public String name() ;

    Object process(Object input) ;
}

// 为什么要定义这样一个抽象类？
// 因为实现了Processor接口的类的name()都一样
// 所以用这样一个抽象类，避免重复的不必要的代码
abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }
}

// 将输入变为大写
class Upcase extends StringProcessor {

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

// 将输入变为小写
class Downcase extends StringProcessor {

    @Override
    public Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}

// 分割
// 按空格分割
class Splitter extends StringProcessor {

    @Override
    public Object process(Object input) {
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

class FilterAdapter implements Processor {

    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public WaveForm process(Object input) {
        return filter.process((WaveForm) input);
    }
}

// 恰好Processor和Filter中有相同的方法
public class AppTest {
    public static void main(String[] args) {
        WaveForm wf = new WaveForm();
        Apply.process(new FilterAdapter(new LowPass(8)),wf);
        Apply.process(new FilterAdapter(new HighPass(8)),wf);
        Apply.process(new FilterAdapter(new BandPass(8,9)),wf);

    }
}
