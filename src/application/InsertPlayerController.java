package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class InsertPlayerController {
	@FXML
	private GridPane mainGrid;
	@FXML
	private Label errorLabel;
	@FXML
	private Button saveButton;
	@FXML 
	private TextField nameTextField;
	@FXML
	private DatePicker dobDatePicker;
	@FXML
	private ComboBox<String> roleComboBox;
	@FXML
	private ComboBox<String> countryComboBox;
	@FXML
	private ComboBox<String> battingStyleComboBox;
	@FXML
	private ComboBox<String> bowlingStyleComboBox;
	@FXML
	private Button odiCareerButton;
	@FXML
	private Button testCareerButton;
	@FXML
	private Button t20CareerButton;
	@FXML
	private TextField matchesTextField;
	@FXML
	private TextField runsTextField;
	@FXML
	private TextField wicketsTextField;
	@FXML
	private TextField battingAvgTextField;
	@FXML
	private TextField bowlingAvgTextField;
	@FXML
	private TextField battingSRTextField;
	@FXML
	private TextField bowlingSRTextField;
}
