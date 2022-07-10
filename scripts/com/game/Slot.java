package com.game;

public class Slot
{

    public Ware ware;
    public int count = 0;

    public Slot()
    {

    }
    public Slot(Ware ware, int count)
    {
        this.ware = ware;
        this.count = count;
    }

    public float gewicht()
    {
       return  count * ware.gewicht;
    }


}
