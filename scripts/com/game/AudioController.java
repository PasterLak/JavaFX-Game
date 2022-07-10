package com.game;

import com.basic.ResourcesLoader;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public final class AudioController
{
    private static AudioController INSTANCE;

    public static final MediaPlayer backgroundMusic = new MediaPlayer(ResourcesLoader.getMedia("audio/game/game.mp3"));
    private boolean isPlaying;
    public static AudioClip click = ResourcesLoader.getAudioClip("audio/UI/click.wav");
    private static AudioClip money = ResourcesLoader.getAudioClip("audio/UI/money.wav");
    public static AudioClip click2 = ResourcesLoader.getAudioClip("audio/UI/pause.wav");
    public static AudioClip among = ResourcesLoader.getAudioClip("audio/UI/among.wav");
    private static AudioClip minecraft = ResourcesLoader.getAudioClip("audio/UI/minecraft.wav");
    public static AudioClip directed = ResourcesLoader.getAudioClip("audio/UI/directed.wav");
    private static AudioClip buy = ResourcesLoader.getAudioClip("audio/UI/buy.wav");
    public static AudioClip win = ResourcesLoader.getAudioClip("audio/UI/win.wav");
    public static AudioClip chest = ResourcesLoader.getAudioClip("audio/UI/chest.wav");
    public static AudioClip villager = ResourcesLoader.getAudioClip("audio/UI/villager.wav");
    public static AudioClip biene = ResourcesLoader.getAudioClip("audio/UI/biene.wav");
    private static AudioClip jump = ResourcesLoader.getAudioClip("audio/UI/jump.wav");

    public AudioController()
    {
        if(INSTANCE == null) {
            INSTANCE = this;
        }
        backgroundMusic.setAutoPlay(true);
        isPlaying = false;
        backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMusic.pause();
        UIController.INSTANCE.setMusicButton(false);
        backgroundMusic.setVolume(0.5f);
        jump.setVolume(0.4f);
        directed.setVolume(0.5f);

    }

    public static AudioController getInstance()
    {
        return INSTANCE;
    }

    public void playClick()
    {
        click.play();
    }
    public void playPause()
    {
        click2.play();
    }
    public void playMoney()
    {
        money.setRate(ResourcesLoader.randomInt(7,10) * 0.1f);
        money.play();
    }

    public void biene()
    {
        biene.play();
    }
    public void playEat()
    {
        minecraft.setRate(ResourcesLoader.randomInt(8,10) * 0.1f);
        minecraft.play();
    }
    public void playBuy()
    {
        buy.setRate(ResourcesLoader.randomInt(8,10) * 0.1f);
        buy.play();
    }
    public void playJump()
    {
        jump.setRate(ResourcesLoader.randomInt(9,10) * 0.1f);
        jump.play();
    }

    public void musicButton()
    {
        AudioController.getInstance().playPause();
        if(isPlaying)
        {
            backgroundMusic.pause();
            UIController.INSTANCE.setMusicButton(false);
            isPlaying = false;
        }
        else
        {
            backgroundMusic.play();
            UIController.INSTANCE.setMusicButton(true);
            isPlaying = true;
        }
    }
}
