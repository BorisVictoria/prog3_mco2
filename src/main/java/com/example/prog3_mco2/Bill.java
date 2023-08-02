package com.example.prog3_mco2;

/**
 * This class represents a denomination of currrency
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
public class Bill
{
    int value; // The value of the bill

    /**
     * Constructor for the Bill class
     *
     * @param value The value of the bill
     */
    public Bill(int value)
    {
        this.value = value;
    }

    /**
     * Getter for the value of the bill
     *
     * @return The value of the bill
     */
    public int getValue()
    {
        return value;
    }

}
