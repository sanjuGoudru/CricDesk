package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import DAO.LeagueDAO;
import Main.Player;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;

public class PlayerViewController implements Initializable {
	@FXML
	private GridPane mainGridPane;
	@FXML
	private ScrollPane mainScroll;
	@FXML
	private VBox contentVBox;

	private int tid, lid, i;
	private ArrayList<Player> players;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setLayout();
		getContent();
		addContent();
	}

	private void getContent() {
		tid = CurrentPlayer.getTID();
		lid = CurrentPlayer.getLID();
		LeagueDAO league = new LeagueDAO();
		league.connect();
		players = null;
		try {
			players = league.getAllPlayers(tid, lid);
			System.out.println(players);
		} catch (SQLException e) {
			System.out.println("Failed to load players. LeagueID: " + lid + ". TeamID: " + tid);
			e.printStackTrace();
		} finally {
			league.close();
		}

	}

	public void addContent() {
		for (i = 0; i < players.size(); i++) {

			Label l = new Label(players.get(i).name);
			l.prefWidthProperty().bind(contentVBox.widthProperty());
			contentVBox.getChildren().add(l);
			l.setStyle("-fx-padding: 4px;");
			l.setId("$" + players.get(i).id);
			l.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					System.out.println("Clicked on " + l.getText());
					CurrentPlayer.setID(l.getId());
					mainGridPane.getChildren().clear();
					GridPane playerGP = null;
					try {
						playerGP = FXMLLoader.load(getClass().getResource("/application/Player.fxml"));
					} catch (IOException e) {
						System.out.println("Failed to load player GridPane");
						e.printStackTrace();
					}
					mainGridPane.getChildren().add(playerGP);
					GridPane.setConstraints(playerGP, 0, 0, 1, 2);
					playerGP.prefHeightProperty().bind(mainGridPane.heightProperty());
					playerGP.prefWidthProperty().bind(mainGridPane.widthProperty());
				}
			});
		}
	}

	private void setLayout() {
		mainScroll.prefWidthProperty().bind(mainGridPane.widthProperty());
		mainScroll.prefHeightProperty().bind(mainGridPane.heightProperty());
		contentVBox.prefWidthProperty().bind(mainScroll.widthProperty());
		contentVBox.prefHeightProperty().bind(mainScroll.heightProperty());
	}

}
