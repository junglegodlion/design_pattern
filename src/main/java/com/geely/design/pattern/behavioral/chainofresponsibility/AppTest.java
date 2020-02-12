package com.geely.design.pattern.behavioral.chainofresponsibility;

/**
 * �������γ̷�������
 */

import org.apache.commons.lang3.StringUtils;

/**
 * �γ�
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
 * ��׼��
 */
abstract class Approver {
    // ��ģʽ�Ĺؼ��ǣ�
    // �����������һ���Լ�����׼��
    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    // �����γ�
    public abstract void deploy(Course course) ;

}

class ArticleApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getArticle())) {
            System.out.println(course.getName() + "�����ּǣ���׼");
            if (approver != null) {
                approver.deploy(course);
            }
            }else {
            System.out.println(course.getName() + "û���ּǣ�����׼���̽���");
            return;
        }
    }
}

class VideoApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getVideo())) {
            System.out.println(course.getName() + "������Ƶ����׼");
            if (approver != null) {
                approver.deploy(course);
            }
            }else {
            System.out.println(course.getName() + "û����Ƶ������׼���̽���");
            return;
        }
    }
}

public class AppTest {
    public static void main(String[] args) {
        Approver articleApprover = new ArticleApprover();
        Approver videoApprover = new VideoApprover();

        Course course = new Course();
        course.setName("Java���ģʽ");
        course.setArticle("java�ּ�");
        course.setVideo("Java��Ƶ");

        articleApprover.setNextApprover(videoApprover);
        articleApprover.deploy(course);
    }
}
