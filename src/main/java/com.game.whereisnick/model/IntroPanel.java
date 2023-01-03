package com.game.whereisnick.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroPanel extends JPanel {
  JLabel info;

  public IntroPanel(){
    info = new JLabel();
    info.setFont(new Font("MV Bole", Font.PLAIN,14));
    info.setBackground(Color.BLUE);
    info.setOpaque(true);
    info.setPreferredSize(new Dimension(500,400));

    this.setBackground(Color.lightGray);
    this.add(info);

  }
  public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
  }

  public JLabel getInfo() {
    return info;
  }

  public void setInfo(JLabel info) {
    this.info = info;
  }
}
