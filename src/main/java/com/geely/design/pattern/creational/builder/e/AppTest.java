package com.geely.design.pattern.creational.builder.e;

/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象,以及给该对象的属性赋值。
 * 针对于d包的问题,修改代码如下:
 * 建造者模式,终于进化出来了
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

// 稳定住建造过程
interface ComputerBuilder {
    void setCpu();
    void setGpu();
    void setMemory();
    void setHd();
    Computer build();

}

// 电脑建造者类,建造者类,必须关联电脑产品
class AdvanceComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();
    @Override
    public void setCpu() {
        computer.setCpu("i7 8750HK");
    }

    @Override
    public void setGpu() {
        computer.setGpu("rtx2080ti");
    }

    @Override
    public void setMemory() {
        computer.setMemory("32g");
    }

    @Override
    public void setHd() {
        computer.setHd("2T机械");
    }

    @Override
    public Computer build() {
        return computer;
    }
}

class MiddleComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void setCpu() {
        computer.setCpu("i7 7700hq");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx1060");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16g");
    }

    @Override
    public void setHd() {
        computer.setHd("2T机械");
    }

    @Override
    public Computer build() {
        return computer;
    }
}

class LowComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();
    @Override
    public void setCpu() {
        computer.setCpu("i7 7500u");
    }

    @Override
    public void setGpu() {
        computer.setGpu("gtx940mx");
    }

    @Override
    public void setMemory() {
        computer.setMemory("8g");
    }

    @Override
    public void setHd() {
        computer.setHd("1T机械");
    }

    @Override
    public Computer build() {
        return computer;
    }
}

// 指挥者
class Director {

    public Computer build(ComputerBuilder cb) {
        cb.setCpu();
        cb.setGpu();
        cb.setMemory();
        cb.setHd();
        return cb.build();
    }
}
// ====================================================================================


class MiddleHighComputerBuilder implements ComputerBuilder {

    private Computer c = new Computer();
    @Override
    public void setCpu() {
        c.setCpu("i5 8500hq");
    }

    @Override
    public void setGpu() {
        c.setGpu("gtx1070");
    }

    @Override
    public void setMemory() {
        c.setMemory("16g");
    }

    @Override
    public void setHd() {
        c.setHd("1T机械");
    }

    @Override
    public Computer build() {
        return c;
    }
}

/**
 *这就是建造者模式:
 * 优点:
 * 1,创建对象的过程稳定不变的(因为有 ComputerBuilder接口来稳定过程
 * 2.创建对象的过程只写了一次,没有重复代码(指挥者完成)
 * 3.当需要扩展指挥者的时候,不用修改之前的代码,这符合了开闭原则
 *
 * 建造者与工厂模式的区别:
 * 工程模式只需一个简单的new,new出产品即可。
 * 建造者更注重,在new出产品之后的,为产品属性赋值的过程!
 */
public class AppTest {
    public static void main(String[] args) {

        AdvanceComputerBuilder acb = new AdvanceComputerBuilder();
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        LowComputerBuilder lcb = new LowComputerBuilder();

        Director director = new Director();
        // 玩游戏
        Computer c = director.build(acb);
        System.out.println(c);

        // 开发
        Computer c2 = director.build(mcb);
        System.out.println(c2);

        // 办公娱乐
        Computer c3 = director.build(lcb);
        System.out.println(c3);

        MiddleHighComputerBuilder mhcd = new MiddleHighComputerBuilder();
        Computer c4 = director.build(mhcd);
        System.out.println(c4);


    }
}
