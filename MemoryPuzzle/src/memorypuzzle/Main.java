package memorypuzzle;

import javafx.application.Application;
import javafx.stage.Stage;
import memorypuzzle.view.initializer.GUIInitializer;

public class Main extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GUIInitializer.initStartPage(stage);
    }
}
