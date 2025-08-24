# JavaFX Layout Containers - Cheat Sheet

*Guide de référence rapide des méthodes et propriétés principales*

---

## 🔗 HBox - Disposition Horizontale

### Construction
```java
HBox hbox = new HBox();
HBox hbox = new HBox(spacing); // avec espacement
HBox hbox = new HBox(spacing, node1, node2, ...); // avec enfants
```

### Méthodes principales
- `setSpacing(double spacing)` - Espacement entre éléments
- `setAlignment(Pos alignment)` - Alignement général (CENTER, TOP_LEFT, etc.)
- `setFillHeight(boolean fillHeight)` - Les enfants remplissent-ils la hauteur ?

### Propriétés statiques pour enfants
- `HBox.setHgrow(node, Priority.ALWAYS)` - Croissance horizontale
- `HBox.setMargin(node, new Insets(top, right, bottom, left))` - Marges

### Valeurs Pos communes
`TOP_LEFT`, `TOP_CENTER`, `TOP_RIGHT`, `CENTER_LEFT`, `CENTER`, `CENTER_RIGHT`, `BOTTOM_LEFT`, `BOTTOM_CENTER`, `BOTTOM_RIGHT`

---

## 📋 VBox - Disposition Verticale

### Construction
```java
VBox vbox = new VBox();
VBox vbox = new VBox(spacing);
VBox vbox = new VBox(spacing, node1, node2, ...);
```

### Méthodes principales
- `setSpacing(double spacing)` - Espacement entre éléments
- `setAlignment(Pos alignment)` - Alignement général
- `setFillWidth(boolean fillWidth)` - Les enfants remplissent-ils la largeur ?

### Propriétés statiques pour enfants
- `VBox.setVgrow(node, Priority.ALWAYS)` - Croissance verticale
- `VBox.setMargin(node, new Insets(top, right, bottom, left))` - Marges

### Valeurs Priority
`ALWAYS`, `SOMETIMES`, `NEVER`

---

## 🏗️ StackPane - Empilement Centré

### Construction
```java
StackPane stackPane = new StackPane();
StackPane stackPane = new StackPane(node1, node2, ...);
```

### Méthodes principales
- `setAlignment(Pos alignment)` - Alignement de tous les enfants

### Propriétés statiques pour enfants
- `StackPane.setAlignment(node, Pos.TOP_LEFT)` - Alignement individuel
- `StackPane.setMargin(node, new Insets(...))` - Marges

### Note importante
⚠️ Le dernier enfant ajouté apparaît au premier plan

---

## 🌊 FlowPane - Disposition Fluide

### Construction
```java
FlowPane flowPane = new FlowPane();
FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);
FlowPane flowPane = new FlowPane(hgap, vgap);
```

### Méthodes principales
- `setHgap(double hgap)` - Espacement horizontal
- `setVgap(double vgap)` - Espacement vertical
- `setOrientation(Orientation orientation)` - HORIZONTAL ou VERTICAL
- `setAlignment(Pos alignment)` - Alignement du contenu
- `setColumnHalignment(HPos halignment)` - Alignement horizontal des colonnes
- `setRowValignment(VPos valignment)` - Alignement vertical des lignes

### Valeurs Orientation
`Orientation.HORIZONTAL`, `Orientation.VERTICAL`

### Valeurs HPos/VPos
`HPos.LEFT`, `HPos.CENTER`, `HPos.RIGHT`
`VPos.TOP`, `VPos.CENTER`, `VPos.BOTTOM`

---

## 🔲 TilePane - Grille Uniforme

### Construction
```java
TilePane tilePane = new TilePane();
TilePane tilePane = new TilePane(Orientation.HORIZONTAL);
TilePane tilePane = new TilePane(hgap, vgap);
```

### Méthodes principales
- `setHgap(double hgap)` - Espacement horizontal
- `setVgap(double vgap)` - Espacement vertical
- `setOrientation(Orientation orientation)` - Direction du flux
- `setPrefColumns(int prefColumns)` - Nombre de colonnes préférées
- `setPrefRows(int prefRows)` - Nombre de lignes préférées
- `setPrefTileWidth(double prefTileWidth)` - Largeur des tuiles
- `setPrefTileHeight(double prefTileHeight)` - Hauteur des tuiles
- `setTileAlignment(Pos alignment)` - Alignement du contenu dans chaque tuile

### Propriétés statiques pour enfants
- `TilePane.setAlignment(node, Pos.CENTER)` - Alignement dans la tuile
- `TilePane.setMargin(node, new Insets(...))` - Marges

---

## 🏛️ BorderPane - Layout Classique

### Construction
```java
BorderPane borderPane = new BorderPane();
BorderPane borderPane = new BorderPane(center);
BorderPane borderPane = new BorderPane(center, top, right, bottom, left);
```

### Méthodes principales
- `setTop(Node top)` - Élément du haut
- `setBottom(Node bottom)` - Élément du bas
- `setLeft(Node left)` - Élément de gauche
- `setRight(Node right)` - Élément de droite
- `setCenter(Node center)` - Élément central

### Propriétés statiques pour enfants
- `BorderPane.setAlignment(node, Pos.CENTER)` - Alignement dans sa région
- `BorderPane.setMargin(node, new Insets(...))` - Marges

### Note importante
⚠️ Le centre s'étend pour remplir l'espace disponible

---

## 📐 GridPane - Grille Flexible

### Construction
```java
GridPane gridPane = new GridPane();
```

### Méthodes principales
- `setHgap(double hgap)` - Espacement horizontal
- `setVgap(double vgap)` - Espacement vertical
- `setAlignment(Pos alignment)` - Alignement de la grille
- `setGridLinesVisible(boolean visible)` - Affichage des lignes de debug

### Ajout d'éléments
- `add(Node child, int columnIndex, int rowIndex)`
- `add(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)`
- `addRow(int rowIndex, Node... children)` - Ajoute une ligne
- `addColumn(int columnIndex, Node... children)` - Ajoute une colonne

### Propriétés statiques pour enfants
- `GridPane.setColumnIndex(node, 2)` - Position colonne
- `GridPane.setRowIndex(node, 1)` - Position ligne
- `GridPane.setColumnSpan(node, 2)` - Étalement colonnes
- `GridPane.setRowSpan(node, 2)` - Étalement lignes
- `GridPane.setHalignment(node, HPos.CENTER)` - Alignement horizontal
- `GridPane.setValignment(node, VPos.CENTER)` - Alignement vertical
- `GridPane.setHgrow(node, Priority.ALWAYS)` - Croissance horizontale
- `GridPane.setVgrow(node, Priority.ALWAYS)` - Croissance verticale
- `GridPane.setFillWidth(node, true)` - Remplit la largeur
- `GridPane.setFillHeight(node, true)` - Remplit la hauteur
- `GridPane.setMargin(node, new Insets(...))` - Marges

### Gestion des contraintes de colonnes/lignes
```java
ColumnConstraints col1 = new ColumnConstraints();
col1.setPercentWidth(25); // 25% de la largeur
gridPane.getColumnConstraints().add(col1);

RowConstraints row1 = new RowConstraints();
row1.setPrefHeight(50); // Hauteur fixe
gridPane.getRowConstraints().add(row1);
```

---

## 🔗 AnchorPane - Positionnement Absolu

### Construction
```java
AnchorPane anchorPane = new AnchorPane();
AnchorPane anchorPane = new AnchorPane(node1, node2, ...);
```

### Propriétés statiques pour enfants
- `AnchorPane.setTopAnchor(node, 10.0)` - Distance du haut
- `AnchorPane.setBottomAnchor(node, 10.0)` - Distance du bas
- `AnchorPane.setLeftAnchor(node, 10.0)` - Distance de la gauche
- `AnchorPane.setRightAnchor(node, 10.0)` - Distance de la droite

### Techniques d'étirement
```java
// Étirement horizontal (largeur automatique)
AnchorPane.setLeftAnchor(node, 20.0);
AnchorPane.setRightAnchor(node, 20.0);

// Étirement vertical (hauteur automatique)
AnchorPane.setTopAnchor(node, 20.0);
AnchorPane.setBottomAnchor(node, 20.0);

// Étirement total (remplit tout l'espace)
AnchorPane.setTopAnchor(node, 0.0);
AnchorPane.setBottomAnchor(node, 0.0);
AnchorPane.setLeftAnchor(node, 0.0);
AnchorPane.setRightAnchor(node, 0.0);
```

### Note importante
⚠️ Si Left + Right sont définis, la largeur est calculée automatiquement
⚠️ Si Top + Bottom sont définis, la hauteur est calculée automatiquement

---

## 🛠️ Propriétés Communes à Tous

### Méthodes héritées de Pane
- `getChildren().add(node)` - Ajouter un enfant
- `getChildren().addAll(node1, node2, ...)` - Ajouter plusieurs enfants
- `getChildren().remove(node)` - Retirer un enfant
- `getChildren().clear()` - Retirer tous les enfants

### Méthodes héritées de Region
- `setPadding(new Insets(top, right, bottom, left))` - Padding interne
- `setPrefSize(width, height)` - Taille préférée
- `setMinSize(width, height)` - Taille minimale
- `setMaxSize(width, height)` - Taille maximale

### Classes utiles
```java
// Espacements et marges
Insets insets = new Insets(10); // Uniforme
Insets insets = new Insets(top, right, bottom, left);

// Priorités de croissance
Priority.ALWAYS    // Grandit autant que possible
Priority.SOMETIMES // Grandit si nécessaire
Priority.NEVER     // Ne grandit jamais
```

---

## 🎯 Conseils de Choix

| Besoin | Container Recommandé |
|--------|---------------------|
| Boutons côte à côte | **HBox** |
| Menu vertical | **VBox** |
| Superposition d'éléments | **StackPane** |
| Éléments qui s'adaptent | **FlowPane** |
| Galerie uniforme | **TilePane** |
| Interface classique | **BorderPane** |
| Formulaire complexe | **GridPane** |
| Positionnement précis | **AnchorPane** |

---

## 📝 Bonnes Pratiques

1. **Commencez simple** : HBox/VBox pour la plupart des cas
2. **Évitez AnchorPane** sauf besoin spécifique de positionnement absolu
3. **Utilisez les Priority** pour contrôler la croissance des éléments
4. **Combinez les containers** pour des layouts complexes
5. **Testez le redimensionnement** de vos interfaces
6. **Utilisez CSS** pour le style, les containers pour la structure