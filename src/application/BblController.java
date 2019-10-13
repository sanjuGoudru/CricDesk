package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import DAO.LeagueDAO;
import Main.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BblController {
	@FXML
	private GridPane grid2;
	@FXML
	private Button ms$3;
	@FXML
	private Button mr$4;
	@FXML
	private Button sr$2;
	@FXML
	private Button st$1;
	@FXML
	private Button bh$6;
	@FXML
	private Button as$7;
	@FXML
	private Button ps$5;
	@FXML
	private Button hh$8;

	public void click(ActionEvent e) {
		Button b = (Button) e.getSource();
		StringTokenizer st = new StringTokenizer(b.getId(), "$");
		st.nextToken();
		int tid = Integer.parseInt(st.nextToken());
		LeagueDAO league = new LeagueDAO();
		league.connect();
		ArrayList<Player> players = null;
		try {
			players = league.getAllPlayers(tid, 2);
			System.out.println(players);
		} catch (SQLException e1) {
			System.out.println("Failed to get players");
			e1.printStackTrace();
		}

	}
}
