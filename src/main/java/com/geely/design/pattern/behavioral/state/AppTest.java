package com.geely.design.pattern.behavioral.state;

/**
 * ��������վ������Ƶ
 * ���ţ���ͣ�����
 */

/**
 * ���ŵ�������
 */
class CourseVideContext {

    private CourseVideoState courseVideoState;
    public final static PlayState PLAY_STATE = new PlayState();
    public final static StopState STOP_STATE = new StopState();
    public final static SpeedState SPEED_STATE = new SpeedState();
    public final static PauseState PAUSE_STATE = new PauseState();

    public CourseVideoState getCourseVideoState() {
        return courseVideoState;
    }

    public void setCourseVideoState(CourseVideoState courseVideoState) {
        this.courseVideoState = courseVideoState;
        // ����������
        this.courseVideoState.setCourseVideContext(this);
    }

    public void play() {
        this.courseVideoState.play();
    }
    public void speed() {
        this.courseVideoState.speed();
    }
    public void stop() {
        this.courseVideoState.stop();
    }
    public void pause() {
        this.courseVideoState.pause();
    }
}

/**
 * ����״̬
 */
abstract class CourseVideoState {
    protected CourseVideContext courseVideContext;

    public void setCourseVideContext(CourseVideContext courseVideContext) {
        this.courseVideContext = courseVideContext;
    }

    public abstract void play();
    public abstract void speed();
    public abstract void pause();
    public abstract void stop();
}

/**
 * ����״̬
 */
class PlayState extends CourseVideoState {

    @Override
    public void play() {
        System.out.println("����������Ƶ��״̬");
    }

    @Override
    public void speed() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PAUSE_STATE);
    }

    @Override
    public void stop() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.STOP_STATE);
    }
}

/**
 * ֹͣ״̬
 */
class StopState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("ERROR ֹͣ״̬���ܿ��");
    }

    @Override
    public void pause() {
        System.out.println("ERROR ֹͣ״̬������ͣ");
    }

    @Override
    public void stop() {
        System.out.println("ֹͣ������Ƶ��״̬");
    }
}

/**
 * ���״̬
 */
class SpeedState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("�������������Ƶ��״̬");
    }

    @Override
    public void pause() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PAUSE_STATE);
    }

    @Override
    public void stop() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.STOP_STATE);
    }
}

/**
 * ��ͣ״̬
 */
class PauseState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        System.out.println("��ͣ��Ƶ��״̬");
    }

    @Override
    public void stop() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.STOP_STATE);
    }
}


public class AppTest {
    public static void main(String[] args) {
        CourseVideContext courseVideContext = new CourseVideContext();
        courseVideContext.setCourseVideoState(new PlayState());
        System.out.println("��ǰ״̬" + courseVideContext.getCourseVideoState().getClass().getSimpleName());
        courseVideContext.pause();
        System.out.println("��ǰ״̬" + courseVideContext.getCourseVideoState().getClass().getSimpleName());
        courseVideContext.speed();
        System.out.println("��ǰ״̬" + courseVideContext.getCourseVideoState().getClass().getSimpleName());
        courseVideContext.stop();
        courseVideContext.speed();

    }
}
