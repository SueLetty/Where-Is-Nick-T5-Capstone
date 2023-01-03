package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import java.text.ParseException;

import java.io.IOException;

public class RunGame {

  public static void main(String[] args) throws IOException, ParseException {
    Game newGame = new Game();

    String input = "";
    while(true){
      System.out.println("\n type your command: ");
      input = Game.getUserChoice();
      System.out.println(newGame.executeCommand(input));

      if(input.equals("q") || input.equals("quit")){
        break;
      }
    }

    System.out.println("Bye!");


  }

}
