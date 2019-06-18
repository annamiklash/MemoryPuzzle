package memorypuzzle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import memorypuzzle.model.DifficultyLevelEnum;
import memorypuzzle.view.initializer.GUIInitializer;

public class OptionPageController {

    @FXML
    private SplitMenuButton splitButtonDifficulty;
    @FXML
    private TextField nameTextField;

    @FXML
    public void onEasyDifficultyChosen() {
        splitButtonDifficulty.setText("EASY");
    }

    @FXML
    public void onMediumDifficultyChosen() {
        splitButtonDifficulty.setText("MEDIUM");
    }

    @FXML
    public void onHardDifficultyChosen() {
        splitButtonDifficulty.setText("HARD");
    }

    /*
    creates game board (grid pane) after clicking "start"
     */

    @FXML
    public void onStartButtonClick(ActionEvent event) {
    /*
    checks if name is empty string
     */
        if (nameTextField.getText().equals("") || nameTextField.getText().equals("ENTER YOUR NAME")) {

            nameTextField.setText("ENTER YOUR NAME");
            nameTextField.setOnMousePressed(event1 -> nameTextField.setText(""));
        } else { //if everything is checked - starts game
            startGame(event);
        }
    }

    @FXML
    public void onShowResultButtonClick(ActionEvent event) {
        final Scene scene = ((Node) event.getSource()).getScene();
        final BorderPane mainPage = (BorderPane) scene.getRoot();
        final Stage stage = (Stage) scene.getWindow();

        GUIInitializer.initResultPage(stage, mainPage);
    }

    private void startGame(ActionEvent event) {
        final Scene scene = ((Node) event.getSource()).getScene();
        final BorderPane mainPage = (BorderPane) scene.getRoot();
        final Stage stage = (Stage) scene.getWindow();

        GUIInitializer.initGamePage(stage, mainPage, DifficultyLevelEnum.valueOf(splitButtonDifficulty.getText()), nameTextField.getText());
    }
}
