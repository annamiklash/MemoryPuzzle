package memorypuzzle.listener;

import javafx.event.Event;
import javafx.event.EventHandler;
import memorypuzzle.controller.Controller;
import memorypuzzle.model.CustomButton;

public class ButtonListener implements EventHandler {

    private final Controller controller;
    private final CustomButton customButton;
    private boolean isImage;

    public ButtonListener(Controller controller, CustomButton customButton) {
        this.controller = controller;
        this.customButton = customButton;
        this.isImage = false;
    }

    @Override
    public void handle(Event event) {
        if (!isImage) {
            controller.handleSelection(customButton);
        }

        isImage = !isImage;

    }
}
