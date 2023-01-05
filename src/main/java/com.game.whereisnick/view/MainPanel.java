package com.game.whereisnick.view;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel{
  JButton startButton;
  JButton beginButton;
  JButton quitButton;
  JTextArea intro;
  public MainPanel(){
    this.setPreferredSize(new Dimension(1000,600));
    this.setLayout(null);

    intro = new JTextArea(15,70);
    intro.setLineWrap(true);
    intro.setEnabled(false);
    intro.setBounds(100, 100, 825, 215);
    intro.setBorder(null);

    /* intro.setAlignmentX(0.5f);
    intro.setMargin(new Insets(0, 0, 0, 0));
    intro.setAlignmentY(CENTER_ALIGNMENT); */



    startButton = new JButton("Start Game");
    startButton.setBounds(450,530,100,30);
    startButton.setFocusable(false);

    beginButton = new JButton("Begin");
    beginButton.setBounds(450,530,100,30);
    startButton.setFocusable(false);

    this.add(intro);
    this.add(startButton);


  }

  public JButton getStartButton() {
    return startButton;
  }

  public void setStartButton(JButton startButton) {
    this.startButton = startButton;
  }

  public JButton getBeginButton() {
    return beginButton;
  }

  public void setBeginButton(JButton beginButton) {
    this.beginButton = beginButton;
  }

  public JButton getQuitButton() {
    return quitButton;
  }

  public void setQuitButton(JButton quitButton) {
    this.quitButton = quitButton;
  }

  public JTextArea getIntro() {
    return intro;
  }

  public void setIntro(JTextArea intro) {
    this.intro = intro;
  }

  public void setPreferredSize(int width, int height) {
  }
}
