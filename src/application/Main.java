package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// padding: distance entre les noeuds et les bordures du panneau VBox.
// spacing: distance entre les noeuds.
// margins: espace supplementaire autour d'un controle
// MinSize: Même si le parent est très petit, l'élément ne rétrécira jamais en
// dessous
// PrefSize: La taille "idéale" que l'élément souhaite avoir
// MaxSize : La plus grande taille autorisée

public class Main extends Application {

	private HBox creerHBox() {
		HBox hbox = new HBox();
		hbox.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hbox.setPadding(new Insets(40, 10, 40, 15));
		hbox.setSpacing(5);
		hbox.setPrefWidth(300);

		Button btn1 = new Button("Button1");
		Button btn2 = new Button("Button2");
		Button btn3 = new Button("Button3");
		Button btn4 = new Button("Button4");
		Button btn5 = new Button("Button5");

		TextField txt1 = new TextField("TextField 1");

		

		hbox.setHgrow(btn1, Priority.ALWAYS);
		btn1.setMaxWidth(Double.MAX_VALUE);
		btn2.setMinWidth(200);
		
		txt1.setMinSize(100, 20);
		txt1.setMaxSize(300, 100);
		txt1.setPrefSize(200, 30);
		
		btn1.setMinSize(100, 20);
		hbox.getChildren().addAll(btn1, txt1, btn2, btn3, btn4, btn5);

		
		return hbox;
	}
	
	private VBox creerVBox() {
		VBox vbox = new VBox();
		vbox.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vbox.setPadding(new Insets(40, 10, 40, 15));
		vbox.setSpacing(5);
		vbox.setPrefWidth(500);

		Button btn1 = new Button("Button1");
		Button btn2 = new Button("Button2");
		Button btn3 = new Button("Button3");
		Button btn4 = new Button("Button4");
		Button btn5 = new Button("Button5");
		
		btn5.setPrefHeight(60);

		TextField txt1 = new TextField("TextField 1");

		vbox.setVgrow(btn1, Priority.ALWAYS);
		btn1.setMaxWidth(Double.MAX_VALUE);
		btn2.setMinWidth(200);
		
		txt1.setMinSize(100, 20);
		txt1.setMaxSize(300, 100);
		txt1.setPrefSize(200, 30);
		
		btn1.setMinSize(100, 20);
		vbox.getChildren().addAll(btn1, txt1, btn2, btn3, btn4, btn5);

		
		return vbox;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane root = new FlowPane();

//			root.getChildren().add(creerHBox());
			root.getChildren().add(creerVBox());

			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
