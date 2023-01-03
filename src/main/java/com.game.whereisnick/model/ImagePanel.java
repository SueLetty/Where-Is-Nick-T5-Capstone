package com.game.whereisnick.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
  ImageIcon image = new ImageIcon("resources/love.png");
  Point imageCorner;

  public ImagePanel(){
    imageCorner = new Point(10,10);
    this.setBackground(Color.BLUE);

  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    image.paintIcon(this,g,(int) imageCorner.getX(),(int) imageCorner.getY());


  }

  public ImageIcon getImage() {
    return image;
  }

  public void setImage(ImageIcon image) {
    this.image = image;
  }

  public Point getImageCorner() {
    return imageCorner;
  }

  public void setImageCorner(Point imageCorner) {
    this.imageCorner = imageCorner;
  }
}
