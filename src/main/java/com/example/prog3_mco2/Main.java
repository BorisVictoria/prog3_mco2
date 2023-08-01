package com.example.prog3_mco2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //RegularVendingMachine vm = null;
        RegularVendingMachine vm = new RegularVendingMachine("k", 7,7);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.setControllerFactory(controllerClass -> new mainController(vm));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("Vending Machine Factory");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}