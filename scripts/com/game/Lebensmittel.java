package com.game;

public class Lebensmittel extends Ware
{
    public final static byte HP_RESTORE = 20;

    public Lebensmittel(int id, String name, float gewicht, int preis)
    {
        super(id, name, gewicht, preis);
    }
}
