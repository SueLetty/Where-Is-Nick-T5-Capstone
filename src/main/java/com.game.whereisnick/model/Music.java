package com.game.whereisnick.model;


import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music extends Thread{

  public void run(){
    playMusic("audio/BunsenBurner.wav");
  }


  public void playMusic(String musicLocation) {

    try {
      File musicPath = new File(musicLocation);
      URL url = Music.class.getClassLoader().getResource(musicLocation);
      assert url != null;
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();
      clip.loop(Clip.LOOP_CONTINUOUSLY);



    } catch (Exception ex) {
      ex.printStackTrace();

    }
  }



}
