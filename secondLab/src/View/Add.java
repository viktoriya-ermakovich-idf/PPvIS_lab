package View;

import Controller.Controller;
import Model.Student;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Add {
	private Main mainFrame;
	private Controller controller;
	private Stage stage;
	private String birthday = "";

	public Add(Main mainFrame, Controller controller) {
		this.mainFrame = mainFrame;
		this.controller = controller;

		GridPane pane = new GridPane();
		pane.setPadding(new Insets(15));
		pane.setVgap(15);
		pane.setHgap(15);

		pane.add(new Label("Enter new information:"), 0, 0);

		pane.add(new Label("Index"), 0, 1);
		pane.add(new Label("Last Name"), 0, 2);
		pane.add(new Label("First Name"), 0, 3);
		pane.add(new Label("Patronymic"), 0, 4);
		pane.add(new Label("Birthday"), 0, 5);
		pane.add(new Label("Team"), 0, 6);
		pane.add(new Label("Faculty"), 0, 7);
		pane.add(new Label("Composition"), 0, 8);
		pane.add(new Label("Position"), 0, 9);

		TextField indexField = new TextField();
		indexField.setPromptText("Index of student");
		pane.add(indexField, 1, 1);

		TextField lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		pane.add(lastNameField, 1, 2);

		TextField firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		pane.add(firstNameField, 1, 3);

		TextField patronymicField = new TextField();
		patronymicField.setPromptText("Patronymic");
		pane.add(patronymicField, 1, 4);

		TextField birthdayField = new TextField();
		birthdayField.setPromptText("Birthday");
		pane.add(birthdayField, 1, 5);

		TextField teamField = new TextField();
		teamField.setPromptText("Team");
		pane.add(teamField, 1, 6);

		TextField facultyField = new TextField();
		facultyField.setPromptText("Faculty");
		pane.add(facultyField, 1, 7);

		TextField compositionField = new TextField();
		compositionField.setPromptText("Composition");
		pane.add(compositionField, 1, 8);

		TextField positionField = new TextField();
		positionField.setPromptText("Position");
		pane.add(positionField, 1, 9);

		Button addStudentButton = new Button("Add student");
		addStudentButton.setOnAction(e -> {
			Student student = new Student();
			student.setIndex(Integer.parseInt(indexField.getText()));
			student.setLastName(lastNameField.getText());
			student.setFirstName(firstNameField.getText());
			student.setPatronymic(patronymicField.getText());
			student.createFio(lastNameField.getText(), firstNameField.getText(), patronymicField.getText());
			student.setBirthday(birthdayField.getText());
			student.setTeam(teamField.getText());
			student.setFaculty(facultyField.getText());
			student.setComposition(compositionField.getText());
			student.setPosition(positionField.getText());

			controller.addStudent(student);
			// главное окно - обновить данные

			// контроллер(addStudent)
			// mainFrame.addStudent(student);
			// mainFrame.update();

			indexField.clear();
			lastNameField.clear();
			firstNameField.clear();
			patronymicField.clear();
			birthdayField.clear();
			teamField.clear();
			facultyField.clear();
			compositionField.clear();
			positionField.clear();

			mainFrame.update();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("New student added");
			alert.showAndWait();
		});

		Button calendar = new Button("Choose date");
		calendar.setOnAction(e -> {
			//
			// DatePicker datePicker = new DatePicker(LocalDate.now());
			// DatePickerSkin datePickerSkin = new DatePickerSkin(datePicker);
			// datePickerSkin.getPopupContent();
			// Node popupContent = datePickerSkin.getPopupContent();
			// LocalDate selectedDate = datePicker.getValue(); // important string!!!!
			// popupContent.setVisible(false);
			// datePicker.getCalendarView().setShowTodayButton(true);
			Stage birthdayStage = new Stage();
			Calendar chooseDate = new Calendar(birthdayStage);
			DatePicker datePicker = chooseDate.getDatePicker();
			// LocalDate selectedDate = datePicker.getValue();
			datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
				birthdayField.setText(newValue.toString());
				birthdayStage.close();
			});
		});

		pane.add(calendar, 2, 5);
		pane.add(addStudentButton, 2, 0);

		Scene scene = new Scene(pane);

		stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Add new student");

		stage.show();
	}
	//
	// public void alertMessage() {
	// Alert alert = new Alert(Alert.AlertType.ERROR);
	// alert.setContentText("New student added");
	// alert.showAndWait();
	// }

}