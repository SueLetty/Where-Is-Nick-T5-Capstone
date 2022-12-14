package com.game.whereisnick.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Arrays;

public class Game {

 String userInput = "";


  BufferedReader inputBuffer;
  String quitSynonymns[] = {"no", "n", "quit", "q"};
  String yesSynonymns[] = {"yes", "y", "play"};

  //Game constructor
  public Game() throws IOException {
    showGameSplash();
    askToBeginGame();
    commandList();

  }

  // Shows the splash screen during start of the game.
  private void showGameSplash() {
    System.out.println(
        "  __      __.__                           .___          _______  .__        __     ._.\n"
            + "/ \\    /  \\  |__   ___________   ____   |   | ______  \\      \\ |__| ____ |  | __ | |\n"
            + "\\   \\/\\/   /  |  \\_/ __ \\_  __ \\_/ __ \\  |   |/  ___/  /   |   \\|  |/ ___\\|  |/ / | |\n"
            + " \\        /|   Y  \\  ___/|  | \\/\\  ___/  |   |\\___ \\  /    |    \\  \\  \\___|    <   \\|\n"
            + "  \\__/\\  / |___|  /\\___  >__|    \\___  > |___/____  > \\____|__  /__|\\___  >__|_ \\  __\n"
            + "       \\/       \\/     \\/            \\/           \\/          \\/        \\/     \\/  \\/"
    );

  }

  // Ask whether the user wants to continue or quit the game. Options are "Yes/y/play and No/n/quit/q"
  private void askToBeginGame() throws IOException {
    System.out.println("\n\n******Press Yes/y OR No/n to continue!************************");
    String userInput = getUserChoice();
    if (Arrays.asList(yesSynonymns).contains(userInput)) {
      //clearScreen();
      System.out.println("Starting Game............");
      introduction();
    } else if (Arrays.asList(quitSynonymns).contains(userInput)) {
      System.out.println("Quitting game..........");
    } else {
      System.out.println(" Please choose the correct option: ");
      askToBeginGame();
    }
  }

  //Get user choice and return whether user wants to play or not
  private String getUserChoice() throws IOException {
    inputBuffer = new BufferedReader(new InputStreamReader(System.in));
    String inputScan = inputBuffer.readLine();
    String userInput = inputScan.toString().toLowerCase();
    return userInput;
  }

  //Display game introduction/ scenario
  public void introduction() {
    System.out.println(
        "Introduction: You are now currently enrolled as a student of TLG Learning facility.\n"
            + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
            + " Upon completion of orientation, you'll now be navigate through different levels of coding classes in order to graduate\n"
            + " from the program. Get ready to learn and soak up your mind to become a real software engineer! ");
  }

  // create command list method
  public void commandList() throws IOException {
// create local variables
    String[] commands = {"North, East, South, West"};
    String text = "help";
    System.out.println("type help if you need further instructions: ");

    userInput = getUserChoice();

    if (userInput.equals(text)) {
      System.out.println(Arrays.toString(commands));
    }

    //Clear the screen before displaying it in console
//    public static void clearScreen() {
//      //Clears Screen in java
//      try {
//        if (System.getProperty("os.name").contains("Windows")) {
//          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//        } else {
//          System.out.print("\033\143");
//        }
//      } catch (IOException | InterruptedException ex) {
//      }
//    }


  }
}
