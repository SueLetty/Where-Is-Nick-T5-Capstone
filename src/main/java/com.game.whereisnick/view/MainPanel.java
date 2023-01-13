package com.game.whereisnick.view;

import com.game.whereisnick.model.ImageImport;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class MainPanel extends JPanel {

  JButton startButton;
  JButton beginButton;
  JButton quitButton;
  JTextPane intro;

  private Image backgroundImage;

  public MainPanel() {
    this.setPreferredSize(new Dimension(1000, 600));
    this.setLayout(null);

    intro = new JTextPane();
    intro.setEnabled(false);
    intro.setBounds(0, 0, 1000, 600);
    intro.setOpaque(false);
    StyledDocument doc = intro.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);

    backgroundImage = ImageImport.importImage("images/intro.png");

    startButton = new JButton("Start Game");
    startButton.setBounds(450, 530, 100, 30);
    startButton.setFocusable(false);

    beginButton = new JButton("Begin");
    beginButton.setBounds(450, 530, 100, 30);
    startButton.setFocusable(false);

    this.add(startButton);
    this.add(intro);


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

  public void paintComponent(Graphics g) {

  }


}
