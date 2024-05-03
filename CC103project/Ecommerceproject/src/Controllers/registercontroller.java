package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import DBconnection.dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class registercontroller {

	@FXML
	private TextField firstnameReg;
	@FXML
	private TextField lastnameReg;
	@FXML
	private TextField usernameReg;
	@FXML
	private TextField emailReg;
	@FXML
	private PasswordField passwordReg;
	@FXML
	private Button buttonReg;
	@FXML
	private Button buttontoLog;
	@FXML
	private Button buttonStart;
	@FXML
	private Label fnameErrorReg;
	@FXML
	private Label lnameErrorReg;
	@FXML
	private Label unameErrorReg;
	@FXML
	private Label emailErrorReg;
	@FXML
	private Label passwordErrorReg;
	private Scene scene;
	private Stage stage;
	private Parent root;
	
	//Sign up function//
	@FXML
	public void submitReg(ActionEvent event) throws SQLException, IOException{
		if(firstnameReg.getText().isEmpty()) {
			return;
		}
		if(lastnameReg.getText().isEmpty()) {
			return;
		}
		if(usernameReg.getText().isEmpty()) {
			return;
		}
		if(emailReg.getText().isEmpty()) {
			return;
		}
		if(passwordReg.getText().isEmpty()) {
			return;
		}
		
		String Firstname = firstnameReg.getText();
		String Lastname = lastnameReg.getText();
		String Username = usernameReg.getText();
		String Email = emailReg.getText();
		String Password = passwordReg.getText();
		
		dbconnect _conn = new dbconnect();
		_conn.insertRecord(Firstname, Lastname, Username, Email, Password);
		
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginandRegister/login.fxml"));
		 Parent root = loader.load();
		 Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		}
 
	//button for login//
	@FXML
	public void switchtoLog(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/LoginandRegister/login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//button for start//
	@FXML
	public void switchtostart(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("/LoginandRegister/startingpage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
