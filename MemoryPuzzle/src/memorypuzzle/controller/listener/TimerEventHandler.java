package memorypuzzle.controller.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class TimerEventHandler implements EventHandler<ActionEvent> {
    private final Text timer;

    private int mins = 0;
    private int secs = 0;
    private int millis = 0;

    public TimerEventHandler (Text timer) {
        this.timer = timer;
    }


    /*
    algorithm for counting millis, sec, min
     */

    @Override
    public void handle(ActionEvent event) {
        change(timer);
    }

    private void change(Text text) {
        if (millis == 1000) {
            secs++;
            millis = 0;
        }
        if (secs == 60) {
            mins++;
            secs = 0;
        }
        text.setText((((mins / 10) == 0) ? "0" : "") + mins + ":"
                + (((secs / 10) == 0) ? "0" : "") + secs + ":"
                + (((millis / 10) == 0) ? "00" : (((millis / 100) == 0) ? "0" : "")) + millis++);
    }

}
