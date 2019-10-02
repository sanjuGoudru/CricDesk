package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class MainController implements Initializable {
	@FXML
	private VBox leftVBox;
	@FXML
	private ImageView catalog;
	@FXML
	private ImageView league;
	@FXML
	private ImageView about;
	@FXML
	private GridPane centerGridPane;
	@FXML
	private ImageView main_logo;
	@FXML
	private ImageView main_logo2;
	@FXML
	private BorderPane mainPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		centerGridPane.heightProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				double height = (double) arg2;
				main_logo.setFitHeight(height / 2);
				main_logo2.setFitHeight(height / 6);
			}
		});
		centerGridPane.widthProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				double width = (double) arg2;
				main_logo.setFitWidth(width / 2);
				main_logo2.setFitWidth(width / 5);
			}
		});
	}

	public void mouseClick() {
		centerGridPane.getChildren().removeAll(main_logo, main_logo2);
		VBox vbox = null;
		try {
			vbox = FXMLLoader.load(getClass().getResource("/application/Catalog.fxml"));
		}catch (Exception e) {
			System.out.println("Error loading File");
			e.printStackTrace();
		}
		centerGridPane.add(vbox, 0, 0, 2, 3);
		GridPane.setHalignment(vbox, HPos.CENTER);
		GridPane.setValignment(vbox, VPos.CENTER);
	}		

}
