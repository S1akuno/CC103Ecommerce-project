package Controllers;

import javafx.event.ActionEvent;
import java.sql.SQLException;
import DBconnection.dbconnect;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class admincontroller {
@FXML
private TextField productnameAdmin;
@FXML
private TextArea productdescAdmin;
@FXML
private TextField quantityAdmin;
@FXML
private TextField priceAdmin;
@FXML
private Button buttonAdmin;

@FXML
public void submitAdmin(ActionEvent event) throws SQLException{
	if(productnameAdmin.getText().isEmpty()) {
		return;
	}
	if(productdescAdmin.getText().isEmpty()) {
		return;
	}
	if(quantityAdmin.getText().isEmpty()) {
		return;
	}
	if(priceAdmin.getText().isEmpty()) {
		return;
	}
	
	String ProductName = productnameAdmin.getText();
	String ProductDesc = productdescAdmin.getText();
	String quantity = quantityAdmin.getText();
	int Quantity = Integer.parseInt(quantity);
	String price = priceAdmin.getText();
	int Price = Integer.parseInt(price);
	dbconnect _conn = new dbconnect();
	_conn.insertProduct(ProductName, ProductDesc, Quantity, Price);
}
}
