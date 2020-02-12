package com.geely.design.pattern.creational.prototype.e;

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

            // ================存到内存中=======================
            // 字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // 对象流
            ObjectOutputStream oos = new ObjectOutputStream(out);

            // 序列化时,对象的所有属性层级关系会被序列化自动处理!!
            oos.writeObject(this);

            // 只需要关闭上层流
            oos.close();

            //===================从内存中读取=============================

            byte[] bb = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bb);
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
 * 此时,这才是我们推荐的原型模式写法!!
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
