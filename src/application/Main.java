package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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

	private BorderPane creerBorderPane() {
		// on utilise setTop, setCenter, setLeft ou setRight

		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(10));

		Text txtTitre = new Text("Voici un BorderPane qui permet de spécifier Top, Center, Left ou Right");
		txtTitre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtTitre.setFill(Color.CORNFLOWERBLUE);

		bPane.setTop(txtTitre);
		BorderPane.setAlignment(txtTitre, Pos.CENTER);

		VBox vboxRight = new VBox();
		vboxRight.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vboxRight.setPrefWidth(140);
		vboxRight.setAlignment(Pos.CENTER);
		Button btn1 = new Button("Bouton à droite");
		vboxRight.getChildren().add(btn1);

		bPane.setRight(vboxRight);
		BorderPane.setAlignment(vboxRight, Pos.CENTER);
		bPane.setMargin(vboxRight, new Insets(10));

		VBox vboxLeft = new VBox();
		vboxLeft.setBorder(new Border(
				new BorderStroke(Color.GREEN, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vboxLeft.setPrefWidth(140);
		vboxLeft.setAlignment(Pos.CENTER);
		Button btn2 = new Button("Bouton à gauche");
		vboxLeft.getChildren().add(btn2);

		bPane.setLeft(vboxLeft);
		BorderPane.setAlignment(vboxRight, Pos.CENTER);
		bPane.setMargin(vboxRight, new Insets(10));

		VBox vboxCenter = new VBox();
		vboxCenter.setPrefWidth(200);
		vboxCenter.setPrefWidth(300);

		TextArea txtCenter = new TextArea(
				"BorderPane divise l'interface en 5 zones fixes : Nord (top), Sud (bottom), Est (right), Ouest (left) et Centre (center).");
		txtCenter.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtCenter.setWrapText(true);
		txtCenter.setEditable(false);

		vboxCenter.getChildren().add(txtCenter);

		vboxCenter.setAlignment(Pos.CENTER);

		bPane.setCenter(vboxCenter);

		Text txtFooter = new Text("Voici la section BOTTOM du BorderPane");
		txtFooter.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtFooter.setFill(Color.CORNFLOWERBLUE);

		bPane.setBottom(txtFooter);
		BorderPane.setAlignment(txtFooter, Pos.CENTER);

		return bPane;

	}

	private GridPane creerGridPane() {
		GridPane form = new GridPane();
		form.setPadding(new Insets(10));
		form.setHgap(10);
		form.setVgap(10);

		Text txtTitre = new Text("Entrez votre nom et email");
		form.add(txtTitre, 0, 0, 2, 1);
		
		// Labels en colonne 0
		form.add(new Label("Nom:"), 0, 2);
		form.add(new Label("Email:"), 0, 3);

		// Champs en colonne 1
		TextField nameField = new TextField();
		GridPane.setHgrow(nameField, Priority.ALWAYS);
		form.add(nameField, 1, 2);

		TextField emailField = new TextField();
		GridPane.setHgrow(emailField, Priority.ALWAYS);
		form.add(emailField, 1, 3);

		// Bouton qui s'étend sur 2 colonnes
		Button submitBtn = new Button("Valider");
		form.add(submitBtn, 0, 4, 2, 1);
		GridPane.setHalignment(submitBtn, HPos.CENTER);
		
		return form;
	}
	
	private AnchorPane creerAnchorPane() {
		AnchorPane aPane = new AnchorPane();
		
		Text txtTitre = new Text("Ceci est un AnchorPane.");
		txtTitre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtTitre.setFill(Color.ROYALBLUE);
		
		AnchorPane.setTopAnchor(txtTitre, 80.0);
		AnchorPane.setLeftAnchor(txtTitre, 150.0);
		
		HBox hBox = new HBox();
		
		Button btnOk = new Button("Ok");
		btnOk.setPrefWidth(100);
		
		Button btnAnnuler = new Button("Annuler");
		btnAnnuler.setPrefWidth(100);
		
		hBox.getChildren().addAll(btnOk, btnAnnuler);
		
		AnchorPane.setBottomAnchor(hBox, 80.0);
		AnchorPane.setLeftAnchor(hBox, 140.0);
		
		aPane.getChildren().add(txtTitre);
		aPane.getChildren().add(hBox);
		
		return aPane;
	}

	@Override
	public void start(Stage primaryStage) {
		try {

//			Pane root = creerFlowPane();
//			Pane root = creerStackPane();
//			Pane root = creerTilePane();
//			Pane root = creerBorderPane();
			
//			Pane root = creerGridPane();
			
			Pane root = creerAnchorPane();

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
