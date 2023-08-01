
/**
 * This class represents a vending machine and its associated features.
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
package com.example.prog3_mco2;

import java.util.ArrayList;

public class RegularVendingMachine {
    protected String name; // name of the vending machine
    protected int numSlots; // number of slots of the vending machine
    protected int numCapacity;
    protected final ArrayList<Slot> SLOT_LIST; // list of slots of the vending machine
    protected final ArrayList<Transaction> TRANSACTION_LIST; // list of transactions of the vending machine
    protected Register register; // array of change in multiple denominations
    protected Register inserted; // array of payments in multiple denominations

    /**
     * Constructor for objects of class RegularVendingMachine
     *
     * @param name the name of the vending machine
     */
    public RegularVendingMachine(String name, int numSlots, int numCapacity) {
        this.name = name;
        SLOT_LIST = new ArrayList<Slot>();
        TRANSACTION_LIST = new ArrayList<Transaction>();
        register = new Register();
        inserted = new Register();

    }

    public ArrayList<ArrayList<Bill>> dispenseChange(int slotIndex)
    {
        int totalChange;
        ArrayList<ArrayList<Bill>> change;
        int temp;

        // checks if total inserted is less than the price of the item
        if (inserted.getTotal() < SLOT_LIST.get(slotIndex).getItemPrice())
            return null;

        // calculates the total change
        totalChange = inserted.getTotal() - SLOT_LIST.get(slotIndex).getItemPrice();
        change = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            change.add(new ArrayList<Bill>());
        }
        temp = totalChange;

        for (int i = 0; i < Math.min(temp / 1000, register.getDenominations().get(8).size()); i++)
        {
            change.get(8).add(new Bill(1000));
        }
        temp -= change.get(8).size() * 1000;

        for (int i = 0; i < Math.min(temp / 500, register.getDenominations().get(7).size()); i++)
        {
            change.get(7).add(new Bill(500));
        }
        temp -= change.get(7).size() * 500;

        for (int i = 0; i < Math.min(temp / 200, register.getDenominations().get(6).size()); i++)
        {
            change.get(6).add(new Bill(200));
        }
        temp -= change.get(6).size() * 200;

        for (int i = 0; i < Math.min(temp / 100, register.getDenominations().get(5).size()); i++)
        {
            change.get(5).add(new Bill(100));
        }
        temp -= change.get(5).size() * 100;

        for (int i = 0; i < Math.min(temp / 50, register.getDenominations().get(4).size()); i++)
        {
            change.get(4).add(new Bill(50));
        }
        temp -= change.get(4).size() * 50;

        for (int i = 0; i < Math.min(temp / 20, register.getDenominations().get(3).size()); i++)
        {
            change.get(3).add(new Bill(20));
        }
        temp -= change.get(3).size() * 20;

        for (int i = 0; i < Math.min(temp / 10, register.getDenominations().get(2).size()); i++)
        {
            change.get(2).add(new Bill(10));
        }
        temp -= change.get(2).size() * 10;

        for (int i = 0; i < Math.min(temp / 5, register.getDenominations().get(1).size()); i++)
        {
            change.get(1).add(new Bill(5));
        }
        temp -= change.get(1).size() * 5;

        for (int i = 0; i < Math.min(temp, register.getDenominations().get(0).size()); i++)
        {
            change.get(0).add(new Bill(1));
        }
        temp -= change.get(0).size();

        // checks if there is enough change
        if (temp != 0)
            return null;

        return change;
    }
    /**
     * This method dispenses an item from the vending machine and calculates for the change
     *
     * @param slotIndex the slot index of the item to be dispensed
     *
     * @return true if the item was dispensed, false if the item was not dispensed
     */
    public ArrayList<ArrayList<Bill>> dispenseItem(int slotIndex)
    {
        ArrayList<ArrayList<Bill>> change = dispenseChange(slotIndex);

        if (change == null)
            return null;

        TRANSACTION_LIST.add(new Transaction(SLOT_LIST.get(slotIndex).getName(), SLOT_LIST.get(slotIndex).getItemPrice(), slotIndex));
        SLOT_LIST.get(slotIndex).removeItem();

        // Displays the transaction summary

//        System.out.println("Transaction Summary \n");
//        System.out.println("Item: " + SLOT_LIST.get(slotIndex).getName());
//        System.out.println("Price: " + SLOT_LIST.get(slotIndex).getItemPrice());
//        System.out.println("Calories: " + SLOT_LIST.get(slotIndex).getItemCalories());
//        System.out.println("Description: " + SLOT_LIST.get(slotIndex).getItemDescription() + "\n");
//        System.out.println("Cash: " + totalInserted);
//        System.out.println("Change: " + totalChange + "\n");

        // Displays the change dispensed

//        if (change[0] != 0) System.out.println("1 Peso x " + change[0] + " dispensed");
//        if (change[1] != 0) System.out.println("5 Peso x " + change[1] + " dispensed");
//        if (change[2] != 0) System.out.println("10 Peso x " + change[2] + " dispensed");
//        if (change[3] != 0) System.out.println("20 Peso x " + change[3] + " dispensed");
//        if (change[4] != 0) System.out.println("50 Peso x " + change[4] + " dispensed");
//        if (change[5] != 0) System.out.println("100 Peso x " + change[5] + " dispensed");
//        if (change[6] != 0) System.out.println("200 Peso x " + change[6] + " dispensed");
//        if (change[7] != 0) System.out.println("500 Peso x " + change[7] + " dispensed");
//        if (change[8] != 0) System.out.println("1000 Peso x " + change[8] + " dispensed");

        // Updates the money in the vending machine

        register.removeMoney(change);
        register.addMoney(inserted.getDenominations());
        inserted.removeAll();

        return change;

    }

    /**
     * This method stocks a new item to the vending machine
     *
     * @param name the name of the item to be stocked
     * @param price the price of the to be stocked
     * @param description the description of the item to be stocked
     * @param calories the calories of the item to be stocked
     *
     * @return true if the item was added, false if the item was not added
     */
    public boolean stock(String name, int price, String description, int calories)
    {

        Item newItem = new Item(name, price, description, calories);

        if (SLOT_LIST.size() >= numSlots)
            return false;
        else
        {
            for (int i = 0; i < SLOT_LIST.size(); i++)
            {
                if (SLOT_LIST.get(i).getName().equals(name))
                    return false;

            }
            SLOT_LIST.add(new Slot(newItem));
        }

        TRANSACTION_LIST.clear();
        return true;
    }

    /**
     * This method replaces an item in the vending machine
     *
     * @param name the name of the item to be stocked
     * @param price the price of the to be stocked
     * @param description the description of the item to be stocked
     * @param calories the calories of the item to be stocked
     * @param slotIndex the slot index of the item to be replaced
     *
     * @return true if the item was replaced, false if the item was not replaced
     */
    public boolean replace(String name, int price, String description, int calories, int slotIndex)
    {
        Item newItem = new Item(name, price, description, calories);

        // If the item to be replaced is the same as the item to be replaced with then return false
        for (int i = 0; i < SLOT_LIST.size(); i++)
        {
            if (SLOT_LIST.get(i).getName().equals(name))
                return false;

        }
        SLOT_LIST.set(slotIndex, new Slot(newItem));

        TRANSACTION_LIST.clear();
        return true;

    }

    /**
     * This method removes an item from the vending machine
     *
     * @param slotIndex the index of the item to be removed
     */
    public void remove(int slotIndex)
    {
        SLOT_LIST.remove(slotIndex);
    }

    /**
     * This method restocks an item in the vending machine
     *
     * @param slotIndex the index of the item to be restocked
     * @param quantity the quantity of the item to be restocked
     *
     * @return true if the item was restocked, false if the item was not restocked
     */
    public boolean restock(int slotIndex, int quantity)
    {
        int total = quantity + SLOT_LIST.get(slotIndex).getItemQuantity();
        // If the total quantity of the item is greater than numCapacity, the item is not restocked
        if (total > numCapacity)
        {
            return false;
        }
        // If the total quantity of the item is less than numCapacity, the item is restocked by the quantity specified
        else
        {
            for (int i = 0; i < quantity; i++)
            {
                SLOT_LIST.get(slotIndex).addItem();
            }
        }

        TRANSACTION_LIST.clear();
        return true;
    }

    /**
     * This method changes the price of an item in the vending machine
     *
     * @param slotIndex the index of the item to be changed
     * @param  price the new price of the item
     *
     * @return true if the price of the item was changed, false if not
     */
    public boolean changeItemPrice(int slotIndex, int price)
    {

       return SLOT_LIST.get(slotIndex).changeItemPrice(price);
    }

    /**
     * This method changes the description of an item in the vending machine
     *
     * @param slotIndex the index of the item to be changed
     * @param description the new description of the item
     *
     */
    public void changeItemDescription(int slotIndex, String description)
    {
        SLOT_LIST.get(slotIndex).changeItemDescription(description);
    }

    /**
     * This method changes the calories of an item in the vending machine
     *
     * @param slotIndex the index of the item to be changed
     * @param calories the new calories of the item
     *
     * @return true if the calories of the item was changed, false if not
     */
    public boolean changeItemCalories(int slotIndex, int calories)
    {
        return SLOT_LIST.get(slotIndex).changeItemCalories(calories);
    }

    /**
     * This method returns the array of change in multiple denominations in the vending machine
     *
     * @return array of change in multiple denominations
     */
    public Register getMoney()
    {
        return register;
    }

    /**
     * This method returns the money inserted into the vending machine
     *
     * @return array of inserted money in multiple denominations
     */
    public Register getInserted()
    {
        return inserted;
    }

    /**
     * This method returns the list of slots in the vending machine
     *
     * @return list of slots of the vending machine
     */
    public ArrayList<Slot> getSlotList()
    {
        return SLOT_LIST;
    }

    public ArrayList<Transaction> getTransactionList()
    {
        return TRANSACTION_LIST;
    }


    /**
     * This method displays the items sold and the total sales for each item
     *
     */
    public void displayTransactions()
    {

        if (TRANSACTION_LIST.size() > 0) // If there are transactions
        {

            int[] slotIndex = new int[8]; // Array to store the number of items sold for each slot
            int[] totalSales = new int[8]; // Array to store the total sales for each slot

            System.out.println("Items Sold");
            for (int i = 0; i < TRANSACTION_LIST.size(); i++)
            {
                slotIndex[TRANSACTION_LIST.get(i).getSlotIndex()]++;
                totalSales[TRANSACTION_LIST.get(i).getSlotIndex()] += TRANSACTION_LIST.get(i).getPrice();
            }
            // Display the items sold and the total sales for each item

            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("|       Item Name       |           Description           |  Prev. Qty  |  Cur. Qty  |    Total Sales    |");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < SLOT_LIST.size(); i++)
            {
                if (slotIndex[i] > 0)
                {
                    System.out.format("| %-21s | %-31s | %10d  | %10d |  %16d |\n", SLOT_LIST.get(i).getName(), SLOT_LIST.get(i).getItemDescription(), SLOT_LIST.get(i).getItemQuantity() + slotIndex[i], SLOT_LIST.get(i).getItemQuantity(), totalSales[i]);
                }

            }

            System.out.println("---------------------------------------------------------------------------------------------------------");
        }
        else
        {
            System.out.println("No transactions found!");

        }

    }

}
