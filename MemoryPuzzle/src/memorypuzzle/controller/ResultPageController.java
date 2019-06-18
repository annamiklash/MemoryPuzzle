package memorypuzzle.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import memorypuzzle.controller.utils.FileUtil;
import memorypuzzle.model.DifficultyLevelEnum;
import memorypuzzle.model.Result;
import memorypuzzle.view.initializer.GUIInitializer;

public class ResultPageController {

    @FXML
    private TableView resultTable;

    public void initialize() {
        Result result = new Result("Ania", 1, "123:123:132", DifficultyLevelEnum.EASY.name());


        TableColumn name = new TableColumn("Name");
        TableColumn clicksCounter = new TableColumn("Clicks Counter");
        TableColumn time = new TableColumn("Time");
        TableColumn difficultyLevel = new TableColumn("Difficulty Level");

        resultTable.getColumns().addAll(name, clicksCounter, time, difficultyLevel);

        name.setCellValueFactory(new PropertyValueFactory<Result, String>("name"));
        clicksCounter.setCellValueFactory(new PropertyValueFactory<Result, Integer>("clicksCounter"));
        time.setCellValueFactory(new PropertyValueFactory<Result, String>("time"));
        difficultyLevel.setCellValueFactory(new PropertyValueFactory<Result, String>("difficultyLevel"));

        resultTable.getItems().add(result);

        final ObservableList<Result> resultObservableList = FXCollections.observableArrayList(FileUtil.getResultList());
//        final ObservableList<Result> resultObservableList = FXCollections.observableArrayList(result);

        resultTable.setItems(resultObservableList);
    }


    @FXML
    public void onBackButtonClicked(ActionEvent event) {
        final Scene scene = ((Node) event.getSource()).getScene();
        final Stage stage = (Stage) scene.getWindow();

        GUIInitializer.initMainPage(stage);
    }




}
