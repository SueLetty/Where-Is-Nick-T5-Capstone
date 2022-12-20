package com.game.whereisnick.model;

import java.util.ArrayList;

public class Student extends Character{
  private Room location;
  private int points;

  public Student(String name, String description) {
    super(name, description);
  }

  public int addPoints(){
    return points += 25;
  }

//  public void addInventory(Item thing){
//    ArrayList<Item> inventory = super.getInventory();
//    inventory.add(thing);
//  }

  public Room getLocation() {
    return location;
  }

  public void setLocation(Room location) {
    this.location = location;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }


}
