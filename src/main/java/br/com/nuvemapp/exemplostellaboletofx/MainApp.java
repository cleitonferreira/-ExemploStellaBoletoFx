package br.com.nuvemapp.exemplostellaboletofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Principal.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/styles/Styles.css");

		stage.setTitle("Emissão de Boleto JavaFX");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
