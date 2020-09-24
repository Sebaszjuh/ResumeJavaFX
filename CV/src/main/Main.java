package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.Controller;
import View.View;

/**
 * @auth Sebastiaan van de Griendt
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Controller controller = new Controller();
        View view = new View(controller);

        Scene scene = new Scene(view.getRoot());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
