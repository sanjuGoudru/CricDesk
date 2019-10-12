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

public class TblController {
	@FXML
	private GridPane grid4;
	@FXML
	private Button dur$7;
	@FXML
	private Button ess$5;
	@FXML
	private Button glo$2;
	@FXML
	private Button hamp$8;
	@FXML
	private Button kent$11;
	@FXML
	private Button lanc$10;
	@FXML
	private Button leic$4;
	@FXML
	private Button mid$9;
	@FXML
	private Button som$1;
	@FXML
	private Button sur$13;
	@FXML
	private Button sus$12;
	@FXML
	private Button war$3;
	@FXML
	private Button worc$14;
	@FXML
	private Button york$6;

	public void click(ActionEvent e) {
		Button b = (Button) e.getSource();
		StringTokenizer st = new StringTokenizer(b.getId(), "$");
		st.nextToken();
		int tid = Integer.parseInt(st.nextToken());
		LeagueDAO league = new LeagueDAO();
		league.connect();
		ArrayList<Player> players = null;
		try {
			players = league.getAllPlayers(tid, 4);
			System.out.println(players);
		} catch (SQLException e1) {
			System.out.println("Failed to get players");
			e1.printStackTrace();
		}

	}
}
