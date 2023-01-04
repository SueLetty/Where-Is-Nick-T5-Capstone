package com.game.whereisnick.model;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroPanel extends JPanel {
  JPanel introPanel;
  public IntroPanel(){
    introPanel = new JPanel();
    introPanel.setBackground(Color.red);
    introPanel.setBounds(10,10,680,300);
    introPanel.setVisible(true);

  }
  public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
  }

//  public JLabel getInfo() {
//    return info;
//  }
//
//  public void setInfo(JLabel info) {
//    this.info = info;
//  }

}
