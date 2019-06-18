package memorypuzzle.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import memorypuzzle.controller.generator.GridPaneGenerator;
import memorypuzzle.model.Node;

import java.util.List;

public class GameBoard extends GridPane {

    public GameBoard() {
        configureBoardLayout();
    }


    private void configureBoardLayout() {
        //Setting size for the pane
        this.setPrefSize(100, 100);

        //Setting the padding
        this.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        this.setVgap(5);
        this.setHgap(5);

        //Setting the Grid alignment
        this.setAlignment(Pos.CENTER);
    }

    public void initNodesLocation(List<Node> nodeList, int columnNumber) {
        GridPaneGenerator.generateNodesGridPane(this, nodeList, columnNumber);
    }

    public void initTimerLocation(Text timer, int columnNumber) {
        GridPaneGenerator.locateTimer(this, timer, columnNumber);
    }

    public void initClickNumberLocation(Text clickNumberTextBox) {
        GridPaneGenerator.locateClickNumberTextBox(this, clickNumberTextBox);
    }
}
