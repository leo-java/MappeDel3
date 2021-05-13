package mappe.del3.post;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mappe.del3.post.model.Post;
import mappe.del3.post.model.PostRegister;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Main window controller.
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private Button searchButton;
    @FXML
    private MenuItem aboutButton;
    @FXML
    private MenuItem exitButton;
    @FXML
    private MenuItem importFromCSVButton;
    @FXML
    private MenuItem saveAsCSVButton;
    @FXML
    private TableColumn<Post,String> categoryColumn;
    @FXML
    private TableColumn<Post,String> municipalityNameColumn;
    @FXML
    private TableColumn<Post,String> municipalityNumberColumn;
    @FXML
    private TableColumn<Post,String> postalAreaColumn;
    @FXML
    private TableColumn<Post,String> postalCodeColumn;
    @FXML
    private TableView<Post> postalTableView;
    @FXML
    private TextField searchField;

    private PostRegister postRegister;
    private ObservableList<Post> observablePostList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.postRegister = new PostRegister();

        this.categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        this.municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));
        this.municipalityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityNumber"));
        this.postalAreaColumn.setCellValueFactory(new PropertyValueFactory<>("postArea"));
        this.postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postCode"));

        this.observablePostList = FXCollections.observableArrayList(this.postRegister.getPost());
        this.postalTableView.setItems(this.observablePostList);
    }

    /**
     * Write to txt.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void writeToTxt(ActionEvent actionEvent) {
        FileHandler fileHandler = new FileHandler();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            FilteredList<Post> filteredData = new FilteredList<>(observablePostList, p -> true);
            filteredData.setPredicate(post -> {
                if (searchField.getText() == null || searchField.getText().isEmpty() || searchField.getText().isBlank()) {
                    return true;
                }
                if(isNumeric(searchField.getText())){
                    if (post.getPostCode().contains(searchField.getText())){
                        return true;
                    }
                } else if (post.getPostArea().contains(searchField.getText().toUpperCase(Locale.ROOT))){
                    return true;
                }
                return false;
            });
            ArrayList<Post> sortedData = new ArrayList<>(filteredData);
            try{
                fileHandler.writeTxt(sortedData, file.getAbsolutePath());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void importFromTxt(ActionEvent actionEvent) throws IOException{
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose txt file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        try {
            FileHandler fileHandler = new FileHandler();
            postRegister.setPost(fileHandler.readTxt(file));
            updateTableView();
        }catch (IOException e){
            System.out.println("ERROR: An IOException has occurred: " + e.getCause());
            throw e;
        }
    }

    private void updateTableView() {
        this.observablePostList.setAll(this.postRegister.getPost());
    }

    /**
     * Open about.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void openAbout(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application information");
        alert.setHeaderText("This application was made by Leo");
        alert.setContentText("V 1.0 11 May 2021");
        alert.show();
    }

    /**
     * Exit.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    /**
     * Search.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void search(ActionEvent actionEvent) {
        FilteredList<Post> filteredData = new FilteredList<>(observablePostList, p -> true);
        filteredData.setPredicate(post -> {
            if (searchField.getText() == null || searchField.getText().isEmpty() || searchField.getText().isBlank()) {
                return true;
            }
            if(isNumeric(searchField.getText())){
                if (post.getPostCode().contains(searchField.getText())){
                    return true;
                }
            } else if (post.getPostArea().contains(searchField.getText().toUpperCase(Locale.ROOT))){
                return true;
            }
            return false;
        });
        SortedList<Post> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(postalTableView.comparatorProperty());
        postalTableView.setItems(sortedData);
    }

    /**
     * Is numeric boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}
