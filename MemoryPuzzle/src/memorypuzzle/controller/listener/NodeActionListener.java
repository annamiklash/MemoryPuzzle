package memorypuzzle.controller.listener;

import javafx.event.Event;
import javafx.event.EventHandler;
import memorypuzzle.controller.GameController;
import memorypuzzle.model.Node;

public class NodeActionListener implements EventHandler {

    private final GameController gameController;
    private final Node node;
    private boolean isImage;

    public NodeActionListener(GameController gameController, Node node) {
        this.gameController = gameController;
        this.node = node;
        this.isImage = false;
    }

    /**
     * checks whether it's a sleeve image or actual image. if later - then calls function
     * to check how many nodes are clicked/selected
     */
    @Override
    public void handle(Event event) {
        if (!isImage) {
            gameController.handleSelection(node);
        }

        isImage = !isImage;

    }
}
