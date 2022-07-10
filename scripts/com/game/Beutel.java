package com.game;

public class Beutel
{
    public static final byte MONEY_ON_START  = 100;
    private int money = MONEY_ON_START;

    public Beutel()
    {
        updateUI();
    }

    public void addMoney(int count)
    {
        money += Math.abs(count);
        updateUI();
    }

    public void removeMoney(int count)
    {
        money -= Math.abs(count);
        updateUI();
    }

    public boolean hasEnoughMoney(int price)
    {
        return money >= Math.abs(price);
    }

    public int getMoney()
    {
        return  money;
    }

    public void updateUI()
    {
        UIController.INSTANCE.updateMoney(money);
    }
}
