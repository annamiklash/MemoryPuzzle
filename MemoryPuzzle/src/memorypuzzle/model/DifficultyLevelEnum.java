package memorypuzzle.model;

public enum DifficultyLevelEnum  {

    EASY(2), //2x2 easy

    MEDIUM(4), //4x4 med

    HARD(6); //6x6 hard


    private final int columnNumber;

    DifficultyLevelEnum(int i) {
        columnNumber = i;
    } //also lvl equals to number of columns and rows

    public int getColumnNumber() {
        return columnNumber;
    }
}
