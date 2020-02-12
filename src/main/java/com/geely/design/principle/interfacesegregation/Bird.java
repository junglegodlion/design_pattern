package com.geely.design.principle.interfacesegregation;

/**
 * Created by geely
 */
public class Bird implements IAnimalAction {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }

    //很明显，鸟不会游泳，swim()这个方法会是个空实现
    @Override
    public void swim() {

    }
}
