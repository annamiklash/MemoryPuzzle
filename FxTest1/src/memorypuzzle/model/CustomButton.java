package memorypuzzle.model;

import javafx.scene.control.Button;

public class CustomButton extends Button {

    private final int image;
    private final int number;
    private boolean isSelected;

    public CustomButton(String text, int image, int number) {
        super(text);

        this.image = image;
        this.number = number;
        this.isSelected = false;
    }

    public int getImage() {
        return image;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected() {
        isSelected = true;
        this.setText("Image: " + image);

    }

    public void setNotSelected() {
        isSelected = false;
        this.setText("Button nr" + number);
    }
}
