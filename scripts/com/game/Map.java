package com.game;

public class Map
{

    public static final Stadt erfurt = new Stadt("Erfurt", UIController.INSTANCE.cityText);

    public static final Dorf schmalkalden = new Dorf("Schmalkalden", UIController.INSTANCE.villageText1);
    public static final Dorf eisenach = new Dorf("Eisenach", UIController.INSTANCE.villageText2);
    public static final Dorf weimar = new Dorf("Weimar", UIController.INSTANCE.villageText3);
    public static final Dorf ilmenau = new Dorf("Ilmenau", UIController.INSTANCE.villageText4);

    public final Ort START_ORT = erfurt;

    public Map()
    {
        erfurt.addWeg(schmalkalden, 1);
        erfurt.addWeg(eisenach, 1);
        erfurt.addWeg(ilmenau, 1);
        erfurt.addWeg(weimar, 2);

        schmalkalden.addWeg(eisenach, 2);
        ilmenau.addWeg(weimar, 1);
        ilmenau.addWeg(schmalkalden, 3);

    }

}
