package View;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Form {

	private TableView<Student> studentTable;
	private VBox paneBox;
	private HBox pageBox;
	private ToolBar pageList;
	private ToolBar recordList;
	private int currentPage = 0;
	private int recordsOnPage = 200;
	private List<Student> list;
	private Label allRecordsLabel;
	private Label allPageLabel;

	public Form() {
		studentTable = new TableView<>();

		TableColumn<Student, String> column0 = new TableColumn<>("¹");
		column0.setCellValueFactory(new PropertyValueFactory<Student, String>("index"));
		column0.setMaxWidth(50);

		TableColumn<Student, String> column1 = new TableColumn<>("FIO of student");
		column1.setCellValueFactory(new PropertyValueFactory<Student, String>("fio"));
		column1.setMinWidth(270);

		TableColumn<Student, String> column2 = new TableColumn<>("Birthday");
		column2.setCellValueFactory(new PropertyValueFactory<Student, String>("birthday"));
		column2.setMinWidth(120);

		TableColumn<Student, String> column3 = new TableColumn<>("Football team");
		column3.setCellValueFactory(new PropertyValueFactory<Student, String>("team"));
		column3.setMinWidth(140);

		TableColumn<Student, String> column4 = new TableColumn<>("Faculty");
		column4.setCellValueFactory(new PropertyValueFactory<Student, String>("faculty"));
		column4.setMinWidth(100);

		TableColumn<Student, String> column5 = new TableColumn<>("Composition");
		column5.setCellValueFactory(new PropertyValueFactory<Student, String>("composition"));
		column5.setMinWidth(150);

		TableColumn<Student, String> column6 = new TableColumn<>("Position");
		column6.setCellValueFactory(new PropertyValueFactory<Student, String>("position"));
		column6.setMinWidth(170);

		studentTable.getColumns().add(column0);
		studentTable.getColumns().add(column1);
		studentTable.getColumns().add(column2);
		studentTable.getColumns().add(column3);
		studentTable.getColumns().add(column4);
		studentTable.getColumns().add(column5);
		studentTable.getColumns().add(column6);

		studentTable.setPrefSize(1000, 500);
		studentTable.setTranslateY(50);

		paneBox = new VBox();

		pageBox = new HBox();

		Label currentPageLabel = new Label("Current page: " + (currentPage + 1));

		allPageLabel = new Label("Number of pages: " + 0);
		allRecordsLabel = new Label();
		Label recordOnPages = new Label("Number of record on page: " + recordsOnPage);

		pageList = new ToolBar();

		Button firstPage = new Button("<<");
		firstPage.setOnAction(e -> {
			currentPage = 0;
			setCurrentPage(currentPage);
			currentPageLabel.setText("Current page: " + (currentPage + 1));
		});

		Button previousPage = new Button("<");
		previousPage.setOnAction(e -> {
			if (currentPage > 0) {
				currentPage--;
				setCurrentPage(currentPage);
				currentPageLabel.setText("Current page: " + (currentPage + 1));
			}
		});

		Button nextPage = new Button(">");
		nextPage.setOnAction(e -> {
			if (currentPage < (list.size() - 1) / recordsOnPage) {
				currentPage++;
				setCurrentPage(currentPage);
				currentPageLabel.setText("Current page: " + (currentPage + 1));
			}
		});

		Button lastPage = new Button(">>");
		lastPage.setOnAction(e -> {
			currentPage = (list.size() - 1) / recordsOnPage;
			setCurrentPage(currentPage);
			currentPageLabel.setText("Current page: " + (currentPage + 1));
		});

		pageList.getItems().addAll(firstPage, previousPage, nextPage, lastPage);
		pageList.setTranslateX(425);
		pageList.setTranslateY(550);

		recordList = new ToolBar();

		TextField recordOnPagesField = new TextField();
		recordOnPagesField.setPromptText("Number of record on page: ");
		Button enterRecord = new Button("OK");
		enterRecord.setOnAction(e -> {
			int records = Integer.parseInt(recordOnPagesField.getText());
			recordsOnPage = records;
			recordOnPages.setText("Number of record on page: " + recordsOnPage);
			currentPage = 0;
			setCurrentPage(currentPage);
			currentPageLabel.setText("Current page: " + (currentPage + 1));
			recordOnPagesField.clear();
			allPageLabel.setText("Number of pages: " + (int) Math.ceil((double) list.size() / recordsOnPage));

		});

		recordList.getItems().addAll(recordOnPagesField, enterRecord);
		recordList.setTranslateX(790);
		recordList.setTranslateY(560);

		pageBox.getChildren().addAll(/* firstPage, previousPage, nextPage, lastPage, */currentPageLabel, allPageLabel,
				allRecordsLabel, recordOnPages/* , recordOnPagesField, enterRecord */);
		pageBox.setSpacing(5);
		pageBox.setTranslateX(8);
		pageBox.setTranslateY(584);
		paneBox.getChildren().addAll(/* studentTable, */ pageBox);
		paneBox.setSpacing(3);
		paneBox.setTranslateX(0);
		paneBox.setTranslateY(530);

	}

	public ToolBar getRecordList() {
		return recordList;
	}

	public ToolBar getPageList() {
		return pageList;
	}

	public VBox getPaneBox() {
		return paneBox;
	}

	public HBox getPageBox() {
		return pageBox;
	}

	public TableView<Student> getStudentTable() {
		return studentTable;
	}

	public void setPaneBox(VBox paneBox) {
		this.paneBox = paneBox;
	}

	public void setStudentTable(TableView<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public void clear() {
		ObservableList<Student> list = FXCollections.observableArrayList();
		studentTable.setItems(list);
	}

	public void setList(List<Student> studentList) {
		this.list = studentList;
		allRecordsLabel.setText("Number of records: " + studentList.size());
		allPageLabel.setText("Number of pages: " + (int) Math.ceil((double) list.size() / recordsOnPage));
	}

	public void setCurrentPage(int currentPage) {
		List<Student> page = new ArrayList<>();
		int numberOfRecords = recordsOnPage;
		if ((list.size() - currentPage * recordsOnPage) < recordsOnPage) {
			numberOfRecords = this.list.size() - currentPage * recordsOnPage;
		}

		for (int stud = currentPage * recordsOnPage; stud < currentPage * recordsOnPage + numberOfRecords; stud++) {
			page.add(this.list.get(stud));
		}
		clear();
		studentTable.setItems(FXCollections.observableArrayList(page));
	}
}
