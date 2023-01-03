package com.game.whereisnick.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControllerPanel extends JPanel {
  private JButton mapButton;
  private JButton helpButton;
  private JButton quitButton;
  private JButton musicButton;
  private JButton northButton;
  private JButton southButton;
  private JButton eastButton;
  private JButton westButton;
  public ControllerPanel(){

    this.setBackground(Color.lightGray);
    this.setLayout(null);

    mapButton = new JButton("Map");
    mapButton.setBounds(10,10,100,30);
    mapButton.setFocusable(false);

    helpButton = new JButton("Help");
    helpButton.setBounds(280,10,100,30);
    helpButton.setFocusable(false);

    quitButton = new JButton("Quit");
    quitButton.setBounds(10,350,100,30);
    quitButton.setFocusable(false);

    musicButton = new JButton("Music");
    musicButton.setBounds(280,350,100,30);
    musicButton.setFocusable(false);

    northButton = new JButton("N");
    northButton.setBounds(175,125,50,50);
    northButton.setFocusable(false);

    southButton = new JButton("S");
    southButton.setBounds(175,225,50,50);
    southButton.setFocusable(false);

    eastButton = new JButton("E");
    eastButton.setBounds(125,175,50,50);
    eastButton.setFocusable(false);

    westButton = new JButton("W");
    westButton.setBounds(225,175,50,50);
    westButton.setFocusable(false);

    this.add(helpButton);
    this.add(mapButton);
    this.add(quitButton);
    this.add(musicButton);
    this.add(northButton);
    this.add(southButton);
    this.add(eastButton);
    this.add(westButton);


  }
  public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
  }

  public JButton getMapButton() {
    return mapButton;
  }

  public void setMapButton(JButton mapButton) {
    this.mapButton = mapButton;
  }

  public JButton getHelpButton() {
    return helpButton;
  }

  public void setHelpButton(JButton helpButton) {
    this.helpButton = helpButton;
  }

  public JButton getQuitButton() {
    return quitButton;
  }

  public void setQuitButton(JButton quitButton) {
    this.quitButton = quitButton;
  }

  public JButton getMusicButton() {
    return musicButton;
  }

  public void setMusicButton(JButton musicButton) {
    this.musicButton = musicButton;
  }

  public JButton getNorthButton() {
    return northButton;
  }

  public void setNorthButton(JButton northButton) {
    this.northButton = northButton;
  }

  public JButton getSouthButton() {
    return southButton;
  }

  public void setSouthButton(JButton southButton) {
    this.southButton = southButton;
  }

  public JButton getEastButton() {
    return eastButton;
  }

  public void setEastButton(JButton eastButton) {
    this.eastButton = eastButton;
  }

  public JButton getWestButton() {
    return westButton;
  }

  public void setWestButton(JButton westButton) {
    this.westButton = westButton;
  }
}
