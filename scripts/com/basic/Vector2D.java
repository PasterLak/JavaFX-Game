package com.basic;

public class Vector2D
{
    public int x;
    public int y;

    public Vector2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public static Vector2D zero()
    {
        return new Vector2D(0,0);
    }

    public Vector2D add(Vector2D b)
    {
        return new Vector2D(x + b.x, y + b.y);
    }
    public Vector2D sub(Vector2D b)
    {
        return new Vector2D(x - b.x, y - b.y);
    }
    public Vector2D milt(int scalar)
    {
        return new Vector2D(x * scalar, y * scalar);
    }
}
