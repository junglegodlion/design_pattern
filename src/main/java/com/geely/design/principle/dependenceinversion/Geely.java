package com.geely.design.principle.dependenceinversion;

/**
 * Created by geely
 *
 * 1.geely在学习慕课网课程的时候，具体的实现类交给高层模块（Test）,而不是针对geely
 * 这个实现类编写
 * 2.geely想学什么课，我们都可以在不动geely这个模块下任意修改
 */
public class Geely {

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    private ICourse iCourse;



    public void studyImoocCourse(){
        iCourse.studyCourse();
    }


}
