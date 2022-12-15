package com.game.whereisnick.controller;

import com.game.whereisnick.view.Game;

import java.util.Scanner;
import java.io.IOException;

public class RunGame {

  public static void main(String[] args) throws IOException {
    Game newGame = new Game();

    String input = "";

    do{
      System.out.println("type your command: ");
      input = Game.getUserChoice();
      System.out.println(newGame.executeCommand(input));
      if(input.equals("q") || input.equals("quit")){
        break;
      }
    }while(true);

    System.out.println("bye");

  }

}
