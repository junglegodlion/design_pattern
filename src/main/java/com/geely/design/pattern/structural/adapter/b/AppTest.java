package com.geely.design.pattern.structural.adapter.b;

import java.util.Arrays;


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

/**
 * 可以发现以下代码再重复
 */
public class AppTest {
    public static void main(String[] args) {
        String str = "how are you";
        Processor p = new Upcase();
        System.out.println("Using Processor:" + p.name());
        System.out.println(p.process(str));
        Processor p2 = new Downcase();
        System.out.println("Using Processor:" + p2.name());
        System.out.println(p2.process(str));
        Processor p3 = new Splitter();
        System.out.println("Using Processor:" + p3.name());
        System.out.println(p3.process(str));
    }
}
