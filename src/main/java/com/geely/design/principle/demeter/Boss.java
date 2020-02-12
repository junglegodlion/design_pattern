package com.geely.design.principle.demeter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by geely
 */
public class Boss {

    // 给负责人下指令，查看课程数目
    // 这里的朋友有哪些？
    // TeamLeader作为入参，是直接的朋友
    // void作为输出，也是直接的朋友
    // 方法体内部的类不算是朋友，比如Course
    // Boss和TeamLeader是直接的关系，Boss不应该与陌生Course发生交流
    public void commandCheckNumber(TeamLeader teamLeader){

//        List<Course> courseList = new ArrayList<Course>();
//
//        // 一页一页查找课程
//        for(int i = 0 ;i < 20;i++){
//            courseList.add(new Course());
//        }
        teamLeader.checkNumberOfCourses();
    }

}
