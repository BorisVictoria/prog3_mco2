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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MultipleSelectionModel;


public class displayController implements Initializable
{

    private static class NoSelectionModel<T> extends MultipleSelectionModel<T>
    {

        @Override
        public ObservableList<Integer> getSelectedIndices() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public ObservableList<T> getSelectedItems() {
            return FXCollections.emptyObservableList();
        }

        @Override
        public void selectIndices(int index, int... indices) {
        }

        @Override
        public void selectAll() {
        }

        @Override
        public void selectFirst() {
        }

        @Override
        public void selectLast() {
        }

        @Override
        public void clearAndSelect(int index) {
        }

        @Override
        public void select(int index) {
        }

        @Override
        public void select(T obj) {
        }

        @Override
        public void clearSelection(int index) {
        }

        @Override
        public void clearSelection() {
        }

        @Override
        public boolean isSelected(int index) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void selectPrevious() {
        }

        @Override
        public void selectNext() {
        }
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    private RegularVendingMachine vm;

    @FXML
    private ListView<String> a1;

    @FXML
    private ListView<String> a2;

    @FXML
    private ListView<Integer> a3;

    @FXML
    private ListView<Integer> a4;

    @FXML
    private ListView<Integer> a5;

    @FXML
    private ListView<Integer> a6;

    @FXML
    private ListView<Integer> a7;

    @FXML
    private Label lbl1;

    public displayController(RegularVendingMachine vm)
    {
        this.vm = vm;
    }

    public void display()
    {
        if (vm.getTransactionList().size() > 0) // If there are transactions
        {

            int[] slotIndex = new int[vm.getSlotList().size()]; // Array to store the number of items sold for each slot
            int[] totalSales = new int[vm.getSlotList().size()]; // Array to store the total sales for each slot
            int total = 0;

            for (int i = 0; i < vm.getTransactionList().size(); i++)
            {
                slotIndex[vm.getTransactionList().get(i).getSlotIndex()]++;
                totalSales[vm.getTransactionList().get(i).getSlotIndex()] += vm.getTransactionList().get(i).getPrice();
            }

            for (int i = 0; i < vm.getSlotList().size(); i++)
            {
                if (slotIndex[i] > 0)
                {

                    a1.getItems().add(vm.getSlotList().get(i).getName());
                    a2.getItems().add(vm.getSlotList().get(i).getClass().getSimpleName());
                    a3.getItems().add(vm.getSlotList().get(i).getItemPrice());
                    a4.getItems().add(vm.getSlotList().get(i).getItemQuantity() + slotIndex[i]);
                    a5.getItems().add(vm.getSlotList().get(i).getItemQuantity());
                    a6.getItems().add(slotIndex[i]);
                    a7.getItems().add(totalSales[i]);
                    total += totalSales[i];
                }

            }

            lbl1.setText(String.valueOf(total));

        }

        a1.setSelectionModel(new NoSelectionModel<String>());
        a2.setSelectionModel(new NoSelectionModel<String>());
        a3.setSelectionModel(new NoSelectionModel<Integer>());
        a4.setSelectionModel(new NoSelectionModel<Integer>());
        a5.setSelectionModel(new NoSelectionModel<Integer>());
        a6.setSelectionModel(new NoSelectionModel<Integer>());
        a7.setSelectionModel(new NoSelectionModel<Integer>());
    }

    public void exit(ActionEvent event) throws IOException {
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
        display();
    }
}