package com.game;

public class ItemSlot
{

    public Ware ware;
    public int count;

    public float gewicht()
    {
       return  count * ware.gewicht;
    }



}
