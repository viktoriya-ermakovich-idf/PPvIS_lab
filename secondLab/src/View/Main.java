package View;

import java.io.File;

import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main {
	private Controller controller;
	private Form form;

	public Main(Controller controller) {
		this.controller = controller;

		ToolBar tb = new ToolBar();
		tb.setOrientation(Orientation.HORIZONTAL);
		Button add = new Button("Add");
		add.setOnAction(e -> {
			Add addFrame = new Add(this, this.controller);
		});
		Button search = new Button("Search");
		search.setOnAction(e -> {
			Search searchFrame = new Search(this, this.controller);
			searchFrame.start();
		});
		Button delete = new Button("Delete");
		delete.setOnAction(e -> {
			Delete deleteFrame = new Delete(this, this.controller);
			deleteFrame.start();
		});
		tb.getItems().addAll(/* load, save, */add, search, delete);

		MenuBar menuBar = new MenuBar();
		Menu menuF = new Menu("File");
		MenuItem menuItemP = new MenuItem("Open");
		menuItemP.setOnAction(e -> {
			controller.getStudentBase().clear();
			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open file");
			fileChooser.setInitialDirectory(new java.io.File("./"));
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
			File file = fileChooser.showOpenDialog(stage);
			controller.setFile(file);
			controller.fromFile();
			update();
		});
		MenuItem menuItemS = new MenuItem("Save");
		menuItemS.setOnAction(e -> {
			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new java.io.File("./"));
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
			File file = fileChooser.showSaveDialog(stage);

			controller.toFile(file);
		});
		menuF.getItems().addAll(menuItemP, menuItemS);

		Menu menuT = new Menu("Table");
		MenuItem menuAdd = new MenuItem("Add");
		MenuItem menuSearch = new MenuItem("Search");
		MenuItem menuDelete = new MenuItem("Delete");
		menuT.getItems().addAll(menuAdd, menuSearch, menuDelete);

		menuBar.getMenus().addAll(menuF, menuT);
		menuAdd.setOnAction(e -> {
			System.out.println("Add is normal!");
			Add addFrame = new Add(this, this.controller);
		});

		menuSearch.setOnAction(e -> {
			System.out.println("Search is normal!");
			Search searchFrame = new Search(this, this.controller);
			searchFrame.start();
		});

		menuDelete.setOnAction(e -> {
			System.out.println("Delete is normal!");
			Delete deleteFrame = new Delete(this, this.controller);
			deleteFrame.start();
		});

		form = new Form();
		form.setList(controller.getStudentBase());

		VBox allBox = new VBox();
		allBox.setPadding(new Insets(15, 40, 50, 10));
		allBox.setSpacing(20);

		HBox collectiveMemberBox = new HBox();
		collectiveMemberBox.setPadding(new Insets(0, 10, 10, 10));
		collectiveMemberBox.setSpacing(20);
		collectiveMemberBox.getChildren().addAll(tb);
		allBox.getChildren().addAll(collectiveMemberBox);
		allBox.setTranslateX(820);

		Scene scene = new Scene(new Group(), 1000, 600);
		((Group) scene.getRoot()).getChildren().addAll(allBox, menuBar, form.getStudentTable(), form.getPageList(),
				form.getPageBox(), form.getRecordList());

		Stage primaryStage = new Stage();

		primaryStage.setScene(scene);
		primaryStage.setTitle("Football players");
		primaryStage.show();
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public void update() {
		form.clear();
		form.setList(controller.getStudentBase());
		form.getStudentTable().setItems(FXCollections.observableArrayList(controller.getStudentBase()));
	}

	public void alertMessage(String text) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(text);
		alert.showAndWait();
	}
}
