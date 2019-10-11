package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import javafx.scene.layout.GridPane;

public class CatalogController implements Initializable {
	@FXML
	private VBox mainVBox;
	@FXML
	private GridPane gridPane1;
	@FXML
	private TextField nameTextField;
	@FXML
	private ComboBox<String> roleComboBox;
	@FXML
	private ComboBox<String> countryComboBox;
	@FXML
	private GridPane gridPane2;
	@FXML
	private ComboBox<String> battingStyleComboBox;
	@FXML
	private ComboBox<String> bowlingStyleComboBox;
	@FXML
	private Button searchButton;
	@FXML
	private ScrollPane scroll;
	@FXML
	private VBox contentVBox;
	public void click(ActionEvent e) {
		System.out.println("Click!!");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
}
