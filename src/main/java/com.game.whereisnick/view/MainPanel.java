package com.game.whereisnick.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
  JButton startButton;
  JButton beginButton;
  JButton quitButton;
  JLabel intro;
  JLabel splash;
  public MainPanel(){
    this.setPreferredSize(new Dimension(900,750));
    this.setLayout(new BorderLayout());

    splash = new JLabel();
    intro = new JLabel();
    intro.setBounds(400,500,700,450);
    intro.setOpaque(true);
    intro.setBackground(Color.lightGray);


    startButton = new JButton("Start Game");
    startButton.setBounds(400,600,100,30);
    startButton.setFocusable(false);

    beginButton = new JButton("Begin");
    beginButton.setBounds(400,600,100,30);
    startButton.setFocusable(false);

    quitButton = new JButton("Quit");
    quitButton.setBounds(400,650,100,30);
    startButton.setFocusable(false);

    this.add(intro,BorderLayout.CENTER);
//    this.add(splash,BorderLayout.CENTER);
    this.add(startButton,BorderLayout.SOUTH);


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

  public JLabel getIntro() {
    return intro;
  }

  public void setIntro(JLabel intro) {
    this.intro = intro;
  }
}
