package com.geely.design.pattern.behavioral.chainofresponsibility;

/**
 * 场景：课程发布过程
 */

import org.apache.commons.lang3.StringUtils;

/**
 * 课程
 */
class Course {
    private String name;
    private String article;
    private String video;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", article='" + article + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}

/**
 * 批准者
 */
abstract class Approver {
    // 该模式的关键是，
    // 类里面包含了一个自己的批准者
    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    // 发布课程
    public abstract void deploy(Course course) ;

}

class ArticleApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getArticle())) {
            System.out.println(course.getName() + "含有手记，批准");
            if (approver != null) {
                approver.deploy(course);
            }
            }else {
            System.out.println(course.getName() + "没有手记，不批准流程结束");
            return;
        }
    }
}

class VideoApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getVideo())) {
            System.out.println(course.getName() + "含有视频，批准");
            if (approver != null) {
                approver.deploy(course);
            }
            }else {
            System.out.println(course.getName() + "没有视频，不批准流程结束");
            return;
        }
    }
}

public class AppTest {
    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("Java设计模式");
        course.setArticle("java手记");
        course.setVideo("Java视频");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}
