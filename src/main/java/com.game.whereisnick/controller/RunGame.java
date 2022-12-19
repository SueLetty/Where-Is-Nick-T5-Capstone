package com.game.whereisnick.controller;

import com.game.whereisnick.model.Exam;
import com.game.whereisnick.model.Instructor;
import com.game.whereisnick.view.Game;

import java.util.Scanner;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class RunGame {

  public static void main(String[] args) throws IOException, ParseException {
    Game newGame = new Game();
//    Exam.getHTMLQuiz();


    String input = "";

    while(true){
      System.out.println("\nType your command: ");
      input = Game.getUserChoice();
      System.out.println(newGame.executeCommand(input));

      if(input.equals("q") || input.equals("quit")){
        break;
      }

    }

    System.out.println("Bye!");

  }

}
