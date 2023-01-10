package com.game.whereisnick.view;

import com.game.whereisnick.model.ImageImport;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainPanel extends JPanel{
  JButton startButton;
  JButton beginButton;
  JButton quitButton;
  JTextPane intro;

  public MainPanel(){
    this.setPreferredSize(new Dimension(1000,600));
    this.setLayout(null);

    intro = new JTextPane();
    intro.setEnabled(false);
    intro.setBounds(100, 100, 825, 300);
    intro.setOpaque(false);
    StyledDocument doc = intro.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);

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

  public JTextPane getIntro() {
    return intro;
  }

  public void setIntro(JTextPane intro) {
    this.intro = intro;
  }

  public void setPreferredSize(int width, int height) {
  }

  public void paintComponent(Graphics g){

  }
}
