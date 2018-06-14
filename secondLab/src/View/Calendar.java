package View;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Calendar extends Application {

	private DatePicker datePicker;

	public Calendar(Stage primaryStage) {
		start(primaryStage);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			datePicker = new DatePicker(LocalDate.now());
			DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
			Node popupContent = datePickerSkin.getPopupContent();

			root.setCenter(popupContent);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DatePicker getDatePicker() {
		return datePicker;
	}

	public static void main(String[] args) {
		launch(args);
	}
}