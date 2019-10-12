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

public class CplContoller {
	@FXML
	private GridPane grid3;
	@FXML
	private Button jt$2;
	@FXML
	private Button bt$5;
	@FXML
	private Button stz$6;
	@FXML
	private Button snp$4;
	@FXML
	private Button tkr$1;
	@FXML
	private Button gaw$3;
	public void click(ActionEvent e) {
		Button b = (Button) e.getSource();
		StringTokenizer st = new StringTokenizer(b.getId(), "$");
		st.nextToken();
		int tid = Integer.parseInt(st.nextToken());
		LeagueDAO league = new LeagueDAO();
		league.connect();
		ArrayList<Player> players=null;
		try {
			players = league.getAllPlayers(tid, 3);
			System.out.println(players);
		} catch (SQLException e1) {
			System.out.println("Failed to get players");
			e1.printStackTrace();
		}
		
	}
}
