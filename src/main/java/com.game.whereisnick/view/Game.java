package com.game.whereisnick.view;

import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Exam;
import com.game.whereisnick.model.Instructor;
import com.game.whereisnick.model.Room;
import com.game.whereisnick.model.School;
import com.game.whereisnick.model.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.simple.parser.ParseException;

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
  String quitSynonymns[] = {"no", "n", "quit", "q"};
  String yesSynonymns[] = {"yes", "y", "play"};
  String[] directionCommands = {"go", "run", "move", "walk"};



  public Game() throws IOException {
    showGameSplash();
    askToBeginGame();
    setUpInstances();
    checkLocation();
//    student.getLocation();
    studentName();

  }

  public void studentName(){
    System.out.println(" Hello " + student.getName() + "!");
  }

  public void graduationGreeting(){
    System.out.println(" Congratulations! " + student.getName() + "you've graduated from TLG!");

  }

  public void greetingFromJeanette(){
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


  public void greetingFromDonte(){
    String htmlGreeting = " I'm here to teach you web development in HTML.\n"
        + " Get ready to have your mind blown....\n"
        + " Now.. you need to pass the exam in order to get to the next round.\n"
        + " It's all up to you!.. Good luck!";
    System.out.println(Donte.greeting() + htmlGreeting);
  }

  public void greetingFromNelly(){
    String javaScriptGreeting = " You are in my Javascript class for web development! Merry Christmas!\n"
        + " Lets get started! Beware, there is going to be pain in this learning,\n"
        + " you will sweat but it's worth it. I am telling you, life is not easy and you have to work hard for it\n"
        + " let's get started.......\n"
        + " Ok now you'll have to pass the exam for this class in order to move forward in the boot camp.\n"
        + " Good luck!";
    System.out.println(Nelly.greeting() + javaScriptGreeting);
  }

  public void greetingFromChad(){
    String pythonGreeting = " Welcome! Sorry about the loud music.\n"
        + " Let's learn Python! One important principle in software design,\n"
        + " you have to keep in mind \"Users are very stupid!\" -In radio personality voice.\n"
        + " jk .. but it is very important to have efficient code!\n"
        + "Ok, now you'll have to pass the exam for this class in order to move forward in the boot camp.\n"
        + " Good luck!... ";
    System.out.println(Chad.greeting() + pythonGreeting);
  }

  public void greetingFromNick(){
    String javaGreeting = " How may I be of help?";
    System.out.println(Nick.greeting() + javaGreeting);
  }

  public void greetingWhereIsNick(){
    System.out.println(" WHERE IS NICK!?");
  }





  public void setUpInstances() throws IOException {

    System.out.println("\nEnter your name: ");
    String name = getUserChoice();
    student = new Student(name, "student");
    TLGSchool = new School();
    Room lobby = new Room("Lobby");
    Room htmlRoom = new Room("HTML Room");
    Room javaRoom = new Room("Java Room");
    Room jsRoom = new Room("JavaScript Room");
    Room pythonRoom = new Room("Python Room");
    Room studyRoom = new Room("studyRoom Room");
    Jeanette = new Instructor("Jeanette", "TLG orientation instructor");
    Donte = new Instructor("Donte", "HTML instructor");
    Nelly = new Instructor("Nelly", "JavaScript instructor");
    Chad = new Instructor("Chad","Python instructor");
    Nick = new Instructor("Nick","Java instructor");
    lobby.setnRoom(htmlRoom);
    htmlRoom.setnRoom(jsRoom);
    htmlRoom.seteRoom(javaRoom);
    jsRoom.seteRoom(pythonRoom);
    pythonRoom.setwRoom(jsRoom);
    pythonRoom.setsRoom(javaRoom);
    pythonRoom.seteRoom(studyRoom);
    studyRoom.setwRoom(pythonRoom);
    javaRoom.setwRoom(htmlRoom);
    javaRoom.setnRoom(pythonRoom);
    student.setLocation(lobby);
    TLGSchool.addRooms(lobby, htmlRoom,jsRoom,pythonRoom,studyRoom,javaRoom);


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
        " Introduction: You are now currently enrolled as a student of TLG Learning Facility.\n"
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

  public void checkLocation(){
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


  private void moveTo(Direction dir) throws IOException, ParseException {
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
      Room location = student.getLocation();
      showGreeting(location);
      Exam.startQuiz(location.getName());

    }else{
      System.out.println("No exit! Choose another direction.");
    }
    checkLocation();
  }

  private void showGreeting(Room room){
    if(room.equals(TLGSchool.getRooms().get(0))){
      greetingFromJeanette();
    }else if(room.equals(TLGSchool.getRooms().get(1))){
      greetingFromDonte();
    }else if(room.equals(TLGSchool.getRooms().get(2))){
      greetingFromNelly();
    }else if(room.equals(TLGSchool.getRooms().get(3))){
      greetingFromChad();
    }else if(room.equals(TLGSchool.getRooms().get(4))){
      greetingFromNick();
    }

  }

  public String executeCommand(String input) throws IOException, ParseException {
//    String input = getUserChoice();
    String result = "";
    if(input.equals("q") || input.equals("quit")){

      result = "Quiting the game...";

    }
    else if(input==null || input.isEmpty()){
      result = "You can't leave it blank. You must enter a command!";
    }
    else if(input.equals("hint")){
      checkWhereCanGo();
    }
    else if(input.equals("map")){
      getMap();
    }
    else if(input.equals("help")){
      commandList();
    }
    // TODO: 12/15/22  check whether the input is q or help after updated the methods from remote dev

    else{
      String[] inputArr = convertInputToArray(input);

      result =parseCommand(inputArr);
    }
    return result;
  }

  public String[] convertInputToArray(String input){
    return input.split(" ");

  }

  private String parseCommand(String[] arr) throws IOException, ParseException {
    String result = "";
    String firstWord = arr[0];

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
