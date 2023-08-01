package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class vendingController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;
    private ArrayList<ArrayList<Bill>> change;

    @FXML
    private Button btn1;

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
    private ChoiceBox<String> choiceBox;

    public vendingController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void dispense(ActionEvent event) throws IOException
    {
        String name = choiceBox.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++)
        {
            if (choiceBox.getItems().get(i).equals(name))
            {
                int temp = vm.getInserted().getTotal();
                change = vm.dispenseItem(i);
                if (change != null)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Item Dispensed!");
                    String str1 = "";
                    str1 = str1.concat("Transaction Summary \n" + "Item: " + vm.getSlotList().get(i).getName() + "\nPrice: " + vm.getSlotList().get(i).getItemPrice() +
                        "\nCalories: " + vm.getSlotList().get(i).getItemCalories() + "\nDescription: " + vm.getSlotList().get(i).getItemDescription() + "\nCash: " + temp + "\nChange: \n");

                    if (change.get(0).size() > 0)  str1 = str1.concat("1 Peso x" + change.get(0).size() + "\n");
                    if (change.get(1).size() > 0)  str1 = str1.concat("5 Peso x" + change.get(1).size() + "\n");
                    if (change.get(2).size() > 0)  str1 = str1.concat("10 Peso x" + change.get(2).size() + "\n");
                    if (change.get(3).size() > 0)  str1 = str1.concat("20 Peso x" + change.get(3).size() + "\n");
                    if (change.get(4).size() > 0)  str1 = str1.concat("50 Peso x" + change.get(4).size() + "\n");
                    if (change.get(5).size() > 0)  str1 = str1.concat("100 Peso x" + change.get(5).size() + "\n");
                    if (change.get(6).size() > 0)  str1 = str1.concat("200 Peso x" + change.get(6).size() + "\n");
                    if (change.get(7).size() > 0)  str1 = str1.concat("500 Peso x" + change.get(7).size() + "\n");
                    if (change.get(8).size() > 0)  str1 = str1.concat("1000 Peso x" + change.get(8).size() + "\n");
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.setContentText(str1);
                    alert.show();
                    choiceList();
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Transaction Error!");
                    alert.setContentText("Please try again");
                    alert.show();
                    choiceList();
                }

            }
        }

    }

    public void cancel(ActionEvent event)
    {
        vm.getInserted().removeAll();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Transaction Cancelled!");
        alert.setContentText("Your money has been removed");
        alert.show();
        choiceList();
    }

    public void add1Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(0).add(new Bill(1));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add5Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(1).add(new Bill(5));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add10Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(2).add(new Bill(10));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add20Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(3).add(new Bill(20));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add50Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(4).add(new Bill(50));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add100Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(5).add(new Bill(100));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add200Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(6).add(new Bill(200));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add500Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(7).add(new Bill(500));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }

    public void add1000Peso(ActionEvent event)
    {
        ArrayList<ArrayList<Bill>> inserted = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            inserted.add(new ArrayList<Bill>());
        }
        inserted.get(8).add(new Bill(1000));
        vm.getInserted().addMoney(inserted);
        choiceList();
    }


    public void list(ActionEvent event)
    {
        choiceList();
    }

    public void choiceList()
    {
        String name = choiceBox.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++) {
            if (choiceBox.getItems().get(i).equals(name))
            {
                lbl1.setText(vm.getSlotList().get(i).getName());
                lbl2.setText(Integer.toString(vm.getSlotList().get(i).getItemPrice()));
                lbl3.setText(Integer.toString(vm.getSlotList().get(i).getItemCalories()));
                lbl4.setText(Integer.toString(vm.getSlotList().get(i).getItemQuantity()));
                lbl5.setText(vm.getSlotList().get(i).getItemDescription());
                lbl6.setText(vm.getSlotList().get(i).getItem().getClass().getSimpleName());
                lbl7.setText(String.valueOf(vm.getInserted().getTotal()));
            }
        }
    }

    public void initSpecial(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("special.fxml"));
        loader.setControllerFactory(controllerClass -> new specialController(vm));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        loader.setControllerFactory(controllerClass -> new testController(vm));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        for (int i = 0; i < vm.getSlotList().size(); i++)
            choiceBox.getItems().add(vm.getSlotList().get(i).toString());

        choiceBox.getSelectionModel().selectFirst();
        choiceList();

        if (vm instanceof RegularVendingMachine)
            btn1.setVisible(false);
    }

}
