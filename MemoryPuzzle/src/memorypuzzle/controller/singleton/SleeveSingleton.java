package memorypuzzle.controller.singleton;

import javafx.scene.image.Image;
import memorypuzzle.controller.utils.ImageUtils;

/*
creating 1 object of a "sleeve" for a card for entire game. If not created - creates it
 */

public class SleeveSingleton {
    private static SleeveSingleton instance;
    private static Image sleeveImage;

    public static SleeveSingleton getInstance() {
        if (instance == null) {
            init();
        }

        return instance;
    }

    private static void init() {
        instance = new SleeveSingleton();
        sleeveImage = ImageUtils.getImage(100);
    }

    public Image getSleeveImage() {
        return sleeveImage;
    }

}
