package com.game;

public class Map
{

    private City erfurt = new City("Erfurt");

    private Village schmalkalden = new Village("Schmalkalden");
    private Village bebra = new Village("Bebra");

    public final Ort START_ORT = erfurt;


    public Map()
    {

        erfurt.addWeg(schmalkalden, 2);
        schmalkalden.addWeg(erfurt, 2);

        erfurt.addWeg(bebra, 1);
        bebra.addWeg(erfurt, 1);

        schmalkalden.addWeg(bebra, 3);
        bebra.addWeg(schmalkalden, 3);

    }

}
