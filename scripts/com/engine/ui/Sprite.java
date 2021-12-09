package com.engine.ui;

import com.basic.Vector2D;
import com.engine.Window;

import javax.swing.JLabel;
import java.awt.*;

public class Sprite extends JLabel
{
    public Color color = Color.black;

    private final int speed = 2;
    private Vector2D size;
    private Vector2D position = Vector2D.zero();


    public Sprite(int x, int y, int sizeX, int sizeY)
    {
        this.size = new Vector2D(sizeX, sizeY);
        super.setSize( Window.frame.getWidth() / 2, Window.frame.getHeight() / 2);
        super.setVisible(true);
        super.setLocation(0, 0);
        position.x = x;
        position.y = y;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(color);

        float x = size.x / (1280 / 100f) / 100f; // 640 / 12.8 / 100
        float y = size.y / (720 / 100f) / 100f; // 12.8
        float x2 = position.x / (1280 / 100f) / 100f; // 640 / 12.8 / 100
        float y2 = position.y / (720 / 100f) / 100f; // 12.8
        //System.out.println(x);
        g.fillRect((int)(x2 * Window.frame.getWidth()), (int)(y2 * Window.frame.getHeight()), (int)(x * Window.frame.getWidth()),
                (int)( y * Window.frame.getHeight()));


        try
        {
            Thread.sleep(10);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.exit(0);
        }

        repaint();
    }
}