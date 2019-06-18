package memorypuzzle.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Result {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty clicksCounter;
    private final SimpleStringProperty time;
    private final SimpleStringProperty difficultyLevel;

    public Result(String name, Integer clicksCounter, String time, String difficultyLevel) {
        this.name =  new SimpleStringProperty(name);
        this.clicksCounter = new SimpleIntegerProperty(clicksCounter);
        this.time =  new SimpleStringProperty(time);
        this.difficultyLevel = new SimpleStringProperty(difficultyLevel);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getClicksCounter() {
        return clicksCounter.get();
    }

    public SimpleIntegerProperty clicksCounterProperty() {
        return clicksCounter;
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public String getDifficultyLevel() {
        return difficultyLevel.get();
    }

    public SimpleStringProperty difficultyLevelProperty() {
        return difficultyLevel;
    }
}
