package memorypuzzle.view;

import javafx.application.Application;
import javafx.stage.Stage;
import memorypuzzle.view.initializer.GUIInitializer;

import java.io.IOException;

public class Main extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        GUIInitializer.init(stage);
    }
}
