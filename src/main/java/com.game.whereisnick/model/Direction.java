package com.game.whereisnick.model;

public enum Direction {
  NORTH,
  SOUTH,
  WEST,
  EAST;

  @Override
  public String toString() {
    String name = name();
    return name.charAt(0) + name.substring(1).toLowerCase();
  }
}
