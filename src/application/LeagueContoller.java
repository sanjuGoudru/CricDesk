package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class LeagueContoller {
	@FXML
	private GridPane grid1;
	@FXML
	private Button ipl;
	@FXML
	private Button bbl;
	@FXML
	private Button cpl;
	@FXML
	private Button tbl;
	public void click(ActionEvent e) {
		System.out.println("click");
	}
}
