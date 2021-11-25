package com.game;

public abstract class Location
{
    private String name;
    private Handler handler = new Handler();

    public Location(String name)
    {
    this.name = name;
    }
}
