package button;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Alarm extends Application {

	public void start(Stage primaryStage) {
		FlowPane group1 = new FlowPane();
		group1.setPadding(new Insets(10));
		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.setPrefSize(100, 30);

		ObservableList<String> items = comboBox.getItems();

		TextArea text = new TextArea();
		text.setPrefSize(100, 30);

		Button btn = new Button();
		btn.setPrefSize(40, 30);

		btn.setText("OK");

		btn.setCursor(Cursor.CLOSED_HAND);
		btn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp = text.getText();
				int i = 0;
				for (i = 0; i < items.size(); i++) {

					if (temp.equals(items.get(i)) || temp.equals(""))
						break;
				}
				if (i == items.size()) {
					items.add(temp);
					comboBox.setItems(items);
				} else {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("This item can not be added!");
					alert.showAndWait();
				}
			}
		});
		group1.getChildren().addAll(btn, text, comboBox);

		/////////////////////////////////////////////////////

		FlowPane group2 = new FlowPane();
		group2.setPadding(new Insets(10));

		TextArea text2 = new TextArea();
		text2.setPrefSize(100, 30);

		Button btn2 = new Button("Button1");
		btn2.setPrefSize(100, 30);
		Button btn2_1 = new Button("Button2");
		btn2_1.setPrefSize(100, 30);

		btn2.setCursor(Cursor.CLOSED_HAND);
		btn2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp2 = text2.getText();
				btn2_1.setText(temp2);
			}
		});
		btn2_1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp2_1 = btn2_1.getText();
				String temp2_2 = btn2.getText();
				btn2_1.setText(temp2_2);
				btn2.setText(temp2_1);
			}
		});
		group2.getChildren().addAll(btn2, btn2_1, text2);

		///////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////

		FlowPane group3 = new FlowPane();
		group3.setPadding(new Insets(10));

		TextArea text3 = new TextArea();
		text3.setPrefSize(100, 30);

		Button btn3 = new Button();
		btn3.setPrefSize(40, 30);
		btn3.setText("OK");

		RadioButton rb1 = new RadioButton();
		rb1.setText("1");
		rb1.setPrefSize(50, 30);
		RadioButton rb2 = new RadioButton();
		rb2.setText("2");
		rb2.setPrefSize(50, 30);
		RadioButton rb3 = new RadioButton();
		rb3.setText("3");
		rb3.setPrefSize(50, 30);

		btn3.setCursor(Cursor.CLOSED_HAND);
		btn3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp2 = text3.getText();
				if (temp2.equals(rb1.getText())) {
					rb1.fire();
					rb2.setSelected(false);
					rb3.setSelected(false);
				} else {
					if (temp2.equals(rb2.getText())) {
						rb2.fire();
						rb1.setSelected(false);
						rb3.setSelected(false);
					} else {
						if (temp2.equals(rb3.getText())) {
							rb3.fire();
							rb2.setSelected(false);
							rb1.setSelected(false);
						} else {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("Error");
							alert.setHeaderText(null);
							alert.setContentText("Error! Try again!");
							alert.showAndWait();
						}
					}
				}

			}
		});

		group3.getChildren().addAll(btn3, text3, rb1, rb2, rb3);

		///////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////

		FlowPane group4 = new FlowPane();
		group4.setPadding(new Insets(10));

		TextArea text4 = new TextArea();
		text4.setPrefSize(100, 30);

		CheckBox chb1 = new CheckBox("1");
		CheckBox chb2 = new CheckBox("2");
		CheckBox chb3 = new CheckBox("3");
		chb1.setPrefSize(50, 30);
		chb2.setPrefSize(50, 30);
		chb3.setPrefSize(50, 30);

		Button btn4 = new Button();
		btn4.setPrefSize(40, 30);

		btn4.setText("OK");
		btn4.setCursor(Cursor.CLOSED_HAND);
		btn4.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp3 = text4.getText();
				if (temp3.equals(chb1.getText())) {
					chb1.fire();
				} else {
					if (temp3.equals(chb2.getText())) {
						chb2.fire();
					} else {
						if (temp3.equals(chb3.getText())) {
							chb3.fire();
						} else {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("Error");
							alert.setHeaderText(null);
							alert.setContentText("Error! Try again!");
							alert.showAndWait();
						}
					}
				}

			}
		});
		group4.getChildren().addAll(btn4, text4, chb1, chb2, chb3);

		///////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////

		FlowPane group5 = new FlowPane();
		group5.setPadding(new Insets(10));

		TextArea text5 = new TextArea();
		text5.setPrefSize(100, 30);

		Button btn5 = new Button("1");
		btn5.setPrefSize(40, 30);

		Button btn6 = new Button("2");
		btn6.setPrefSize(40, 30);

		Button btn7 = new Button("3");
		btn7.setPrefSize(40, 30);

		TableView table = new TableView();
		table.setEditable(true);
		TableColumn name = new TableColumn("");
		TableColumn surname = new TableColumn("");
		table.getColumns().addAll(name, surname);
		table.setPrefSize(160, 0);

		btn5.setCursor(Cursor.CLOSED_HAND);
		btn5.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp5 = text5.getText();
				name.setText(temp5);
				surname.setText(null);
			}
		});
		btn6.setCursor(Cursor.CLOSED_HAND);
		btn6.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp6 = text5.getText();
				surname.setText(temp6);
				name.setText(null);
			}
		});
		btn7.setCursor(Cursor.CLOSED_HAND);
		btn7.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String temp7 = text5.getText();
				name.setText(temp7);
				surname.setText(null);
			}
		});
		group5.getChildren().addAll(btn5, btn6, btn7, text5, table);

		///////////////////////////////////////////////////////////////

		FlowPane root = new FlowPane(group1, group2, group3, group4, group5);
		Scene scene = new Scene(root, 410, 300);
		primaryStage.setTitle("part 1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
