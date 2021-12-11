package com.game;

public class Weg
{
    public final Ort nextOrt;
    public final int distance;

    public Weg(Ort nextOrt, int distance)
    {
        this.nextOrt = nextOrt;
        this.distance = distance;
    }

}
