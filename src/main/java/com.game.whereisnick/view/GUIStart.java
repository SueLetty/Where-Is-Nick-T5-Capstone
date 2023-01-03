package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFrame;

public class GUIStart extends JFrame implements ActionListener {
  private Game game;
  private MainPanel mainPanel;

  public GUIStart() throws IOException, ParseException {
    game = new Game();

    this.setTitle("Where is Nick");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(1000,750);

    mainPanel = new MainPanel();
    mainPanel.splash.setText(game.showGameSplash());
    mainPanel.intro.setText("Where is Nick?");
    mainPanel.intro.setFont(new Font("MV Boli",Font.BOLD,36));
    mainPanel.startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
      mainPanel.intro.setText(game.introduction());
      mainPanel.intro.setVisible(true);
        mainPanel.intro.setFont(new Font("MV Boli",Font.BOLD,12));
      mainPanel.remove(mainPanel.startButton);
      mainPanel.add(mainPanel.beginButton, BorderLayout.SOUTH);
      }
    });

    mainPanel.beginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        dispose();
        GUIDetail guiDetail = new GUIDetail();

      }
    });

    this.add(mainPanel);
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public static void main(String[] args) throws IOException, ParseException {
    GUIStart gui = new GUIStart();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

}
