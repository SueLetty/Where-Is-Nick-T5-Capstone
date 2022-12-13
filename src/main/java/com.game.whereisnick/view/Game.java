package com.game.whereisnick.view;

import java.util.Scanner;

public class Game {


  public Game() {
    showGameSplash();
    introduction();
    commandList();

  }

  public void showGameSplash() {
    System.out.println(
        "  __      __.__                           .___          _______  .__        __     ._.\n"
            + "/ \\    /  \\  |__   ___________   ____   |   | ______  \\      \\ |__| ____ |  | __ | |\n"
            + "\\   \\/\\/   /  |  \\_/ __ \\_  __ \\_/ __ \\  |   |/  ___/  /   |   \\|  |/ ___\\|  |/ / | |\n"
            + " \\        /|   Y  \\  ___/|  | \\/\\  ___/  |   |\\___ \\  /    |    \\  \\  \\___|    <   \\|\n"
            + "  \\__/\\  / |___|  /\\___  >__|    \\___  > |___/____  > \\____|__  /__|\\___  >__|_ \\  __\n"
            + "       \\/       \\/     \\/            \\/           \\/          \\/        \\/     \\/  \\/"
            + "\n\n******Press Yes/y OR No/n to continue!************************");


  }

  // create introduction method to inform the user of the game
  public void introduction() {
    System.out.println(
        "Introduction: You are now currently enrolled as a student of TLG Learning facility.\n"
            + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
            + " Upon completion of orientation, you'll now be navigate through different levels of coding classes in order to graduate\n"
            + " from the program. Get ready to learn and soak up your mind to become a real software engineer! ");
  }

  // create command list method
  public void commandList() {
// create local variables
    String[] commands = {"North, East, South, West"};
    String userInput = "";
    String text = "help";

    if (userInput == text) {
      System.out.println(commands);
    }


  }


}
