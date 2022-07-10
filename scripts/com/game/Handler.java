package com.game;

import com.basic.ResourcesLoader;

public class Handler
{

    private Slot[] waren;
    private final Ort ort;
    private Interesse interesse = Interesse.geringesInteresse;

    public Handler(Ort ort)
    {
        this.ort = ort;
        updateWaren();
    }

    private void interesseNeuBerechnen()
    {
        byte interesseProzent = (byte)(Math.random() * 101);

        if(interesseProzent < 25)
            interesse = Interesse.keinInteresse;
        else if(interesseProzent < 50)
            interesse = Interesse.geringesInteresse;
        else
            interesse = Interesse.grossesInteresse;
    }

    public void updateWaren()
    {
        interesseNeuBerechnen();

        byte warenCount = 0;

        if(ort instanceof Dorf)
        {
            warenCount = (byte)(ResourcesLoader.randomInt(2, WarenData.lebensmitteln.length-1));
            waren = new Slot[warenCount];

            for (byte i = 0; i < warenCount; i++)
                waren[i] = new Slot(WarenData.lebensmitteln[i], ResourcesLoader.randomInt(10, 60));
        }
        else
        {
            warenCount = (byte)(ResourcesLoader.randomInt(2, WarenData.waren.length-1));
            warenCount++;

            waren = new Slot[warenCount];
            waren[0] = new Slot(WarenData.lebensmitteln[7], ResourcesLoader.randomInt(20, 40));

            for (byte i = 1; i < warenCount; i++)
                waren[i] = new Slot(WarenData.waren[i-1], ResourcesLoader.randomInt(5, 30));
        }

    }

    public Interesse getInteresse()
    {
        return  interesse;
    }

    public int getVerkaufsPreis(int preis)
    {
        switch (interesse)
        {
            case keinInteresse: return 0;
            case geringesInteresse: return preis;
            case grossesInteresse: return 2 * preis;
        }
        return preis;
    }

    public Slot[] getWaren()
    {
        return  waren;
    }

    public enum Interesse
    {
        keinInteresse,
        geringesInteresse,
        grossesInteresse
    }
}
