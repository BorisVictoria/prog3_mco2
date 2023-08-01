package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class createController
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;

    @FXML
    TextField nameField;

    @FXML
    TextField numSlotsField;

    @FXML
    TextField numCapacityField;

    public createController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void createRegular(ActionEvent event)
    {
        String name;
        int numSlots;
        int numCapacity;

        try
        {
            name = nameField.getText();
            numSlots = Integer.parseInt(numSlotsField.getText());
            numCapacity = Integer.parseInt(numCapacityField.getText());

            if (numSlots < 1 || numCapacity < 1)
                throw new Exception();

            vm = new RegularVendingMachine(name, numSlots, numCapacity);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Regular Vending Machine Created!");
            alert.setContentText("Name: " + name + "\n" + "Slots: " + numSlots + "\n" + "Capacity: " + numCapacity);
            alert.show();


        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Input Error!");
            alert.setContentText("Please try again");
            alert.show();
        }

    }

    public void createSpecial(ActionEvent event)
    {
        String name;
        int numSlots;
        int numCapacity;

        try
        {
            name = nameField.getText();
            numSlots = Integer.parseInt(numSlotsField.getText());
            numCapacity = Integer.parseInt(numCapacityField.getText());

            if (numSlots < 1 || numCapacity < 1)
                throw new Exception();

            vm = new SpecialVendingMachine(name, numSlots, numCapacity);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Special Vending Machine Created!");
            alert.setContentText("Name: " + name + "\n" + "Slots: " + numSlots + "\n" + "Capacity: " + numCapacity);
            alert.show();

        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Input Error!");
            alert.setContentText("Please try again");
            alert.show();
        }
    }


    public void exit(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.setControllerFactory(controllerClass -> new mainController(vm));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
