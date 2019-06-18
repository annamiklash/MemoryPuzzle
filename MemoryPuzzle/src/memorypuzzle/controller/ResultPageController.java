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
import memorypuzzle.model.Result;
import memorypuzzle.view.initializer.GUIInitializer;

public class ResultPageController {

    @FXML
    private TableView resultTable;

    public void initialize() {
        final TableColumn name = new TableColumn("Name");
        final TableColumn clicksCounter = new TableColumn("Clicks Counter");
        final TableColumn time = new TableColumn("Time");
        final TableColumn difficultyLevel = new TableColumn("Difficulty Level");

        resultTable.getColumns().addAll(name, clicksCounter, time, difficultyLevel);

        //set value type of columns in TableView
        name.setCellValueFactory(new PropertyValueFactory<Result, String>("name"));
        clicksCounter.setCellValueFactory(new PropertyValueFactory<Result, Integer>("clicksCounter"));
        time.setCellValueFactory(new PropertyValueFactory<Result, String>("time"));
        difficultyLevel.setCellValueFactory(new PropertyValueFactory<Result, String>("difficultyLevel"));

        final ObservableList<Result> resultObservableList = FXCollections.observableArrayList(FileUtil.getResultList());

        resultTable.setItems(resultObservableList);
    }


    @FXML
    public void onBackButtonClicked(ActionEvent event) {
        final Scene scene = ((Node) event.getSource()).getScene();
        final Stage stage = (Stage) scene.getWindow();

        GUIInitializer.initStartPage(stage);
    }


}
