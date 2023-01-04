package com.game.whereisnick.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionalPanel extends JPanel {
  private JRadioButton answer1;
  private JRadioButton answer2;
  private JRadioButton answer3;
  private JRadioButton answer4;
  private JLabel info;
  public OptionalPanel(){



    info = new JLabel();
    info.setFont(new Font("MV Boli",Font.PLAIN,12));
    info.setText("Click on direction button and move to a different room.");
    info.setOpaque(true);
    info.setBackground(Color.CYAN);
    info.setVisible(true);

    answer1 = new JRadioButton();
    answer2 = new JRadioButton();
    answer3 = new JRadioButton();
    answer4 = new JRadioButton();

    this.add(info);
    this.setVisible(true);
  }
  public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
  }

  public JRadioButton getAnswer1() {
    return answer1;
  }

  public void setAnswer1(JRadioButton answer1) {
    this.answer1 = answer1;
  }

  public JRadioButton getAnswer2() {
    return answer2;
  }

  public void setAnswer2(JRadioButton answer2) {
    this.answer2 = answer2;
  }

  public JRadioButton getAnswer3() {
    return answer3;
  }

  public void setAnswer3(JRadioButton answer3) {
    this.answer3 = answer3;
  }

  public JRadioButton getAnswer4() {
    return answer4;
  }

  public void setAnswer4(JRadioButton answer4) {
    this.answer4 = answer4;
  }
}
