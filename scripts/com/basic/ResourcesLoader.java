package com.basic;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public final class ResourcesLoader
{
    public static String fontPath = "fonts/new.ttf";

    public static Image getImage(String path)
    {
        return new Image("file:" + path);
    }

    public static Image getImage(String path, int x, int y)
    {
        return new Image("file:" + path, x, y, false, false);
    }

    public static AudioClip getAudioClip(String path)
    {
        return new AudioClip("file:"+ path);
    }

    public static Media getMedia(String path)
    {
        return new Media(new File(path).toURI().toString());
    }

    public static Font getFont(String path, double size)
    {
        return Font.loadFont("file:" + path, size);
    }

    public static void setFont(Text text)
    {
        if(fontPath == "") return;
        text.setFont(getFont(fontPath, text.getFont().getSize()));
    }
    public static void setFont(Button button)
    {
        if(fontPath == "") return;
        button.setFont(getFont(fontPath, button.getFont().getSize()));
    }
    public static void setFontSize(Button button, int size)
    {
        if(fontPath == "") return;
        button.setFont(getFont(fontPath, size));
    }

    public static int randomInt(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min; // [min - max]
    }

}
