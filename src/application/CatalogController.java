package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.VBox;

import javafx.scene.layout.GridPane;

public class CatalogController {
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
	public void click(ActionEvent e) {
		System.out.println("Click!!");
	}
}
