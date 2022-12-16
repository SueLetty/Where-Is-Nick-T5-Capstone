package com.game.whereisnick.model;

import java.io.IOException;

public class Instructor extends Character{

  public Instructor(String name, String description) {
    super(name, description);
  }

  public String greeting(){
    return ("\n Hello!.. My name is " + super.getName() + ", and I'm your " + super.getDescription() + ".\n");

  }



}
