package memorypuzzle.view.initializer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import memorypuzzle.controller.GameController;
import memorypuzzle.model.DifficultyLevelEnum;
import memorypuzzle.view.GameBoard;

import java.io.IOException;
import java.util.Objects;


public class GUIInitializer {

    public static void initResultPage(Stage stage, BorderPane mainPage) {
        try {
            final GridPane resultPage = processResultPage();

            mainPage.setCenter(resultPage);

            stage.hide();
            stage.show();
        } catch (IOException e) {
            System.out.println("Error while initializing result page ");
            e.printStackTrace();
        }
    }

    public static void initGamePage(Stage stage, BorderPane mainPage, DifficultyLevelEnum difficultyLevel, String playerName) {
        final GameBoard gameBoard = new GameBoard();
        final GameController gameController = new GameController(stage,
                gameBoard,
                difficultyLevel,
                playerName);

        mainPage.setCenter(gameBoard);

        stage.hide();
        stage.show();
    }

    public static void initMainPage(Stage stage) {
        try {
            final GridPane optionPage = processOptionPage(); //center part of border pane on launch window
            final BorderPane mainPage = processMainPage(); //center part of border pane in game

            mainPage.setCenter(optionPage);

            //Setting title to the Stage
            stage.setTitle("Memory Puzzle");

            //Adding scene to the stage
            stage.setScene(new Scene(mainPage));

            //adding css
            mainPage.getStylesheets().add("GUI/mainpagestyle.css");
            optionPage.getStylesheets().add("GUI/optionpagestyle.css");

            stage.setResizable(false);

            //Displaying the contents of the stage
            stage.hide();
            stage.show();
        } catch (IOException e) {
            System.out.println("Error while initializing main page " );
            e.printStackTrace();
        }

    }

    public static GridPane processOptionPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/OptionsPage.fxml")));  //loader for launch window center grid pane
    }

    public static BorderPane processMainPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/MainPage.fxml"))); //loading game window
    }

    public static GridPane processResultPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/ResultPage.fxml")));  //loader for result window center grid pane
    }

}
