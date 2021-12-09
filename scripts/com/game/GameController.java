package com.game;

public class GameController
{
    private final static byte CITIES_COUNT = 1;
    private final static byte VILLAGES_COUNT = 4;

    private byte day = 0;
    Map map = new Map();
    Spieler spieler = new Spieler(map.START_ORT);



    public GameController()
    {
        day = 0;

    }

    public void move()
    {
        day++;
        spieler.removeHp(20);
    }

    public void endGame()
    {
        showResults();
    }

    private void showResults()
    {

    }
}
