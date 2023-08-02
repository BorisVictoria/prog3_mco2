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
    public SpecialVendingMachine(String name, int numSlots, int numCapacity)
    {
        super(name, numSlots, numCapacity);
    }

    public ArrayList<ArrayList<Bill>> dispenseSpecialChange(ArrayList<Item> itemList)
    {
        int totalChange;
        int totalPayment = 0;
        ArrayList<ArrayList<Bill>> change;
        Register total;
        int temp;

        for (int i = 0; i < itemList.size(); i++)
        {
            totalPayment += itemList.get(i).getPrice();
        }

        // checks if total inserted is less than the price of the item
        if (inserted.getTotal() < totalPayment)
            return null;

        // calculates the total change
        totalChange = inserted.getTotal() - totalPayment;
        total = new Register();
        total.addMoney(register.getDenominations());
        total.addMoney(inserted.getDenominations());
        change = new ArrayList<ArrayList<Bill>>();

        for (int i = 0; i < 9; i++)
        {
            change.add(new ArrayList<Bill>());
        }
        temp = totalChange;

        for (int i = 0; i < Math.min(temp / 1000, total.getDenominations().get(8).size()); i++)
        {
            change.get(8).add(new Bill(1000));
        }
        temp -= change.get(8).size() * 1000;

        for (int i = 0; i < Math.min(temp / 500, total.getDenominations().get(7).size()); i++)
        {
            change.get(7).add(new Bill(500));
        }
        temp -= change.get(7).size() * 500;

        for (int i = 0; i < Math.min(temp / 200, total.getDenominations().get(6).size()); i++)
        {
            change.get(6).add(new Bill(200));
        }
        temp -= change.get(6).size() * 200;

        for (int i = 0; i < Math.min(temp / 100, total.getDenominations().get(5).size()); i++)
        {
            change.get(5).add(new Bill(100));
        }
        temp -= change.get(5).size() * 100;

        for (int i = 0; i < Math.min(temp / 50, total.getDenominations().get(4).size()); i++)
        {
            change.get(4).add(new Bill(50));
        }
        temp -= change.get(4).size() * 50;

        for (int i = 0; i < Math.min(temp / 20, total.getDenominations().get(3).size()); i++)
        {
            change.get(3).add(new Bill(20));
        }
        temp -= change.get(3).size() * 20;

        for (int i = 0; i < Math.min(temp / 10, total.getDenominations().get(2).size()); i++)
        {
            change.get(2).add(new Bill(10));
        }
        temp -= change.get(2).size() * 10;

        for (int i = 0; i < Math.min(temp / 5, total.getDenominations().get(1).size()); i++)
        {
            change.get(1).add(new Bill(5));
        }
        temp -= change.get(1).size() * 5;

        for (int i = 0; i < Math.min(temp, total.getDenominations().get(0).size()); i++)
        {
            change.get(0).add(new Bill(1));
        }
        temp -= change.get(0).size();

        // checks if there is enough change
        if (temp != 0)
            return null;

        return change;
    }

    public ArrayList<ArrayList<Bill>> dispenseSpecialItem(ArrayList<Item> itemList)
    {

        int[] slotIndex = new int[SLOT_LIST.size()];

        for (int i = 0; i < itemList.size(); i++)
        {
            for (int j = 0; j < SLOT_LIST.size(); j++)
            {
                if (itemList.get(i).getName().equals(SLOT_LIST.get(j).getName()))
                {
                    slotIndex[j]++;
                }
            }
        }

        for (int i = 0; i < SLOT_LIST.size(); i++)
        {
            if (slotIndex[i] > SLOT_LIST.get(i).getItemQuantity())
                return null;
        }

        ArrayList<ArrayList<Bill>> change = dispenseSpecialChange(itemList);

        if (change == null)
            return null;

        for (int i = 0; i < slotIndex.length; i++)
        {
            for (int j = 0; j < slotIndex[i]; j++)
            {
                TRANSACTION_LIST.add(new Transaction(SLOT_LIST.get(i).getName(), SLOT_LIST.get(i).getItemPrice(), i));
                SLOT_LIST.get(i).removeItem();
            }
        }

        register.addMoney(inserted.getDenominations());
        register.removeMoney(change);
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
