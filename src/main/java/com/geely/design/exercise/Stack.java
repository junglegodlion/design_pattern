package com.geely.design.exercise;

import java.util.LinkedList;

public class Stack<T> {

    // 组合优于继承
    private LinkedList<T> list = new LinkedList<>();

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        return list.removeLast();
    }
}
