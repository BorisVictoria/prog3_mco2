package com.example.prog3_mco2;

import java.util.ArrayList;

/**
 * This class represents a cash register in a vending machine
 *
 * @author Katipunan Miguel Delos Reyes
 * @author Boris Victoria
 */
public class Register
{
    private ArrayList<ArrayList<Bill>> bills; // The outer arraylist are the denominations, the inner arrayList are the bills
    private int total; // The total amount of money in the register

    /**
     * Constructor for the register
     *
     */
    public Register()
    {
        bills = new ArrayList<ArrayList<Bill>>();
        for (int i = 0; i < 9; i++)
        {
            bills.add(new ArrayList<Bill>());
        }

        total = 0;

    }

    /**
     * Adds money to the register
     *
     * @param deposit  the denominations to be deposited
     */
    public void addMoney(ArrayList<ArrayList<Bill>> deposit) {

        for (int i = 0; i < deposit.get(0).size(); i++) {
            bills.get(0).add(new Bill(1));
        }

        for (int i = 0; i < deposit.get(1).size(); i++) {
            bills.get(1).add(new Bill(5));
        }

        for (int i = 0; i < deposit.get(2).size(); i++) {
            bills.get(2).add(new Bill(10));
        }

        for (int i = 0; i < deposit.get(3).size(); i++) {
            bills.get(3).add(new Bill(20));
        }

        for (int i = 0; i < deposit.get(4).size(); i++) {
            bills.get(4).add(new Bill(50));
        }

        for (int i = 0; i < deposit.get(5).size(); i++) {
            bills.get(5).add(new Bill(100));
        }

        for (int i = 0; i < deposit.get(6).size(); i++) {
            bills.get(6).add(new Bill(200));
        }

        for (int i = 0; i < deposit.get(7).size(); i++) {
            bills.get(7).add(new Bill(500));
        }
        for (int i = 0; i < deposit.get(8).size(); i++) {
            bills.get(8).add(new Bill(1000));
        }

        total = 0;
        for (int i : new int[]{bills.get(0).size(), bills.get(1).size() * 5, bills.get(2).size() * 10, bills.get(3).size() * 20, bills.get(4).size() * 50, bills.get(5).size() * 100, bills.get(6).size() * 200, bills.get(7).size() * 500, bills.get(8).size() * 1000}) {
            total += i;
        }
    }

    /**
     * Removes the selected amount of money from the register
     *
     * @param withdraw the money to be withdrawn
     * @return true if the money was removed, false if not
     */
    public boolean removeMoney(ArrayList<ArrayList<Bill>> withdraw)
    {

        for (int i = 0; i < 9; i++)
        {
            if (withdraw.get(i).size() > bills.get(i).size())
                return false;
        }

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < withdraw.get(i).size(); j++)
            {
                bills.get(i).remove(bills.get(i).size() - 1);
            }
        }

        total = 0;
        for (int i : new int[]{bills.get(0).size(), bills.get(1).size() * 5, bills.get(2).size() * 10, bills.get(3).size() * 20, bills.get(4).size() * 50, bills.get(5).size() * 100, bills.get(6).size() * 200, bills.get(7).size() * 500, bills.get(8).size() * 1000})
        {
            total += i;
        }

        return true;

    }

    /**
     * Removes all money from the register
     *
     */
    public void removeAll()
    {
        for (int i = 0; i < 9; i++)
        {
            bills.get(i).clear();
        }
        total = 0;
    }

    /**
     * Returns the bills in the register
     * @return bills
     */
    public ArrayList<ArrayList<Bill>> getDenominations()
    {
        return bills;
    }


    /**
     * Returns the total amount of money in the register
     * @return total
     */
    public int getTotal()
    {
        return total;
    }


}
