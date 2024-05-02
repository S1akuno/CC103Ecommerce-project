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

public class homepagecontroller {
@FXML
private Button toshop;
@FXML
private Button logout;
private Stage stage;
private Scene scene;
private Parent root;

public void product(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("/SystemApp/productspage.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void logout(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("/LoginandRegister/Login.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
}
