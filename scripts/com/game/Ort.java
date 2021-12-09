package com.game;

import java.util.ArrayList;

public abstract class Ort
{
    public byte id;
    private String name;
    private Handler handler = new Handler();
    private byte interesseProzent = 0;

    private ArrayList<Weg> wegs = new ArrayList<>();

    public Ort(String name)
    {

        this.name = name;

        interesseNeuBerechnen();
    }


    public void addWeg(Ort nextOrt, int distance)
    {
        wegs.add(new Weg(nextOrt, distance));
    }

    public void handeln()
    {

    }

    public void interesseNeuBerechnen()
    {
        interesseProzent = (byte)(Math.random() * 10);
    }

    public ArrayList<Weg> getWege()
    {
        return wegs;
    }

}
