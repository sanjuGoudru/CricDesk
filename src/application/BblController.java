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
		int tid = getPID(e);

		// clearing all league and opening PlayerView.
		grid2.getChildren().clear();
		GridPane contentGrid = null;
		CurrentPlayer.setLID(PlayerConstants.League.BBL);
		CurrentPlayer.setTID(tid);
		try {
			contentGrid = FXMLLoader.load(getClass().getResource("/application/PlayerView.fxml"));
		} catch (IOException e1) {
			System.out.println("Failed to load player GridPane");
			e1.printStackTrace();
		}
		grid2.add(contentGrid, 0, 0, 2, 4);
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
		contentGrid.prefHeightProperty().bind(grid2.heightProperty());
		contentGrid.prefWidthProperty().bind(grid2.widthProperty());
	}
}
