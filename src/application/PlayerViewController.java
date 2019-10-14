package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;

import javafx.scene.layout.VBox;

import javafx.scene.layout.GridPane;

public class PlayerViewController implements Initializable{
	@FXML
	private GridPane mainGridPane;
	@FXML
	private ScrollPane mainScroll;
	@FXML
	private VBox contentVBox;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setLayout();
	}
	
	private void setLayout() {
		mainScroll.prefWidthProperty().bind(mainGridPane.widthProperty());
		mainScroll.prefHeightProperty().bind(mainGridPane.heightProperty());
		contentVBox.prefWidthProperty().bind(mainScroll.widthProperty());
		contentVBox.prefHeightProperty().bind(mainScroll.heightProperty());
	}
	
}
