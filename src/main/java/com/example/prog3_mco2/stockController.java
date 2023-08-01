package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class stockController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;


    public stockController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void addItem(ActionEvent event)
    {

        try
        {
            String name = txt1.getText();
            int price = Integer.parseInt(txt2.getText());
            int calories = Integer.parseInt(txt3.getText());
            String description = txt4.getText();

            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (vm.getSlotList().get(i).getName().equals(name))
                    throw new Exception();
            }

            if (!vm.stock(name, price, description, calories))
                throw new Exception();

            lbl1.setText(name);
            lbl2.setText(String.valueOf(price));
            lbl3.setText(String.valueOf(calories));
            lbl4.setText(description);
            lbl5.setText("Item");
        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Item Creation Error!");
            alert.setContentText("Please try again");
            alert.show();
        }
    }

    public void addBase(ActionEvent event)
    {

        try
        {
            String name = txt1.getText();
            int price = Integer.parseInt(txt2.getText());
            int calories = Integer.parseInt(txt3.getText());
            String description = txt4.getText();

            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (vm.getSlotList().get(i).getName().equals(name))
                    throw new Exception();
            }

            if (!((SpecialVendingMachine) vm).stockBase(name, price, description, calories))
                throw new Exception();

            lbl1.setText(name);
            lbl2.setText(String.valueOf(price));
            lbl3.setText(String.valueOf(calories));
            lbl4.setText(description);
            lbl5.setText("Base");
        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Item Creation Error!");
            alert.setContentText("Please try again");
            alert.show();
        }
    }

    public void addAddon(ActionEvent event)
    {

        try
        {
            String name = txt1.getText();
            int price = Integer.parseInt(txt2.getText());
            int calories = Integer.parseInt(txt3.getText());
            String description = txt4.getText();

            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (vm.getSlotList().get(i).getName().equals(name))
                    throw new Exception();
            }

            if (!((SpecialVendingMachine) vm).stockAddon(name, price, description, calories))
                throw new Exception();

            lbl1.setText(name);
            lbl2.setText(String.valueOf(price));
            lbl3.setText(String.valueOf(calories));
            lbl4.setText(description);
            lbl5.setText("Addon");
        }
        catch (Exception e)
        {
            System.out.println(e);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Item Creation Error!");
            alert.setContentText("Please try again");
            alert.show();
        }
    }

    public void exit(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maintenance.fxml"));
        loader.setControllerFactory(controllerClass -> new maintenanceController(vm));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        if (vm instanceof RegularVendingMachine)
        {
            btn1.setVisible(false);
            btn2.setVisible(false);
        }
    }
}
