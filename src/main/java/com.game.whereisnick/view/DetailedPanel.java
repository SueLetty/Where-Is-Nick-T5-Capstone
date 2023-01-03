package com.game.whereisnick.view;

import com.game.whereisnick.model.ControllerPanel;
import com.game.whereisnick.model.ImagePanel;
import com.game.whereisnick.model.IntroPanel;
import com.game.whereisnick.model.OptionalPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class DetailedPanel extends JPanel {

  private IntroPanel introPanel;
  private OptionalPanel optionPanel;
  private ImagePanel imagePanel;
  private ControllerPanel controllerPanel;

  public DetailedPanel() {

    this.setPreferredSize(new Dimension(1000, 800));
    this.setLayout(new FlowLayout());

    introPanel = new IntroPanel();
    introPanel.setPreferredSize(new Dimension(600,500));
    introPanel.setOpaque(true);
    introPanel.setBackground(Color.lightGray);


    imagePanel = new ImagePanel();
    imagePanel.setPreferredSize(new Dimension(400,400));
    imagePanel.setOpaque(true);
    imagePanel.setBackground(Color.BLUE);


    optionPanel = new OptionalPanel();
    optionPanel.setPreferredSize(new Dimension(600,300));
    optionPanel.setOpaque(true);
    optionPanel.setBackground(Color.yellow);


    controllerPanel = new ControllerPanel();
    controllerPanel.setPreferredSize(new Dimension(400,400));
    controllerPanel.setOpaque(true);
    controllerPanel.setBackground(Color.CYAN);


    this.add(introPanel);
    this.add(imagePanel);
    this.add(optionPanel);
    this.add(controllerPanel);

  }
  public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D) g;

  }

  public IntroPanel getIntroPanel() {
    return introPanel;
  }

  public void setIntroPanel(IntroPanel introPanel) {
    this.introPanel = introPanel;
  }

  public OptionalPanel getOptionPanel() {
    return optionPanel;
  }

  public void setOptionPanel(OptionalPanel optionPanel) {
    this.optionPanel = optionPanel;
  }

  public ImagePanel getImagePanel() {
    return imagePanel;
  }

  public void setImagePanel(ImagePanel imagePanel) {
    this.imagePanel = imagePanel;
  }

  public ControllerPanel getControllerPanel() {
    return controllerPanel;
  }

  public void setControllerPanel(ControllerPanel controllerPanel) {
    this.controllerPanel = controllerPanel;
  }
}
