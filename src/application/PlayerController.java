package application;

import java.net.URL;
import java.util.*;
import DAO.*;
import Main.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class PlayerController implements Initializable {
	@FXML
	private Label nameLabel;
	@FXML
	private Label dobLabel;
	@FXML
	private Label roleLabel;
	@FXML
	private Label countryLabel;
	@FXML
	private Label battingStyleLabel;
	@FXML
	private Label bowlingStyleLabel;
	@FXML
	private ComboBox<String> careerComboBox;
	@FXML
	private Label matchesLabel;
	@FXML
	private Label runsLabel;
	@FXML
	private Label wicketsLabel;
	@FXML
	private Label battingAvgLabel;
	@FXML
	private Label bowlingAvgLabel;
	@FXML
	private Label battingSRLabel;
	@FXML
	private Label bowlingSRLabel;
	private int id;
	private Player player;
	private String[] career = { "Test", "ODI", "T20" };

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getPlayerData();
		setPlayerDataLabels();
		setCareerComboBox();
	}

	private void getPlayerData() {
		id = CurrentPlayer.getID();
		PlayerDAO pdao = new PlayerDAO();
		pdao.connect();
		player = pdao.getPlayer(id);
		System.out.println(player);
		pdao.close();
	}

	private void setPlayerDataLabels() {
		nameLabel.setText(player.name.toUpperCase());
		dobLabel.setText(player.dob);
		roleLabel.setText(PlayerConstants.getRole(player.role));
		countryLabel.setText(PlayerConstants.getCountry(player.country));
		battingStyleLabel.setText(PlayerConstants.getBattingStyle(player.batStyle));
		bowlingStyleLabel.setText(PlayerConstants.getBowlingStyle(player.bowlStyle));
	}

	private void setCareerComboBox() {
		careerComboBox.setItems(FXCollections.observableArrayList(career));
	}

	public void careerComboSelected(ActionEvent ae) {
		if (careerComboBox.getSelectionModel().getSelectedItem().equals(career[0]))
			testCareer();
		else if (careerComboBox.getSelectionModel().getSelectedItem().equals(career[1]))
			odiCareer();
		else
			t20Career();
	}

	private void testCareer() {
		TestCareerDAO dao = new TestCareerDAO();
		dao.connect();
		TestCareer career = dao.getTestCareer(id);
		matchesLabel.setText(career.matches + "");
		runsLabel.setText(career.runs + "");
		wicketsLabel.setText(career.wickets + "");
		battingAvgLabel.setText(career.batting_avg + "");
		bowlingAvgLabel.setText(career.bowling_avg + "");
		battingSRLabel.setText(career.batting_sr + "");
		bowlingSRLabel.setText(career.bowling_sr + "");
		dao.close();
	}

	private void odiCareer() {
		ODICareerDAO dao = new ODICareerDAO();
		dao.connect();
		ODICareer career = dao.getODICareer(id);
		matchesLabel.setText(career.matches + "");
		runsLabel.setText(career.runs + "");
		wicketsLabel.setText(career.wickets + "");
		battingAvgLabel.setText(career.batting_avg + "");
		bowlingAvgLabel.setText(career.bowling_avg + "");
		battingSRLabel.setText(career.batting_sr + "");
		bowlingSRLabel.setText(career.bowling_sr + "");
		dao.close();
	}

	private void t20Career() {
		T20CareerDAO dao = new T20CareerDAO();
		dao.connect();
		T20Career career = dao.getT20Career(id);
		matchesLabel.setText(career.matches + "");
		runsLabel.setText(career.runs + "");
		wicketsLabel.setText(career.wickets + "");
		battingAvgLabel.setText(career.batting_avg + "");
		bowlingAvgLabel.setText(career.bowling_avg + "");
		battingSRLabel.setText(career.batting_sr + "");
		bowlingSRLabel.setText(career.bowling_sr + "");
		dao.close();
	}
}
