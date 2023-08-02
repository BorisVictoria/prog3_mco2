package com.example.prog3_mco2;

import java.util.ArrayList;

/**
 * This class represents a slot in a vending machine
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
public class Slot
{
    private final String SLOT_NAME; // name of the slot
    private final Item ITEM; // item sold by the slot
    private final ArrayList<Item> ITEM_LIST; // instances of the item sold by the slot

    /**
     * Constructor for objects of class Slot
     *
     * @param item the item to be placed in the slot
     */
    public Slot(Item item)
    {
        this.SLOT_NAME = item.getName();
        this.ITEM = item;
        this.ITEM_LIST = new ArrayList<Item>();
    }

    /**
     * This method adds an item to the slot
     *
     * @return true if the item was added, false if the slot is full
     */
    public boolean addItem()
    {
        if (isFull())
        {
            return false;
        }
        else
        {
            if (ITEM instanceof Base)
                ITEM_LIST.add(new Base(ITEM.getName(), ITEM.getPrice(), ITEM.getDescription(), ITEM.getCalories()));
            else if (ITEM instanceof Addon)
                ITEM_LIST.add(new Addon(ITEM.getName(), ITEM.getPrice(), ITEM.getDescription(), ITEM.getCalories()));
            else
                ITEM_LIST.add(new Item(ITEM.getName(), ITEM.getPrice(), ITEM.getDescription(), ITEM.getCalories()));
            return true;
        }
    }
    /**
     * This method removes an item from the slot
     *
     * @return true if the item was removed, false if the slot is empty
     */
    public boolean removeItem()
    {
        if (isEmpty())
        {
            return false;
        }
        else
        {
            ITEM_LIST.remove(ITEM_LIST.size() - 1);
            return true;
        }
    }
    /**
     * This method checks if the slot is full
     *
     * @return true if the slot is full, false if the slot is not full
     */
    public boolean isFull()
    {
        return ITEM_LIST.size() == 10;
    }

    /**
     * This method checks if the slot is empty
     *
     * @return true if the slot is empty, false if the slot is not empty
     */
    public boolean isEmpty()
    {
        return ITEM_LIST.size() == 0;
    }

    public Item getItem()
    {
        return ITEM;
    }
    /**
     * This method gets the name of the item in the slot
     *
     * @return the name of the slot
     */
    public String getName()
    {
        return SLOT_NAME;
    }

    /**
     * This method gets the item in the slot's price
     *
     * @return the price of the item in the slot
     */
    public int getItemPrice()
    {
        return ITEM.getPrice();
    }

    /**
     * This method gets the description of the item in the slot
     *
     * @return the description of the item in the slot
     */
    public String getItemDescription()
    {
        return ITEM.getDescription();
    }

    /**
     * This method gets the item's calories in the slot
     *
     * @return the calories of the item in the slot
     */
    public int getItemCalories()
    {
        return ITEM.getCalories();
    }

    /**
     * This method gets the quantity of items in the slot
     *
     * @return the quantity of items in the slot
     */
    public int getItemQuantity()
    {
        return ITEM_LIST.size();
    }

    /**
     * THis method changes the price of the item in the slot
     *
     * @param price the new price of the item
     *
     * @return true if the price was changed, false if the price was not changed
     */
    public boolean changeItemPrice(int price)
    {
        if (price < 1)
        {
            return false;
        }
        else
        {
            ITEM.changePrice(price);
            for(Item i : ITEM_LIST)
            {
                i.changePrice(price);
            }
            return true;
        }
    }

    /**
     * This method changes the description of the item in the slot
     *
     * @param description the new description of the item
     */
    public void changeItemDescription(String description)
    {
        ITEM.changeDescription(description);
    }

    /**
     * This method changes the calories of the item in the slot
     *
     * @param calories the new calories of the item
     *
     * @return true if the calories were changed, false if the calories were not changed
     *
     */
    public boolean changeItemCalories(int calories)
    {
        if (calories < 1)
        {
            return false;
        }
        else
        {
            ITEM.changeCalories(calories);
            for(Item i : ITEM_LIST)
            {
                i.changeCalories(calories);
            }
            return true;
        }
    }

    /**
     * This method returns the name of the item in the slot for gui purposes
     *
     * @return the name of the item in the slot
     */
    public String toString()
    {
        return ITEM.getName();
    }

}
