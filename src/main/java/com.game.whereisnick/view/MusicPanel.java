package com.game.whereisnick.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MusicPanel extends JFrame implements Runnable {

  private JPanel panel;
  private JButton muteMusicButton;
  private JButton increaseVolumeButton;
  private JButton decreaseVolumeButton;
  private JButton muteAudioButton;

  public MusicPanel() {
    this.setPreferredSize(new Dimension(230, 130));
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent e) {
        GUIDetail.setMusicPanelCount(0);
      }
    });

    muteMusicButton = new JButton("Mute Music");
    muteMusicButton.setBounds(10, 10, 100, 30);

    increaseVolumeButton = new JButton("+");
    increaseVolumeButton.setBounds(110, 10, 100, 30);

    decreaseVolumeButton = new JButton("-");
    decreaseVolumeButton.setBounds(110, 50, 100, 30);

    muteAudioButton = new JButton("Mute SFX");
    muteAudioButton.setBounds(10, 50, 100, 30);

    this.add(muteMusicButton);
    this.add(muteAudioButton);
    this.add(increaseVolumeButton);
    this.add(decreaseVolumeButton);
    this.setTitle("Music");
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public JButton getMuteMusicButton() {
    return muteMusicButton;
  }

  public JButton getIncreaseVolumeButton() {
    return increaseVolumeButton;
  }

  public JButton getDecreaseVolumeButton() {
    return decreaseVolumeButton;
  }

  public JButton getMuteAudioButton() {
    return muteAudioButton;
  }

  @Override
  public void run() {

  }
}
