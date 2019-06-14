package memorypuzzle.generator;

import memorypuzzle.controller.Controller;
import memorypuzzle.listener.ButtonListener;
import memorypuzzle.model.CustomButton;

public class ButtonsGenerator {

    public static CustomButton generate(int buttonNumber, int image, Controller controller) {
        final CustomButton customButton =
                new CustomButton("Button nr" + buttonNumber, image, buttonNumber);

        final ButtonListener buttonListener = new ButtonListener(controller, customButton);

        customButton.setOnMousePressed(buttonListener);
        customButton.setOnMouseReleased(buttonListener);

        return customButton;
    }
}
