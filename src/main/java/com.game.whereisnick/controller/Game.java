package com.game.whereisnick.controller;
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
import java.text.ParseException;
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
  private static final String BUNSENBURNER = "audio/BunsenBurner.wav";

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
        "\n Introduction: You are now currently enrolled as a student of TLG Learning Facility.\n"
            + " You will be greeted by Jeanette in the lobby to get started with your orientation.\n"
            + " Upon completion of your orientation, you'll now navigate your way through different levels of coding classes in order to graduate\n"
            + " from the TLG Learning Facility! Get ready to learn and soak up your mind to become a real software engineer! \n\n"
            + " You can type your name to start the game.\n After game starts, type hint if you want to know where to go from current location,\n type map to see the map,\n type help to see the command you can use,\n or quit the game anytime by typing q or quit.";
  }


  public static String getUserChoice(){

//    inputBuffer = new BufferedReader(new InputStreamReader(System.in));
//    String inputScan = inputBuffer.readLine();
    inputBuffer = new Scanner(System.in);
    String inputScan = inputBuffer.nextLine();
    String userInput = inputScan.toString().toLowerCase();
    return userInput;
  }



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
  
  public void setUpInstances(){
    System.out.println("\nEnter your name: ");
//    inputBuffer = new BufferedReader(new InputStreamReader(System.in));
//    String inputScan = inputBuffer.readLine();
    inputBuffer = new Scanner(System.in);
    String inputScan = inputBuffer.nextLine();
    String name = inputScan.toString().toUpperCase();
    student = new Student(name, "student");
    System.out.printf("\nHello %s!", student.getName());;
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
      userInput = getUserChoice();
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
    showGreeting(currentLocation);
  }

  public Room moveTo(Direction dir){
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
      checkLocation();
    }else{
      System.out.println(NO_DIRECTION_MESSAGE);
      }
    return exit;
    }

  private void showGreeting(Room room) {
    // TODO: 12/18/22 may need remove passed eaxm print out and change if(Exam.passHTML) to check if(htmlRoom.firstTime)
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
        executeExamCommand(htmlRoom);
      }
    }else if(room.equals(jsRoom)){
      if(!jsKey){
        printDontHaveKey();
      }else if(Exam.passJs){
        System.out.println("You already passed the JavaScript exam. Go check other places.");
      } else{
        greetingFromNelly();
        executeExamCommand(jsRoom);
      }
    }else if(room.equals(pythonRoom)){
      if(!pythonKey){
        printDontHaveKey();
      }else if(Exam.passPython){
        System.out.println("You already passed the Python exam. Go check other places.");
      } else{
        greetingFromChad();
        executeExamCommand(pythonRoom);
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
        executeExamCommand(javaRoom);
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


  public void executeExamCommand(Room room) {
    String answer = getUserChoice();

    if(answer.equals("yes") || answer.equals("y")){
      Exam.startQuiz(room);
      checkKey(room);

    }else if(answer.equals("no") || answer.equals("n")){
      System.out.println("You can type your command or you can quit the game by tying quit");
    }else{
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
      result = "You can only type 2 words as command.";
    }
    return result;
  }
  public void encryptedmessage(){
    System.out.println("\n $$WHGEH&*BEDE@@ILRIENGT*EBEAA975%FE#HGHJUUTJN RF#WWW YTU$BD @GE \n &EHGEHH%E$SWHEH*NFDEREDG@B GHR8543!GHR HRHSHJJ&09$22GENES@G!\n\n Oh no, you need to find someone to translate this encrypted message.\n\n WHERE IS NICK!? \n");
  }


  // create command list method
  public String commandList()  {

    return "Please select from the following commands : \n" +
    "You can type go/run/move to directions north/east/south/west\n"
        + "to navigate through this game!\n\n"
        + "Please type yes/no when being asked a question.\n\n";
  }

  public String greetingFromJeanette(){
    String lobbyGreeting = " I hope you had your coffee this morning,\n"
        + " because your going to have a very good, but long day,\n"
        + " ..but I promise you, it's going to be great!..\n"
        + " with that being said, I would  like to welcome you to TLG!\n\n"
        + " You are about to meet with your first instructor,\n"
        + " You will have to go to the HTML room, which is North of the this lobby.\n"
        + " Be careful, don't venture to other areas of the building else you will be kicked out.\n"
        + " Have a good day! ";
    return Jeanette.greeting() + lobbyGreeting;
  }


  public void greetingFromDonte(){
    String htmlGreeting = " I'm here to teach you web development in HTML.\n"
        + " Get ready to have your mind blown....\n"
        + " Three days later...\n"
        + " Now.. you need to pass the exam in order to get to the next round.\n"
        + " It's all up to you!.. Good luck!\n"
        + " Are you ready to take the exam?";
    System.out.println(Donte.greeting() + htmlGreeting);
  }

  public void greetingFromNelly(){
    String javaScriptGreeting = " You are in my Javascript class for web development! Merry Christmas!\n"
        + " Lets get started! Beware, there is going to be pain in this learning,\n"
        + " you will sweat but it's worth it. I am telling you, life is not easy and you have to work hard for it\n"
        + " let's get started.......\n"
        + " 1 week later...\n"
        + " Ok now you'll have to pass the exam for this class in order to move forward in the boot camp.\n"
        + " Good luck!\n Are you ready to take the exam?";
    System.out.println(Nelly.greeting() + javaScriptGreeting);
  }

  public void greetingFromChad(){
    String pythonGreeting = " Welcome! Sorry about the loud music.\n"
        + " Let's learn Python! One important principle in software design,\n"
        + " you have to keep in mind \"Users are very stupid!\" -In radio personality voice.\n"
        + " jk .. but it is very important to have efficient code!\n 1 week later...\n"
        + " Ok, now you'll have to pass the exam for this class in order to move forward in the boot camp.\n"
        + " Good luck!...\n Are you ready to take the exam? ";
    System.out.println(Chad.greeting() + pythonGreeting);
  }

  public void greetingFromNick(){
    String javaGreeting = " Let's learn Java.\n Couple of months later...\n Are you ready to take the exam?";
    System.out.println(Nick.greeting() + javaGreeting);
  }


  public void printDontHaveKey(){
    System.out.println(" You can't enter this room because you don't have the key to unlock this door.");
    System.out.println(" Maybe go to last room and pass the exam?");
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
}
