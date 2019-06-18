package memorypuzzle.controller.generator;

import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import memorypuzzle.model.Node;

import java.util.List;

public class GridPaneGenerator {

    /**
     * sets location for each Image on Grid Pane (Nodes)
     */
    public static void generateNodesGridPane(GridPane gridPane, List<Node> nodeList, int columnNumber) {
        for (int count = 0, i = 1, j = 0; count < nodeList.size(); count++) {
            if (j == columnNumber) {
                j = 0;
                i++;
            }

            gridPane.add(nodeList.get(count), j, i);
            j++;

        }
    }

    /**
     * sets location for timer
     */
    public static void locateTimer(GridPane gridPane, Text timer, int columnNumber) {
        GridPane.setHalignment(timer, HPos.CENTER);
        gridPane.add(timer, columnNumber - 1, 0);
    }

    /**
     * sets location for mouse clicks counter
     */
    public static void locateClickNumberTextBox(GridPane gridPane, Text clickNumberTextBox) {
        gridPane.add(clickNumberTextBox, 0, 0, 2, 1);
    }
}
