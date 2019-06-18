package memorypuzzle.controller.generator;

import memorypuzzle.controller.utils.ImageUtils;
import memorypuzzle.model.CustomImage;

import java.util.ArrayList;
import java.util.Collections;


public class ImageGenerator {

    /**
     * generates pairs of images needed for given level also shuffles it
     */
    public static ArrayList<CustomImage> generateRandomImagelist(int columnNumber) {
        final ArrayList<CustomImage> imageList = new ArrayList<>();

        for (int i = 1; i <= columnNumber * columnNumber / 2; i++) {
            for (int j = 0; j < 2; j++) {
                imageList.add(ImageUtils.getImage(i));
            }
        }

        Collections.shuffle(imageList);

        return imageList;
    }
}
