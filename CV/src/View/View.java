package View;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends GridPane {

    private static int MIN_WIDTH = 600;
    private static int MIN_HEIGHT = MIN_WIDTH + 100;
    private int SPACING = MIN_WIDTH / 60;
    private Controller controller;

    public Parent getRoot() {
        return root;
    }

    private Parent root;
    private Button btnNAW;
    private Button btnSkills;
    private Button btnProfiel;
    private Button btnOpleidingen;
    private Button btnLanguage;
    private Label label;

    private static TextArea text = new TextArea();

    public View(Controller controller) {
        this.controller = controller;
        root = initialize();
        setUpController();
    }

    public View() {
    }

    private Parent initialize() {
        BorderPane borderPane = new BorderPane();
        label = new Label("Druk op een van de knoppen om meer informatie te zien betrekkende mijn CV");
        HBox hBox = new HBox();
        VBox vBox = new VBox();

        btnNAW = new Button("NAW-Gegevens");
        btnSkills = new Button("Vaardigheden");
        btnProfiel = new Button("Profiel");
        btnOpleidingen = new Button("Opleidingen");
        btnLanguage = new Button();
        btnLanguage.setText("English");

        text.setMinHeight(MIN_HEIGHT);
        hBox.setMinWidth(MIN_WIDTH);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(SPACING);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(SPACING);
        vBox.getChildren().addAll(label, hBox, text);
        hBox.getChildren().addAll(btnNAW, btnSkills, btnProfiel, btnOpleidingen, btnLanguage);

        borderPane.setMinHeight(MIN_HEIGHT);
        borderPane.setTop(vBox);

        return borderPane;
    }

    private void setUpController() {
        btnNAW.setOnAction(e -> controller.NAW());
        btnOpleidingen.setOnAction(e -> controller.Opleidingen());
        btnProfiel.setOnAction(e -> controller.Werkervaring());
        btnSkills.setOnAction(e -> controller.Skills());
        btnLanguage.setOnAction(e -> changeLanguage());
    }

    private String getBtnLanguage() {
        return btnLanguage.getText();
    }

    // Switched text voor buttons in view
    private void changeLanguage() {
        if (getBtnLanguage().equals("English")) {
            label.setText("Use one of the buttons to get more information");
            btnNAW.setText("Personal Information");
            btnLanguage.setText("Nederlands");
            btnSkills.setText("Skills");
            btnProfiel.setText("Profile");
            btnOpleidingen.setText("Certificates");
        } else {
            label.setText("Druk op een van de knoppen om meer informatie te zien betrekkende mijn CV");
            btnNAW.setText("NAW-gegevens");
            btnLanguage.setText("English");
            btnSkills.setText("Vaardigheden");
            btnProfiel.setText("Profiel");
            btnOpleidingen.setText("Opleidingen");
        }
    }

    public TextArea getText() {
        return text;
    }
}
