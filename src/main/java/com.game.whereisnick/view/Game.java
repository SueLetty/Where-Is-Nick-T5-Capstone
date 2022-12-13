package com.game.whereisnick.view;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Game {
  Scanner inputScan;
  String quitSynonymns[] = {"no", "n", "quit"};
  String yesSynonymns[] = {"yes", "y", "play"};

  public Game() {
    run();
  }



  public void run() {
    showGameSplash();
    askToBeginGame();
  }

  // Shows the splash screen during start of the game.
  private void showGameSplash(){
    System.out.println("  __      __.__                           .___          _______  .__        __     ._.\n"
        + "/ \\    /  \\  |__   ___________   ____   |   | ______  \\      \\ |__| ____ |  | __ | |\n"
        + "\\   \\/\\/   /  |  \\_/ __ \\_  __ \\_/ __ \\  |   |/  ___/  /   |   \\|  |/ ___\\|  |/ / | |\n"
        + " \\        /|   Y  \\  ___/|  | \\/\\  ___/  |   |\\___ \\  /    |    \\  \\  \\___|    <   \\|\n"
        + "  \\__/\\  / |___|  /\\___  >__|    \\___  > |___/____  > \\____|__  /__|\\___  >__|_ \\  __\n"
        + "       \\/       \\/     \\/            \\/           \\/          \\/        \\/     \\/  \\/"
    );

  }

  private void askToBeginGame() {
    System.out.println("\n\n******Press Yes/y OR No/n to continue!************************");
    inputScan = new Scanner(System.in);
    String userInput = inputScan.next().toLowerCase();
    if (Arrays.asList(yesSynonymns).contains(userInput)){
    clearScreen();
    System.out.println("Starting Game............");
    }else if (Arrays.asList(quitSynonymns).contains(userInput)){
      System.out.println("Quitting game..........");
    }else {
      System.out.println(" Please choose the correct option: ");
      askToBeginGame();
    }
  }

  public static void clearScreen(){
    //Clears Screen in java
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      else {
        System.out.print("\033\143");
      }
    } catch (IOException | InterruptedException ex) {}
  }



}
