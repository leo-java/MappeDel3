package mappe.del3.post;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ResourceBundle;

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

    @FXML
    public void writeToTxt(ActionEvent actionEvent) {
        FileHandler fileHandler = new FileHandler();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            try{
                fileHandler.writeTxt(postRegister.getPost(), file.getAbsolutePath());
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
            System.out.println("ERROR: An IOException has occured: " + e.getCause());
            throw e;
        }
    }

    private void updateTableView() {
        this.observablePostList.setAll(this.postRegister.getPost());
    }

    @FXML
    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void search(ActionEvent actionEvent) {
    }
}
