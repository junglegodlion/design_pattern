package com.geely.design.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppTest {
    public static void main(String[] args) throws Exception{

        Class objectClass = HungrySingleton.class;

        Constructor constructor = objectClass.getDeclaredConstructor();

        constructor.setAccessible(true);
        HungrySingleton instance = HungrySingleton.getInstance();

        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance==newInstance);
    }
}
