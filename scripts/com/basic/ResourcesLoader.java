package com.basic;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.text.Font;

import java.io.File;

public final class ResourcesLoader
{
    public static Image getImage(String path)
    {
        return new Image("file:" + path);
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
}
