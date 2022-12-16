package com.game.whereisnick.model;

import java.util.ArrayList;
import java.util.Arrays;

public class School {

  private ArrayList<Room> rooms = new ArrayList<>();

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public void addRooms(Room... rooms) {
    this.rooms.addAll(Arrays.asList(rooms));
  }
//  public void addRooms(Room room){
//    rooms.add(room);
//  }
}
