package com.geely.design.pattern.behavioral.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * 课程
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
        System.out.println(question.getUserName() + "在" + course.courseName + "提交了一个问题");
        // 状态发生改变
        setChanged();
        notifyObservers(question);
    }
}

/**
 * 提问
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
 * 教师
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
        System.out.println(teacherName + "老师的" + course.getCourseName() +
                "课程接受到一个" + question.getUserName() +
                "提交的问答:" + question.getQuestionContent());
    }
}

/**
 * 观察的是course
 * 观察者是teacher
 *
 */
public class AppTest {

    public static void main(String[] args) {
        Course course = new Course("java设计模式");
        Teacher teacher = new Teacher("jungle");
        Teacher teacher2 = new Teacher("top");

        // 添加观察者
        course.addObserver(teacher);
        course.addObserver(teacher2);

        // **************业务逻辑代码*******************
        Question question = new Question();
        question.setUserName("joey");
        question.setQuestionContent("java该怎么学");

        course.produceQuestion(course,question);
    }
}
