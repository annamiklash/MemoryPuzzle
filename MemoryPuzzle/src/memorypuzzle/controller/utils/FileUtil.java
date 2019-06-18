package memorypuzzle.controller.utils;

import memorypuzzle.common.Constants;
import memorypuzzle.model.DifficultyLevelEnum;
import memorypuzzle.model.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void savingToFile(String playerName, int clickNumber, String time, DifficultyLevelEnum levelOfDifficulty) {
        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_NAME, true));

            writer.write("Player Name: " + playerName + "; Clicks Number: " + clickNumber + "; Time: " + time + "; Level of Difficulty: " + levelOfDifficulty.name() + '\n');

            writer.close();

        } catch (IOException e) {
            System.out.println("Error while saving results to file: " + e);
        }
    }


    public static List<Result> getResultList() {
        final List<Result> resultList = new ArrayList<>();

        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.FILE_NAME));
            String line = bufferedReader.readLine();

            while (line != null) {
                final Result result = parseResult(line);

                resultList.add(result);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error while parsing result file");
            e.printStackTrace();
        }

        return resultList;
    }

    private static Result parseResult(String line) {
        final String nameAttr = "Player Name: ";
        final String resultAttr = "; Clicks Number: ";
        final String timeAttr = "; Time: ";
        final String difficultyLevelAttr = "; Level of Difficulty: ";

        int beginIndex = nameAttr.length();
        int endIndex = line.indexOf(resultAttr);

        final String finalName = line.substring(beginIndex, endIndex);

        beginIndex = beginIndex + finalName.length() + resultAttr.length();
        endIndex = line.indexOf(timeAttr);

        final String finalResult = line.substring(beginIndex, endIndex);
        final Integer finalResultInt = Integer.valueOf(finalResult);

        beginIndex = beginIndex + finalResult.length() + timeAttr.length();
        endIndex = line.indexOf(difficultyLevelAttr);

        final String finalTime = line.substring(beginIndex, endIndex);

        beginIndex = beginIndex + finalTime.length() + difficultyLevelAttr.length();

        final String finalDifficultyLevel = line.substring(beginIndex);

        return new Result(finalName, finalResultInt, finalTime, finalDifficultyLevel);
    }


}



