/**
 * This class represents transactions in a vending machine
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
package com.example.prog3_mco2;

public class Transaction
{
    private final String ITEM_NAME; // name of the item
    private final double PRICE; // price of the item
    private final int SLOT_INDEX; // slot index of the item
    /**
     * Constructor for Transaction with a name, price, and slot index
     *
     * @param name the name of the item transacted
     * @param price the price of the item transacted
     * @param slotIndex the index of the slot item transacted
     */
    Transaction(String name, double price, int slotIndex)
    {
        this.ITEM_NAME = name;
        this.PRICE = price;
        this.SLOT_INDEX = slotIndex;
    }

    /**
     * This method gets the name of the item
     *
     * @return name of the item
     */
    public String getName()
    {
        return ITEM_NAME;
    }

    /**
     * This method gets the price of the item
     *
     * @return price of the item
     */
    public double getPrice()
    {
        return PRICE;
    }

    /**
     * This method gets the slot index of the item
     *
     * @return slot index of the item
     */
    public int getSlotIndex()
    {
        return SLOT_INDEX;
    }

}
