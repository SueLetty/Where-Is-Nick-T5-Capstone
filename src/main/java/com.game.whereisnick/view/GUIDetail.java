package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import com.game.whereisnick.model.ControllerPanel;
import com.game.whereisnick.model.ImagePanel;
import com.game.whereisnick.model.IntroPanel;
import com.game.whereisnick.model.OptionalPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIDetail extends JFrame {
  private Game game;

  private JPanel introPanel;

  private JPanel optionPanel;
  private JLabel imageLabel;
  private JPanel controllerPanel;
  private JLabel introInfo;
  private ImageIcon image;
  private JLabel optionInfo;

  private JButton mapButton;
  private JButton helpButton;
  private JButton quitButton;
  private JButton musicButton;
  private JButton northButton;
  private JButton southButton;
  private JButton eastButton;
  private JButton westButton;

  public GUIDetail(Game game) throws IOException, ParseException {
    this.game = game;

    introPanel = new JPanel();
    introPanel.setBackground(Color.red);
    introPanel.setBounds(10,10,680,300);

    introInfo = new JLabel(game.greetingFromJeanette());
    introInfo.setFont(new Font("MV Bole", Font.PLAIN,14));
    introInfo.setOpaque(true);
    introInfo.setBounds(10,10,660,4280);
    introInfo.setVisible(true);
    introPanel.add(introInfo);


    image = new ImageIcon("resources/love.png");
    imageLabel = new JLabel();
    imageLabel.setIcon(image);
    imageLabel.setBackground(Color.BLUE);
    imageLabel.setBounds(700,-10,280,280);
    imageLabel.setVisible(true);

    optionPanel = new JPanel();
    optionPanel.setBackground(Color.green);
    optionPanel.setBounds(10,320,680,300);


    optionInfo = new JLabel("Using Direction button go to a different room.");
    optionInfo.setVerticalAlignment(JLabel.CENTER);
    optionInfo.setFont(new Font("MV Bole", Font.PLAIN,14));
    optionInfo.setOpaque(true);
    optionInfo.setBounds(10,10,660,4280);
    optionInfo.setVisible(true);
    optionPanel.add(optionInfo);

    controllerPanel = new JPanel();
    controllerPanel.setBackground(Color.yellow);
    controllerPanel.setBounds(700,270,300,300);

    mapButton = new JButton("Map");
    mapButton.setBounds(10,10,100,30);
    mapButton.setFocusable(false);

    helpButton = new JButton("Help");
    helpButton.setBounds(180,10,100,30);
    helpButton.setFocusable(false);

    quitButton = new JButton("Quit");
    quitButton.setBounds(10,250,100,30);
    quitButton.setFocusable(false);

    musicButton = new JButton("Music");
    musicButton.setBounds(180,250,100,30);
    musicButton.setFocusable(false);

    northButton = new JButton("N");
    northButton.setBounds(125,75,50,50);
    northButton.setFocusable(false);

    southButton = new JButton("S");
    southButton.setBounds(125,175,50,50);
    southButton.setFocusable(false);

    eastButton = new JButton("E");
    eastButton.setBounds(75,125,50,50);
    eastButton.setFocusable(false);

    westButton = new JButton("W");
    westButton.setBounds(175,125,50,50);
    westButton.setFocusable(false);
    controllerPanel.setLayout(null);

    controllerPanel.add(helpButton);
    controllerPanel.add(mapButton);
    controllerPanel.add(quitButton);
    controllerPanel.add(musicButton);
    controllerPanel.add(northButton);
    controllerPanel.add(southButton);
    controllerPanel.add(eastButton);
    controllerPanel.add(westButton);

    this.setTitle("Where is Nick");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setResizable(false);
    this.setSize(1000,600);



    this.setVisible(true);
    this.add(introPanel);
    this.add(imageLabel);
    this.add(optionPanel);
    this.add(controllerPanel);

    this.setLocationRelativeTo(null);

  }

  public static void main(String[] args) throws IOException, ParseException {
    new GUIDetail(new Game());
  }
}
