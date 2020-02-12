package com.geely.design.principle.demeter.positive;

class Computer {

    private void saveData() {
        System.out.println("保存数据");
    }

    private void killProcess() {
        System.out.println("关闭程序");
    }

    private void closeScreen() {
        System.out.println("关闭屏幕");
    }

    private void poweroff() {
        System.out.println("断电");
    }

    public void shutDown() {
        saveData();
        killProcess();
        closeScreen();
        poweroff();
    }

}

class Person {

    private Computer c = new Computer();

    public void shutdownComputer() {
        c.shutDown();
    }
}

public class AppTest {
    public static void main(String[] args) {

    }
}
