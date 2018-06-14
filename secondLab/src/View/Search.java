package View;

import java.util.List;

import Controller.Controller;
import Model.Student;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Search {
	private Main mainFrame;
	private Controller controller;
	private TabPane tp;
	private Widget widget;
	private TableView<Student> studentTable;
	private Form formFB;
	private Form formPC;
	private Form formFT;
	private Form formFF;
	private Button buttonFB;
	private Button buttonPC;
	private Button buttonFT;
	private Button buttonFF;
	private Button calendar;

	public Search(Main mainFrame, Controller controller) {
		this.mainFrame = mainFrame;
		this.controller = controller;
	}

	public void start() {
		widget = new Widget();
		Group root = new Group();
		// studentTable = mainFrame.getForm().getStudentTable();
		// studentTable.setPrefSize(1000, 310);
		// studentTable.setTranslateY(245);
		setTabPane();
		root.getChildren().addAll(getTabPane());
		setForm();
		setActionOnButtons();
		Scene scene = new Scene(root, 1000, 600);
		Stage stage = new Stage();
		stage.setTitle("Search students");
		stage.setScene(scene);
		stage.showAndWait();
	}

	public void setActionOnButtons() {
		buttonFB.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentFioAndBirthday(),
					"Fio And Birthday");
			formFB.setList(resultOfSearch);
			formFB.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
			alertMessage(resultOfSearch);
		});

		buttonPC.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentPositionAndComposition(),
					"Position And Composition");
			formPC.setList(resultOfSearch);
			formPC.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
			alertMessage(resultOfSearch);
		});

		buttonFT.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentFioAndTeam(), "Fio And Team");
			formFT.setList(resultOfSearch);
			formFT.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
			alertMessage(resultOfSearch);
			studentTable.refresh();
		});

		buttonFF.setOnAction(e -> {
			List<Student> resultOfSearch = controller.searchStudents(widget.getStudentFacultyAndFio(),
					"Faculty And Fio");
			formFF.setList(resultOfSearch);
			formFF.getStudentTable().setItems(FXCollections.observableArrayList(resultOfSearch));
			alertMessage(resultOfSearch);
			studentTable.refresh();
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
			alert.setHeaderText(list.size() + " searched students");
			alert.showAndWait();
			// Form form = new Form();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("No such students");
			alert.showAndWait();
		}
	}

	public void setTabPane() {
		tp = new TabPane();
		// tp.setLayoutX(3);
		// tp.setLayoutY(7);

		// search FIO and Birtday
		Tab tabFB = new Tab("Search FIO and Birtday");
		tabFB.setContent(widget.getRootFioAndBirthday());
		buttonFB = new Button("Search");
		calendar = new Button("Choose date");
		widget.getRootFioAndBirthday().getChildren().addAll(calendar, buttonFB);

		// search Position and Composition
		Tab tabPC = new Tab("Search Position and Composition");
		tabPC.setContent(widget.getRootPositionAndComposition());
		buttonPC = new Button("Search");
		widget.getRootPositionAndComposition().getChildren().addAll(buttonPC);

		// search FIO and Team
		Tab tabFT = new Tab("Search FIO and Team");
		tabFT.setContent(widget.getRootFioAndTeam());
		buttonFT = new Button("Search");
		widget.getRootFioAndTeam().getChildren().addAll(buttonFT);

		// search Faculty and FIO
		Tab tabFF = new Tab("Search Faculty and FIO");
		tabFF.setContent(widget.getRootFacultyAndFio());
		buttonFF = new Button("Search");
		widget.getRootFacultyAndFio().getChildren().addAll(buttonFF);

		tp.getTabs().addAll(tabFB, tabPC, tabFT, tabFF);
	}

	public void setForm() {
		formFB = new Form();
		widget.getRootFioAndBirthday().getChildren().add(formFB.getPaneBox());

		formPC = new Form();
		widget.getRootPositionAndComposition().getChildren().add(formPC.getPaneBox());

		formFT = new Form();
		widget.getRootFioAndTeam().getChildren().add(formFT.getPaneBox());

		formFF = new Form();
		widget.getRootFacultyAndFio().getChildren().add(formFF.getPaneBox());
	}

	public TabPane getTabPane() {
		return tp;
	}

}
