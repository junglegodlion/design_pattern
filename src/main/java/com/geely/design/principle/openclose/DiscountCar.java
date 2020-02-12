package com.geely.design.principle.openclose;

public class DiscountCar extends Car{

    @Override
    public double getPrice() {
        return super.getPrice() * 0.8;
    }
}
