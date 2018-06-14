package View;

import java.util.List;

import Controller.Controller;
import Model.Student;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Delete {
	private Main mainFrame;
	private Controller controller;
	private TabPane tp;
	private Button buttonFB;
	private Button buttonPC;
	private Button buttonFT;
	private Button buttonFF;
	private Button calendar;
	private Widget widget;

	public Delete(Main mainFrame, Controller controller) {
		this.mainFrame = mainFrame;
		this.controller = controller;
	}

	public void start() {
		widget = new Widget();
		Group root = new Group();
		setTabPane();
		root.getChildren().addAll(tp);
		setActionOnButtons();
		Scene scene = new Scene(root, 670, 250);
		Stage stage = new Stage();
		stage.setTitle("Delete students");
		stage.setScene(scene);
		stage.showAndWait();
	}

	public void setTabPane() {
		tp = new TabPane();
		tp.setLayoutX(3);
		tp.setLayoutY(7);

		// search FIO and Birtday
		Tab tabFB = new Tab("Delete FIO and Birtday");
		tabFB.setContent(widget.getRootFioAndBirthday());
		buttonFB = new Button("Delete");
		widget.getRootFioAndBirthday().getChildren().addAll(calendar, buttonFB);

		// search Position and Composition
		Tab tabPC = new Tab("Delete Position and Composition");
		tabPC.setContent(widget.getRootPositionAndComposition());
		buttonPC = new Button("Delete");
		widget.getRootPositionAndComposition().getChildren().addAll(buttonPC);

		// search FIO and Team
		Tab tabFT = new Tab("Delete FIO and Team");
		tabFT.setContent(widget.getRootFioAndTeam());
		buttonFT = new Button("Delete");
		widget.getRootFioAndTeam().getChildren().addAll(buttonFT);

		// search Faculty and FIO
		Tab tabFF = new Tab("Delete Faculty and FIO");
		tabFF.setContent(widget.getRootFacultyAndFio());
		buttonFF = new Button("Delete");
		widget.getRootFacultyAndFio().getChildren().addAll(buttonFF);

		tp.getTabs().addAll(tabFB, tabPC, tabFT, tabFF);
	}

	public void setActionOnButtons() {
		buttonFB.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentFioAndBirthday(),
					"Fio And Birthday");
			controller.removeStudent(resultOfSearch);
			mainFrame.update();
			alertMessage(resultOfSearch);
		});

		buttonPC.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentPositionAndComposition(),
					"Position And Composition");
			controller.removeStudent(resultOfSearch);
			mainFrame.update();
			alertMessage(resultOfSearch);
		});

		buttonFT.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentFioAndTeam(), "Fio And Team");
			controller.getStudentBase().removeAll(resultOfSearch);
			mainFrame.update();
			alertMessage(resultOfSearch);
		});

		buttonFF.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentFacultyAndFio(),
					"Faculty And Fio");
			controller.getStudentBase().removeAll(resultOfSearch);
			mainFrame.update();
			alertMessage(resultOfSearch);
		});

		calendar.setOnAction(e -> {
			Stage birthdayStage = new Stage();
			Calendar chooseDate = new Calendar(birthdayStage);
			DatePicker datePicker = chooseDate.getDatePicker();
			datePicker.valueProperty().addListener((observable, oldValue, newValue) -> { // ????????
				widget.birthdayFieldFB.setText(newValue.toString());
				birthdayStage.close();
			});
		});
	}

	public void alertMessage(List<Student> list) {
		if (list.size() != 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(list.size() + " deleted students");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("No such students");
			alert.showAndWait();
		}
	}

}
