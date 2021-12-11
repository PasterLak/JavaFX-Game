package com.game;

import com.basic.ResourcesLoader;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public final class AudioController
{
    public static AudioController INSTANCE;

    private MediaPlayer backgroundMusic = new MediaPlayer(ResourcesLoader.getMedia("audio/game/soundtrack.mp3"));

    private AudioClip click = ResourcesLoader.getAudioClip("audio/UI/click.wav");


    public AudioController()
    {
        if(INSTANCE == null) INSTANCE = this;

        backgroundMusic.setAutoPlay(true);
        backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void play()
    {
        click.play();
    }

}
