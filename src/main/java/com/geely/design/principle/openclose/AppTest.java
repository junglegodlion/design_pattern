package com.geely.design.principle.openclose;

/**
 * 变化来了,现在所有汽车,需要打8折!!
 * 违反开闭原则的做法就是,直接打开Car的源代码,在 getPrice上修改
 * 符合开闭原则的做法就是,始终保证Car的源代码不会被修改,我们可以这样做:
 *  创建一个Car的子类重写getPrice的方法
 */
public class AppTest {

    public static void main(String[] args) {
//        Car car = new Car();

        DiscountCar car = new DiscountCar();
        car.setBrand("奔驰");
        car.setColor("黑色");
        car.setLouyou(true);
        car.setPrice(666666);

        System.out.println(car.getPrice());
    }
}
