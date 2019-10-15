package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class InsertPlayerController implements Initializable {
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
	boolean[] valid = new boolean[16];
	String role[] = { "ANYTHING", "BATSMAN", "BOWLER", "BATTING ALLROUNDER", "BOWLING  ALLROUNDER" };
	String country[] = { "ANYTHING", "INDIA", "AUSTRALIA", "ENGLAND", "SOUTH AFRICA", "NEW ZEALAND", "PAKISTAN",
			"SRI LANKA", "WEST INDIES", "BANGLADESH", "AFGHANISTAN" };
	String battingStyle[] = { "ANYTHING", "RIGHT HANDED", "LEFT HANDED" };
	String bowlingStyle[] = { "ANYTHING", "RIGHT PACER", "RIGHT SPINNER", "LEFT PACER", "LEFT SPINNER" };
	String testMatches, testRuns, testWickets, testBattingAvg, testBowlingAvg, testBattingSR, testBowlingSR;
	String odiMatches, odiRuns, odiWickets, odiBattingAvg, odiBowlingAvg, odiBattingSR, odiBowlingSR;
	String t20Matches, t20Runs, t20Wickets, t20BattingAvg, t20BowlingAvg, t20BattingSR, t20BowlingSR;
	boolean test = true, odi = false, t20 = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setIsValidArray();
		setComboBoxes();
		setListeners();
	}

	private void setIsValidArray() {
		for (int i = 0; i < valid.length; i++)
			valid[i] = false;
	}

	private void setListeners() {
		matchesTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testMatches = newValue;
				else if ((!test) && (odi) && (!t20))
					odiMatches = newValue;
				else if ((!test) && (!odi) && (t20))
					t20Matches = newValue;
				else
					System.out.println("Error in  matchesTextField");
			}
		});
		runsTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testRuns = newValue;
				else if ((!test) && (odi) && (!t20))
					odiRuns = newValue;
				else if ((!test) && (!odi) && (t20))
					t20Runs = newValue;
				else
					System.out.println("Error in  runsTextField");
			}
		});
		wicketsTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testWickets = newValue;
				else if ((!test) && (odi) && (!t20))
					odiWickets = newValue;
				else if ((!test) && (!odi) && (t20))
					t20Wickets = newValue;
				else
					System.out.println("Error in  wicketsTextField");
			}
		});
		battingAvgTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testBattingAvg = newValue;
				else if ((!test) && (odi) && (!t20))
					odiBattingAvg = newValue;
				else if ((!test) && (!odi) && (t20))
					t20BattingAvg = newValue;
				else
					System.out.println("Error in  battingAvgTextField");
			}
		});
		bowlingAvgTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testBowlingAvg = newValue;
				else if ((!test) && (odi) && (!t20))
					odiBowlingAvg = newValue;
				else if ((!test) && (!odi) && (t20))
					t20BowlingAvg = newValue;
				else
					System.out.println("Error in  bowlingAvgTextField");
			}
		});
		battingSRTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testBattingSR = newValue;
				else if ((!test) && (odi) && (!t20))
					odiBattingSR = newValue;
				else if ((!test) && (!odi) && (t20))
					t20BattingSR = newValue;
				else
					System.out.println("Error in  battingSRTextField");
			}
		});
		bowlingSRTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testBowlingSR = newValue;
				else if ((!test) && (odi) && (!t20))
					odiBowlingSR = newValue;
				else if ((!test) && (!odi) && (t20))
					t20BowlingSR = newValue;
				else
					System.out.println("Error in  bowlingSRTextField");
			}
		});
	}

	private boolean isAlpha(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}

	private void setComboBoxes() {
		roleComboBox.setItems(FXCollections.observableArrayList(role));
		countryComboBox.setItems(FXCollections.observableArrayList(country));
		battingStyleComboBox.setItems(FXCollections.observableArrayList(battingStyle));
		bowlingStyleComboBox.setItems(FXCollections.observableArrayList(bowlingStyle));
	}

	public void saveClick(ActionEvent ae) {

	}
}

/*
 * nameTextField.textProperty().addListener(new ChangeListener<Object>() {
 * 
 * @Override public void changed(ObservableValue<? extends Object> observable,
 * Object oldValue, Object newValue) { if(isAlpha((String)newValue)) valid[1] =
 * true; else valid[1] = false; } });
 * dobDatePicker.valueProperty().addListener(new ChangeListener<Object>() {
 * 
 * @Override public void changed(ObservableValue<? extends Object> observable,
 * Object oldValue, Object newValue) { String d =
 * dobDatePicker.getValue().toString(); if(d==null ||d.isEmpty()) valid[2] =
 * false; else valid[2] = true; } });
 */