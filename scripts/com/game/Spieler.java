package com.game;

public class Spieler
{
    private static final byte MAX_HP  = 100;
    private static final byte MONEY_ON_START  = 100;

    private Ort startOrt;
    private Ort currentort;

    private byte hp = MAX_HP;
    private byte money = MONEY_ON_START;

    private Esel esel = new Esel();

    public Spieler(Ort startOrt)
    {
        this.startOrt = startOrt;
        currentort = startOrt;
    }

    public void addHp(int i)
    {
        if(hp < MAX_HP)
        {
            hp += i;
        }
    }

    public void eat()
    {

    }

    public void removeHp(int i)
    {
        hp -= i;

        if(hp < 0)
        {
            // action stop game
        }
    }

    public Esel getEsel()
    {
        return esel;
    }

}
