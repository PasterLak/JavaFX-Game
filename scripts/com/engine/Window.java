package com.engine;

import com.engine.ui.Sprite;

import javax.swing.JFrame;
import java.awt.*;

public class Window
{

    public static JFrame frame;
    public static int WIDTH = 1280, HEIGHT = 720;



    public static void main(String[] args)
    {
        frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().setBackground(new Color(202,148,39));
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(false);
        frame.setResizable(true);

        Sprite s = new Sprite(0,0,640,360);
        s.color = Color.CYAN;
        frame.add(s);

        Sprite s1 = new Sprite(640,360,640,360);
        s1.color = Color.RED;
        frame.add(s1);


        frame.setVisible(true);
    }

}