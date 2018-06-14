package View;

import Model.Student;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Widget {
	private TextField lastNameFieldFB;
	private TextField firstNameFieldFB;
	private TextField patronymicFieldFB;
	public TextField birthdayFieldFB;
	private TextField positionFieldPC;
	private TextField compositionFieldPC;
	private TextField lastNameFieldFT;
	private TextField firstNameFieldFT;
	private TextField patronymicFieldFT;
	private TextField teamFieldFT;
	private TextField facultyFieldFF;
	private TextField lastNameFieldFF;
	private TextField firstNameFieldFF;
	private TextField patronymicFieldFF;
	private Student searchStudent = new Student();
	private VBox rootFioAndBirthday;
	private VBox rootPositionAndComposition;
	private VBox rootFioAndTeam;
	private VBox rootFacultyAndFio;

	public Widget() {
		rootFioAndBirthday = new VBox();

		GridPane fioAndBirthdayBox = new GridPane();
		fioAndBirthdayBox.setPadding(new Insets(15));
		fioAndBirthdayBox.setVgap(15);
		fioAndBirthdayBox.setHgap(15);

		Label lastNameLabelFB = new Label("Last Name:");
		lastNameFieldFB = new TextField();
		lastNameFieldFB.setPromptText("Last Name");
		fioAndBirthdayBox.add(lastNameLabelFB, 0, 0);
		fioAndBirthdayBox.add(lastNameFieldFB, 1, 0);

		Label firstNameLabelFB = new Label("First Name:");
		firstNameFieldFB = new TextField();
		firstNameFieldFB.setPromptText("First Name");
		fioAndBirthdayBox.add(firstNameLabelFB, 0, 1);
		fioAndBirthdayBox.add(firstNameFieldFB, 1, 1);

		Label patronymicLabelFB = new Label("Patronymic:");
		patronymicFieldFB = new TextField();
		patronymicFieldFB.setPromptText("Patronymic");
		fioAndBirthdayBox.add(patronymicLabelFB, 0, 2);
		fioAndBirthdayBox.add(patronymicFieldFB, 1, 2);

		Label birthdayLabelFB = new Label("Birthday:");
		birthdayFieldFB = new TextField();
		birthdayFieldFB.setPromptText("Birthday");
		fioAndBirthdayBox.add(birthdayLabelFB, 0, 3);
		fioAndBirthdayBox.add(birthdayFieldFB, 1, 3);

		rootFioAndBirthday.getChildren().addAll(fioAndBirthdayBox);
		/////////////////////////////////////////////
		rootPositionAndComposition = new VBox();

		GridPane positionAndCompositionBox = new GridPane();
		positionAndCompositionBox.setPadding(new Insets(15));
		positionAndCompositionBox.setVgap(15);
		positionAndCompositionBox.setHgap(15);

		Label positionLabelPC = new Label("Position:");
		positionFieldPC = new TextField();
		positionFieldPC.setPromptText("Position");
		positionAndCompositionBox.add(positionLabelPC, 0, 0);
		positionAndCompositionBox.add(positionFieldPC, 1, 0);

		Label compositionLabelPC = new Label("Composition: ");
		compositionFieldPC = new TextField();
		compositionFieldPC.setPromptText("Composition");
		positionAndCompositionBox.add(compositionLabelPC, 0, 1);
		positionAndCompositionBox.add(compositionFieldPC, 1, 1);

		rootPositionAndComposition.getChildren().addAll(positionAndCompositionBox);
		////////////////////////////////////////
		rootFioAndTeam = new VBox();

		GridPane fioAndTeamBox = new GridPane();
		fioAndTeamBox.setPadding(new Insets(15));
		fioAndTeamBox.setVgap(15);
		fioAndTeamBox.setHgap(15);

		Label lastNameLabelFT = new Label("Last Name:");
		lastNameFieldFT = new TextField();
		lastNameFieldFT.setPromptText("LastName");
		fioAndTeamBox.add(lastNameLabelFT, 0, 0);
		fioAndTeamBox.add(lastNameFieldFT, 1, 0);

		Label firstNameLabelFT = new Label("First Name:");
		firstNameFieldFT = new TextField();
		firstNameFieldFT.setPromptText("First Name");
		fioAndTeamBox.add(firstNameLabelFT, 0, 1);
		fioAndTeamBox.add(firstNameFieldFT, 1, 1);

		Label patronymicLabelFT = new Label("Patronymic:");
		patronymicFieldFT = new TextField();
		patronymicFieldFT.setPromptText("Patronymic");
		fioAndTeamBox.add(patronymicLabelFT, 0, 2);
		fioAndTeamBox.add(patronymicFieldFT, 1, 2);

		Label teamLabelFT = new Label("Team:");
		teamFieldFT = new TextField();
		teamFieldFT.setPromptText("Team");
		fioAndTeamBox.add(teamLabelFT, 0, 3);
		fioAndTeamBox.add(teamFieldFT, 1, 3);

		rootFioAndTeam.getChildren().addAll(fioAndTeamBox);
		////////////////////////////////////////
		rootFacultyAndFio = new VBox();

		GridPane facultyAndFioBox = new GridPane();
		facultyAndFioBox.setPadding(new Insets(15));
		facultyAndFioBox.setVgap(15);
		facultyAndFioBox.setHgap(15);

		Label facultyAndFioLabelFF = new Label("Faculty:");
		facultyFieldFF = new TextField();
		facultyFieldFF.setPromptText("Faculty");
		facultyAndFioBox.add(facultyAndFioLabelFF, 0, 0);
		facultyAndFioBox.add(facultyFieldFF, 1, 0);

		Label lastNameLabelFF = new Label("Last Name:");
		lastNameFieldFF = new TextField();
		lastNameFieldFF.setPromptText("Last Name");
		facultyAndFioBox.add(lastNameLabelFF, 0, 1);
		facultyAndFioBox.add(lastNameFieldFF, 1, 1);

		Label firstNameLabelFF = new Label("First Name:");
		firstNameFieldFF = new TextField();
		firstNameFieldFF.setPromptText("First Name");
		facultyAndFioBox.add(firstNameLabelFF, 0, 2);
		facultyAndFioBox.add(firstNameFieldFF, 1, 2);

		Label patronymicFieldLabelFF = new Label("Patronymic:");
		patronymicFieldFF = new TextField();
		patronymicFieldFF.setPromptText("Patronymic");
		facultyAndFioBox.add(patronymicFieldLabelFF, 0, 3);
		facultyAndFioBox.add(patronymicFieldFF, 1, 3);

		rootFacultyAndFio.getChildren().addAll(facultyAndFioBox);
	}

	public Student getStudentFioAndBirthday() {
		searchStudent.clean();
		searchStudent.setLastName(lastNameFieldFB.getText());
		searchStudent.setFirstName(firstNameFieldFB.getText());
		searchStudent.setPatronymic(patronymicFieldFB.getText());
		searchStudent.createFio(lastNameFieldFB.getText(), firstNameFieldFB.getText(), patronymicFieldFB.getText());
		searchStudent.setBirthday(birthdayFieldFB.getText());
		lastNameFieldFB.clear();
		firstNameFieldFB.clear();
		patronymicFieldFB.clear();
		birthdayFieldFB.clear();
		return searchStudent;
	}

	public Student getStudentPositionAndComposition() {
		searchStudent.clean();
		searchStudent.setPosition(positionFieldPC.getText());
		searchStudent.setComposition(compositionFieldPC.getText());
		positionFieldPC.clear();
		compositionFieldPC.clear();
		return searchStudent;
	}

	public Student getStudentFioAndTeam() {
		searchStudent.clean();
		searchStudent.setLastName(lastNameFieldFT.getText());
		searchStudent.setFirstName(firstNameFieldFT.getText());
		searchStudent.setPatronymic(patronymicFieldFT.getText());
		searchStudent.setTeam(teamFieldFT.getText());
		lastNameFieldFT.clear();
		firstNameFieldFT.clear();
		patronymicFieldFT.clear();
		teamFieldFT.clear();
		return searchStudent;
	}

	public Student getStudentFacultyAndFio() {
		searchStudent.clean();
		searchStudent.setFaculty(facultyFieldFF.getText());
		searchStudent.setLastName(lastNameFieldFF.getText());
		searchStudent.setFirstName(firstNameFieldFF.getText());
		searchStudent.setPatronymic(patronymicFieldFF.getText());
		facultyFieldFF.clear();
		lastNameFieldFF.clear();
		firstNameFieldFF.clear();
		patronymicFieldFF.clear();
		return searchStudent;
	}

	public VBox getRootFioAndBirthday() {
		return rootFioAndBirthday;
	}

	public VBox getRootPositionAndComposition() {
		return rootPositionAndComposition;
	}

	public VBox getRootFioAndTeam() {
		return rootFioAndTeam;
	}

	public VBox getRootFacultyAndFio() {
		return rootFacultyAndFio;
	}

	public TextField getLastNameFieldFB() {
		return lastNameFieldFB;
	}

	public TextField getFirstNameFieldFB() {
		return firstNameFieldFB;
	}

	public TextField getPatronymicFieldFB() {
		return patronymicFieldFB;
	}

	public TextField getBirthdayFieldFB() {
		return birthdayFieldFB;
	}

	public TextField getPositionFieldPC() {
		return positionFieldPC;
	}

	public TextField getCompositionFieldPC() {
		return compositionFieldPC;
	}

	public TextField getLastNameFieldFT() {
		return lastNameFieldFT;
	}

	public TextField getFirstNameFieldFT() {
		return firstNameFieldFT;
	}

	public TextField getPatronymicFieldFT() {
		return patronymicFieldFT;
	}

	public TextField getTeamFieldFT() {
		return teamFieldFT;
	}

	public TextField getFacultyFieldFF() {
		return facultyFieldFF;
	}

	public TextField getLastNameFieldFF() {
		return lastNameFieldFF;
	}

	public TextField getFirstNameFieldFF() {
		return firstNameFieldFF;
	}

	public TextField getpatronymicFieldFF() {
		return patronymicFieldFF;
	}
}
