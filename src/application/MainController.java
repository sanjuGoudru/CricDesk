package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

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
				main_logo.setFitHeight(height/2);
				main_logo2.setFitHeight(height/6);
			}
		});
		centerGridPane.widthProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
				double width = (double) arg2;
				main_logo.setFitWidth(width/2);
				main_logo2.setFitWidth(width/5);
			}
		});
	}

	public void mouseClick() {
		System.out.println(main_logo2.getFitHeight() + "\t" + main_logo2.getFitWidth());// 130 150
	}

}
