package com.example.prog3_mco2;

public class Register
{
    int[] money;
    int total;

    public Register()
    {
        money = new int[9];
        total = 0;

    }

    public void addMoney(int[] deposit)
    {
        for (int i = 0; i < 9; i++)
        {
            money[i] += deposit[i];
        }

        total = 0;
        for (int i : new int[]{money[0], money[1] * 5, money[2] * 10, money[3] * 20, money[4] * 50, money[5] * 100, money[6] * 200, money[7] * 500, money[8] * 1000})
        {
            total += i;
        }
    }

    public boolean removeMoney(int[] withdraw)
    {
        for (int i = 0; i < 9; i++)
        {
            money[i] -= withdraw[i];
            if (money[i] < 0)
                return false;
        }

        total = 0;
        for (int i : new int[]{money[0], money[1] * 5, money[2] * 10, money[3] * 20, money[4] * 50, money[5] * 100, money[6] * 200, money[7] * 500, money[8] * 1000})
        {
            total += i;
        }

        return true;

    }

    public void removeAll()
    {
        for (int i = 0; i < 9; i++)
        {
            money[i] = 0;
        }

        total = 0;
    }

    public int[] getDenominations()
    {
        return money;
    }

    public int getTotal()
    {
        return total;
    }


}
