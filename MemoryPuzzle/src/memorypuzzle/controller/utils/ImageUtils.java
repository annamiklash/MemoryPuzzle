package memorypuzzle.controller.utils;


import memorypuzzle.model.CustomImage;

import java.io.File;
import java.net.MalformedURLException;

public class ImageUtils {

    public static CustomImage getImage(int imageNumber) {
        try {
            final File file = new File("resources/" + imageNumber + ".jpg");
            final String localUrl =  file.toURI().toURL().toString();
            return new CustomImage(localUrl, imageNumber);
        } catch (MalformedURLException e) {
            System.out.println("Error while loading image " + imageNumber);
        }

        return null;
    }
}
