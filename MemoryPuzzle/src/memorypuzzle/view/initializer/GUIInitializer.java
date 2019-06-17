package memorypuzzle.view.initializer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import memorypuzzle.controller.OptionPageController;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GUIInitializer {

    public static void init(Stage stage) {
        try{
            final GridPane optionPage = processOptionPage(stage); //center part of border pane on launch window
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
            stage.show();
        } catch (IOException e) {
            System.out.println("Error while start game " + e);
        }

    }

    public static GridPane processOptionPage(Stage stage) throws IOException {
        final FXMLLoader optionsPageLoader = new FXMLLoader(GUIInitializer.class.getClassLoader().getResource("GUI/OptionsPage.fxml")); //loader for launch window center grid pane
        final OptionPageController optionPageController = new OptionPageController(stage); //had to create controller here and attach it to fxml

        optionsPageLoader.setController(optionPageController);

        return optionsPageLoader.load();

    }

    public static BorderPane processMainPage() throws IOException {

        return FXMLLoader.load(Objects.requireNonNull(GUIInitializer.class.getClassLoader().getResource("GUI/MainPage.fxml"))); //loading game window
    }
}
