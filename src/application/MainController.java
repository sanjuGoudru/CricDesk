package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

public class MainController implements Initializable {
	@FXML
	private VBox leftVBox;
	@FXML
	private ImageView catalog;
	@FXML
	private ImageView league;
	@FXML
	private ImageView about;
	@FXML
	private AnchorPane rightAnchor;
	@FXML
	private ImageView main_logo;
	@FXML
	private ImageView main_logo2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	
}
