package memorypuzzle.controller.generator;

import memorypuzzle.controller.GameController;
import memorypuzzle.controller.listener.NodeActionListener;
import memorypuzzle.model.CustomImage;
import memorypuzzle.model.Node;

import java.util.ArrayList;
import java.util.List;

public class NodeGenerator {

    /*
    generates list of nodes with images
     */

    public static List<Node> generateNodeList(int columnNumber, GameController gameController) {
        final ArrayList<CustomImage> imageList = ImageGenerator.generateRandomImagelist(columnNumber);

        final List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < columnNumber * columnNumber; i++) {
            nodeList.add(generate(i, imageList.get(i), gameController));
        }

        return nodeList;
    }

    /*
    generates one node with an image
     */

    private static Node generate(int nodeNumber, CustomImage image, GameController gameController) {

        final Node node = new Node(image, nodeNumber);

        final NodeActionListener nodeActionListener = new NodeActionListener(gameController, node);


        /*
      2 action Listeners because it wouldnt work on first click
        */

        node.setOnMousePressed(nodeActionListener);
        node.setOnMouseReleased(nodeActionListener);

        return node;
    }
}
