//package com.geely.design.exercise;
//
//
///**
// * 1.执行静态块
// * 2.执行构造代码块
// * 3.执行构造器
// * 注意
// *  类中的实例成员,等价于构造代码块。也就是说,构造代码块该执行的时候,也就会执行实例成员的代码
// *  类中的静态成员,等价于静态块。也就是说,静态块该执行的时候,也就会执行静态成员的代码
// *  静态方法不属于静态块
// */
//class Foo {
//
//    // 实例成员,
//    int a = 5;
//    // 静态成员
//    static int b = 10;
//
//    // 构造代码块
//    {
//        System.out.println("2");
//    }
//
//    public Foo() {
//        System.out.println("3");
//    }
//
//    static {
//        System.out.println("1");
//    }
//}
//
//public class AppTest {
//
//    public static void main(String[] args) {
//        new Foo();
//        new Foo();
//    }
//}
