package memorypuzzle.controller;

import javafx.stage.Stage;
import memorypuzzle.controller.generator.NodeGenerator;
import memorypuzzle.controller.utils.FileUtil;
import memorypuzzle.model.CustomImage;
import memorypuzzle.model.DifficultyLevelEnum;
import memorypuzzle.model.Node;
import memorypuzzle.model.SelectionEnum;
import memorypuzzle.view.GameBoard;
import memorypuzzle.view.initializer.GUIInitializer;

import java.util.List;

public class GameController {
    private final Stage stage;

    private final TimerController timerController;
    private final ClickNumberController clickNumberController;
    private final GameBoard gameBoard;
    private final DifficultyLevelEnum difficultyLevel;
    private final String playerName;
    private List<Node> nodeList;

    public GameController(Stage stage, GameBoard gameBoard, DifficultyLevelEnum difficultyLevelEnum, String playerName) {
        this.stage = stage;
        this.gameBoard = gameBoard;
        this.difficultyLevel = difficultyLevelEnum;
        this.timerController = new TimerController();
        this.clickNumberController = new ClickNumberController();
        this.playerName = playerName;


        initGame();
    }

    public void handleSelection(Node actualNode) {
        final SelectionEnum selectionType = validateSelection(actualNode);

        if (selectionType.equals(SelectionEnum.SELECTED_SAME_NODE)) {
            return; // doesnt let you select the same node more than once
        }

        if (selectionType.equals(SelectionEnum.ONE_NODE_SELECTED)) {
            findPair(actualNode); //if there is one node selected - compares it with previously selected node
        }

        if (selectionType.equals(SelectionEnum.TWO_NODES_SELECTED)) {
            disableSelectedNodes(); //doesnt let you select more than 2 nodes
        }

        if (isGameOver(nodeList)) { //if the size of list of nodes is 0 than game's over
            gameOver();

        }

        actualNode.setSelected(); //default

        clickNumberController.incrementClickNumber(); // increments clicks counter after selection of a node
    }

    private void gameOver() {
        FileUtil.savingToFile(playerName, clickNumberController.getClickNumber(), timerController.getGameTime(), difficultyLevel); //saving results of a game to a file

        GUIInitializer.initMainPage(stage); //restarts game
    }

    private boolean isGameOver(List<Node> nodeList) {
        return nodeList.size() == 0;
    }

    private void initGame() {

        /*
        generating and initializing Grid, Timer and Clicks Counter
         */
        nodeList = NodeGenerator.generateNodeList(difficultyLevel.getColumnNumber(), this);

        gameBoard.initNodesLocation(nodeList, difficultyLevel.getColumnNumber());
        gameBoard.initTimerLocation(timerController.getTimer(), difficultyLevel.getColumnNumber());
        gameBoard.initClickNumberLocation(clickNumberController.getClickNumberTextBox());
    }


    private SelectionEnum validateSelection(Node actualNode) {
        int selectedButtonCounter = 0;
        for (Node node : nodeList) {
            if (node.isSelected()) {

                if (node.equals(actualNode)) { //if previous node u selected last time is the same that u've just selected

                    return SelectionEnum.SELECTED_SAME_NODE;
                } else {
                    selectedButtonCounter++;
                }
            }
        }

        if (selectedButtonCounter == 1) { //selected one
            return SelectionEnum.ONE_NODE_SELECTED;
        }

        if (selectedButtonCounter == 2) { //selected two
            return SelectionEnum.TWO_NODES_SELECTED;
        }

        return SelectionEnum.NO_NODE_SELECTED; //default
    }

    private void findPair(Node actualNode) { //checks if u found a pair
        final CustomImage actualImage = actualNode.getFaceImage();
        for (Node node : nodeList) {
            if (node.isSelected()) { //if its selected
                if (node.getFaceImage().equals(actualImage)) { //is they are the same
                    node.setVisible(false); //make them disappear
                    actualNode.setVisible(false);

                    nodeList.remove(node); //delete from the list in order to later check if the game is over
                    nodeList.remove(actualNode);

                    break;
                }
            }
        }
    }

    private void disableSelectedNodes() { //"unselect 2 nodes"
        for (Node node : nodeList) {
            if (node.isSelected()) {
                node.setNotSelected();
            }
        }
    }


}

