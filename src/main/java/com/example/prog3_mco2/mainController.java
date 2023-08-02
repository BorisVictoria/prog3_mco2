package com.example.prog3_mco2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;

    public mainController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void initCreate(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("create.fxml"));
        loader.setControllerFactory(controllerClass -> new createController(vm));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initTest(ActionEvent event) throws IOException
    {
        if (vm != null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
            loader.setControllerFactory(controllerClass -> new testController(vm));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Uninitialized Vending Machine");
            alert.setContentText("Please create a vending machine first!");
            alert.show();
        }

    }

    public void exit(ActionEvent event) throws IOException
    {
        Platform.exit();
    }

}