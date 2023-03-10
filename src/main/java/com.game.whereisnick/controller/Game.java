package com.game.whereisnick.controller;

import com.game.whereisnick.model.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

  private static String userInput;
  private Instructor Jeanette;
  private Instructor Donte;
  private Instructor Nelly;
  private Instructor Chad;
  private Instructor Nick;
//  private static BufferedReader inputBuffer;
  private static Scanner inputBuffer;
  private Student student;
  private School TLGSchool;
  private static String quitSynonymns[] = {"no", "n", "quit", "q"};
  private static String yesSynonymns[] = {"yes", "y", "play"};
  private String[] directionCommands = {"go", "run", "move", "walk"};
  private boolean htmlKey = false;
  private boolean pythonKey = false;
  private boolean javaKey = false;
  private boolean jsKey=false;
  private boolean findNick = false;
  private boolean wentToJavaWithoutNick=false;
  private static final String BUNSENBURNER = "audio/BBMT16Bit.wav";

  private Music musicObject = new Music();

  private final String NO_DIRECTION_MESSAGE = "No exit! Choose another direction.";


  public Game(){
    clearScreen();
    showGameSplash();
    playMusicInBackground();
    introduction();
    setUpInstances();
    checkLocation();
  }

  private void playMusicInBackground() {
    String filepath = BUNSENBURNER; // put filepath here, ex: musicPlayBackground.wav
    musicObject.playMusic(filepath);
  }

  public Music getMusicObject(){
    return musicObject;
  }

  // Shows the splash screen during start of the game.
  public String showGameSplash() {
    return
        "  __      __.__                           .___          _______  .__        __     ._.\n"
            + "/ \\    /  \\  |__   ___________   ____   |   | ______  \\      \\ |__| ____ |  | __ | |\n"
            + "\\   \\/\\/   /  |  \\_/ __ \\_  __ \\_/ __ \\  |   |/  ___/  /   |   \\|  |/ ___\\|  |/ / | |\n"
            + " \\        /|   Y  \\  ___/|  | \\/\\  ___/  |   |\\___ \\  /    |    \\  \\  \\___|    <   \\|\n"
            + "  \\__/\\  / |___|  /\\___  >__|    \\___  > |___/____  > \\____|__  /__|\\___  >__|_ \\  __\n"
            + "       \\/       \\/     \\/            \\/           \\/          \\/        \\/     \\/  \\/";
  }

  //Display game introduction/ scenario
  public String introduction() {
    return
        "\nYou are now currently enrolled as a student with TLG Learning Facility.\n"
            + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
            + " Upon completion of your orientation, \nyou'll now navigate your way through different levels of coding classes \nin order to graduate"
            + " from the TLG Learning Facility! \nGet ready to learn and soak up your mind to become a real Software Engineer! \n\n"
            + " Click the button to start the game.\n After game starts, you will click on compass buttons to move,\n click Map button to view the map,\n click Help for assistance,\n or Quit the game.";
  }


//  public static String getUserChoice(){
//
////    inputBuffer = new BufferedReader(new InputStreamReader(System.in));
////    String inputScan = inputBuffer.readLine();
//    inputBuffer = new Scanner(System.in);
//    String inputScan = inputBuffer.nextLine();
//    String userInput = inputScan.toString().toLowerCase();
//    return userInput;
//  }



  //Clear the screen before displaying it in console
  public static void clearScreen(){
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

  /**
   * Sets up the student, old way that is extracted from setUpInstances().
   * Depreciated.
   */
  private void setUpStudent(){
//    System.out.println("\nEnter your name: ");
//    inputBuffer = new BufferedReader(new InputStreamReader(System.in));
//    String inputScan = inputBuffer.readLine();
//    inputBuffer = new Scanner(System.in);
//    String inputScan = inputBuffer.nextLine();
//    String name = inputScan.toString().toUpperCase();
//    student = new Student(name, "student");
//    System.out.printf("\nHello %s!", student.getName());
  }

  public void setUpInstances(){
    student = new Student("You", "student"); // move old code for student into setUpStudent()
    TLGSchool = new School();
    Room lobby = new Room("Lobby","lobby");
    Room htmlRoom = new Room("HTML Room","HTML");
    Room javaRoom = new Room("Java Room","Java");
    Room jsRoom = new Room("JavaScript Room","Js");
    Room pythonRoom = new Room("Python Room","Python");
    Room studyRoom = new Room("studyRoom Room","study");
    Jeanette = new Instructor("Jeanette", "TLG orientation instructor");
    Donte = new Instructor("Donte", "HTML instructor");
    Nelly = new Instructor("Nelly", "JavaScript instructor");
    Chad = new Instructor("Chad","Python instructor");
    Nick = new Instructor("Nick","Java instructor");
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
    lobby.setInstructor(Jeanette);
    htmlRoom.setInstructor(Donte);
    jsRoom.setInstructor(Nelly);
    pythonRoom.setInstructor(Chad);
    studyRoom.setInstructor(Nick);
    TLGSchool.addRooms(lobby, htmlRoom,jsRoom,pythonRoom,studyRoom,javaRoom);
  }

  public static boolean checkIfUserQuit(String input){
    boolean quit = false;
    if (Arrays.asList(quitSynonymns).contains(input)) {
      System.out.println("Are you sure you want to quit?");
//      userInput = getUserChoice();
      if (Arrays.asList(yesSynonymns).contains(userInput)) {
        quit = true;
      }
    } else {
      quit = false;
    }
    return quit;
  }

  public void checkLocation(){
    Room currentLocation = student.getLocation();
    System.out.println("\n=============================================");
    System.out.println("Current Room: " + currentLocation.getName());
    System.out.println("\n=============================================");
    if(currentLocation.getName().equals("Java Room") && javaKey){
      wentToJavaWithoutNick = true;
    }
//    showGreeting(currentLocation);
  }

  public Room moveTo(Direction dir) {
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
    accessible(exit);
    return exit;
  }
  public boolean accessible(Room room){

    if(room!=null){
      student.setLocation(room);
//      checkLocation();
    }
    return false;
    }

  public void showGreeting(Room room) {
    // TODO: 12/18/22 may need remove passed exam print out and change if(Exam.passHTML) to check if(htmlRoom.firstTime)
    Room lobby = TLGSchool.getRooms().get(0);
    Room htmlRoom = TLGSchool.getRooms().get(1);
    Room jsRoom = TLGSchool.getRooms().get(2);
    Room pythonRoom = TLGSchool.getRooms().get(3);
    Room studyRoom = TLGSchool.getRooms().get(4);
    Room javaRoom = TLGSchool.getRooms().get(5);

    if(room.equals(lobby)){
      greetingFromJeanette();
    }else if(room.equals(htmlRoom)){
      if(Exam.passHTML){
        System.out.println("You already passed the HTML exam. Go check other places.");
      }else{
        greetingFromDonte();
//        executeExamCommand(htmlRoom);
      }
    }else if(room.equals(jsRoom)){
      if(!jsKey){
        printDontHaveKey();
      }else if(Exam.passJs){
        System.out.println("You already passed the JavaScript exam. Go check other places.");
      } else{
        greetingFromNelly();
//        executeExamCommand(jsRoom);
      }
    }else if(room.equals(pythonRoom)){
      if(!pythonKey){
        printDontHaveKey();
      }else if(Exam.passPython){
        System.out.println("You already passed the Python exam. Go check other places.");
      } else{
        greetingFromChad();
//        executeExamCommand(pythonRoom);
      }
    }else if(room.equals(studyRoom)){
      if(!javaKey || !wentToJavaWithoutNick){
        System.out.println("SHH...Nick is playing guitar.");
      }else if(javaKey && wentToJavaWithoutNick){
        System.out.println("\n Nick says: \"I know what happened. Come and fly with me to Java Room.\"\n");
        findNick=true;
        javaRoom.setInstructor(Nick);
        student.setLocation(javaRoom);
        greetingFromNick();
//        executeExamCommand(javaRoom);
      }
    } else if(room.equals(javaRoom)) {
      if (!javaKey) {
        printDontHaveKey();
      } else if (!findNick) {
        encryptedmessage();

      }
    }
    }


  public String checkWhereCanGo() {
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

    return "\n====================================================================================="
    + student.getName() +" can go " + exit + "from current location --- " + student.getLocation().getName() +
        "\n=====================================================================================";

  }


//  public void executeExamCommand(Room room) {
////    String answer = getUserChoice();
//
//    if(answer.equals("yes") || answer.equals("y")){
//      Exam.startQuiz(room);
//      checkKey(room);
//
//    }else if(answer.equals("no") || answer.equals("n")){
//      System.out.println("You can type your command or you can quit the game by tying quit");
//    }else{
//      System.out.println("You must type yes or no.");
//      executeExamCommand(room);
//    }
//  }


  public void checkKey(Room room) {
    Room htmlRoom = TLGSchool.getRooms().get(1);
    Room jsRoom = TLGSchool.getRooms().get(2);
    Room pythonRoom = TLGSchool.getRooms().get(3);
    Room javaRoom = TLGSchool.getRooms().get(5);
    if (room.equals(htmlRoom)) {
      if (Exam.passHTML) {
        System.out.printf(
            "Congratulations! %s gives you the key and you can use it to unlock JavaScript Room.",
            htmlRoom.getInstructor().getName());
        jsKey = true;
      }
    } else if (room.equals(jsRoom)) {

      if (Exam.passJs) {
        System.out.printf(
            "Congratulations! %s gives you the key and you can use it to unlock Python Room.",
            jsRoom.getInstructor().getName());
        pythonKey = true;
      }
    } else if (room.equals(pythonRoom)) {
      if (Exam.passPython) {
        System.out.printf(
            "Congratulations! %s gives you the key and you can use it to unlock Java Room.",
            pythonRoom.getInstructor().getName());
        javaKey = true;
      }
    } else if (room.equals(javaRoom)) {
      if (Exam.passJava) {
        System.out.printf(
            "--------Congratulations %s! %s gives you the diploma and you have graduated from TLG Learning Facility!--------\n",
            student.getName(), javaRoom.getInstructor().getName());
        System.exit(0);
      }
      }
    }

  /**
   * depreciated?
   * @param input
   * @return
   * @throws IOException
   */
  public String executeCommand(String input) throws IOException {

    String result = "";
    if (input.equals("q") || input.equals("quit")) {

      result = "Quiting the game...";

    }
    else if(input.isEmpty()){
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
     else{
      String[] inputArr = convertInputToArray(input);

      result = parseCommand(inputArr);
    }
    return result;
  }

  public String[] convertInputToArray(String input) {
    return input.split(" ");
  }

  /**
   * depreciated?
   * @param arr
   * @return
   * @throws IOException
   */
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
    } else {
      result = "You can only type 2 words for a command.";
    }
    return result;
  }
  public String encryptedmessage(){
    //todo changed the script
    return "\n $$WHGEH&*BEDE@@ILRIENGT*EBEAA975%FE#HGHJUUTJN RF#WWW YTU$BD @GE \n &EHGEHH%E$SWHEH*NFDEREDG@B GHR8543!GHR HRHSHJJ&09$22GENES@G!\n\n Oh no, Adobe Connect is having issues.\n\n WHERE IS NICK!? \n";
  }


  // create command list method
  public String commandList()  {


    return "This will need expanded for exams.\n"
        + "- You can move to other rooms with the N,S,E,W buttons.\n"
        + "- Music button will mute/unmute the background music and\n"
        + "  mute/unmute the sound effect, and\n"
        + "  change the volume of the background music.\n"
        + "- Map button will display a map of the game.\n"
        + "- Quit button will quit the game.";

  }

  public String greetingFromJeanette(){
    String lobbyGreeting = " I hope you had your coffee this morning,\n"
        + " because you're going to have a very good, but long day,\n"
        + " ..but I promise you, it's going to be great!..\n"
        + " with that being said, I would like to welcome you to TLG!\n\n"
        + " You are about to meet with your first instructor,\n"
        + " You will have to go into the HTML room, which is North of the this lobby.\n"
        + " Be careful, don't venture to other areas of the building or else you will be kicked out.\n"
        + " Have a good day! ";
    return Jeanette.greeting() + lobbyGreeting;
  }


  public String greetingFromDonte(){
    String htmlGreeting = " I'm here to teach you web development in HTML.\n"
        + " Get ready to have your mind blown....\n\n"
        + " Three days later...\n\n\n"
        + " You need to pass the exam in order to get to the next round.\n"
        + " It's all up to you!\nGood luck!";
    return Donte.greeting() + htmlGreeting;
  }

  public String greetingFromNelly(){
    String javaScriptGreeting = " You are in my Javascript class for web development! Merry Christmas!\n"
        + " Lets get started! \nBeware, there is going to be pain in this learning,\n"
        + " you will sweat but it's worth it. \nI am telling you, life is not easy and you have to work hard for it\n"
        + " let's get started.......\n\n"
        + " 1 week later...\n\n"
        + " Ok, now you'll have to pass the exam for this class \nin order to move forward in the boot camp.\n"
        + " Good luck!";
    return Nelly.greeting() + javaScriptGreeting;
  }

  public String greetingFromChad(){
    String pythonGreeting = " Welcome! Sorry about the loud music.\n"
        + " Let's learn Python! \nOne important principle in software design,\n"
        + " you have to keep in mind \"Users are very stupid!\" -In radio personality voice.\n"
        + " jk .. but it is very important to have efficient code!\n\n 1 week later...\n\n"
        + " Ok, now you'll have to pass the exam for this class \nin order to move forward in the boot camp.\n"
        + " Good luck!";
    return Chad.greeting() + pythonGreeting;
  }

  public String greetingFromNick(){
    String javaGreeting = " Let's learn Java.\n\n Couple of months later...\n\n"
        + " Ok, now you'll have to pass the exam for this class \nin order to graduate from TLG.\n"
        + " Good luck!";
    return Nick.greeting() + javaGreeting;
  }


  public void printDontHaveKey(){
    System.out.println(" You can't enter this room because you don't have the key to unlock this door.");
    System.out.println(" Maybe go to the last room and pass the exam?");
  }


  public String getMap(){
    return " \n"

        + "  |JAVASCRIPT|----------|PYTHON|--------|STUDYROOM|\n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "   |HTML|______________ |JAVA|                    \n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "      |                   |                       \n"
        + "   |LOBBY|              |EXIT|                    \n"
    ;
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

  public String getNO_DIRECTION_MESSAGE() {
    return NO_DIRECTION_MESSAGE;
  }

  public static String getUserInput() {
    return userInput;
  }

  public boolean isHtmlKey() {
    return htmlKey;
  }

  public boolean isPythonKey() {
    return pythonKey;
  }

  public boolean isJavaKey() {
    return javaKey;
  }

  public boolean isJsKey() {
    return jsKey;
  }

  public boolean isFindNick() {
    return findNick;
  }

  public boolean isWentToJavaWithoutNick() {
    return wentToJavaWithoutNick;
  }

  public void setHtmlKey(boolean htmlKey) {
    this.htmlKey = htmlKey;
  }

  public void setPythonKey(boolean pythonKey) {
    this.pythonKey = pythonKey;
  }

  public void setJavaKey(boolean javaKey) {
    this.javaKey = javaKey;
  }

  public void setJsKey(boolean jsKey) {
    this.jsKey = jsKey;
  }

  public void setFindNick(boolean findNick) {
    this.findNick = findNick;
  }

  public void setWentToJavaWithoutNick(boolean wentToJavaWithoutNick) {
    this.wentToJavaWithoutNick = wentToJavaWithoutNick;
  }
}
