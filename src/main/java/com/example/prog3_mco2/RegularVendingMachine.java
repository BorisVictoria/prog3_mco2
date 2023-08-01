
/**
 * This class represents a vending machine and its associated features.
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
package com.example.prog3_mco2;

import java.util.ArrayList;

public class RegularVendingMachine
{
    protected String name; // name of the vending machine
    protected int numSlots; // number of slots of the vending machine
    protected int numCapacity;
    protected final ArrayList<Slot> SLOT_LIST; // list of slots of the vending machine
    protected final ArrayList<Transaction> TRANSACTION_LIST; // list of transactions of the vending machine
    protected int totalMoney; // total amount of change of the vending machine
    protected int totalInserted; // total amount of money inserted by a buyer to the vending machine
    protected int[] money; // array of change in multiple denominations
    protected int[] inserted; // array of payments in multiple denominations

    /**
     * Constructor for objects of class RegularVendingMachine
     *
     * @param name the name of the vending machine
     *
     */
    public RegularVendingMachine(String name, int numSlots, int numCapacity)
    {
        this.name = name;
        SLOT_LIST = new ArrayList<Slot>();
        TRANSACTION_LIST = new ArrayList<Transaction>();
        totalMoney = 0;
        totalInserted = 0;
        money = new int[9];
        inserted = new int[9];

    }

    /**
     * This method dispenses an item from the vending machine and calculates for the change
     *
     * @param slotIndex the slot index of the item to be dispensed
     *
     * @return true if the item was dispensed, false if the item was not dispensed
     */
    public boolean dispenseItem(int slotIndex)
    {

        int totalChange;
        int[] change;
        int temp;

        // checks if total inserted is less than the price of the item
        if (totalInserted < SLOT_LIST.get(slotIndex).getItemPrice())
            return false;

        // calculates the total change
        totalChange = totalInserted - SLOT_LIST.get(slotIndex).getItemPrice();
        change = new int[9];
        temp = totalChange;

        change[8] = Math.min(temp / 1000, money[8]);
        temp -= change[8] * 1000;

        change[7] = Math.min(temp / 500, money[7]);
        temp -= change[7] * 500;

        change[6] = Math.min(temp / 200, money[6]);
        temp -= change[6] * 200;

        change[5] = Math.min(temp / 100, money[5]);
        temp -= change[5] * 100;

        change[4] = Math.min(temp / 50, money[4]);
        temp -= change[4] * 50;

        change[3] = Math.min(temp / 20, money[3]);
        temp -= change[3] * 20;

        change[2] = Math.min(temp / 10, money[2]);
        temp -= change[2] * 10;

        change[1] = Math.min(temp / 5, money[1]);
        temp -= change[1] * 5;

        change[0] = Math.min(temp, money[0]);
        temp -= change[0];
        // checks if there is enough change
        if (temp != 0)
            return false;

        TRANSACTION_LIST.add(new Transaction(SLOT_LIST.get(slotIndex).getName(), SLOT_LIST.get(slotIndex).getItemPrice(), slotIndex));
        SLOT_LIST.get(slotIndex).removeItem();

        // Displays the transaction summary

        System.out.println("Transaction Summary \n");
        System.out.println("Item: " + SLOT_LIST.get(slotIndex).getName());
        System.out.println("Price: " + SLOT_LIST.get(slotIndex).getItemPrice());
        System.out.println("Calories: " + SLOT_LIST.get(slotIndex).getItemCalories());
        System.out.println("Description: " + SLOT_LIST.get(slotIndex).getItemDescription() + "\n");
        System.out.println("Cash: " + totalInserted);
        System.out.println("Change: " + totalChange + "\n");

        // Displays the change dispensed

        if (change[0] != 0) System.out.println("1 Peso x " + change[0] + " dispensed");
        if (change[1] != 0) System.out.println("5 Peso x " + change[1] + " dispensed");
        if (change[2] != 0) System.out.println("10 Peso x " + change[2] + " dispensed");
        if (change[3] != 0) System.out.println("20 Peso x " + change[3] + " dispensed");
        if (change[4] != 0) System.out.println("50 Peso x " + change[4] + " dispensed");
        if (change[5] != 0) System.out.println("100 Peso x " + change[5] + " dispensed");
        if (change[6] != 0) System.out.println("200 Peso x " + change[6] + " dispensed");
        if (change[7] != 0) System.out.println("500 Peso x " + change[7] + " dispensed");
        if (change[8] != 0) System.out.println("1000 Peso x " + change[8] + " dispensed");

        // Updates the money in the vending machine
        for (int i = 0; i < 9; i++)
        {
            money[i] -= change[i];
            money[i] += inserted[i];
            inserted[i] = 0;
        }
        totalInserted = 0;

        return true;

    }

    /**
     * This method cancels the transaction and returns the money inserted
     *
     */
    public void cancel()
    {
        totalInserted = 0;

        for (int i = 0; i < 9; i++)
        {
            inserted[i] = 0;
        }
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
    public int[] getMoney()
    {
        return money;
    }

    /**
     * This method returns the money inserted into the vending machine
     *
     * @return array of inserted money in multiple denominations
     */
    public int[] getInserted()
    {
        return inserted;
    }

    /**
     * This method returns the total money in the vending machine
     *
     * @return total amount of money of the vending machine
     */
    public int getTotalMoney()
    {
        return totalMoney;
    }

    /**
     * This method returns the total money inserted into the vending machine
     *
     * @return total amount of inserted money of the vending machine
     */
    public int getTotalInserted()
    {
        return totalInserted;
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

    /**
     * This method adds money to the vending machine
     *
     * @param deposit array of denominations to be deposited
     */
    public void addMoney(int[] deposit)
    {
        for (int i = 0; i < 9; i++)
        {
            money[i] += deposit[i];
        }

        totalMoney = 0;
        for (int i : new int[]{money[0], money[1] * 5, money[2] * 10, money[3] * 20, money[4] * 50, money[5] * 100, money[6] * 200, money[7] * 500, money[8] * 1000})
        {
            totalMoney += i;
        }

    }

    /**
     * This method inserts money into the machine
     *
     * @param inserted array of denominations to be inserted
     */
    public void insertMoney(int[] inserted)
    {
        // Adds the inserted money to the inserted array
        for (int i = 0; i < 9; i++)
        {
            this.inserted[i] += inserted[i];
        }
        // Calculates the total inserted money
        for (int i : new int[]{inserted[0], inserted[1] * 5, inserted[2] * 10, inserted[3] * 20, inserted[4] * 50, inserted[5] * 100, inserted[6] * 200, inserted[7] * 500, inserted[8] * 1000})
        {
            totalInserted += i;
        }
    }

    /**
     * This method collects all the money inside the vending machine and removes it from the array of change
     *
     */
    public void collectMoney()
    {
        for (int i = 0; i < 9; i++)
        {
            money[i] = 0;
        }

        totalMoney = 0;
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
