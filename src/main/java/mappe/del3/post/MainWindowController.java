package mappe.del3.post;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mappe.del3.post.model.Post;
import mappe.del3.post.model.PostRegister;

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
}
