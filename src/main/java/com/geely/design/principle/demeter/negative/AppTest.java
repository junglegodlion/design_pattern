package com.geely.design.principle.demeter.negative;

class Computer {

    public void saveData() {
        System.out.println("保存数据");
    }

    public void killProcess() {
        System.out.println("关闭程序");
    }

    public void closeScreen() {
        System.out.println("关闭屏幕");
    }

    public void poweroff() {
        System.out.println("断电");
    }

}

class Person {
    private Computer c = new Computer();

    //此时,这个 Person对于Computer的细节就知道的太多了。
    //对于 Preson而言,只需要知道,关机按钮在哪就行,不需要知道如何保存数据,如何关闭进程,如果断电等等这些细节...
    //这样的话,代码的复杂度就提升了!! 万一用户使用不当,就有可能造成更大的损失。
    public void shutdownComputer() {
        c.saveData();
        c.killProcess();
        c.closeScreen();
        c.poweroff();
    }
}

public class AppTest {
    public static void main(String[] args) {

    }
}
