package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import DBconnection.dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class logincontroller {

@FXML
private TextField usernameLog;
@FXML
private PasswordField passwordLog;
@FXML
private Button buttonLog;
@FXML
private Button buttonStart;
@FXML
private Button buttontoReg;
@FXML
private Button buttontoAdmin;
@FXML
private Label unameErrorLog;
@FXML
private Label passwordErrorLog;
private Stage stage;
private Scene scene;
private Parent root;

//button for logging in//
@FXML
public void submitLog(ActionEvent event) throws SQLException {
	if(usernameLog.getText().isEmpty()) {
		return;
	}
	if(passwordLog.getText().isEmpty()) {
		return;
	}
	String Username = usernameLog.getText();
	String Password = passwordLog.getText();
	
	dbconnect _conn = new dbconnect();
	try {
	boolean isValid  = _conn.validateLogin(Username, Password);
	if(isValid) {
		try {
			root = FXMLLoader.load(getClass().getResource("/SystemApp/homepage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}else {
		System.out.print("Testing wrong");
	}
	}catch (SQLException e) {
		  e.printStackTrace();
	}
}

//button for switching different scenes//
@FXML
public void switchtoReg(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("/LoginandRegister/register.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
@FXML
public void switchtoAdmin(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("/Admin/admin.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
@FXML
public void switchtostart(ActionEvent event) throws IOException{
	root = FXMLLoader.load(getClass().getResource("/LoginandRegister/startingpage.fxml"));
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
}