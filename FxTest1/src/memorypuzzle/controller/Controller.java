package memorypuzzle.controller;

import javafx.scene.layout.GridPane;
import memorypuzzle.generator.ButtonsGenerator;
import memorypuzzle.generator.GridPaneGenerator;
import memorypuzzle.model.CustomButton;
import memorypuzzle.model.SelectionEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Controller {
    private List<CustomButton> buttonList;


    public Controller() {

        ArrayList<Integer> imageList = buildImageList();

        initButtonList(imageList, 4);
    }

    private ArrayList<Integer> buildImageList() {
        ArrayList<Integer> imageList = new ArrayList<>();
        final Random randomGenerator = new Random();

        int actualImage = 0;
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                actualImage = randomGenerator.nextInt(100);
            }
            imageList.add(actualImage);
        }

        Collections.shuffle(imageList);

        return imageList;
    }

    private void initButtonList(List<Integer> imageList, int columnNumber) {
        buttonList = new ArrayList<>();

        for (int i = 0; i < columnNumber * columnNumber; i++) {
            buttonList.add(ButtonsGenerator.generate(i, imageList.get(i), this));
        }
    }

    public void initButtonsLocation(GridPane gridPane) {
        GridPaneGenerator.generateButtonsGridPane(gridPane, buttonList);
    }


    public void checkSelectedButtons(CustomButton actualButton) {
        int actualImage = actualButton.getImage();
        for (CustomButton button : buttonList) {
            if (button.isSelected()) {
                if (button.getImage() == actualImage) {
                    button.setVisible(false);
                    actualButton.setVisible(false);
                    break;
                }
            }
        }
    }

    public SelectionEnum validateSelection(CustomButton actualButton) {
        int selectedButtonCounter = 0;
        for (CustomButton button : buttonList) {
            if (button.isSelected()) {
                if (button.equals(actualButton)) {
                    return SelectionEnum.SELECTED_SAME_BUTTON;
                } else {
                    selectedButtonCounter++;
                }
            }
        }

        if (selectedButtonCounter == 1) {
            return SelectionEnum.ONE_BUTTON_SELECTED;
        }

        if (selectedButtonCounter == 2) {
            return SelectionEnum.TWO_BUTTONS_SELECTED;
        }

        return SelectionEnum.NO_BUTTON_SELECTED;
    }

    public void disableSelectedButtons() {
        for (CustomButton button : buttonList) {
            if (button.isSelected()) {
                button.setNotSelected();
            }
        }
    }

    public void handleSelection(CustomButton customButton) {
        final SelectionEnum selectionType = validateSelection(customButton);

        if (selectionType.equals(SelectionEnum.SELECTED_SAME_BUTTON)) {
            return;
        }

        if (selectionType.equals(SelectionEnum.ONE_BUTTON_SELECTED)) {
            checkSelectedButtons(customButton);
        }

        if (selectionType.equals(SelectionEnum.TWO_BUTTONS_SELECTED)) {
            disableSelectedButtons();
        }

        customButton.setSelected();
    }
}
