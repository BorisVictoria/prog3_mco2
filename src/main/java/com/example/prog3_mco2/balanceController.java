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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class balanceController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;

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

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl8;

    @FXML
    private Label lbl9;

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
    }

    public void deposit(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> bills;
        bills = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            bills.add(new ArrayList<Bill>());
        }

        for (int i = 0; i < spn1.getValue(); i++)
        {
            bills.get(0).add(new Bill(1));
        }

        for (int i = 0; i < spn2.getValue(); i++)
        {
            bills.get(1).add(new Bill(5));
        }

        for (int i = 0; i < spn3.getValue(); i++)
        {
            bills.get(2).add(new Bill(10));
        }

        for (int i = 0; i < spn4.getValue(); i++)
        {
            bills.get(3).add(new Bill(20));
        }

        for (int i = 0; i < spn5.getValue(); i++)
        {
            bills.get(4).add(new Bill(50));
        }

        for (int i = 0; i < spn6.getValue(); i++)
        {
            bills.get(5).add(new Bill(100));
        }

        for (int i = 0; i < spn7.getValue(); i++)
        {
            bills.get(6).add(new Bill(200));
        }

        for (int i = 0; i < spn8.getValue(); i++)
        {
            bills.get(7).add(new Bill(500));
        }
        for (int i = 0; i < spn9.getValue(); i++)
        {
            bills.get(8).add(new Bill(1000));
        }

        vm.getMoney().addMoney(bills);

        setLabels();

    }

    public void withdraw(ActionEvent event)
    {

        ArrayList<ArrayList<Bill>> bills;
        bills = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            bills.add(new ArrayList<Bill>());
        }

        for (int i = 0; i < spn1.getValue(); i++)
        {
            bills.get(0).add(new Bill(1));
        }

        for (int i = 0; i < spn2.getValue(); i++)
        {
            bills.get(1).add(new Bill(5));
        }

        for (int i = 0; i < spn3.getValue(); i++)
        {
            bills.get(2).add(new Bill(10));
        }

        for (int i = 0; i < spn4.getValue(); i++)
        {
            bills.get(3).add(new Bill(20));
        }

        for (int i = 0; i < spn5.getValue(); i++)
        {
            bills.get(4).add(new Bill(50));
        }

        for (int i = 0; i < spn6.getValue(); i++)
        {
            bills.get(5).add(new Bill(100));
        }

        for (int i = 0; i < spn7.getValue(); i++)
        {
            bills.get(6).add(new Bill(200));
        }

        for (int i = 0; i < spn8.getValue(); i++)
        {
            bills.get(7).add(new Bill(500));
        }
        for (int i = 0; i < spn9.getValue(); i++)
        {
            bills.get(8).add(new Bill(1000));
        }

        if (!vm.getMoney().removeMoney(bills))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Withdraw Error!");
            alert.setContentText("Please make sure that you're not withdrawing greater than the current amount");
            alert.show();
        }

        setLabels();

    }

    public void withdrawAll()
    {
        vm.getMoney().removeAll();
        setLabels();
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

    public void setLabels()
    {
        lbl1.setText(Integer.toString(vm.getMoney().getDenominations().get(0).size()));
        lbl2.setText(Integer.toString(vm.getMoney().getDenominations().get(1).size()));
        lbl3.setText(Integer.toString(vm.getMoney().getDenominations().get(2).size()));
        lbl4.setText(Integer.toString(vm.getMoney().getDenominations().get(3).size()));
        lbl5.setText(Integer.toString(vm.getMoney().getDenominations().get(4).size()));
        lbl6.setText(Integer.toString(vm.getMoney().getDenominations().get(5).size()));
        lbl7.setText(Integer.toString(vm.getMoney().getDenominations().get(6).size()));
        lbl8.setText(Integer.toString(vm.getMoney().getDenominations().get(7).size()));
        lbl9.setText(Integer.toString(vm.getMoney().getDenominations().get(8).size()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
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

        setLabels();
    }
}
