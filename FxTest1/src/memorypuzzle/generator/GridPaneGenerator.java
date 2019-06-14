package memorypuzzle.generator;

import javafx.scene.layout.GridPane;
import memorypuzzle.model.CustomButton;

import java.util.List;

public class GridPaneGenerator {

    public static void generateButtonsGridPane(GridPane gridPane, List<CustomButton> buttonList) {
        int columnNumber = (int) Math.sqrt(buttonList.size());
        for (int count = 0, i = 0, j = 0; count < buttonList.size(); count++) {
            if (j == columnNumber) {
                j = 0;
                i++;
            }

            gridPane.add(buttonList.get(count), j, i);
            j++;

        }
    }

    /*
    i j
    0 0
    0 1
    1 0
    1 1
     */

}
