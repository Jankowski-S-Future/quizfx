package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ViewBuilder {
	private int click = 0;
	private int completed = 0;
	private int counter = 0;
	private Integer lastindex;

	public Scene buildScene(GridPane grid) {
		return new Scene(grid, 640, 630);
	}

	public GridPane buildGridPane() {
		GridPane grid = new GridPane();
		List<Button> buttonsList = prepareButtons();

		Collections.shuffle(buttonsList);
		int rowIndex = 0;
		int columnIndex = 0;

		for (Button button : buttonsList) {
			if (columnIndex == 4) {
				rowIndex++;
				columnIndex = 0;
			}

			grid.add(button, columnIndex, rowIndex);
			columnIndex++;
		}

		return grid;
	}

	private List<Button> prepareButtons() {
		List<Button> buttonsList = new ArrayList<>();
		int imageId;

		for (int i = 1; i <= 16; i++) {
			Button button = new Button("");
			imageId = i <= 8 ? i : i - 8;

			button.setPrefSize(160, 160);
			button.setId(String.valueOf(imageId));
			button.setText("CLICK Me");
			button.setBorder(null);
			button.setOnAction(event -> {
				counter++;
				click++;

				Button clickedButton = (Button) event.getSource();
				clickedButton.setText(null);

				Image image = new Image(getClass().getResourceAsStream("/" + clickedButton.getId() + ".png"));
				ImageView view = new ImageView(image);
				clickedButton.setGraphic(view);
				clickedButton.setMouseTransparent(true);

				if (counter % 2 == 0) {
					if (buttonsList.get(lastindex).getId().equals((clickedButton).getId())) {
						clickedButton.setDisable(true);
						buttonsList.get(lastindex).setDisable(true);

						completed++;

						if (completed == 8) {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("Zwyciêstwo");
							alert.setHeaderText("GRATULACJE!");
							alert.setContentText("Do zwyciêstwa potrzebowa³eœ tylko " + click + " klikniêæ");
							alert.showAndWait();
						}
					} else {
						buttonsList.get(lastindex).setText("CLICK Me");
						buttonsList.get(lastindex).setGraphic(null);
						buttonsList.get(lastindex).setMouseTransparent(false);

						counter = 1;
					}
				}

				lastindex = buttonsList.indexOf(clickedButton);
			});

			buttonsList.add(button);
		}

		return buttonsList;
	}
}
