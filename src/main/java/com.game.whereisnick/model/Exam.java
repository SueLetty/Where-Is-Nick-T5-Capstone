package com.game.whereisnick.model;

import com.game.whereisnick.controller.Audio;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Exam {

  public static boolean passHTML =false;
  public static boolean passJs =false;
  public static boolean passPython =false;
  public static boolean passJava =false;
  private static final String HTMLFILENAME = "questionsHtml.json";
  private static final String JSFILENAME = "questionsJavascript.json";
  private static final String PYTHONFILENAME = "questionsPython.json";
  private static final String JAVAFILENAME = "questionsJava.json";
  private static final String CORRECTAUDIO = "audio/correct.wav";
  private static final String WRONGAUDIO = "audio/wrongCopy.wav";
  public static String question;
  public static String answer1;
  public static String answer2;
  public static String answer3;
  public static String answer4;
  public static int correctCount = 0;
  public static String actualAnswer;
  public static int count = 0;
  public static Audio audio = new Audio();

  public Exam() {

  }


  public static void startQuiz(Room room) {
    String filePath;
    if (room.getName().equals("HTML Room")) {
      filePath = HTMLFILENAME;
    }
    else if (room.getName().equals("JavaScript Room")) {
      filePath = JSFILENAME;
    } else if (room.getName().equals("Python Room")) {
      filePath = PYTHONFILENAME;
    } else if (room.getName().equals("Java Room")) {
      filePath = JAVAFILENAME;
    } else {
      throw new IllegalStateException("Unexpected value: ");
    }

    Gson gson = new Gson();
    ClassLoader classLoader = Exam.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(filePath);
    if (inputStream == null){
      throw new IllegalArgumentException("File not found: " + filePath);
    } else {
      try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
      JsonObject obj = gson.fromJson(reader, JsonObject.class);
      JsonArray arr = (JsonArray) obj.get(room.getName());
      parseQuizFromJson(arr);
      }catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

  }

  public static void parseQuizFromJson(JsonArray jsonArray){
//    int correctAnswer = 0;
//    String answer = "";
//    boolean checkIfUserQuit = false;

//    do {
//      for (int i = 0; i < 5; i++) {
    if(count < 5) {
      JsonObject jsonObject = (JsonObject) jsonArray.get(count++);
      question = jsonObject.get("Question").toString().replaceAll("\"", "");
      answer1 = "a. " + jsonObject.get("a").toString().replaceAll("\"", "");
      answer2 = "b. " + jsonObject.get("b").toString().replaceAll("\"", "");
      answer3 = "c. " + jsonObject.get("c").toString().replaceAll("\"", "");
      answer4 = "d. " + jsonObject.get("d").toString().replaceAll("\"", "");
      System.out.println(count + ". " + question);
      System.out.println(answer1);
      System.out.println(answer2);
      System.out.println(answer3);
      System.out.println(answer4);

//        System.out.println("\n  Enter your answer: ");
//        answer = Game.getUserChoice();
//        checkIfUserQuit = Game.checkIfUserQuit(answer);

//        if(checkIfUserQuit){
//          System.out.println("Quitting exam....");
//          break;
//        }
      actualAnswer = jsonObject.get("answer").getAsString();
      System.out.println(actualAnswer);
    }
//        correctAnswer = checkCorrectAnswerAndReturnCounter(correctAnswer, answer, actualAnswer);
//      }
//      if (correctAnswer < 4) {
//        System.out.println("\n\n You failed the exam. Please retake the exam! \n");
//        correctAnswer = 0;
//      }
//    } while (correctAnswer < 4 && !checkIfUserQuit);
//    System.out.printf("Result:You got: %d out of 5", correctAnswer);
//    System.out.println("\n\n");

//    if (room.getName().equals("HTML Room") && correctAnswer > 3) {
//      passHTML = true;
//    } else if (room.getName().equals("JavaScript Room") && correctAnswer > 3) {
//
//      passJs = true;
//    } else if (room.getName().equals("Python Room") && correctAnswer > 3) {
//      passPython = true;
//    } else if (room.getName().equals("Java Room") && correctAnswer > 3) {
//      passJava = true;
//    }
  }


  public static int checkCorrectAnswerAndReturnCounter(int correctAnswer, String answer,
      String actualAnswer) {

    if (answer.equals(actualAnswer)) {
      correctAnswer += 1;
      System.out.println("Correct! \n");
      if (!audio.isMutedAudio()){
        audio.play(CORRECTAUDIO);
      }
    } else {
      System.out.println("Not correct! \n");
      if (!audio.isMutedAudio()){
        audio.play(WRONGAUDIO);
      }
    }
    System.out.println(correctAnswer);
    return correctAnswer;
  }
}



