package Main;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Start extends Application{
	private Scene scene;
	private Parent root;

	@Override
	public void start(Stage stage) {
		try {
		root = FXMLLoader.load(getClass().getResource("/LoginandRegister/startingpage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		} catch(Exception e) {
			e.printStackTrace();
	}
}
	public static void main(String[] args) {
		launch(args);
	}
}
