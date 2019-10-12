package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.*;
import Main.Player;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	@FXML
	private GridPane contentGrid;
	PlayerDAO pdao;
	String role[] = { "ANYTHING", "BATSMAN", "BOWLER", "BATTING ALLROUNDER", "BOWLING  ALLROUNDER" };
	String country[] = { "ANYTHING", "INDIA", "AUSTRALIA", "ENGLAND", "SOUTH AFRICA", "NEW ZEALAND", "PAKISTAN",
			"SRI LANKA", "WEST INDIES", "BANGLADESH", "AFGHANISTAN" };
	String battingStyle[] = { "ANYTHING", "RIGHT HANDED", "LEFT HANDED" };
	String bowlingStyle[] = { "ANYTHING", "RIGHT PACER", "RIGHT SPINNER", "LEFT PACER", "LEFT SPINNER" };

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setComboBoxes();
		setInitialData();
		
	}

	public void setInitialData() {
		pdao = new PlayerDAO();
		pdao.connect();
		ArrayList<Player> players = null;
		try {
			players = pdao.findPlayer("$#$0$0$0$0");
			System.out.println(players);
		} catch (IllegalArgumentException | SQLException e) {
			System.out.println("Error");
			Log.print();
		}
		addContent(players);
		pdao.close();
	}

	public void setComboBoxes() {
		roleComboBox.setItems(FXCollections.observableArrayList(role));
		countryComboBox.setItems(FXCollections.observableArrayList(country));
		battingStyleComboBox.setItems(FXCollections.observableArrayList(battingStyle));
		bowlingStyleComboBox.setItems(FXCollections.observableArrayList(bowlingStyle));
		roleComboBox.getSelectionModel().selectFirst();
		countryComboBox.getSelectionModel().selectFirst();
		battingStyleComboBox.getSelectionModel().selectFirst();
		bowlingStyleComboBox.getSelectionModel().selectFirst();
	}

	public GridPane getPlayerContent() throws IOException {
		GridPane gp = null;
		try {
			gp = FXMLLoader.load(getClass().getResource("/application/PlayerContent.fxml"));
		} catch (IOException e) {
			System.out.println("Error getting PlayerContent");
			throw e;
		}
		return gp;
	}

	public void search(ActionEvent ae) {
		String name = nameTextField.getText().trim();
		if (name == null || name.isEmpty())
			name = "#";
		int role = roleComboBox.getSelectionModel().getSelectedIndex();
		int country = countryComboBox.getSelectionModel().getSelectedIndex();
		int battingStyle = battingStyleComboBox.getSelectionModel().getSelectedIndex();
		int bowlingStyle = bowlingStyleComboBox.getSelectionModel().getSelectedIndex();
		pdao.connect();
		String query = "$" + name + "$" + role + "$" + country + "$" + battingStyle + "$" + bowlingStyle;
		System.out.println(query);
		ArrayList<Player> players = null;
		try {
			players = pdao.findPlayer(query);
		} catch (IllegalArgumentException | SQLException e) {
			Log.print();
			e.printStackTrace();
		}
		contentVBox.getChildren().clear();
		addContent(players);
	}

	public void addContent(ArrayList<Player> players) {
		GridPane gp = null;
		for (int i = 0; i < players.size(); i++) {
			try {
				gp = getPlayerContent();
			} catch (IOException e) {
				e.printStackTrace();
			}
			gp.getChildren().set(0, new Label(players.get(i).name));
			Label l = (Label)gp.getChildren().get(0);
			l.setId("$"+players.get(i).id+"");
			System.out.println(l.getId());
			
			l.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					System.out.println("Clicked on "+l.getText());
				}
			});
			contentVBox.getChildren().add(gp);
		}
	}

}