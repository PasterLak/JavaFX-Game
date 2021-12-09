package com.game;

import java.util.HashMap;
import java.util.Map;

public class WarenData
{
    Map<Integer, Ware> waren = new HashMap<Integer, Ware>()
    {
        {
            put(0, new Ware(0, "Axt", 1f, 20));
            put(1, new Ware(1, "Topf", 0.6f, 12));
            put(2, new Ware(2, "Löffel", 0.1f, 2));
        }
    };

    Map<Integer, Lebensmittel> lebensmitteln = new HashMap<Integer, Lebensmittel>()
    {
        {
            put(10, new Lebensmittel(1, "Brot", 0.5f, 5));
            put(11, new Lebensmittel(1, "Apfel", 0.1f, 1));
            put(12, new Lebensmittel(2, "Kuchen", 1f, 10));
        }
    };
}
