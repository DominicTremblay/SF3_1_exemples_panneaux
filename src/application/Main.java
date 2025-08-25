package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

	private StackPane creerStackPane() {

		StackPane stackpane = new StackPane();

		Rectangle rectangle = new Rectangle(500, 300);
		rectangle.setFill(Color.ORANGE);

		Circle cercle = new Circle();
		cercle.setRadius(120);
		cercle.setFill(Color.BLUE);

		Text texte = new Text("Voici le StackPane");

		texte.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		texte.setFill(Color.WHITE);

		stackpane.getChildren().addAll(rectangle, cercle, texte);

		return stackpane;
	}

	private FlowPane creerFlowPane() {
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(20));
		BackgroundFill bg = new BackgroundFill(Color.BEIGE, new CornerRadii(15), new Insets(10));

		flowpane.setBackground(new Background(bg));

		return flowpane;
	}

	private TilePane creerTilePane() {
		TilePane tilepane = new TilePane();

		tilepane.setPadding(new Insets(10));
		tilepane.setVgap(10);
		tilepane.setHgap(10);
		tilepane.setPrefColumns(2);

		Rectangle rec1 = new Rectangle(100, 100);
		rec1.setFill(Color.ORANGE);
		Rectangle rec2 = new Rectangle(200, 150);
		rec2.setFill(Color.BLUE);
		Rectangle rec3 = new Rectangle(100, 100);
		rec3.setFill(Color.GREEN);
		Rectangle rec4 = new Rectangle(100, 100);
		rec4.setFill(Color.YELLOW);
		Rectangle rec5 = new Rectangle(100, 100);
		rec5.setFill(Color.RED);

//		Button btn1 = new Button("Le Button1 est plus haut");
//		btn1.setPrefHeight(20);
//		Button btn2 = new Button("Button2");
//		Button btn3 = new Button("Le Button3 est plus large");
//		Button btn4 = new Button("Button4");
//		Button btn5 = new Button("Button5");

		BackgroundFill bg = new BackgroundFill(Color.BEIGE, new CornerRadii(5), new Insets(10));
		tilepane.setBackground(new Background(bg));

		Border tileBorder = new Border(
				new BorderStroke(Color.CRIMSON, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT));

		tilepane.getChildren().addAll(rec1, rec2, rec3, rec4, rec5);
		return tilepane;
	}
	


	@Override
	public void start(Stage primaryStage) {
		try {

//			Pane root = creerFlowPane();
//			Pane root = creerStackPane();
			Pane root = creerTilePane();

//			root.getChildren().add(creerHBox());
//			root.getChildren().add(creerVBox());

			Scene scene = new Scene(root, 500, 400);
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
