package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import com.game.whereisnick.model.ImageImport;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GUIStart extends JFrame implements ActionListener {
  private Game game;
  private MainPanel mainPanel;

  public GUIStart() throws IOException, ParseException {
    game = new Game();

    this.setTitle("Where is Nick");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(1000,600);
    mainPanel = new MainPanel();
//    mainPanel = new MainPanel(){
//      @Override
//      public void paintComponent(Graphics g){
//        Image backgroundImage = ImageImport.importImage("images/intro.png");
//        g.drawImage(backgroundImage,0,0,1000,600,null);
////        g.drawString("Where is Nick",450,300);
//      }
//    };
    mainPanel.intro.setText("Where is Nick?");
    mainPanel.intro.setFont(new Font("MV Boli",Font.BOLD,36));
    mainPanel.setLayout(null);



    mainPanel.startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
      mainPanel.intro.setText(game.introduction());
      mainPanel.intro.setAlignmentX(JLabel.CENTER);
      mainPanel.intro.setVisible(true);
      mainPanel.intro.setBounds(100, 50, 825, 300);
      mainPanel.intro.setFont(new Font("MV Boli",Font.BOLD,16));
      mainPanel.intro.setOpaque(false);
      StyledDocument doc = mainPanel.intro.getStyledDocument();
      SimpleAttributeSet center = new SimpleAttributeSet();
      StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
      doc.setParagraphAttributes(0, doc.getLength(), center, false);
      mainPanel.remove(mainPanel.startButton);
      mainPanel.add(mainPanel.beginButton);
      }
    });

    mainPanel.beginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        dispose();
        try {
          GUIDetail guiDetail = new GUIDetail(game);
        } catch (IOException e) {
          throw new RuntimeException(e);
        } catch (ParseException e) {
          throw new RuntimeException(e);
        }

      }
    });
    this.add(mainPanel);
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }



  @Override
  public void actionPerformed(ActionEvent e) {

  }


}
