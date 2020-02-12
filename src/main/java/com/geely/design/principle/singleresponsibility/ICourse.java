package com.geely.design.principle.singleresponsibility;

/**
 * Created by geely
 * 这里没有遵守单一职责
 * 需要进行拆分
 */
public interface ICourse {

    /**获取课程信息*/
    String getCourseName();
    byte[] getCourseVideo();


    /**管理课程，和课程内容无关*/
    void studyCourse();

    // 退款操作
    // 退款之后，就无法获取课程名字与字节流
    // 这个操作影响上面两个操作
    // 所以可以拆分职责
    void refundCourse();

}
