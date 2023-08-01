package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class balanceController
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;
    private int[] money;

    @FXML
    private Spinner<Integer> spn1;

    @FXML
    private Spinner<Integer> spn2;

    @FXML
    private Spinner<Integer> spn3;

    @FXML
    private Spinner<Integer> spn4;

    @FXML
    private Spinner<Integer> spn5;

    @FXML
    private Spinner<Integer> spn6;

    @FXML
    private Spinner<Integer> spn7;

    @FXML
    private Spinner<Integer> spn8;

    @FXML
    private Spinner<Integer> spn9;

    public balanceController(RegularVendingMachine vm)
    {
        this.vm = vm;
        money = new int[9];
    }

    public void deposit(ActionEvent event)
    {
        money[0] = spn1.getValue();
        money[1] = spn2.getValue();
        money[2] = spn3.getValue();
        money[3] = spn4.getValue();
        money[4] = spn5.getValue();
        money[5] = spn6.getValue();
        money[6] = spn7.getValue();
        money[7] = spn8.getValue();
        money[8] = spn9.getValue();

        vm.getMoney().addMoney(money);

    }

    public void withdraw(ActionEvent event)
    {
        money[0] = spn1.getValue();
        money[1] = spn2.getValue();
        money[2] = spn3.getValue();
        money[3] = spn4.getValue();
        money[4] = spn5.getValue();
        money[5] = spn6.getValue();
        money[6] = spn7.getValue();
        money[7] = spn8.getValue();
        money[8] = spn9.getValue();

        if (vm.getMoney().removeMoney(money));

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

    public void initialize(URL arg0, ResourceBundle arg1)
    {
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory1.setValue(0);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory2.setValue(0);
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory3.setValue(0);
        SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory4.setValue(0);
        SpinnerValueFactory<Integer> valueFactory5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory5.setValue(0);
        SpinnerValueFactory<Integer> valueFactory6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory6.setValue(0);
        SpinnerValueFactory<Integer> valueFactory7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory7.setValue(0);
        SpinnerValueFactory<Integer> valueFactory8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory8.setValue(0);
        SpinnerValueFactory<Integer> valueFactory9 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);
        valueFactory9.setValue(0);

        spn1.setValueFactory(valueFactory1);
        spn2.setValueFactory(valueFactory2);
        spn3.setValueFactory(valueFactory3);
        spn4.setValueFactory(valueFactory4);
        spn5.setValueFactory(valueFactory5);
        spn6.setValueFactory(valueFactory6);
        spn7.setValueFactory(valueFactory7);
        spn8.setValueFactory(valueFactory8);
        spn9.setValueFactory(valueFactory9);
    }


}
