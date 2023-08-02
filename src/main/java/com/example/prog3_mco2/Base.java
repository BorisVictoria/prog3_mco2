package com.example.prog3_mco2;

/**
 * This class represents an item base in a vending machine
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
public class Base extends Item
{

    /**
     * Constructor for an item base with a name, price, description, and calories
     *
     * @param name  the name of the base
     * @param price  the price of the base
     * @param description  the description of the base
     * @param calories  the calories of the base
     */
    public Base(String name, int price, String description, int calories)
    {
        super(name, price, description, calories);
    }
}
