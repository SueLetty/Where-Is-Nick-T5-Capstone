package com.game.whereisnick.controller;

import com.game.whereisnick.view.Game;
import java.util.Scanner;

public class RunGame {

  public static void main(String[] args) {
    Game newGame = new Game();

      //create user input for help to get directions
      Scanner directions = new Scanner(System.in);
      System.out.println("Feeling loss? type HELP to get further instructions: ");

      String input = directions.nextLine();
      System.out.println(directions);

  }

}
