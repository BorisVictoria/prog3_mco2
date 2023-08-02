package com.example.prog3_mco2;

/**
 * This class represents an item addon in a vending machine
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
public class Addon extends Item
{

    /**
     * Constructor for an addon with a name, price, description, and calories
     *
     * @param name  the name of the addon
     * @param price  the price of the addon
     * @param description  the description of the addon
     * @param calories  the calories of the addon
     */
    Addon(String name, int price, String description, int calories)
    {
        super(name, price, description, calories);
    }
}
