package com.game;

public final class GameController
{
    private static GameController INSTANCE;
    private static final byte MAX_DAY = 100;

    private byte day;

    public final Map map = new Map();
    public final Spieler spieler = new Spieler(map.START_ORT);

    public GameController()
    {
        if(INSTANCE == null) INSTANCE = this;
        AudioController.among.play();
        day = 1;
    }

    public static GameController getInstance()
    {
        return INSTANCE;
    }

    public void updateDays(int count)
    {
        if(count <= 0) return;

        day += count;
        UIController.INSTANCE.updateDays(day);
        spieler.getCurrentOrt().getHandler().updateWaren();

        if(day >= MAX_DAY)
        {
            AudioController.win.play();
            endGame();
        }
    }

    public void endGame()
    {
        showResults();
    }

    public void restart()
    {
        AudioController.among.play();
        day = 1;
        UIController.INSTANCE.updateDays(1);
        spieler.restart();
        UIController.INSTANCE.closeResult();
    }

    private void showResults()
    {
        UIController.INSTANCE.showResult();
    }

    public int currentDay()
    {
        return day;
    }
}
