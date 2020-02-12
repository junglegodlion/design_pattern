package com.geely.design.pattern.creational.builder.c;

/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象,以及给该对象的属性赋值。
 *
 * 针对于b包中的问题,修改代码如下:
 * 针对于不同需求,我们需要创建不同的建造者,来分别生产不同配置的产品
 */
class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}

// 电脑建造者类,建造者类,必须关联电脑产品
class AdvanceComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 8750HK");
        computer.setGpu("rtx2080ti");
        computer.setMemory("32g");
        computer.setHd("2T机械");
        return computer;
    }
}

class MiddleComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 7700hq");
        computer.setGpu("gtx1060");
        computer.setMemory("16g");
        computer.setHd("2T机械");
        return computer;
    }
}

class LowComputerBuilder {

    private Computer computer = new Computer();

    public Computer build() {
        computer.setCpu("i7 7500u");
        computer.setGpu("gtx940mx");
        computer.setMemory("8g");
        computer.setHd("1T机械");
        return computer;
    }
}
// ====================================================================================

/**
 *这仍然不是建造者模式:
 * 优点:
 * 1.可以根据客户端的不同需求,使用不同的建造者来生产产品
 * 缺点:
 * 1.我们发现,多个不同的建造者中的代码在重复!既然代码中出现了重复的代码,那就有了“坏味道”!
 * 2.建造的过程不稳定,如果在某个建造者创建产品的过程中,漏掉了某一步,编译器也不会有报错!
 * (相当于,KFC的某一家分店,制作汉堡包的流程突然少了某一个步骤,出来的汉堡包味道就变了!因为没有标准!)
 */
public class AppTest {
    public static void main(String[] args) {

        // 创造一个建造者
        AdvanceComputerBuilder acb = new AdvanceComputerBuilder();
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        LowComputerBuilder lcb = new LowComputerBuilder();

        // 玩游戏
        Computer c = acb.build();
        System.out.println(c);

        // 开发
        Computer c2 = mcb.build();
        System.out.println(c2);

        // 开发娱乐
        Computer c3 = lcb.build();
        System.out.println(c3);
    }
}
