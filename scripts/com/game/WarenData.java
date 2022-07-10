package com.game;

public class WarenData
{
    public static final Ware[] waren = new Ware[]
            {
                    new Ware(0, "Axt", 2.2f, 20),
                    new Ware(1, "Topf", 1.2f, 12),
                    new Ware(2, "Löffeln", 0.5f, 5),
                    new Ware(3, "Schaufel", 2f, 17),
                    new Ware(4, "Hacke", 1.5f, 15),
                    new Ware(5, "Werkzeuge", 3f, 25),
                    new Ware(6, "Werkzeuge", 3f, 25)
            };

    public static final Lebensmittel[] lebensmitteln = new Lebensmittel[]
            {
                    new Lebensmittel(10, "Brot", 0.5f, 5),
                    new Lebensmittel(11, "Apfel", 1f, 2),
                    new Lebensmittel(12, "Kuchen", 1.5f, 10),
                    new Lebensmittel(13, "Mais", 1f, 2),
                    new Lebensmittel(14, "Tomaten", 1f, 4),
                    new Lebensmittel(15, "Rüben", 1f, 3),
                    new Lebensmittel(16, "Kartoffel", 1f, 2),
                    new Lebensmittel(17, "Speck", 1f, 5)
            };



//    Map<Integer, Lebensmittel> lebensmitteln = new HashMap<Integer, Lebensmittel>()
//    {
//        {
//            put(10, new Lebensmittel(1, "Brot", 0.5f, 5));
//
//        }
//    };
}
