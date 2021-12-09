package com.game;

public class Weg
{
    public Ort nextOrt;
    public int distance;

    public Weg(Ort nextOrt, int distance)
    {
        this.nextOrt = nextOrt;
        this.distance = distance;
    }

}
