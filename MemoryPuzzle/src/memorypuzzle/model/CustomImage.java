package memorypuzzle.model;

import javafx.scene.image.Image;

public class CustomImage extends Image {

    private final int imageNumber;

    public CustomImage(String url, int imageNumber) {
        /*
        has image number for comparison reasons to check if selected images are the same
         */
        super(url);
        this.imageNumber = imageNumber;
    }

    /*
    check numbers of images
     */

    public boolean equals(CustomImage that) {
        return imageNumber == that.imageNumber;
    }
}
