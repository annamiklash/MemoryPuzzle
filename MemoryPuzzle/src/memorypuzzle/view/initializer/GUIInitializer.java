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

    /**
     * loading fxml for result page
     * setting resultPage as center of MainPage
     */
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

    /**
     * creating gridPane with gameBoard, creating controller  and setting gameBoard as center
     */
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

    /**
     * initializing game launch window with settings
     */
    public static void initStartPage(Stage stage) {
        try {
            final GridPane optionPage = processOptionPage(); //loading center part of border pane on launch window from fxml
            final BorderPane mainPage = processMainPage(); //loading center part of border pane in game from fxml

            mainPage.setCenter(optionPage);

            //Setting title to the Stage
            stage.setTitle("Memory Puzzle");

            stage.setScene(new Scene(mainPage));

            stage.setResizable(false);

            //Displaying the contents of the stage
            //To make stage different size depending on game state
            stage.hide();
            stage.show();
        } catch (IOException e) {
            System.out.println("Error while initializing main page " );
            e.printStackTrace();
        }

    }

    /**
     * loader for launch window center grid pane
     */
    private static GridPane processOptionPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/OptionsPage.fxml")));
    }

    /**
     * loading game window
     */
    private static BorderPane processMainPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/MainPage.fxml")));
    }


    /**
     * loader for result window center grid pane
     */
    private static GridPane processResultPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/ResultPage.fxml")));
    }

}
