package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	private ViewBuilder builder = new ViewBuilder();

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Dopasuj Logo Producenta Samochodu");

		GridPane grid = builder.buildGridPane();
		Scene scene = builder.buildScene(grid);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
