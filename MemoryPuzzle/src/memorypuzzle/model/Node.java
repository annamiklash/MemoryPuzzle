package memorypuzzle.model;

import javafx.scene.image.ImageView;
import memorypuzzle.controller.singleton.SleeveSingleton;

public class Node extends ImageView {

    private final CustomImage faceImage;
    private final Integer nodeNumber;
    private boolean isSelected;

    public Node(CustomImage image, Integer nodeNumber) {
        super(SleeveSingleton.getInstance().getSleeveImage());

        this.setFitWidth(100);
        this.setFitHeight(100);

        this.faceImage = image;
        this.nodeNumber = nodeNumber;

        isSelected = false; //at the beginning by default not selected
    }

    public CustomImage getFaceImage() {
        return faceImage;
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public boolean isSelected() {
        return isSelected;
    }


    public void setSelected() { //show "face" of an image
        isSelected = true;
        this.setImage(faceImage);

    }

    public void setNotSelected() { //show sleeve
        isSelected = false;
        this.setImage(SleeveSingleton.getInstance().getSleeveImage());
    }
}
