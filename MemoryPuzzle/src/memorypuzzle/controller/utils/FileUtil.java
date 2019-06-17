package memorypuzzle.controller.utils;

import memorypuzzle.common.Constants;
import memorypuzzle.model.DifficultyLevelEnum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void savingToFile(String playerName, int clickNumber, String time, DifficultyLevelEnum levelOfDifficulty) {
        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_NAME, true));

            writer.write("Player Name: " + playerName + "; Clicks Number " + clickNumber + "; Time: " + time + "; Level of Difficulty: " + levelOfDifficulty.name() + '\n');

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
