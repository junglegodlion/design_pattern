package com.geely.design.pattern.creational.prototype.c;

import java.util.Date;

/**
 *
 * 针对于b包中的问题,修改代码如下:
 * 仅仅修改 WeekReport的clone的方法。
 */
class WeekReport implements Cloneable{
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

        // 深克隆
        WeekReport clone = (WeekReport) super.clone();
        Date clone2 = (Date) clone.getTime().clone();
        clone.setTime(clone2);
        return clone;
    }
}

/**
 * 目前已经达到了深拷贝的目的,也就是修改副本对象的任何属性,都对原有对象没有任何影响的!!
 * 问题是:
 *      如果对象深度比较深,则深拷贝实现起来很木乱
 *      比如 生日
 *              年
 *              月
 *              日
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
