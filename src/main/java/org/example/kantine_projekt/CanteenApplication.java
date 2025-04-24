package org.example.kantine_projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CanteenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CanteenApplication.class.getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 300);
        stage.setTitle("Welcome!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}