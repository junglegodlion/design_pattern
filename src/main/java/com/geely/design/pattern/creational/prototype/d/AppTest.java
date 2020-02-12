package com.geely.design.pattern.creational.prototype.d;

import java.io.*;
import java.util.Date;

/**
 *
 * 针对于c包中的问题,修改代码如下:
 * 仅仅修改 WeekReport的clone的方法。
 * 序列化可以解决属性嵌套问题
 * 序列化天生就是深拷贝
 */
class WeekReport implements Cloneable, Serializable {
    private int id;
    private String emp;
    private String summary;
    private String plan;
    private String suggestion;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeekReport{" +
                "id=" + id +
                ", emp='" + emp + '\'' +
                ", summary='" + summary + '\'' +
                ", plan='" + plan + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", time=" + time +
                '}';
    }


    // 将protected改为public
    @Override
    public Object clone() throws CloneNotSupportedException {

        try {

            // ================存到文件中=======================
            // 字节流
            FileOutputStream out = new FileOutputStream("E:\\a.txt");
            // 对象流
            ObjectOutputStream oos = new ObjectOutputStream(out);

            // 序列化时,对象的所有属性层级关系会被序列化自动处理!!
            oos.writeObject(this);

            // 只需要关闭上层流
            oos.close();

            //===================从文件中读取=============================

            // 字节输入流
            FileInputStream in = new FileInputStream("E:\\a.txt");

            // 对象输入流
            ObjectInputStream ois = new ObjectInputStream(in);
            Object clone = ois.readObject();

            //关闭上层流
            ois.close();

            return clone;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 *此时,利用序列化+反序列化,已经简化了深拷贝的写法。
 * 问题是:
 * 序列化的目标位置是写死的,位置不应该写死linux下没有盘符!
 */
public class AppTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        // 第一周周报
        WeekReport wr = new WeekReport();
        wr.setEmp("张珊珊");
        wr.setSummary("讲解完7大原则");
        wr.setPlan("解决设计模式");
        wr.setSuggestion("无");
        wr.setTime(new Date());
        // 假设入库
        System.out.println(wr);

        WeekReport wr2 = (WeekReport) wr.clone();
        wr2.setSummary("讲解HTML");
        wr2.setPlan("解决CSS");

        // 假设入库
        System.out.println(wr2);
        System.out.println(wr2 == wr);

        wr2.getTime().setTime(0);

        /**我们希望克隆出来的副本对象,无论怎么修改它,都不会影响原来的对象!!*/
        System.out.println(wr);
        System.out.println(wr2);
    }
}
