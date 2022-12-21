package com.game.whereisnick.model;

import com.game.whereisnick.view.Audio;
import com.game.whereisnick.view.Game;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Exam {

  public static boolean passHTML =false;
  public static boolean passJs =false;
  public static boolean passPython =false;
  public static boolean passJava =false;
  private static final String HTMLFILENAME = "./resources/questionsHtml.json";
  private static final String JSFILENAME = "./resources/questionsJavascript.json";
  private static final String PYTHONFILENAME = "./resources/questionsPython.json";
  private static final String JAVAFILENAME = "./resources/questionsJava.json";
  private static final String CORRECTAUDIO = "./resources/audio/correct.wav";
  private static final String WRONGAUDIO = "./resources/audio/wrongCopy.wav";

  public Exam() {

  }


  public static void startQuiz(Room room) throws IOException {
    String filePath;
    if (room.getName().equals("HTML Room")) {
      filePath = HTMLFILENAME;
    } else if (room.getName().equals("JavaScript Room")) {
      filePath = JSFILENAME;
    } else if (room.getName().equals("Python Room")) {
      filePath = PYTHONFILENAME;
    } else if (room.getName().equals("Java Room")) {
      filePath = JAVAFILENAME;
    } else {
      throw new IllegalStateException("Unexpected value: ");
    }

    Gson gson = new Gson();
    JsonObject obj = gson.fromJson(
        new BufferedReader(new FileReader(filePath)), JsonObject.class);
    JsonArray arr = (JsonArray) obj.get(room.getName());
    parseQuizFromJson(arr, room);

  }

  private static void parseQuizFromJson(JsonArray jsonArray, Room room) throws IOException {
    int correctAnswer = 0;
    String answer = "";
    boolean checkIfUserQuit = false;
    do {
      for (int i = 0; i < 5; i++) {
        JsonObject jsonObject = (JsonObject) jsonArray.get(i);
        System.out.println(jsonObject.get("Question").toString().replaceAll("\"", ""));
        System.out.println("a. " + jsonObject.get("a").toString().replaceAll("\"", ""));
        System.out.println("b. " + jsonObject.get("b").toString().replaceAll("\"", ""));
        System.out.println("c. " + jsonObject.get("c").toString().replaceAll("\"", ""));
        System.out.println("d. " + jsonObject.get("d").toString().replaceAll("\"", ""));
        System.out.println("\n  Enter your answer: ");
        answer = Game.getUserChoice();
        checkIfUserQuit = Game.checkIfUserQuit(answer);

        if(checkIfUserQuit){
          System.out.println("Quitting exam....");
          break;
        }
        String actualAnswer = jsonObject.get("answer").getAsString();
        correctAnswer = checkCorrectAnswerAndReturnCounter(correctAnswer, answer, actualAnswer);
      }
      if (correctAnswer < 4) {
        System.out.println("\n\n You failed the exam. Please retake the exam! \n");
        correctAnswer = 0;
      }
    }
    while (correctAnswer < 4 && !checkIfUserQuit);
    System.out.printf("Result:You got: %d out of 5", correctAnswer);
    System.out.println("\n\n");

    if (room.getName().equals("HTML Room") && correctAnswer > 3) {
      passHTML = true;
      System.out.println("pass html: "+passHTML);
    } else if (room.getName().equals("JavaScript Room") && correctAnswer > 3) {

      passJs = true;
    } else if (room.getName().equals("Python Room") && correctAnswer > 3) {
      passPython = true;
    } else if (room.getName().equals("Java Room") && correctAnswer > 3) {
      passJava = true;
    }
  }

  private static int checkCorrectAnswerAndReturnCounter(int correctAnswer, String answer,
      String actualAnswer) {
    Audio audio = new Audio();
    if (answer.equals(actualAnswer)) {
      correctAnswer += 1;
      System.out.println("Correct! \n");
      audio.play(CORRECTAUDIO);
    } else {
      System.out.println("Not correct! \n");
      audio.play(WRONGAUDIO);
    }
    return correctAnswer;
  }
}



