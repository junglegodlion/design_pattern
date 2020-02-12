package com.geely.design.pattern.behavioral.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * �γ�
 */
class Course  extends Observable {
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(Course course,Question question) {
        System.out.println(question.getUserName() + "��" + course.courseName + "�ύ��һ������");
        // ״̬�����ı�
        setChanged();
        notifyObservers(question);
    }
}

/**
 * ����
 */
class Question {
    private String userName;
    private String questionContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}

/**
 * ��ʦ
 */
class Teacher implements Observer {
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(teacherName + "��ʦ��" + course.getCourseName() +
                "�γ̽��ܵ�һ��" + question.getUserName() +
                "�ύ���ʴ�:" + question.getQuestionContent());
    }
}

/**
 * �۲����course
 * �۲�����teacher
 *
 */
public class AppTest {

    public static void main(String[] args) {
        Course course = new Course("java���ģʽ");
        Teacher teacher = new Teacher("jungle");
        Teacher teacher2 = new Teacher("top");

        // ��ӹ۲���
        course.addObserver(teacher);
        course.addObserver(teacher2);

        // **************ҵ���߼�����*******************
        Question question = new Question();
        question.setUserName("joey");
        question.setQuestionContent("java����ôѧ");

        course.produceQuestion(course,question);
    }
}
