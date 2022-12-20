package com.game.whereisnick.view;

import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Exam;
import com.game.whereisnick.model.Instructor;
import com.game.whereisnick.model.Music;
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


  private static String userInput;
  private Instructor Jeanette;
  private Instructor Donte;
  private Instructor Nelly;
  private Instructor Chad;
  private Instructor Nick;
  private static BufferedReader inputBuffer;
  private Student student;
  private School TLGSchool;
  private static String quitSynonymns[] = {"no", "n", "quit", "q"};
  private static String yesSynonymns[] = {"yes", "y", "play"};
  private String[] directionCommands = {"go", "run", "move", "walk"};
  private boolean htmlKey = false;
  private boolean pythonKey = false;
  private boolean javaKey = false;
  public static final String BUNSENBURNER = "./resources/audio/BunsenBurner.wav";


  public Game() throws IOException {
    showGameSplash();
    playMusicInBackground();
    introduction();
//    askToBeginGame();
    setUpInstances();
    checkLocation();
//    student.getLocation();
  }

  public void setUpInstances() throws IOException {

    System.out.println("\nEnter your name: ");
    String name = getUserChoice();
    student = new Student(name, "student");
    System.out.printf("\nHello %s!", student.getName());
    ;
    TLGSchool = new School();
    Room lobby = new Room("Lobby", "lobby");
    Room htmlRoom = new Room("HTML Room", "HTML");
    Room javaRoom = new Room("Java Room", "Java");
    Room jsRoom = new Room("JavaScript Room", "Js");
    Room pythonRoom = new Room("Python Room", "Python");
    Room studyRoom = new Room("studyRoom Room", "study");
    Jeanette = new Instructor("Jeanette", "TLG orientation instructor");
    Donte = new Instructor("Donte", "HTML instructor");
    Nelly = new Instructor("Nelly", "JavaScript instructor");
    Chad = new Instructor("Chad", "Python instructor");
    Nick = new Instructor("Nick", "Java instructor");
    lobby.setnRoom(htmlRoom);
    htmlRoom.setnRoom(jsRoom);
    htmlRoom.seteRoom(javaRoom);
    jsRoom.seteRoom(pythonRoom);
    jsRoom.setsRoom(htmlRoom);
    pythonRoom.setwRoom(jsRoom);
    pythonRoom.setsRoom(javaRoom);
    pythonRoom.seteRoom(studyRoom);
    studyRoom.setwRoom(pythonRoom);
    javaRoom.setwRoom(htmlRoom);
    javaRoom.setnRoom(pythonRoom);
    student.setLocation(lobby);
    TLGSchool.addRooms(lobby, htmlRoom, jsRoom, pythonRoom, studyRoom, javaRoom);
  }

  private void playMusicInBackground() {
    Music musicObject = new Music();
    String filepath = BUNSENBURNER; // put filepath here, ex: musicPlayBackground.wav
    musicObject.playMusic(filepath);
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

  //Display game introduction/ scenario
  public void introduction() {
    System.out.println(
        " Introduction: You are now currently enrolled as a student of TLG Learning Facility.\n"
            + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
            + " Upon completion of your orientation, you'll now navigate your way through different levels of coding classes in order to graduate\n"
            + " from the TLG Learning Facility! Get ready to learn and soak up your mind to become a real software engineer! \n"
            + " You can type your name to start the game, after game starts, quit the game anytime by typing q or quit.");
  }

  public static String getUserChoice() throws IOException {
    inputBuffer = new BufferedReader(new InputStreamReader(System.in));
    String inputScan = inputBuffer.readLine();
    String userInput = inputScan.toString().toLowerCase();
    return userInput;
  }


  //Clear the screen before displaying it in console
  public static void clearScreen() throws IOException {
    //Clears Screen in java
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033\143");
      }
    } catch (IOException | InterruptedException ex) {
    }
  }

  public static boolean checkIfUserQuit(String input) throws IOException {
    boolean quit = false;
    if (Arrays.asList(quitSynonymns).contains(input)) {
      System.out.println("Are you sure you want to quit?");
      userInput = getUserChoice();
      if (Arrays.asList(yesSynonymns).contains(userInput)) {
        quit = true;
      }
    } else {
      quit = false;
    }
    return quit;
  }

  // create command list method
  public void commandList() throws IOException {

    System.out.println("Please select from the following commands : \n");
    System.out.println("You can type go/run/move to directions north/east/south/west\n"
        + "to navigate through this game!\n\n"
        + "Please type yes/no when being asked a question.\n\n"
        + "You can type grab/receive/get to access your key/diploma.");
  }

  private void moveTo(Direction dir) throws IOException {
    Room currentLocation = student.getLocation();
    Room exit = null;
    if (dir == Direction.NORTH) {
      exit = currentLocation.getnRoom();
    }
    if (dir == Direction.SOUTH) {
      exit = currentLocation.getsRoom();
    }
    if (dir == Direction.WEST) {
      exit = currentLocation.getwRoom();
    }
    if (dir == Direction.EAST) {
      exit = currentLocation.geteRoom();
    }

    if (exit != null) {
      student.setLocation(exit);
      Room location = student.getLocation();
      checkLocation();
      executeDifferentExam(location);

    } else {
      System.out.println("No exit! Choose another direction.");
    }
  }

  public void checkLocation() {
    Room currentLocation = student.getLocation();
    System.out.println("\n=============================================");
    System.out.println("Current Room: " + currentLocation.getName());
    System.out.println("\n=============================================");
    showGreeting(currentLocation);
  }


  private void showGreeting(Room room) {
    // TODO: 12/18/22 may need remove passed eaxm print out and change if(Exam.passHTML) to check if(htmlRoom.firstTime)
    if (room.equals(TLGSchool.getRooms().get(0))) {
      greetingFromJeanette();

    } else if (room.equals(TLGSchool.getRooms().get(1))) {
      if (Exam.passHTML) {
        System.out.println("You already passed the exam. Go check other places.");
      } else {
        greetingFromDonte();
      }

    } else if (room.equals(TLGSchool.getRooms().get(2))) {
      greetingFromNelly();
    } else if (room.equals(TLGSchool.getRooms().get(3))) {
      greetingFromChad();
    } else if (room.equals(TLGSchool.getRooms().get(4))) {
      greetingFromNick();
    }
  }

  private void checkWhereCanGo() {
    Room currentLocation = student.getLocation();
    ArrayList<String> exit = new ArrayList<>();

    if (currentLocation.getnRoom() != null) {
      exit.add(Direction.NORTH.toString());
    }

    if (currentLocation.getsRoom() != null) {
      exit.add(Direction.SOUTH.toString());
    }

    if (currentLocation.getwRoom() != null) {
      exit.add(Direction.WEST.toString());
    }
    if (currentLocation.geteRoom() != null) {
      exit.add(Direction.EAST.toString());
    }

    System.out.println("\n=============================================");
    System.out.printf("%s can go %s from current location.\n", student.getName(), exit);
    System.out.println("\n=============================================");
  }


  public void executeExamCommand(Room room) throws IOException {
//    System.out.println("Are you ready to take the exam?");

    String answer = getUserChoice();
//    if(answer.isEmpty()){
//      System.out.println("You must type yes or no.");
//      executeExamCommand(room);
//    }
    if (answer.equals("yes") || answer.equals("y")) {
      Exam.startQuiz(room);
      checkKey(room);

    } else if (answer.equals("no") || answer.equals("n")) {
      System.out.println("You can type your command or you can quit the game by tying quit");
      String input = getUserChoice();
      executeCommand(input);
    } else {
      System.out.println("You must type yes or no.");
      executeExamCommand(room);
    }
  }

  public void checkKey(Room room) {
    Room htmlRoom = TLGSchool.getRooms().get(1);
    Room jsRoom = TLGSchool.getRooms().get(2);
    Room pythonRoom = TLGSchool.getRooms().get(3);
    Room javaRoom = TLGSchool.getRooms().get(5);
    if (room.equals(htmlRoom)) {
      if (Exam.passHTML) {
        System.out.println("Congratulations! You got the key to JavaScript Room.");
        htmlKey = true;
      }
    } else if (room.equals(jsRoom)) {
      System.out.println("Congratulations! You got the key to Python Room.");
      pythonKey = true;
    } else if (room.equals(pythonRoom)) {
      System.out.println("Congratulations! You got the key to Java Room.");
      javaKey = true;
    } else if (room.equals(javaRoom)) {
      System.out.println("Congratulations! You graduated from TLG school.");
    }

  }

  public void executeDifferentExam(Room room) throws IOException {
    //   if(!Exam.passHTML){ //todo how to combine string and variable Exam.pass{location.getDescription()}
//        executeExamCommand(location);
//      }
    Room htmlRoom = TLGSchool.getRooms().get(1);
    Room jsRoom = TLGSchool.getRooms().get(2);
    Room pythonRoom = TLGSchool.getRooms().get(3);
    Room javaRoom = TLGSchool.getRooms().get(5);

    if (room.equals(htmlRoom)) {
      if (!Exam.passHTML) {
        executeExamCommand(htmlRoom);
      } else {
        return;
      }
    } else if (room.equals(jsRoom)) {
      if (!Exam.passJs) {
        executeExamCommand(jsRoom);
      } else {
        return;
      }
    } else if (room.equals(pythonRoom)) {
      if (!Exam.passPython) {
        executeExamCommand(pythonRoom);
      } else {
        return;
      }
    } else if (room.equals(javaRoom)) {
      if (!Exam.passJava) {
        executeExamCommand(javaRoom);
      } else {
        return;
      }
    }


  }


  public String executeCommand(String input) throws IOException {
//    String input = getUserChoice();
    String result = "";
    if (input.equals("q") || input.equals("quit")) {

      result = "Quiting the game...";

    } else if (input == null || input.isEmpty()) {
      result = "You can't leave it blank. You must enter a command!";
    } else if (input.equals("hint")) {
      checkWhereCanGo();
    } else if (input.equals("map")) {
      getMap();
    } else if (input.equals("help")) {
      commandList();
    } else if (input.equals("where")) {
      checkLocation();
    }
    // TODO: 12/15/22  check whether the input is q or help after updated the methods from remote dev

    else {
      String[] inputArr = convertInputToArray(input);

      result = parseCommand(inputArr);
    }
    return result;
  }

  public String[] convertInputToArray(String input) {
    return input.split(" ");

  }

  private String parseCommand(String[] arr) throws IOException {
    String result = "";
    String firstWord = arr[0];

    if (Array.getLength(arr) == 2 && Arrays.asList(directionCommands).contains(firstWord)) {
      String secondWord = arr[1];

      switch (secondWord) {
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
          result = secondWord + " is not a valid word.";
          break;
      }
    } else if (!Arrays.asList(directionCommands).contains(firstWord)) {
      result = firstWord + " is not a valid word.";
      // TODO: 12/15/22 add get command later for another ticket

    } else {
      result = "You can only type 2 words as command.";
    }

    return result;
  }


  public void graduationGreeting() {
    System.out.println(" Congratulations! " + student.getName() + "you've graduated from TLG!");

  }

  public void greetingFromJeanette() {
    String lobbyGreeting = " I hope you had your coffee this morning,\n"
        + " because your going to have a very good, but long day,\n"
        + " ..but I promise you, it's going to be great!..\n"
        + " with that being said, I would  like to welcome you to TLG!\n\n"
        + " You are about to meet with your first instructor,\n"
        + " You will have to go to the HTML room, which is North of the this lobby.\n"
        + " Be careful, don't venture to other areas of the building else you will be kicked out.\n"
        + " Have a good day! ";
    System.out.println(Jeanette.greeting() + lobbyGreeting);
  }


  public void greetingFromDonte() {
    String htmlGreeting = " I'm here to teach you web development in HTML.\n"
        + " Get ready to have your mind blown....\n"
        + " Three days later...\n"
        + " Now.. you need to pass the exam in order to get to the next round.\n"
        + " It's all up to you!.. Good luck!\n"
        + " Are you ready to take the exam?";
    System.out.println(Donte.greeting() + htmlGreeting);
  }

  public void greetingFromNelly() {
    String javaScriptGreeting =
        " You are in my Javascript class for web development! Merry Christmas!\n"
            + " Lets get started! Beware, there is going to be pain in this learning,\n"
            + " you will sweat but it's worth it. I am telling you, life is not easy and you have to work hard for it\n"
            + " let's get started.......\n"
            + " 1 week later...\n"
            + " Ok now you'll have to pass the exam for this class in order to move forward in the boot camp.\n"
            + " Good luck!\n Are you ready to take the exam?";
    System.out.println(Nelly.greeting() + javaScriptGreeting);
  }

  public void greetingFromChad() {
    String pythonGreeting = " Welcome! Sorry about the loud music.\n"
        + " Let's learn Python! One important principle in software design,\n"
        + " you have to keep in mind \"Users are very stupid!\" -In radio personality voice.\n"
        + " jk .. but it is very important to have efficient code!\n 1 week later...\n"
        + "Ok, now you'll have to pass the exam for this class in order to move forward in the boot camp.\n"
        + " Good luck!...\n Are you ready to take the exam? ";
    System.out.println(Chad.greeting() + pythonGreeting);
  }

  public void greetingFromNick() {
    String javaGreeting = "How may I be of help?";
    System.out.println(Nick.greeting() + javaGreeting);
  }

  public void greetingWhereIsNick() {
    System.out.println("WHERE IS NICK!?");
  }

  public void messageFromJava() {
    System.out.println("OH NO!... The java code is encrypted!");
  }


  private void getMap() {
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
