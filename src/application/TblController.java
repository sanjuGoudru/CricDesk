package application;

import java.io.IOException;
import java.util.StringTokenizer;
import Main.PlayerConstants;
import javafx.event.ActionEvent;
import javafx.fxml.*;
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
		int tid = getPID(e);

		// clearing all league and opening PlayerView.
		grid4.getChildren().clear();
		GridPane contentGrid = null;
		CurrentPlayer.setLID(PlayerConstants.League.TBL);
		CurrentPlayer.setTID(tid);
		try {
			contentGrid = FXMLLoader.load(getClass().getResource("/application/PlayerView.fxml"));
		} catch (IOException e1) {
			System.out.println("Failed to load player GridPane");
			e1.printStackTrace();
		}
		grid4.add(contentGrid, 0, 0, 2, 7);
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
		contentGrid.prefHeightProperty().bind(grid4.heightProperty());
		contentGrid.prefWidthProperty().bind(grid4.widthProperty());
	}
}
