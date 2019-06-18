package memorypuzzle.controller;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ClickNumberController {

    /*
    controller for clicks counter
     */

    private Text clickNumberTextBox;
    private int clickNumber;

    public ClickNumberController() {
        clickNumber = 0;
        initTextBox();
        clickNumberTextBox.setFont(new Font(15));
    }

    private void initTextBox() {
        clickNumberTextBox = new Text("Clicks Counter " + clickNumber);
        clickNumberTextBox.setFont(new Font(12));
    }

    public void incrementClickNumber() {
        clickNumber++;
        clickNumberTextBox.setText("Clicks Counter: " + clickNumber);
    }

    public Text getClickNumberTextBox() {
        return clickNumberTextBox;
    }

    public int getClickNumber() {
        return clickNumber;
    }
}
