package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DBconnection.dbconnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class productscontroller implements Initializable {
//product 1//
	@FXML
	private Label productName1;
	@FXML
	private Label productDesc1;
	@FXML
	private Label quantity1;
	@FXML
	private Label price1;
	@FXML
	private ImageView image1;
	@FXML
//product 2//
	private Label productName2;
	@FXML
	private Label productDesc2;
	@FXML
	private Label quantity2;
	@FXML
	private Label price2;
	@FXML
	private ImageView image2;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		try {
			dbconnect _conn = new dbconnect();
			ResultSet resultset = _conn.getAllProducts();
			int labelCounter = 1;
			 while (resultset.next() && labelCounter <= 2) {
				  String Name = resultset.getString("product_name");
				  String Desc = resultset.getString("product_desc");
				  String Quantity = resultset.getString("quantity");
				  String Price = resultset.getString("price");
				  String Image = resultset.getString("image");
				  
				  switch (labelCounter) {
				  //product 1//
				  case 1:
				  productName1.setText(Name);
				  productDesc1.setText(Desc);
				  quantity1.setText(Quantity);
				  price1.setText(Price);
				  image1.setId(Image);
				  break;
				  //product 2//
				  case 2:
				  productName2.setText(Name);
				  productDesc2.setText(Desc);
				  quantity2.setText(Quantity);
				  price2.setText(Price);
				  image2.setId(Image);
				  break;
			  }
				  labelCounter++;
			 }
		}catch (SQLException e) {
            e.printStackTrace();
		
	}

}
}