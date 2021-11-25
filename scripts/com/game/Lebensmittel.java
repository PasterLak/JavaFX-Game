package com.game;

public class Lebensmittel extends Ware
{
    public final static byte HP_RESTORE = 20;

    public Lebensmittel(String name, int gewicht, int preis)
    {
        super(name, gewicht, preis);
    }
}
