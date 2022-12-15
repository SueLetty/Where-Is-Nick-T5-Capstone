package com.game.whereisnick.view;

import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Room;
import com.game.whereisnick.model.School;
import com.game.whereisnick.model.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {


  private static BufferedReader inputBuffer;
 String userInput = "";
  private Student student;
  private School TLGSchool;
  String quitSynonymns[] = {"no", "n", "quit", "q"};
  String yesSynonymns[] = {"yes", "y", "play"};



  public Game() throws IOException {
    showGameSplash();
    askToBeginGame();
    setUpInstances();
    //greetings()
    commandList();
    checkWhereCanGo();
    moveTo(Direction.NORTH);
    checkWhereCanGo();
    getMap();
    moveTo(Direction.EAST);
    checkWhereCanGo();
    moveTo(Direction.EAST);

  }

  public void setUpInstances() throws IOException {
    //    create instances
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("\nEnter your name: ");
    String name = reader.readLine();
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
    System.out.println("Current Room: " + currentLocation.getName());
    System.out.printf("%s can go %s from current location.",student.getName(),exit);
    System.out.println("\n=============================================");

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
      System.out.println("Starting Game............\n");
      introduction();
    } else if (Arrays.asList(quitSynonymns).contains(userInput)) {
      System.out.println("Quitting game..........");
    } else {
      System.out.println(" Please choose the correct option: ");
      askToBeginGame();
    }
  }

  //Get user choice and return whether user wants to play or not

  public static String getUserChoice() throws IOException {
    inputBuffer = new BufferedReader (new InputStreamReader (System.in));

    String inputScan = inputBuffer.readLine();
    String userInput = inputScan.toString().toLowerCase();
    return userInput;
  }

  //Display game introduction/ scenario
  public void introduction() {
    System.out.println(
        "Introduction: You are now currently enrolled as a student of TLG Learning Facility.\n"
            + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
            + " Upon completion of your orientation, you'll now navigate your way through different levels of coding classes in order to graduate\n"
            + " from the TLG Learning Facility! Get ready to learn and soak up your mind to become a real software engineer! \n");
  }


  private void getMap(){
    System.out.println(" \n"

        + "  |JAVASCRIPT|----------|PYTHON|--------|STUDYROOM|\n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "   |HTML|______________ |JAVA|                    \n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "   |LOBBY|              |EXIT|                    \n"
    );
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

  // create command list method
  public void commandList() throws IOException {
    String text = "help";

    System.out.println("\n\ntype help if you need further instructions: ");
    userInput = getUserChoice();

    if (userInput.equals(text)) {
      System.out.println("Please select from the following commands : \n");
      System.out.println("You can type go/run/move to directions north/east/south/west\n"
          + "to navigate through this game!\n\n"
          + "Please type yes/no when being asked a question.\n\n"
          + "You can type grab/receive/get to access your key/diploma.");
    }
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
