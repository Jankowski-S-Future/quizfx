package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	// Utworzenie instancji obiektu do budowania widoku
	private ViewHelper helper = new ViewHelper();

	// Implementacja metody abstrakcyjnej start() z klasy Application pakietu javafx
	// Startuje aplikacjê
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Dopasuj Logo Producenta Samochodu");

		// Utworzenie widoku
		GridPane grid = helper.buildGridPane();
		Scene scene = helper.buildScene(grid);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
