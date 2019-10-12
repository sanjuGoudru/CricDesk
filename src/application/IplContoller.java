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

public class IplContoller {
	@FXML
	private GridPane grid2;
	@FXML
	private Button rcb$1;
	@FXML
	private Button csk$2;
	@FXML
	private Button mi$3;
	@FXML
	private Button kkr$8;
	@FXML
	private Button kxip$5;
	@FXML
	private Button dd$7;
	@FXML
	private Button rr$6;
	@FXML
	private Button srh$4;

	public void click(ActionEvent e) {
		Button b = (Button) e.getSource();
		StringTokenizer st = new StringTokenizer(b.getId(), "$");
		st.nextToken();
		int tid = Integer.parseInt(st.nextToken());
		LeagueDAO league = new LeagueDAO();
		league.connect();
		ArrayList<Player> players=null;
		try {
			players = league.getAllPlayers(tid, 1);
			System.out.println(players);
		} catch (SQLException e1) {
			System.out.println("Failed to get players");
			e1.printStackTrace();
		}
		
	}

}
