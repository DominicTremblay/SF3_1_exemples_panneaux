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

/**
 * Concepts fondamentaux de dimensionnement JavaFX :
 * 
 * PADDING: Distance entre le contenu et les bordures internes du conteneur
 * SPACING: Distance entre les éléments enfants dans un conteneur MARGIN: Espace
 * supplémentaire autour d'un contrôle spécifique
 * 
 * MinSize: Taille minimale - l'élément ne rétrécira jamais en dessous PrefSize:
 * Taille préférée - la taille "idéale" que l'élément souhaite MaxSize: Taille
 * maximale - l'élément ne grandira jamais au-delà
 */

public class Main extends Application {

	/**
	 * HBOX - Conteneur horizontal Organise les éléments de gauche à droite en une
	 * ligne
	 */
	private HBox creerHBox() {
		HBox hbox = new HBox();

		// Bordure bleue en pointillés pour visualiser les limites du conteneur
		hbox.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		// Padding : espace interne (haut=40, droite=10, bas=40, gauche=15)
		hbox.setPadding(new Insets(40, 10, 40, 15));

		// Espacement de 5px entre chaque élément enfant
		hbox.setSpacing(5);

		// Largeur préférée du conteneur
		hbox.setPrefWidth(300);

		// Création des éléments enfants
		Button btn1 = new Button("Button1");
		Button btn2 = new Button("Button2");
		Button btn3 = new Button("Button3");
		Button btn4 = new Button("Button4");
		Button btn5 = new Button("Button5");
		TextField txt1 = new TextField("TextField 1");

		// CROISSANCE HORIZONTALE : btn1 grandit pour occuper l'espace disponible
		hbox.setHgrow(btn1, Priority.ALWAYS);
		btn1.setMaxWidth(Double.MAX_VALUE); // Permet l'étirement maximal

		// Largeur minimale fixe pour btn2
		btn2.setMinWidth(200);

		// Configuration complète de taille pour le TextField
		txt1.setMinSize(100, 20); // Taille minimale
		txt1.setMaxSize(300, 100); // Taille maximale
		txt1.setPrefSize(200, 30); // Taille préférée

		btn1.setMinSize(100, 20); // Taille minimale pour btn1

		// Ajout de tous les éléments au conteneur
		hbox.getChildren().addAll(btn1, txt1, btn2, btn3, btn4, btn5);

		return hbox;
	}

	/**
	 * VBOX - Conteneur vertical Organise les éléments de haut en bas en une colonne
	 */
	private VBox creerVBox() {
		VBox vbox = new VBox();

		// Même style de bordure que HBox pour cohérence
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
		TextField txt1 = new TextField("TextField 1");

		// Hauteur spécifique pour btn5
		btn5.setPrefHeight(60);

		// CROISSANCE VERTICALE : btn1 grandit verticalement
		vbox.setVgrow(btn1, Priority.ALWAYS);
		btn1.setMaxWidth(Double.MAX_VALUE); // Remplit toute la largeur disponible
		btn2.setMinWidth(200);

		// Configuration de taille identique au HBox pour comparaison
		txt1.setMinSize(100, 20);
		txt1.setMaxSize(300, 100);
		txt1.setPrefSize(200, 30);
		btn1.setMinSize(100, 20);

		vbox.getChildren().addAll(btn1, txt1, btn2, btn3, btn4, btn5);

		return vbox;
	}

	/**
	 * STACKPANE - Conteneur d'empilement Superpose les éléments les uns sur les
	 * autres, centrés par défaut Le dernier élément ajouté apparaît au premier plan
	 */
	private StackPane creerStackPane() {
		StackPane stackpane = new StackPane();

		// Couche 1 (arrière-plan) : Rectangle orange
		Rectangle rectangle = new Rectangle(500, 300);
		rectangle.setFill(Color.ORANGE);

		// Couche 2 (milieu) : Cercle bleu
		Circle cercle = new Circle();
		cercle.setRadius(120);
		cercle.setFill(Color.BLUE);

		// Couche 3 (premier plan) : Texte blanc
		Text texte = new Text("Voici le StackPane");
		texte.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		texte.setFill(Color.WHITE);

		// Ordre d'ajout = ordre d'empilement (dernier = premier plan)
		stackpane.getChildren().addAll(rectangle, cercle, texte);

		return stackpane;
	}

	/**
	 * FLOWPANE - Conteneur fluide Dispose les éléments de gauche à droite, puis
	 * passe à la ligne suivante Comme le comportement d'un texte qui s'adapte à la
	 * largeur
	 */
	private FlowPane creerFlowPane() {
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(20));

		// Arrière-plan personnalisé avec coins arrondis
		BackgroundFill bg = new BackgroundFill(Color.BEIGE, new CornerRadii(15), new Insets(10));
		flowpane.setBackground(new Background(bg));

		return flowpane;
	}

	/**
	 * TILEPANE - Grille uniforme Organise les éléments dans une grille où toutes
	 * les cellules ont la même taille Contrairement au FlowPane, impose une taille
	 * uniforme à tous les éléments
	 */
	private TilePane creerTilePane() {
		TilePane tilepane = new TilePane();

		tilepane.setPadding(new Insets(10));
		tilepane.setVgap(10); // Espacement vertical entre les tuiles
		tilepane.setHgap(10); // Espacement horizontal entre les tuiles
		tilepane.setPrefColumns(2); // Nombre de colonnes préférées

		// Création de rectangles de tailles différentes
		// IMPORTANT : Dans TilePane, tous auront la même taille finale
		Rectangle rec1 = new Rectangle(100, 100);
		rec1.setFill(Color.ORANGE);
		Rectangle rec2 = new Rectangle(200, 150); // Sera redimensionné
		rec2.setFill(Color.BLUE);
		Rectangle rec3 = new Rectangle(100, 100);
		rec3.setFill(Color.GREEN);
		Rectangle rec4 = new Rectangle(100, 100);
		rec4.setFill(Color.YELLOW);
		Rectangle rec5 = new Rectangle(100, 100);
		rec5.setFill(Color.RED);

		// Exemple alternatif avec des boutons (actuellement commenté)
		// Montre comment TilePane uniformise des éléments de tailles différentes
		/*
		 * Button btn1 = new Button("Le Button1 est plus haut"); btn1.setPrefHeight(20);
		 * Button btn2 = new Button("Button2"); Button btn3 = new
		 * Button("Le Button3 est plus large"); Button btn4 = new Button("Button4");
		 * Button btn5 = new Button("Button5");
		 */

		// Arrière-plan avec coins moins arrondis que FlowPane
		BackgroundFill bg = new BackgroundFill(Color.BEIGE, new CornerRadii(5), new Insets(10));
		tilepane.setBackground(new Background(bg));

		// Bordure rouge en pointillés (peut être appliquée individuellement aux
		// éléments)
		Border tileBorder = new Border(
				new BorderStroke(Color.CRIMSON, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT));

		tilepane.getChildren().addAll(rec1, rec2, rec3, rec4, rec5);
		return tilepane;
	}

	/**
	 * BORDERPANE - Layout classique à 5 zones Divise l'interface en 5 régions :
	 * Nord (top), Sud (bottom), Est (right), Ouest (left) et Centre (center) La
	 * zone centre s'étend automatiquement pour remplir l'espace disponible
	 */
	private BorderPane creerBorderPane() {
		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(10));

		// REGION NORD (TOP) - Titre principal
		Text txtTitre = new Text("Voici un BorderPane qui permet de spécifier Top, Center, Left ou Right");
		txtTitre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtTitre.setFill(Color.CORNFLOWERBLUE);
		bPane.setTop(txtTitre);
		BorderPane.setAlignment(txtTitre, Pos.CENTER); // Centre le titre horizontalement

		// REGION EST (RIGHT) - Panneau latéral droit
		VBox vboxRight = new VBox();
		vboxRight.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vboxRight.setPrefWidth(140); // Largeur fixe
		vboxRight.setAlignment(Pos.CENTER); // Centre le contenu dans le VBox
		Button btn1 = new Button("Bouton à droite");
		vboxRight.getChildren().add(btn1);
		bPane.setRight(vboxRight);
		BorderPane.setAlignment(vboxRight, Pos.CENTER);
		bPane.setMargin(vboxRight, new Insets(10)); // Marge autour du panneau

		// REGION OUEST (LEFT) - Panneau latéral gauche
		VBox vboxLeft = new VBox();
		vboxLeft.setBorder(new Border(
				new BorderStroke(Color.GREEN, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vboxLeft.setPrefWidth(140);
		vboxLeft.setAlignment(Pos.CENTER);
		Button btn2 = new Button("Bouton à gauche");
		vboxLeft.getChildren().add(btn2);
		bPane.setLeft(vboxLeft);
		// NOTE : Il y a une erreur dans le code original - devrait être vboxLeft, pas
		// vboxRight
		BorderPane.setAlignment(vboxLeft, Pos.CENTER);
		bPane.setMargin(vboxLeft, new Insets(10));

		// REGION CENTRE - Zone principale extensible
		VBox vboxCenter = new VBox();
		vboxCenter.setPrefWidth(200);
		// NOTE : Ligne suivante redondante et sans effet
		vboxCenter.setPrefWidth(300);

		TextArea txtCenter = new TextArea(
				"BorderPane divise l'interface en 5 zones fixes : Nord (top), Sud (bottom), Est (right), Ouest (left) et Centre (center).");
		txtCenter.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtCenter.setWrapText(true); // Retour à la ligne automatique
		txtCenter.setEditable(false); // Zone de texte en lecture seule

		vboxCenter.getChildren().add(txtCenter);
		vboxCenter.setAlignment(Pos.CENTER);
		bPane.setCenter(vboxCenter);

		// REGION SUD (BOTTOM) - Pied de page
		Text txtFooter = new Text("Voici la section BOTTOM du BorderPane");
		txtFooter.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtFooter.setFill(Color.CORNFLOWERBLUE);
		bPane.setBottom(txtFooter);
		BorderPane.setAlignment(txtFooter, Pos.CENTER);

		return bPane;
	}

	/**
	 * GRIDPANE - Grille flexible Permet un positionnement précis en lignes et
	 * colonnes Les éléments peuvent s'étendre sur plusieurs cellules
	 * (colspan/rowspan) Idéal pour les formulaires complexes
	 */
	private GridPane creerGridPane() {
		GridPane form = new GridPane();
		form.setPadding(new Insets(10));
		form.setHgap(10); // Espacement horizontal entre colonnes
		form.setVgap(10); // Espacement vertical entre lignes

		// Titre du formulaire - s'étend sur 2 colonnes (colspan=2)
		Text txtTitre = new Text("Entrez votre nom et email");
		form.add(txtTitre, 0, 0, 2, 1); // (élément, colonne, ligne, colspan, rowspan)

		// Labels de formulaire - tous en colonne 0
		form.add(new Label("Nom:"), 0, 2); // Colonne 0, ligne 2
		form.add(new Label("Email:"), 0, 3); // Colonne 0, ligne 3

		// Champs de saisie - tous en colonne 1 avec croissance horizontale
		TextField nameField = new TextField();
		GridPane.setHgrow(nameField, Priority.ALWAYS); // S'étend horizontalement
		form.add(nameField, 1, 2); // Colonne 1, ligne 2

		TextField emailField = new TextField();
		GridPane.setHgrow(emailField, Priority.ALWAYS);
		form.add(emailField, 1, 3); // Colonne 1, ligne 3

		// Bouton de validation - centré et s'étend sur 2 colonnes
		Button submitBtn = new Button("Valider");
		form.add(submitBtn, 0, 4, 2, 1); // Démarre en colonne 0, s'étend sur 2 colonnes
		GridPane.setHalignment(submitBtn, HPos.CENTER); // Alignement horizontal centré

		return form;
	}

	/**
	 * ANCHORPANE - Positionnement absolu Permet d'ancrer les éléments à des
	 * distances fixes des bords Offre le contrôle le plus précis mais nécessite
	 * plus de configuration
	 */
	private AnchorPane creerAnchorPane() {
		AnchorPane aPane = new AnchorPane();

		// Titre positionné de manière absolue
		Text txtTitre = new Text("Ceci est un AnchorPane.");
		txtTitre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		txtTitre.setFill(Color.ROYALBLUE);

		// Positionnement précis : 80px du haut, 150px de la gauche
		AnchorPane.setTopAnchor(txtTitre, 80.0);
		AnchorPane.setLeftAnchor(txtTitre, 150.0);

		// Groupe de boutons dans un HBox
		HBox hBox = new HBox();
		Button btnOk = new Button("Ok");
		btnOk.setPrefWidth(100); // Largeur fixe
		Button btnAnnuler = new Button("Annuler");
		btnAnnuler.setPrefWidth(100); // Largeur fixe identique
		hBox.getChildren().addAll(btnOk, btnAnnuler);

		// Positionnement du groupe de boutons : 80px du bas, 140px de la gauche
		AnchorPane.setBottomAnchor(hBox, 80.0);
		AnchorPane.setLeftAnchor(hBox, 140.0);

		// Ajout des éléments au conteneur
		// IMPORTANT : Dans AnchorPane, l'ordre d'ajout n'affecte que l'ordre de
		// superposition
		aPane.getChildren().add(txtTitre);
		aPane.getChildren().add(hBox);

		return aPane;
	}

	/**
	 * Méthode principale de lancement de l'application JavaFX
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			// Décommentez la ligne correspondant au conteneur à tester

			// Pane root = creerFlowPane(); // Conteneur fluide adaptatif
			// Pane root = creerStackPane(); // Superposition d'éléments
			// Pane root = creerTilePane(); // Grille uniforme
			// Pane root = creerBorderPane(); // Layout à 5 zones
			// Pane root = creerGridPane(); // Grille flexible pour formulaires
			Pane root = creerAnchorPane(); // Positionnement absolu précis

			// Exemples de conteneurs linéaires (ajout dans un conteneur parent)
			// root.getChildren().add(creerHBox()); // Disposition horizontale
			// root.getChildren().add(creerVBox()); // Disposition verticale

			// Création de la scène avec taille fixe
			Scene scene = new Scene(root, 500, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Démonstration des Conteneurs JavaFX");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Point d'entrée de l'application
	 */
	public static void main(String[] args) {
		launch(args); // Lance l'application JavaFX
	}
}