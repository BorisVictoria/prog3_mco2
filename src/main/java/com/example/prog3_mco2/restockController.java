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

public class restockController implements Initializable {

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
    private ChoiceBox<String> choiceBox;

    @FXML
    private Spinner<Integer> spn1;

    public restockController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void restock(ActionEvent event) throws IOException
    {
        String name = choiceBox.getValue();
        int qty = spn1.getValue();

        for (int i = 0; i < vm.getSlotList().size(); i++)
        {
            if (choiceBox.getItems().get(i).equals(name)) {
                if (!vm.restock(i, qty))
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Total quantity exceeds maximum capacity!");
                    alert.setContentText("Please try again");
                    alert.show();
                }
                else
                    choiceList();
            }
        }

    }

    public void list(ActionEvent event) throws IOException
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
            }
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
        for (int i = 0; i < vm.getSlotList().size(); i++)
            choiceBox.getItems().add(vm.getSlotList().get(i).toString());

        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory1.setValue(1);
        spn1.setValueFactory(valueFactory1);

        choiceBox.getSelectionModel().selectFirst();
        choiceList();

    }



}
