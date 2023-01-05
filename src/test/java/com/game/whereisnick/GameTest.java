package com.game.whereisnick;

import static org.junit.Assert.*;

import com.game.whereisnick.model.Room;
import com.game.whereisnick.model.School;
import com.game.whereisnick.model.Student;
import com.game.whereisnick.controller.Game;
import java.io.IOException;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;


public class GameTest {
  private Game game;
  private Student student;
  private School TLGSchool;
  private String[] directionCommands = {"go", "run", "move", "walk"};

  @Before
  public void setUp() throws Exception {
    student = new Student("player", "student");
    TLGSchool = new School();
    Room lobby = new Room("Lobby","lobby");
    Room htmlRoom = new Room("HTML Room","HTML");
    Room javaRoom = new Room("Java Room","Java");
    Room jsRoom = new Room("JavaScript Room","Js");
    Room pythonRoom = new Room("Python Room","Python");
    Room studyRoom = new Room("studyRoom Room","study");
//    Jeanette = new Instructor("Jeanette", "TLG orientation instructor");
//    Donte = new Instructor("Donte", "HTML instructor");
//    Nelly = new Instructor("Nelly", "JavaScript instructor");
//    Chad = new Instructor("Chad","Python instructor");
//    Nick = new Instructor("Nick","Java instructor");
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
    TLGSchool.addRooms(lobby, htmlRoom,jsRoom,pythonRoom,studyRoom,javaRoom);
    game = new Game();
  }


  @Test
  public void test_quit_for_executeCommandMethod() throws IOException, ParseException {
    String quitString = game.executeCommand("q");
    assertEquals("Quiting the game...", quitString);

  }
}