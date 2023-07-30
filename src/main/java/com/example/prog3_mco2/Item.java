/**
 * This class represents an item in a vending machine
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
package com.example.prog3_mco2;

public class Item
{

    private final String ITEM_NAME; // name of the item
    private int price; // price of the item
    private String description; // description of the item
    private int calories;  // calories of the item

    /**
     * Constructor for item with a name, price, description, and calories
     *
     * @param name the name of the item
     * @param price the price of the item
     * @param description the description of the item
     * @param calories the calories of the item
     */
    Item(String name, int price, String description, int calories)
    {
        this.ITEM_NAME = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    /**
     * This method gets the name of the item
     *
     * @return the name of the item
     */

    public String getName()
    {
        return ITEM_NAME;
    }
    /**
     * This method gets the price of the item
     *
     * @return the price of the item
     */
    public int getPrice()
    {
        return price;
    }
    /**
     * This method gets the description of the item
     *
     * @return the description of the item
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * This method gets the calories of the item
     *
     * @return the calories of the item
     */
    public int getCalories()
    {
        return calories;
    }
    /**
     * This method changes the price of the item
     *
     * @param price the new price of the item
     */
    public void changePrice(int price)
    {
        this.price = price;
    }
    /**
     * This method changes the description of the item
     *
     * @param description the new description of the item
     */
    public void changeDescription(String description)
    {
        this.description = description;
    }

    /**
     * This method changes the calories of the item
     *
     * @param calories the new calories of the item
     */
    public void changeCalories(int calories)
    {
        this.calories = calories;
    }

}
