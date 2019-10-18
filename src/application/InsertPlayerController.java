package application;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import DAO.*;
import Main.*;
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
	private TextField inningsTextField;
	@FXML
	private TextField bowlingAvgTextField;
	@FXML
	private TextField battingSRTextField;
	@FXML
	private TextField bowlingSRTextField;
	boolean[] valid = new boolean[16];
	String role[] = { "BATSMAN", "BOWLER", "BATTING ALLROUNDER", "BOWLING  ALLROUNDER" };
	String country[] = { "INDIA", "AUSTRALIA", "ENGLAND", "SOUTH AFRICA", "NEW ZEALAND", "PAKISTAN", "SRI LANKA",
			"WEST INDIES", "BANGLADESH", "AFGHANISTAN" };
	String battingStyle[] = { "RIGHT HANDED", "LEFT HANDED" };
	String bowlingStyle[] = { "RIGHT PACER", "RIGHT SPINNER", "LEFT PACER", "LEFT SPINNER" };
	String testMatches = "", testRuns = "", testWickets = "", testInnings = "", testBowlingAvg = "", testBattingSR = "",
			testBowlingSR = "";
	String odiMatches = "", odiRuns = "", odiWickets = "", odiInnings = "", odiBowlingAvg = "", odiBattingSR = "",
			odiBowlingSR = "";
	String t20Matches = "", t20Runs = "", t20Wickets = "", t20Innings = "", t20BowlingAvg = "", t20BattingSR = "",
			t20BowlingSR = "";
	boolean test = true, odi = false, t20 = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		testCareerButton.setStyle("-fx-background-color: #87cefa;");
		odiCareerButton.setStyle("-fx-background-color: #fffff0;");
		t20CareerButton.setStyle("-fx-background-color: #fffff0;");
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
		inningsTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if ((test) && (!odi) && (!t20))
					testInnings = newValue;
				else if ((!test) && (odi) && (!t20))
					odiInnings = newValue;
				else if ((!test) && (!odi) && (t20))
					t20Innings = newValue;
				else
					System.out.println("Error in  inningsTextField");
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

	public void careerButton(ActionEvent ae) {
		Button b = (Button) ae.getSource();
		if (testCareerButton == b) {
			testCareerButton.setStyle("-fx-background-color: #87cefa;");
			odiCareerButton.setStyle("-fx-background-color: #fffff0;");
			t20CareerButton.setStyle("-fx-background-color: #fffff0;");
			System.out.println("Test Career button clicked");
			test = true;
			odi = t20 = false;
			matchesTextField.setText(testMatches);
			runsTextField.setText(testRuns);
			wicketsTextField.setText(testWickets);
			inningsTextField.setText(testInnings);
			battingSRTextField.setText(testBattingSR);
			bowlingAvgTextField.setText(testBowlingAvg);
			bowlingSRTextField.setText(testBowlingSR);
		} else if (odiCareerButton == b) {
			testCareerButton.setStyle("-fx-background-color: #fffff0;");
			odiCareerButton.setStyle("-fx-background-color: #87cefa;");
			t20CareerButton.setStyle("-fx-background-color: #fffff0;");
			System.out.println("ODI career button clicked");
			odi = true;
			test = t20 = false;
			matchesTextField.setText(odiMatches);
			runsTextField.setText(odiRuns);
			wicketsTextField.setText(odiWickets);
			inningsTextField.setText(odiInnings);
			battingSRTextField.setText(odiBattingSR);
			bowlingAvgTextField.setText(odiBowlingAvg);
			bowlingSRTextField.setText(odiBowlingSR);
		} else if (t20CareerButton == b) {
			testCareerButton.setStyle("-fx-background-color: #fffff0;");
			odiCareerButton.setStyle("-fx-background-color: #fffff0;");
			t20CareerButton.setStyle("-fx-background-color: #87cefa;");
			System.out.println("T20 career button clicked");
			t20 = true;
			odi = test = false;
			matchesTextField.setText(t20Matches);
			runsTextField.setText(t20Runs);
			wicketsTextField.setText(t20Wickets);
			inningsTextField.setText(t20Innings);
			battingSRTextField.setText(t20BattingSR);
			bowlingAvgTextField.setText(t20BowlingAvg);
			bowlingSRTextField.setText(t20BowlingSR);
		} else
			System.out.println("Error in careerButton function!");
	}

	private boolean isAlpha(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (c == ' ')
				continue;
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
		errorLabel.setText("");
		errorLabel.setStyle("-fx-text-fill: red;");
		if ((nameTextField.getText() == null) || (nameTextField.getText().isEmpty())
				|| !isAlpha(nameTextField.getText())) {
			errorLabel.setText("Name field is invalid");
			return;
		}
		LocalDate ld = dobDatePicker.getValue();
		if ((ld == null) || (ld.toString() == null || ld.toString().isEmpty()) || (ld.isAfter(LocalDate.now()))) {
			errorLabel.setText("Date is invalid");
			return;
		}
		if (roleComboBox.getSelectionModel().isEmpty()) {
			errorLabel.setText("Select any role");
			return;
		}
		if (countryComboBox.getSelectionModel().isEmpty()) {
			errorLabel.setText("Select any country");
			return;
		}
		if (battingStyleComboBox.getSelectionModel().isEmpty()) {
			errorLabel.setText("Select any batting style");
			return;
		}
		if (bowlingStyleComboBox.getSelectionModel().isEmpty()) {
			errorLabel.setText("Select any bowling style");
			return;
		}
		if (testMatches == null || testRuns == null || testWickets == null || testBattingSR == null
				|| testInnings == null || testBowlingAvg == null || testBowlingSR == null) {
			errorLabel.setText("Test Career data  is invalid");
			return;
		}
		if (odiMatches == null || odiRuns == null || odiWickets == null || odiBattingSR == null || odiInnings == null
				|| odiBowlingAvg == null || odiBowlingSR == null) {
			errorLabel.setText("ODI Career data  is invalid");
			return;
		}
		if (t20Matches == null || t20Runs == null || t20Wickets == null || t20BattingSR == null || t20Innings == null
				|| t20BowlingAvg == null || t20BowlingSR == null) {
			errorLabel.setText("T20 Career data  is invalid");
			return;
		}
		trim();
		if (testMatches.isEmpty() || testRuns.isEmpty() || testWickets.isEmpty() || testInnings.isEmpty()
				|| testBattingSR.isEmpty() || testBowlingAvg.isEmpty() || testBowlingSR.isEmpty()) {
			errorLabel.setText("Test Career data  is invalid");
			return;
		}
		if (odiMatches.isEmpty() || odiRuns.isEmpty() || odiWickets.isEmpty() || odiInnings.isEmpty()
				|| odiBattingSR.isEmpty() || odiBowlingAvg.isEmpty() || odiBowlingSR.isEmpty()) {
			errorLabel.setText("ODI Career data  is invalid");
			return;
		}
		if (t20Matches.isEmpty() || t20Runs.isEmpty() || t20Wickets.isEmpty() || t20Innings.isEmpty()
				|| t20BattingSR.isEmpty() || t20BowlingAvg.isEmpty() || t20BowlingSR.isEmpty()) {
			errorLabel.setText("T20 Career data  is invalid");
			return;
		}
		System.out.println("About to check test  data");
		if (isNotNumValid(testMatches) || isNotNumValid(testRuns) || isNotNumValid(testWickets)
				|| isNotNumValid(testInnings) || isNotNumValid(testBattingSR) || isNotNumValid(testBowlingAvg)
				|| isNotNumValid(testBowlingSR)) {
			errorLabel.setText("Test Career data  is invalid");
			return;
		}
		System.out.println("About to check odi data");
		if (isNotNumValid(odiMatches) || isNotNumValid(odiRuns) || isNotNumValid(odiWickets)
				|| isNotNumValid(odiInnings) || isNotNumValid(odiBattingSR) || isNotNumValid(odiBowlingAvg)
				|| isNotNumValid(odiBowlingSR)) {
			errorLabel.setText("odi Career data  is invalid");
			return;
		}
		System.out.println("About to check t20  data");
		if (isNotNumValid(t20Matches) || isNotNumValid(t20Runs) || isNotNumValid(t20Wickets)
				|| isNotNumValid(t20Innings) || isNotNumValid(t20BattingSR) || isNotNumValid(t20BowlingAvg)
				|| isNotNumValid(t20BowlingSR)) {
			errorLabel.setText("t20 Career data  is invalid");
			return;
		}
		errorLabel.setStyle("-fx-text-fill: green;");
		errorLabel.setText("Player successfully saved.");
		int id = savePlayer();
		saveTestCareer(id);
		saveODICareer(id);
		saveT20Career(id);
	}

	private void saveODICareer(int id) {
		int matches = Integer.parseInt(odiMatches);
		int runs = Integer.parseInt(odiRuns);
		int wickets = Integer.parseInt(odiWickets);
		int innings = Integer.parseInt(odiInnings);
		double bowlAvg = Integer.parseInt(odiBowlingAvg);
		double batSR = Integer.parseInt(odiBattingSR);
		double bowlSR = Integer.parseInt(odiBowlingSR);
		ODICareerDAO odiDAO = new ODICareerDAO();
		odiDAO.connect();
		ODICareer oc = new ODICareer(matches, runs, wickets, innings, bowlAvg, batSR, bowlSR);
		oc.setId(id);
		try {
			odiDAO.insertODICareer(oc);
			odiDAO.UpdateAvg(id);
		} catch (SQLException e) {
			System.out.println("Error in inserting odi career");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		odiDAO.close();
	}

	private void saveT20Career(int id) {
		int matches = Integer.parseInt(t20Matches);
		int runs = Integer.parseInt(t20Runs);
		int wickets = Integer.parseInt(t20Wickets);
		int innings = Integer.parseInt(t20Innings);
		double bowlAvg = Integer.parseInt(t20BowlingAvg);
		double batSR = Integer.parseInt(t20BattingSR);
		double bowlSR = Integer.parseInt(t20BowlingSR);
		T20CareerDAO t20DAO = new T20CareerDAO();
		t20DAO.connect();
		T20Career t20c = new T20Career(matches, runs, wickets, innings, bowlAvg, batSR, bowlSR);
		t20c.setId(id);
		try {
			t20DAO.insertT20Career(t20c);
			t20DAO.UpdateAvg(id);
		} catch (SQLException e) {
			System.out.println("Error in inserting t20 career");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		t20DAO.close();
	}

	private void saveTestCareer(int id) {
		int matches = Integer.parseInt(testMatches);
		int runs = Integer.parseInt(testRuns);
		int wickets = Integer.parseInt(testWickets);
		int innings = Integer.parseInt(testInnings);
		double bowlAvg = Integer.parseInt(testBowlingAvg);
		double batSR = Integer.parseInt(testBattingSR);
		double bowlSR = Integer.parseInt(testBowlingSR);
		TestCareerDAO tdao = new TestCareerDAO();
		tdao.connect();
		TestCareer tc = new TestCareer(matches, runs, wickets, innings, bowlAvg, batSR, bowlSR);
		tc.setId(id);
		try {
			tdao.insertTestCareer(tc);
			tdao.UpdateAvg(id);
		} catch (SQLException e) {
			System.out.println("Error in inserting test career");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tdao.close();
	}

	private int savePlayer() {
		PlayerDAO pdao = new PlayerDAO();
		pdao.connect();
		String name = nameTextField.getText();
		int role = roleComboBox.getSelectionModel().getSelectedIndex() + 1;
		int country = countryComboBox.getSelectionModel().getSelectedIndex() + 1;
		int batt_s = battingStyleComboBox.getSelectionModel().getSelectedIndex() + 1;
		int bowl_s = bowlingStyleComboBox.getSelectionModel().getSelectedIndex() + 1;
		LocalDate ld = dobDatePicker.getValue();
		String dob = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("///dob :: " + dob);
		Player player = new Player(name, role, country, batt_s, bowl_s, dob);
		int id = -1;
		try {
			id = pdao.insertPlayer(player);
		} catch (SQLException e) {
			System.out.println("Error in inserting player");
			e.printStackTrace();
		}
		pdao.close();
		return id;
	}

	private void trim() {
		testMatches.trim();
		testRuns.trim();
		testWickets.trim();
		testInnings.trim();
		testBattingSR.trim();
		testBowlingAvg.trim();
		testBowlingSR.trim();

		odiMatches.trim();
		odiRuns.trim();
		odiWickets.trim();
		odiInnings.trim();
		odiBattingSR.trim();
		odiBowlingAvg.trim();
		odiBowlingSR.trim();

		t20Matches.trim();
		t20Runs.trim();
		t20Wickets.trim();
		t20Innings.trim();
		t20BattingSR.trim();
		t20BowlingAvg.trim();
		t20BowlingSR.trim();
	}

	private boolean isNotNumValid(String s) {
		if (s.matches("[0-9]+")) {
			if (Integer.parseInt(s) >= 0) {
				System.out.println(Integer.parseInt(s));
				return false;
			}
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '.')
				count++;
		}
		if (count == 0 || count == 1)
			return true;
		else
			return false;
	}
}