package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.*;
import Main.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
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
		PlayerDAO pdao = new PlayerDAO();
		pdao.connect();
		ArrayList<Player> players=null;
		try {
			players = pdao.findPlayer("$#$0$0$0$0");
			System.out.println(players);
		} catch (IllegalArgumentException | SQLException e) {
			System.out.println("Error");
			Log.print();
		}
		GridPane gp=null;
		for(int i=0;i<players.size();i++) {
			try {
				gp = getPlayerContent();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		gp.getChildren().set(0, new Label(players.get(i).name));
		gp.getChildren().set(1, new Label(players.get(i).country+""));
		gp.getChildren().set(2, new Label(players.get(i).role+""));
		contentVBox.getChildren().add(gp);
		}
		
	}
	public GridPane getPlayerContent() throws IOException {
		GridPane gp=null;
		try {
			gp =  FXMLLoader.load(getClass().getResource("/application/PlayerContent.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error getting PlayerContent");
			throw e;
		}
		return gp;
	}
}
