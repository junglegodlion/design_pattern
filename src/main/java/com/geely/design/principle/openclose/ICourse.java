package com.geely.design.principle.openclose;

/**
 * Created by geely
 * 以I开头命名表明这是个接口
 */
public interface ICourse {

    // 课程id
    Integer getId();

    // 课程名称
    String getName();

    // 课程价格
    Double getPrice();


}
