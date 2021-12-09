package com.game;

import java.util.Arrays;

public class Esel
{
    private final static byte INVENTORY_SIZE = 10;
    private final static float MAX_LOAD = 100f;


    private Ware waren[] = new Ware[INVENTORY_SIZE];
    private float warenGewicht = 0;

    public Esel ()
    {
        //waren[0] = new Lebensmittel("1",1,1);
    }

    public void getInventory()
    {

    }

    public void checkItem()
    {

    }

    public boolean isInventoryFull()
    {
        if(Arrays.toString(waren).indexOf("null") > -1)
            return false;
        return true;
    }

    public void addItem(Ware ware)
    {
        if(isInventoryFull()) return;

        byte emptySlotID = findEmptySlot();

        waren[emptySlotID] = ware;


    }
    public void removeItem(Ware ware)
    {

    }

    private byte findEmptySlot()
    {
        if(isInventoryFull()) return -1;

        for (byte i = 0; i < waren.length; i++)
        {
            if(waren[i] == null)
                return i;
        }

        return -1;
    }

}
