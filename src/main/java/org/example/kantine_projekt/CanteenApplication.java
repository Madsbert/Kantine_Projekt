package org.example.kantine_projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CanteenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
<<<<<<<< HEAD:src/main/java/org/example/kantine_projekt/HelloApplication.java
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Welcome!");
========
        FXMLLoader fxmlLoader = new FXMLLoader(CanteenApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 966, 616);
        stage.setTitle("Kantine Lagerbeholdning");
>>>>>>>> master:src/main/java/org/example/kantine_projekt/CanteenApplication.java
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}