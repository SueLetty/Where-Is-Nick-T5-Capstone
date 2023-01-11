package com.game.whereisnick.model;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

public class ExamTest {
  Room html = new Room("HTML Room");
  Room ruby = new Room("Ruby Room");

  @org.junit.jupiter.api.Test
  void negativeTestStartQuiz() {
    Exception exception = assertThrows(IllegalStateException.class, () -> {
      Exam.startQuiz(ruby);
    });
    String expectedMessage = "Unexpected value: ";
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage,actualMessage);
  }


  @org.junit.jupiter.api.Test
  void parseQuizFromJson() {
    Exam.count = 0;
    Gson gson = new Gson();
    String filePath = "questionsHtml.json";
    ClassLoader classLoader = Exam.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(filePath);
    if (inputStream == null){
      throw new IllegalArgumentException("File not found: " + filePath);
    } else {
      try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        JsonObject obj = gson.fromJson(reader, JsonObject.class);
        JsonArray arr = (JsonArray) obj.get(html.getName());
        for(int i = 0; i < 5; i++){
          Exam.parseQuizFromJson(arr);
          assertEquals(Exam.count, i+1);
        }

      }catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @org.junit.jupiter.api.Test
  void negativeTestCheckCorrectAnswerAndReturnCounter() {
    Exam.startQuiz(html);
    String answer = "";
    int actual = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctCount,answer, Exam.actualAnswer);
    int expected = 0;
    assertEquals(actual,expected);
  }
  @Test
  void positiveTestCheckCorrectAnswerAndReturnCounter() {
    Exam.correctCount = 0;
    Exam.count = 0;
    Gson gson = new Gson();
    String filePath = "questionsHtml.json";
    ClassLoader classLoader = Exam.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(filePath);
    String[] answers = new String[]{"b","c","a","a","c"};
    if (inputStream == null){
      throw new IllegalArgumentException("File not found: " + filePath);
    } else {
      try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        JsonObject obj = gson.fromJson(reader, JsonObject.class);
        JsonArray arr = (JsonArray) obj.get(html.getName());
        for(int i = 0; i < 5; i++){
          Exam.parseQuizFromJson(arr);
          Exam.correctCount = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctCount,answers[i],Exam.actualAnswer);
          System.out.println(answers[i] + ": " + Exam.actualAnswer);
          assertEquals(i+1, Exam.correctCount);
        }

      }catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

}