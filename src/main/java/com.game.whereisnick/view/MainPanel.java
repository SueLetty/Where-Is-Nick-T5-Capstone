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
  public MainPanel(){
    this.setPreferredSize(new Dimension(1000,600));
    this.setLayout(null);

    intro = new JLabel();
    intro.setBounds(10,10,980,500);
    intro.setOpaque(true);
    intro.setHorizontalAlignment(JLabel.CENTER);
    intro.setBackground(Color.lightGray);


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

  public JLabel getIntro() {
    return intro;
  }

  public void setIntro(JLabel intro) {
    this.intro = intro;
  }
}
