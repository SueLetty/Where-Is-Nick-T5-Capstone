package com.game.whereisnick.view;

import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Item;
import com.game.whereisnick.model.Room;
import com.game.whereisnick.model.School;
import com.game.whereisnick.model.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
  private Student student;
  private School TLGSchool;
  BufferedReader inputBuffer;
  String quitSynonymns[] = {"no", "n", "quit", "q"};
  String yesSynonymns[] = {"yes", "y", "play"};
  String[] directionCommands = {"go", "run", "move", "walk"};





  public Game() throws IOException {
    showGameSplash();
    setUpInstances();
    askToBeginGame();
//    checklocation();
//
//    System.out.println("type your command: \n");
//    System.out.println(executeCommand());


  }

  public void setUpInstances() throws IOException {
    //    create instances
    System.out.println("\nEnter your name: ");
    String name = getUserChoice();
    student = new Student(name, "student");
    TLGSchool = new School();
    Room lobby = new Room("Lobby");
    Room htmlRoom = new Room("HTML Room");
    Room javaRoom = new Room("Java Room");
    Room jsRoom = new Room("JavaScript Room");
    Room pythonRoom = new Room("Python Room");
    Room study = new Room("study Room");
    lobby.setnRoom(htmlRoom);
    htmlRoom.setnRoom(jsRoom);
    htmlRoom.seteRoom(javaRoom);
    jsRoom.seteRoom(pythonRoom);
    pythonRoom.setwRoom(jsRoom);
    pythonRoom.setsRoom(javaRoom);
    pythonRoom.seteRoom(study);
    study.setwRoom(pythonRoom);
    javaRoom.setwRoom(htmlRoom);
    javaRoom.setnRoom(pythonRoom);
    student.setLocation(lobby);

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
  // Ask whether the user wants to continue or quit the game. Options are "Yes/y/play and No/n/quit/q"
  private void askToBeginGame() throws IOException {
    System.out.println("\n\n******Press Yes/y OR No/n to continue!************************");
    String userInput = getUserChoice();
    if (Arrays.asList(yesSynonymns).contains(userInput)){
    clearScreen();
    System.out.println("Starting Game............");
    introduction();
    }else if (Arrays.asList(quitSynonymns).contains(userInput)){
      System.out.println("Quitting game..........");
    }else {
      System.out.println(" Please choose the correct option: ");
      askToBeginGame();
    }
  }
  //Get user choice and return whether user wants to play or not
  public String getUserChoice() throws IOException {
    inputBuffer = new BufferedReader (new InputStreamReader (System.in));
    String inputScan = inputBuffer.readLine();
    String userInput = inputScan.toString().toLowerCase();
    return userInput;
  }

  //Display game introduction/ scenario
  public void introduction(){
    System.out.println("Introduction: You are now currently enrolled as a student of TLG Learning facility.\n"
        + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
        + " Upon completion of orientation, you'll now be navigate through different levels of coding classes in order to graduate\n"
        + " from the program. Get ready to learn and soak up your mind to become a real software engineer! ");
  }

  //Clear the screen before displaying it in console
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

  private void checklocation(){
    Room currentLocation = student.getLocation();
    System.out.println("\n=============================================");
    System.out.println("Current Room: " + currentLocation.getName());
    System.out.println("\n=============================================");

  }

  private void checkWhereCanGo(){
    Room currentLocation = student.getLocation();
    ArrayList<String> exit = new ArrayList<>();

    if(currentLocation.getnRoom()!=null){
      exit.add(Direction.NORTH.toString());
    }

    if(currentLocation.getsRoom()!=null){
      exit.add(Direction.SOUTH.toString());
    }
    if(currentLocation.getwRoom()!=null){
      exit.add(Direction.WEST.toString());
    }
    if(currentLocation.geteRoom()!=null){
      exit.add(Direction.EAST.toString());
    }

    System.out.println("\n=============================================");
    System.out.printf("%s can go %s from current location.\n",student.getName(),exit);
  }



  private void moveTo(Direction dir){
    Room currentLocation = student.getLocation();
    Room exit = null;
    if(dir==Direction.NORTH){
      exit = currentLocation.getnRoom();
    }
    if(dir==Direction.SOUTH){
      exit = currentLocation.getsRoom();
    }
    if(dir==Direction.WEST){
      exit = currentLocation.getwRoom();
    }
    if(dir==Direction.EAST){
      exit = currentLocation.geteRoom();
    }


    if(exit!=null){
      student.setLocation(exit);
    }else{
      System.out.println("No exit! Choose another direction.");
    }
    checklocation();
  }

  public String executeCommand() throws IOException {
    String input = getUserChoice();
    String result = "";
    if(input==null || input.isEmpty()){
      result = "You can't leave it blank. You must enter a command!";
    }
    else if(input.equals("hint")){
      checkWhereCanGo();
    }
    // TODO: 12/15/22  check whether the input is q or help after updated the methods from remote dev

    else{
      String[] inputArr = convertInputToArray(input);

      result =parseCommand(inputArr);
    }
    return result;
  }

  public String[] convertInputToArray(String input){
    String[] arr = input.split(" ");
    return arr;

  }

  private String parseCommand(String[] arr) throws IOException {
    String result = "";
    String firstWord = arr[0];

//    Direction exit=null;
    if(Array.getLength(arr)==2 && Arrays.asList(directionCommands).contains(firstWord)){
      String secondWord = arr[1];

      switch (secondWord){
        case "north":
          moveTo(Direction.NORTH);
          break;
        case "south":
          moveTo(Direction.SOUTH);
          break;
        case "west":
          moveTo(Direction.WEST);
          break;
        case "east":
          moveTo(Direction.EAST);
          break;
        default:
          result = secondWord +" is not a valid word.";
          break;
      }
    }else if(!Arrays.asList(directionCommands).contains(firstWord)){
      result = firstWord +" is not a valid word.";
      // TODO: 12/15/22 add get command later for another ticket

    }else{
      result = "You can only type 2 words as command.";
    }

    return result;
  }



  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public School getSchool() {
    return TLGSchool;
  }

  public void setSchool(School school) {
    this.TLGSchool = school;
  }
}
