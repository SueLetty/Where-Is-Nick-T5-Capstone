package com.game.whereisnick.controller;

import com.game.whereisnick.view.Game;

import java.util.Scanner;
import java.io.IOException;

public class RunGame {

  public static void main(String[] args) throws IOException {
    Game newGame = new Game();
    String input = newGame.getUserChoice();
    while(input!="q" || input!="quit"){

      System.out.println(newGame.executeCommand());
    }

  }

}
