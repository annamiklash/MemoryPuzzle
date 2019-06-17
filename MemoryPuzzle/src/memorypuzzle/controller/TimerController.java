package memorypuzzle.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import memorypuzzle.controller.listener.TimerEventHandler;

public class TimerController {

    private Text timer;
    private Timeline timeline;
    /*
    A Timeline can be used to define a free form animation. Uses Key Frames. So "technically" not requiring another thread
     */

    public TimerController() {
        configureTimer();

        startTimer();
    }

    private void configureTimer() {
        timer = new Text("00:00:000");
        timer.setFont(new Font(18));


    }

    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new TimerEventHandler(timer)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    public String getGameTime() {
        timeline.stop();

        return timer.getText();
    }

    public Text getTimer() {
        return timer;
    }
}
