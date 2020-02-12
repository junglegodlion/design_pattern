package com.geely.design.pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令
 */
interface Command {
    void execte();
}

/**
 * 课程视频
 */
class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open() {

        System.out.println(this.name + "课程视频开发");
    }

    public void close() {
        System.out.println(this.name + "课程视频关闭");


    }
}

/**
 * 开启命令
 */
class OpenCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public OpenCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execte() {

        courseVideo.open();
    }
}

/**
 * 关闭命令
 */
class CloseCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execte() {

        courseVideo.close();
    }
}

/**
 * 职工
 */
class Staff {
    private List<Command> commandList = new ArrayList<>();
    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void execteCommands() {
        for (Command command : commandList) {
            command.execte();
        }
        commandList.clear();
    }
}

public class AppTest {

    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("java学习");
        OpenCourseVideoCommand oc = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand cc = new CloseCourseVideoCommand(courseVideo);

        Staff staff = new Staff();
        staff.addCommand(oc);
        staff.addCommand(cc);

        staff.execteCommands();
    }
}
