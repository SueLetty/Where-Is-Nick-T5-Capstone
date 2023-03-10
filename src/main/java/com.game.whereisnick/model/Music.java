package com.game.whereisnick.model;


import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;

public class Music extends Thread{

  private Clip musicClip;
  private boolean soundOn = true;

  private float volumeGain = 0f;

  public void run(){
    playMusic("audio/BunsenBurner.wav");
  }


  public void playMusic(String musicLocation) {

    try {
      File musicPath = new File(musicLocation);
      URL url = Music.class.getClassLoader().getResource(musicLocation);
      assert url != null;
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
      musicClip = AudioSystem.getClip();
      musicClip.open(audioInput);
      musicClip.start();
      musicClip.loop(Clip.LOOP_CONTINUOUSLY);
      Thread.sleep(1);


    } catch (Exception ex) {
      ex.printStackTrace();

    }
  }

  public void stopMusic(){
    musicClip.stop();
    //musicClip.close();
    soundOn = false;
  }

  public void increaseVolume(){
    FloatControl gain = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
    volumeGain = volumeGain + 5;
    gain.setValue(volumeGain);
  }

  public void decreaseVolume(){
    FloatControl gain = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
    volumeGain = volumeGain - 5;
    gain.setValue(volumeGain);
  }


  public boolean isSoundOn(){
    return soundOn;
  }

  public void turnSoundOn(){
    musicClip.start();
    musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    soundOn = true;
  }


}
