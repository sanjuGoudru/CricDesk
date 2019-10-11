package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
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
	GridPane gp;
	public void clickipl(ActionEvent event) {
			try {
				gp = FXMLLoader.load(getClass().getResource("/application/IplLeague.fxml"));
				
			}catch (Exception e) {
				System.out.println("Error loading File");
				e.printStackTrace();
		}
			grid1.getChildren().removeAll(ipl,bbl,cpl,tbl);
			grid1.add(gp, 0, 0, 2, 2);
			GridPane.setHalignment(gp, HPos.CENTER);
			GridPane.setValignment(gp, VPos.CENTER);
	}
}