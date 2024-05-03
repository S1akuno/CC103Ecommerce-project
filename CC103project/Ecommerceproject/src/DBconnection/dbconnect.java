package DBconnection;

import java.sql.*;
public class dbconnect {

	static Connection _conn;
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/dbconnection";
	static String uname = "root";
	static String pass = "";
	static String loginandregister = "INSERT INTO users(firstname, lastname, username, email, password) VALUES (?, ?, ?, ?, ?)";
	static String product = "INSERT INTO products(product_name, product_desc, quantity, price, image) VALUES (?, ?, ?, ?, ?)";
	static String productQuery = "SELECT * FROM products";
	
	public void insertRecord(String firstname, String lastname, String username, String email, String password) throws SQLException{
		try {
		Class.forName(driver);
		
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try(Connection connection = DriverManager.getConnection(url, uname, pass);
				PreparedStatement preparedStatement = connection.prepareStatement(loginandregister)) {
			 	preparedStatement.setString(1, firstname);
	            preparedStatement.setString(2, lastname);
	            preparedStatement.setString(3, username);
	            preparedStatement.setString(4, email);
	            preparedStatement.setString(5, password);
	            
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
		}catch (SQLException e) {
            printSQLException(e);
}	
}
	 public boolean validateLogin(String username, String password) throws SQLException {
	        boolean isValid = false;
	        try {
	            Class.forName(driver);
	        } catch (ClassNotFoundException e1) {
	            e1.printStackTrace();
	        }
	        try (Connection connection = DriverManager.getConnection(url, uname, pass);
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                isValid = true; // User exists and password matches
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return isValid;
	    }
	public void insertProduct(String product_name, String product_desc, int quantity, int price) throws SQLException{
		try {
			Class.forName(driver);
		}catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try(Connection connection = DriverManager.getConnection(url, uname, pass);
				PreparedStatement preparedStatement = connection.prepareStatement(product)) {
			 	preparedStatement.setString(1, product_name);
	            preparedStatement.setString(2, product_desc);
	            preparedStatement.setInt(3, quantity);
	            preparedStatement.setInt(4, price);
	            
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	}catch (SQLException e) {
        printSQLException(e);
}
}
	public ResultSet getAllProducts() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, uname, pass);
        PreparedStatement preparedStatement = connection.prepareStatement(productQuery);
        return preparedStatement.executeQuery();
    }
	private void printSQLException(SQLException e) {
		for (Throwable e1: e) {
			 if (e1 instanceof SQLException) {
	                e1.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = e.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
}
}
}
}
}