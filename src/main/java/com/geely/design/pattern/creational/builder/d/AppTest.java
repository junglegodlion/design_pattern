package com.geely.design.pattern.creational.builder.d;

/**
 * 需求:定义一个电脑类,并且实例化出电脑类的对象,以及给该对象的属性赋值。
 *针对于c包的问题,修改代码如下:
 * 创建一个建造者接口,把制作产品的具体步骤,稳定下来!
 * 我们让建造者类,去实现建造者接口,接口中的方法步骤,类就必须都要实现,少实现一个抽象方法就会报错!
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

interface ComputerBuilder {
    void setCpu();
    void setGpu();
    void setMemory();
    void setHd();
    Computer build();

}
// 电脑建造者类,建造者类,必须关联电脑产品
class AdvanceComputerBuilder implements ComputerBuilder{

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

class LowComputerBuilder implements ComputerBuilder{

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
// ====================================================================================

/**
 * 这还不是建造者模式:
 * 优点:
 * 建造者类中的建造过程是稳定的。不会漏掉某一步!!这样当客户端想扩展建造者时,也不会漏掉某一步。
 * 缺点:
 * 1.代码仍然有重复。
 * 2.现在又变成了客户端自己配置电脑,又违反了迪米特法则。
 * (这相当于,你去赛格电脑城配电脑,虽然不用你亲自组装电脑,但是你必须“指挥”那个装机boy,该装..该装..)
 */
public class AppTest {
    public static void main(String[] args) {

        // 玩游戏
        AdvanceComputerBuilder acb = new AdvanceComputerBuilder();
        acb.setCpu();
        acb.setGpu();
        acb.setMemory();
        acb.setHd();
        Computer c = acb.build();
        System.out.println(c);

        // 开发
        MiddleComputerBuilder mcb = new MiddleComputerBuilder();
        mcb.setCpu();
        mcb.setGpu();
        mcb.setMemory();
        mcb.setHd();
        Computer c2 = mcb.build();
        System.out.println(c2);

        // 开发娱乐
        LowComputerBuilder lcb = new LowComputerBuilder();
        lcb.setCpu();
        lcb.setGpu();
        lcb.setMemory();
        lcb.setHd();
        Computer c3 = lcb.build();
        System.out.println(c3);
    }
}
