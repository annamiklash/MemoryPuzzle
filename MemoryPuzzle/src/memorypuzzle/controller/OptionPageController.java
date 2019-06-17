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
import memorypuzzle.view.GameBoard;

import java.io.IOException;

public class OptionPageController {

    private final Stage stage;
    @FXML
    private SplitMenuButton splitButtonDifficulty;
    @FXML
    private TextField nameTextField;

    public OptionPageController(Stage stage) {
        this.stage = stage;
    }

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
    public void onStartButtonClick(ActionEvent event) throws IOException {
        final GameBoard gameBoard = new GameBoard();
        final GameController gameController = new GameController(stage,
                gameBoard,
                DifficultyLevelEnum.valueOf(splitButtonDifficulty.getText()),
                nameTextField.getText());
    /*
    checks if name is empty string
     */

        if (nameTextField.getText().equals("") || nameTextField.getText().equals("ENTER YOUR NAME")) {

            nameTextField.setText("ENTER YOUR NAME");
            nameTextField.setOnMousePressed(event1 -> nameTextField.setText(""));
        } else { //if everything is checked - starts game
            startGame(event, gameBoard);
        }
    }

    private void startGame(ActionEvent event, GameBoard gameBoard) {
        final Scene scene = ((Node) event.getSource()).getScene();

        final BorderPane mainPage = (BorderPane) scene.getRoot();
        mainPage.setCenter(gameBoard);
        stage.hide();
        stage.show();
    }
}
