package com.game.whereisnick.model;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.tools.Tool;

public class ImageImport {

  public static Image importImage(String location){
    URL url = getURL(location);
    Image image = Toolkit.getDefaultToolkit().getImage(url);
    return image;
  }

  public static ImageIcon importIcon(String location){
    URL url  = getURL(location);
    ImageIcon imageIcon = new ImageIcon(url);
    return imageIcon;
  }

  private static URL getURL(String location){
    return ImageImport.class.getClassLoader().getResource(location);
  }

}
