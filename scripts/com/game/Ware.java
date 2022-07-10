package com.game;

public class Ware
{
    public final int id;
    public final String name;
    public final float gewicht;
    public final int preis;

    public Ware(int id, String name, float gewicht, int preis)
    {
        this.id = id;
        this.name = name;
        this.gewicht = gewicht;
        this.preis = preis;
    }

    public boolean equal(Ware ware)
    {
        return this.id == ware.id;
    }

    public static boolean equal(Ware ware1, Ware ware2)
    {
        return ware1.id == ware2.id;
    }

    public String getDescription()
    {
        return name+ "\nid: " + id + "\ngewicht: " + gewicht + " kg\npreis: " + preis;
    }


}
