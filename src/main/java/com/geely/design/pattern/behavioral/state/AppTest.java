package com.geely.design.pattern.behavioral.state;

/**
 * 场景：网站播放视频
 * 播放，暂停，快进
 */

/**
 * 播放的上下文
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
        // 设置上下文
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
 * 播放状态
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
 * 播放状态
 */
class PlayState extends CourseVideoState {

    @Override
    public void play() {
        System.out.println("正常播放视频的状态");
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
 * 停止状态
 */
class StopState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("ERROR 停止状态不能快进");
    }

    @Override
    public void pause() {
        System.out.println("ERROR 停止状态不能暂停");
    }

    @Override
    public void stop() {
        System.out.println("停止播放视频的状态");
    }
}

/**
 * 快进状态
 */
class SpeedState extends CourseVideoState {

    @Override
    public void play() {
        super.courseVideContext.setCourseVideoState(CourseVideContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("快进正常播放视频的状态");
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
 * 暂停状态
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
        System.out.println("暂停视频的状态");
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
        System.out.println("当前状态" + courseVideContext.getCourseVideoState().getClass().getSimpleName());
        courseVideContext.pause();
        System.out.println("当前状态" + courseVideContext.getCourseVideoState().getClass().getSimpleName());
        courseVideContext.speed();
        System.out.println("当前状态" + courseVideContext.getCourseVideoState().getClass().getSimpleName());
        courseVideContext.stop();
        courseVideContext.speed();

    }
}
