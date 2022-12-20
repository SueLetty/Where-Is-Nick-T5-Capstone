package com.game.whereisnick.model;

import java.util.ArrayList;

public class Character {
   private String name;
   private String description;
//   private ArrayList<Item> inventory;

  public Character(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

//  public ArrayList<Item> getInventory() {
//    return inventory;
//  }

//  public void setInventory(ArrayList<Item> inventory) {
//    this.inventory = inventory;
//  }
}
