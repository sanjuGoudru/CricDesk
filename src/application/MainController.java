package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
	private AnchorPane rightAnchor;
	@FXML
	private ImageView main_logo;
	@FXML
	private ImageView main_logo2;
	@FXML
	private BorderPane mainPane;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rightAnchor.heightProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				double height=(double) newValue;
				//System.out.println(height);
				main_logo.setFitHeight(height/1.3);
				main_logo2.setFitHeight(height/3.5);
			}
		});
		rightAnchor.widthProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				double width=(double) newValue;
				//System.out.println(width);
				main_logo.setFitWidth(width/1.3);
				main_logo2.setFitWidth(width/3.6);
			}
		});
	}

	
}
