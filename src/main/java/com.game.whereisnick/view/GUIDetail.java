package com.game.whereisnick.view;

import javax.swing.JFrame;

public class GUIDetail extends JFrame {
  DetailedPanel detailedPanel;
  public GUIDetail(){
    detailedPanel = new DetailedPanel();
    this.setTitle("Where is Nick");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(1100,900);


    this.add(detailedPanel);
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new GUIDetail();
  }
}
