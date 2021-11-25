package com.game;

import com.basic.Graph;

public class GameController
{
    private final static byte CITIES_COUNT = 1;
    private final static byte VILLAGES_COUNT = 4;

    private byte day = 0;

    Spieler spieler = new Spieler();

    Graph map = new Graph(CITIES_COUNT + VILLAGES_COUNT);

    public GameController()
    {
        day = 0;

        map.addEdge(1,3);
        map.addEdge(3,1);
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
