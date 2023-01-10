package com.game.whereisnick.view;

import com.game.whereisnick.model.ImageImport;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class GraduationPanel extends JFrame {
  private JPanel panel;
  private JLabel jeanetteImage;
  private JLabel donteImage;
  private JLabel nellyImage;
  private JLabel nickImage;
  private JLabel scottImage;
  private JLabel tomImage;
  private JLabel chadImage ;
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
    shang = ImageImport.importIcon("images/Sang_Hector.jpg",140, 160);
    tom = ImageImport.importIcon("images/Tom_Saul.jpg",140, 160);



    panel = new JPanel();
    panel.setBounds(0,0,1000,600);

    textPane = new JTextPane();
    StyledDocument doc = textPane.getStyledDocument();
//    SimpleAttributeSet center = new SimpleAttributeSet();
//    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
//    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    
//    textArea = new JTextArea(4,25);
    textPane.setText("Congratulations! \nYou have successfully graduated from TLG!");
    textPane.setFont(new Font("MV Boli", Font.BOLD,35));
    textPane.setBounds(330,150,300,120);
    textPane.setEditable(false);


    jeanetteImage = new JLabel("Jeanette");
    jeanetteImage.setIcon(jeanette);
    jeanetteImage.setIconTextGap(5);
    jeanetteImage.setHorizontalTextPosition(JLabel.CENTER);
    jeanetteImage.setVerticalTextPosition(JLabel.BOTTOM);
    jeanetteImage.setVerticalAlignment(JLabel.TOP);
    jeanetteImage.setHorizontalAlignment(JLabel.CENTER);

    donteImage = new JLabel("Donte");
    donteImage.setIcon(donte);
    donteImage.setIconTextGap(5);
    donteImage.setHorizontalTextPosition(JLabel.CENTER);
    donteImage.setVerticalTextPosition(JLabel.BOTTOM);
    donteImage.setVerticalAlignment(JLabel.TOP);
    donteImage.setHorizontalAlignment(JLabel.CENTER);

    nellyImage = new JLabel("Nelly");
    nellyImage.setIcon(nelly);
    nellyImage.setIconTextGap(5);
    nellyImage.setHorizontalTextPosition(JLabel.CENTER);
    nellyImage.setVerticalTextPosition(JLabel.BOTTOM);
    nellyImage.setVerticalAlignment(JLabel.TOP);
    nellyImage.setHorizontalAlignment(JLabel.CENTER);

    nickImage = new JLabel("Nick");
    nickImage.setIcon(nick);
    nickImage.setIconTextGap(5);
    nickImage.setHorizontalTextPosition(JLabel.CENTER);
    nickImage.setVerticalTextPosition(JLabel.BOTTOM);
    nickImage.setVerticalAlignment(JLabel.TOP);
    nickImage.setHorizontalAlignment(JLabel.CENTER);

    scottImage = new JLabel("Scott");
    scottImage.setIcon(scott);
    scottImage.setIconTextGap(5);
    scottImage.setHorizontalTextPosition(JLabel.CENTER);
    scottImage.setVerticalTextPosition(JLabel.BOTTOM);
    scottImage.setVerticalAlignment(JLabel.TOP);
    scottImage.setHorizontalAlignment(JLabel.CENTER);

    tomImage = new JLabel("Tom");
    tomImage.setIcon(tom);
    tomImage.setIconTextGap(5);
    tomImage.setHorizontalTextPosition(JLabel.CENTER);
    tomImage.setVerticalTextPosition(JLabel.BOTTOM);
    tomImage.setVerticalAlignment(JLabel.TOP);
    tomImage.setHorizontalAlignment(JLabel.CENTER);

    chadImage = new JLabel("Chad");
    chadImage.setIcon(chad);
    chadImage.setIconTextGap(5);
    chadImage.setHorizontalTextPosition(JLabel.CENTER);
    chadImage.setVerticalTextPosition(JLabel.BOTTOM);
    chadImage.setVerticalAlignment(JLabel.TOP);
    chadImage.setHorizontalAlignment(JLabel.CENTER);

    sangImage = new JLabel("Sang");
    sangImage.setIcon(shang);
    sangImage.setIconTextGap(5);
    sangImage.setHorizontalTextPosition(JLabel.CENTER);
    sangImage.setVerticalTextPosition(JLabel.BOTTOM);
    sangImage.setVerticalAlignment(JLabel.TOP);
    sangImage.setHorizontalAlignment(JLabel.CENTER);

    richardImage = new JLabel("Richard");
    richardImage.setIcon(richard);
    richardImage.setIconTextGap(5);
    richardImage.setHorizontalTextPosition(JLabel.CENTER);
    richardImage.setVerticalTextPosition(JLabel.BOTTOM);
    richardImage.setVerticalAlignment(JLabel.TOP);
    richardImage.setHorizontalAlignment(JLabel.CENTER);


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

  public static void main(String[] args) {
    new GraduationPanel();
  }
}
