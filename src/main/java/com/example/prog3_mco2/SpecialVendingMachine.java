package com.example.prog3_mco2;

import java.util.ArrayList;

public class SpecialVendingMachine extends RegularVendingMachine
{


    /**
     * Constructor for objects of class RegularVendingMachine
     *
     * @param name        the name of the vending machine
     * @param numSlots
     * @param numCapacity
     */
    public SpecialVendingMachine(String name, int numSlots, int numCapacity) {
        super(name, numSlots, numCapacity);
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
    public boolean stockBase(String name, int price, String description, int calories)
    {

        Base newItem = new Base(name, price, description, calories);

        if (SLOT_LIST.size() >= numSlots || price < 1 || calories < 1)
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
     * This method stocks a new item to the vending machine
     *
     * @param name the name of the item to be stocked
     * @param price the price of the to be stocked
     * @param description the description of the item to be stocked
     * @param calories the calories of the item to be stocked
     *
     * @return true if the item was added, false if the item was not added
     */
    public boolean stockAddon(String name, int price, String description, int calories)
    {

        Addon newItem = new Addon(name, price, description, calories);

        if (SLOT_LIST.size() >= numSlots || price < 1 || calories < 1)
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


}
