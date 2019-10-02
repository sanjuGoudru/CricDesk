package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.scene.Parent;
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
		AnchorPane anchor = null;
		try {
			anchor = FXMLLoader.load(getClass().getResource("/application/Catalog.fxml"));
		} catch (IOException e) {
			System.out.println("Unable to load  Catalog.fxml");
			e.printStackTrace();
		}
		Label l = (Label) anchor.getChildren().get(0);
		centerGridPane.add(l, 0, 0, 2, 3);
		GridPane.setHalignment(l, HPos.CENTER);
		GridPane.setValignment(l, VPos.CENTER);
	}		

}
