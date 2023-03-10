package com.game.whereisnick.controller;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * @author www.codejava.net
 *
 */
public class Audio implements LineListener, Runnable {

  /**
   * this flag indicates whether the playback completes or not.
   */
  boolean playCompleted;
  private boolean mutedAudio = false;

  /**
   * Play a given audio file.
   * @param audioFilePath Path of the audio file.
   */
  public void play(String audioFilePath) {
    File audioFile = new File(audioFilePath);

    try {
      URL url = Audio.class.getClassLoader().getResource(audioFilePath);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);

      AudioFormat format = audioStream.getFormat();

      DataLine.Info info = new DataLine.Info(Clip.class, format);

      Clip audioClip = (Clip) AudioSystem.getLine(info);

      audioClip.addLineListener(this);

      audioClip.open(audioStream);

      audioClip.start();

    } catch (UnsupportedAudioFileException ex) {
      System.out.println("The specified audio file is not supported.");
      ex.printStackTrace();
    } catch (LineUnavailableException ex) {
      System.out.println("Audio line for playing back is unavailable.");
      ex.printStackTrace();
    } catch (IOException ex) {
      System.out.println("Error playing the audio file.");
      ex.printStackTrace();
    }

  }

  public boolean isMutedAudio() {
    return mutedAudio;
  }

  public void setMutedAudio(boolean mutedAudio) {
    this.mutedAudio = mutedAudio;
  }

  /**
   * Listens to the START and STOP events of the audio line.
   */
  @Override
  public void update(LineEvent event) {
    LineEvent.Type type = event.getType();

    if (type == LineEvent.Type.START) {

    } else if (type == LineEvent.Type.STOP) {
      playCompleted = true;
    }

  }

   /* String audioFilePath = "./resources/audio/correct.wav";
    Audio player = new Audio();
    player.play(audioFilePath);*/

  @Override
  public void run() {

  }
}