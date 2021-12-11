package com.game;

public final class GameController
{
    private static GameController INSTANCE;

    private byte day = 0;

    private Map map = new Map();
    private Spieler spieler = new Spieler(map.START_ORT);


    public GameController()
    {
        day = 1;
    }

    public static GameController getInstance()
    {
        if(INSTANCE == null) {
            INSTANCE = new GameController();
        }

        return INSTANCE;
    }

    public void nextDay()
    {
        day++;
        UIController.INSTANCE.updateDays(day);
        AudioController.INSTANCE.play();

        if(day == 100)
        {
            endGame();
        }
    }

    private void endGame()
    {
        showResults();
    }

    private void showResults()
    {

    }
}
