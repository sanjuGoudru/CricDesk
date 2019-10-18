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

		} catch (Exception e) {
			System.out.println("Error loading File");
			e.printStackTrace();
		}
		grid1.getChildren().clear();
		grid1.add(gp, 0, 0, 2, 2);
		gp.prefHeightProperty().bind(grid1.heightProperty());
		gp.prefWidthProperty().bind(grid1.widthProperty());
		GridPane.setHalignment(gp, HPos.CENTER);
		GridPane.setValignment(gp, VPos.CENTER);
	}

	public void clickbbl(ActionEvent event) {
		try {
			gp = FXMLLoader.load(getClass().getResource("/application/bblLeague.fxml"));

		} catch (Exception e) {
			System.out.println("Error loading File");
			e.printStackTrace();
		}
		grid1.getChildren().clear();
		grid1.add(gp, 0, 0, 2, 2);
		gp.prefHeightProperty().bind(grid1.heightProperty());
		gp.prefWidthProperty().bind(grid1.widthProperty());
		GridPane.setHalignment(gp, HPos.CENTER);
		GridPane.setValignment(gp, VPos.CENTER);
	}

	public void clickcpl(ActionEvent event) {
		try {
			gp = FXMLLoader.load(getClass().getResource("/application/CplLeague.fxml"));

		} catch (Exception e) {
			System.out.println("Error loading File");
			e.printStackTrace();
		}
		grid1.getChildren().clear();
		grid1.add(gp, 0, 0, 2, 2);
		gp.prefHeightProperty().bind(grid1.heightProperty());
		gp.prefWidthProperty().bind(grid1.widthProperty());
		GridPane.setHalignment(gp, HPos.CENTER);
		GridPane.setValignment(gp, VPos.CENTER);
	}

	public void clicktbl(ActionEvent event) {
		try {
			gp = FXMLLoader.load(getClass().getResource("/application/TblLeague.fxml"));

		} catch (Exception e) {
			System.out.println("Error loading File");
			e.printStackTrace();
		}
		grid1.getChildren().clear();
		grid1.add(gp, 0, 0, 2, 2);
		gp.prefHeightProperty().bind(grid1.heightProperty());
		gp.prefWidthProperty().bind(grid1.widthProperty());
		GridPane.setHalignment(gp, HPos.CENTER);
		GridPane.setValignment(gp, VPos.CENTER);
	}
}