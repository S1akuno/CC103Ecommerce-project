package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class startingpagecontroller {
@FXML
private Button toReg;
@FXML
private Button toLog;
private Stage stage;
private Scene scene;
private Parent root;

public void switchtoReg(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("/LoginandRegister/register.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
}
