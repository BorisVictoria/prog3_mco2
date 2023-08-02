package com.example.prog3_mco2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class specialController implements Initializable
{

    private Stage stage;
    private Scene scene;
    private Parent root;

    private SpecialVendingMachine vm;
    private ArrayList<ArrayList<Bill>> change;
    private ArrayList<Item> itemList;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

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
    private Label lbl10;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl12;

    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private ChoiceBox<String> choiceBox2;

    @FXML
    private Spinner<Integer> spn1;

    @FXML
    private ListView<String> listview1;

    @FXML
    private ListView<Integer> listview2;

    public specialController(SpecialVendingMachine vm)
    {
        this.vm = vm;
        itemList = new ArrayList<Item>();
    }

    public void list1(ActionEvent event) throws IOException
    {
        choiceList1();
    }

    public void list2(ActionEvent event) throws IOException
    {
        choiceList2();
    }

    public void choiceList1()
    {
        String name = choiceBox1.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++) {
            if (vm.getSlotList().get(i).getName().equals(name))
            {
                lbl1.setText(vm.getSlotList().get(i).getName());
                lbl2.setText(Integer.toString(vm.getSlotList().get(i).getItemPrice()));
                lbl3.setText(Integer.toString(vm.getSlotList().get(i).getItemCalories()));
                lbl4.setText(Integer.toString(vm.getSlotList().get(i).getItemQuantity()));
                lbl5.setText(vm.getSlotList().get(i).getItemDescription());
                lbl6.setText(vm.getSlotList().get(i).getItem().getClass().getSimpleName());
                lbl7.setText("Name:");
                lbl8.setText("Price:");
                lbl9.setText("Calories:");
                lbl10.setText("Quantity:");
                lbl11.setText("Description:");
                lbl12.setText("Type:");

            }
        }
    }

    public void choiceList2()
    {
        String name = choiceBox2.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++) {
            if (vm.getSlotList().get(i).getName().equals(name))
            {
                lbl1.setText(vm.getSlotList().get(i).getName());
                lbl2.setText(Integer.toString(vm.getSlotList().get(i).getItemPrice()));
                lbl3.setText(Integer.toString(vm.getSlotList().get(i).getItemCalories()));
                lbl4.setText(Integer.toString(vm.getSlotList().get(i).getItemQuantity()));
                lbl5.setText(vm.getSlotList().get(i).getItemDescription());
                lbl6.setText(vm.getSlotList().get(i).getItem().getClass().getSimpleName());
                lbl7.setText("Name:");
                lbl8.setText("Price:");
                lbl9.setText("Calories:");
                lbl10.setText("Quantity:");
                lbl11.setText("Description:");
                lbl12.setText("Type:");
            }
        }
    }

    public void choiceList3()
    {
        String base = itemList.get(itemList.size()-1).getName();
        String addons = "";

        for (int i = 0; i < listview1.getItems().size(); i++)
        {
            addons = addons.concat(" " + listview2.getItems().get(i) + " " + listview1.getItems().get(i) + ",");
        }

        lbl1.setText("");
        lbl2.setText("");
        lbl3.setText("");
        lbl4.setText("");
        lbl5.setText("");
        lbl6.setText("");
        lbl7.setText("Turning on item replicator...");
        lbl8.setText("Creating atomic structure of " +base + "...");
        lbl9.setText("Powering up addon synthesizer...");
        if (listview1.getItems().size() > 0)
        {
            lbl10.setText("Topping with" + addons + "...");
        }
        else
            lbl10.setText("No toppings :(");
        lbl11.setText("Adding finishing touches...");
        lbl12.setText("Your item is ready!");
    }


    public void add(ActionEvent event)
    {
        String name = choiceBox2.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++)
        {
            if (vm.getSlotList().get(i).getName().equals(name))
            {
                if (spn1.getValue() > vm.getSlotList().get(i).getItemQuantity())
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Total quantity exceeds maximum capacity!");
                    alert.setContentText("Please try again");
                    alert.show();
                }
                else
                {
                    boolean newItem = true;

                    for (int k = 0; k < listview1.getItems().size(); k++)
                    {
                        if (listview1.getItems().get(k).equals(name))
                        {
                            listview2.getItems().set(k, listview2.getItems().get(k) + spn1.getValue());
                            newItem = false;
                        }

                    }

                    if (newItem)
                    {
                        listview1.getItems().add(vm.getSlotList().get(i).getName());
                        listview2.getItems().add(spn1.getValue());
                    }


                    for (int j = 0; j < spn1.getValue(); j++)
                    {
                        itemList.add(vm.getSlotList().get(i).getItem());
                    }
                }

            }
        }

    }

    public void remove(ActionEvent event)
    {
        String name = listview1.getSelectionModel().getSelectedItem();

        itemList.removeIf(item -> item.getName().equals(name));

        int index = listview1.getSelectionModel().getSelectedIndex();

        listview1.getItems().remove(index);
        listview2.getItems().remove(index);

    }


    public void dispense(ActionEvent event) throws IOException {

        String name = choiceBox1.getValue();
        boolean present = false;

        for (int i = 0; i < vm.getSlotList().size(); i++) {
            if (vm.getSlotList().get(i).getName().equals(name)) {
                itemList.add(vm.getSlotList().get(i).getItem());
                present = true;
            }
        }

        if (present)
        {
            int temp = vm.getInserted().getTotal();
            change = vm.dispenseSpecialItem(itemList);
            if (change != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Special Item Dispensed!");
                String str1 = "";
                str1 = str1.concat("Transaction Summary \n");
                str1 = str1.concat("Items: \n\n");

                str1 = str1.concat(itemList.get(itemList.size() - 1).getName() + " x1\n");

                for (int i = 0; i < listview1.getItems().size(); i++) {
                    str1 = str1.concat(listview1.getItems().get(i) + " x" + listview2.getItems().get(i) + "\n");
                }
                str1 = str1.concat("\n");

                int totalCalories = 0;

                for (int i = 0; i < itemList.size(); i++)
                {
                    totalCalories += itemList.get(i).getCalories();
                }
                str1 = str1.concat("Calories: " + totalCalories + "\n");
                str1 = str1.concat("Cash: " + temp + "\n");
                str1 = str1.concat("\nChange: \n");

                if (change.get(0).size() > 0) str1 = str1.concat("1 Peso x" + change.get(0).size() + "\n");
                if (change.get(1).size() > 0) str1 = str1.concat("5 Peso x" + change.get(1).size() + "\n");
                if (change.get(2).size() > 0) str1 = str1.concat("10 Peso x" + change.get(2).size() + "\n");
                if (change.get(3).size() > 0) str1 = str1.concat("20 Peso x" + change.get(3).size() + "\n");
                if (change.get(4).size() > 0) str1 = str1.concat("50 Peso x" + change.get(4).size() + "\n");
                if (change.get(5).size() > 0) str1 = str1.concat("100 Peso x" + change.get(5).size() + "\n");
                if (change.get(6).size() > 0) str1 = str1.concat("200 Peso x" + change.get(6).size() + "\n");
                if (change.get(7).size() > 0) str1 = str1.concat("500 Peso x" + change.get(7).size() + "\n");
                if (change.get(8).size() > 0) str1 = str1.concat("1000 Peso x" + change.get(8).size() + "\n");
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.setContentText(str1);
                alert.show();
                choiceList3();
                itemList.clear();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Transaction Error!");
                alert.setContentText("Please try again");
                alert.show();
                choiceList1();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("No Base Found!");
            alert.setContentText("Please create a base first");
            alert.show();
        }


    }

    public void exit(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vending.fxml"));
        loader.setControllerFactory(controllerClass -> new vendingController(vm));
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
        {
            if (vm.getSlotList().get(i).getItem() instanceof Base)
            {
                choiceBox1.getItems().add(vm.getSlotList().get(i).toString());
            }
            else if (vm.getSlotList().get(i).getItem() instanceof Addon)
            {
                choiceBox2.getItems().add(vm.getSlotList().get(i).toString());
            }
        }

        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory1.setValue(1);
        spn1.setValueFactory(valueFactory1);

        choiceBox1.getSelectionModel().selectFirst();
        choiceList1();

    }
}
