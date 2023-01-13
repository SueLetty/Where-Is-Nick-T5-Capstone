package com.game.whereisnick.view;

import com.game.whereisnick.model.ImageImport;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class GraduationPanel extends JFrame {

  private JPanel panel;
  private JLabel jeanetteImage;
  private JLabel donteImage;
  private JLabel nellyImage;
  private JLabel nickImage;
  private JLabel scottImage;
  private JLabel tomImage;
  private JLabel chadImage;
  private JLabel sangImage;
  private JLabel richardImage;

  private JTextPane textPane;
  private ImageIcon chad;
  private ImageIcon donte;
  private ImageIcon richard;
  private ImageIcon jeanette;
  private ImageIcon nelly;
  private ImageIcon nick;
  private ImageIcon scott;
  private ImageIcon shang;
  private ImageIcon tom;

  private JPanel contentPane;

  public GraduationPanel() {
    this.setPreferredSize(new Dimension(1000, 600));
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(1000, 600);
    chad = ImageImport.importIcon("images/Chad_Gale.jpg", 140, 160);
    donte = ImageImport.importIcon("images/Donte_Tyrus.png", 140, 160);
    jeanette = ImageImport.importIcon("images/jeanette.jpg", 140, 160);
    nelly = ImageImport.importIcon("images/Nelly_Gus.jpg", 140, 160);
    nick = ImageImport.importIcon("images/Nick_Walter.jpg", 140, 160);
    richard = ImageImport.importIcon("images/Hank_Richard.png", 140, 160);
    scott = ImageImport.importIcon("images/Scott_Mike.jpg", 140, 160);
    shang = ImageImport.importIcon("images/Sang_Hector.jpg", 140, 160);
    tom = ImageImport.importIcon("images/Tom_Saul.jpg", 140, 160);
    panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        Image backgroundImage = ImageImport.importImage("images/Graduation_background.jpg");
        g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
      }
    };
    panel.setBounds(0, 0, 1000, 600);
    textPane = new JTextPane();
    textPane.setText("Congratulations! \nYou have successfully graduated from TLG!");
    textPane.setFont(new Font("MV Boli", Font.BOLD, 40));
    textPane.setBounds(330, 150, 300, 120);
    textPane.setOpaque(false);
    StyledDocument doc = textPane.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    textPane.setEditable(false);
    jeanetteImage = new JLabel("Jeanette");
    jeanetteImage.setIcon(jeanette);
    positionImage(jeanetteImage);

    donteImage = new JLabel("Donte");
    donteImage.setIcon(donte);
    positionImage(donteImage);

    nellyImage = new JLabel("Nelly");
    nellyImage.setIcon(nelly);
    positionImage(nellyImage);

    nickImage = new JLabel("Nick");
    nickImage.setIcon(nick);
    positionImage(nickImage);

    scottImage = new JLabel("Scott");
    scottImage.setIcon(scott);
    positionImage(scottImage);

    tomImage = new JLabel("Tom");
    tomImage.setIcon(tom);
    positionImage(tomImage);

    chadImage = new JLabel("Chad");
    chadImage.setIcon(chad);
    chadImage.setIconTextGap(5);
    positionImage(chadImage);

    sangImage = new JLabel("Sang");
    sangImage.setIcon(shang);
    positionImage(sangImage);

    richardImage = new JLabel("Richard");
    richardImage.setIcon(richard);
    richardImage.setIconTextGap(5);
    positionImage(richardImage);

    panel.setLayout(new FlowLayout());
    panel.add(jeanetteImage);
    panel.add(donteImage);
    panel.add(nellyImage);
    panel.add(nickImage);
    panel.add(scottImage);
    panel.add(tomImage);
    panel.add(chadImage);
    panel.add(sangImage);
    panel.add(richardImage);
    panel.add(textPane);
    this.setLayout(null);
    this.add(panel);
    this.setResizable(false);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  private void positionImage(JLabel label){
    label.setIconTextGap(5);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setVerticalTextPosition(JLabel.BOTTOM);
    label.setVerticalAlignment(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);
  }

  public static void main(String[] args) {
    new GraduationPanel();
  }
}
