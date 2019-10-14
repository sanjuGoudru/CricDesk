package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import DAO.LeagueDAO;
import Main.Player;
import Main.PlayerConstants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
		int tid = getPID(e);

		// clearing all league and opening PlayerView.
		grid3.getChildren().clear();
		GridPane contentGrid = null;
		CurrentPlayer.setLID(PlayerConstants.League.CPL);
		CurrentPlayer.setTID(tid);
		try {
			contentGrid = FXMLLoader.load(getClass().getResource("/application/PlayerView.fxml"));
		} catch (IOException e1) {
			System.out.println("Failed to load player GridPane");
			e1.printStackTrace();
		}
		grid3.add(contentGrid, 0, 0, 2, 3);
		setLayout(contentGrid);
	}

	private int getPID(ActionEvent e) {
		Button b = (Button) e.getSource();
		StringTokenizer st = new StringTokenizer(b.getId(), "$");
		st.nextToken();
		int tid = Integer.parseInt(st.nextToken());
		return tid;
	}

	private void setLayout(GridPane contentGrid) {
		contentGrid.prefHeightProperty().bind(grid3.heightProperty());
		contentGrid.prefWidthProperty().bind(grid3.widthProperty());
	}
}
