package com.game.whereisnick.view;

import com.game.whereisnick.model.ImageImport;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GraduationPanel extends JFrame {
  private JPanel panel;
  private JLabel jeanetteImage;
  private JLabel donteImage;
  private JLabel nellyImage;
  private JLabel nickImage;
  private JLabel scottImage;
  private JLabel tomImage;
  private JLabel chadImage ;
  private JLabel shangImage;
  private JLabel richardImage;
  private JTextArea textArea;
  private ImageIcon chad;
  private ImageIcon donte;
  private ImageIcon richard;
  private ImageIcon jeanette;
  private ImageIcon nelly;
  private ImageIcon nick;
  private ImageIcon scott;
  private ImageIcon shang;
  private ImageIcon tom;

  public GraduationPanel(){
    this.setPreferredSize(new Dimension(1000,600));
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(1000,600);

    chad = ImageImport.importIcon("images/Chad_Gale.jpg", 140, 160);
    donte = ImageImport.importIcon("images/Donte_Tyrus.png",140, 160);
    jeanette = ImageImport.importIcon("images/jeanette.jpg",140, 160);
    nelly = ImageImport.importIcon("images/Nelly_Gus.jpg",140, 160);
    nick = ImageImport.importIcon("images/Nick_Walter.jpg",140, 160);
    richard = ImageImport.importIcon("images/Hank_Richard.png", 140, 160);
    scott = ImageImport.importIcon("images/Scott_Mike.jpg",140, 160);
    shang = ImageImport.importIcon("images/Shang_Hector.jpg",140, 160);
    tom = ImageImport.importIcon("images/Tom_Saul.jpg",140, 160);



    panel = new JPanel();
    panel.setBounds(0,0,1000,600);

    textArea = new JTextArea(4,25);
    textArea.setText("Congratulations! \nYou have successfully graduated from TLG!");
    textArea.setFont(new Font("MV Boli", Font.BOLD,35));
    textArea.setBounds(330,150,300,120);
    textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
    textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
    textArea.setEditable(false);

    jeanetteImage = new JLabel();
    jeanetteImage.setIcon(jeanette);

    donteImage = new JLabel();
    donteImage.setIcon(donte);

    nellyImage = new JLabel();
    nellyImage.setIcon(nelly);

    nickImage = new JLabel();
    nickImage.setIcon(nick);

    scottImage = new JLabel();
    scottImage.setIcon(scott);

    tomImage = new JLabel();
    tomImage.setIcon(tom);

    chadImage = new JLabel();
    chadImage.setIcon(chad);

    shangImage = new JLabel();
    shangImage.setIcon(shang);

    richardImage = new JLabel();
    richardImage.setIcon(richard);

    panel.setLayout(new FlowLayout());

    panel.add(jeanetteImage);
    panel.add(donteImage);
    panel.add(nellyImage);
    panel.add(nickImage);
    panel.add(scottImage);
    panel.add(tomImage);
    panel.add(chadImage);
    panel.add(shangImage);
    panel.add(richardImage);
    panel.add(textArea);
    this.setLayout(null);
    this.add(panel);
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);

  }


}
