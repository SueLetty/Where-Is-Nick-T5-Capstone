package com.game.whereisnick.model;

import com.game.whereisnick.view.Game;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class Exam {
  public static final String HTMLFILENAME = "./src/main/resources/questionsHtml.json";
  public static final String JSFILENAME = "./src/main/resources/questionsJavascript.json";
  public static final String PYTHONFILENAME = "./src/main/resources/questionsPython.json";
  public static final String JAVAFILENAME = "./src/main/resources/questionsJava.json";


    public static void getHTMLQuiz() throws IOException, ParseException {
      JSONParser jsonParser=new JSONParser();
      Object obj= jsonParser.parse(new FileReader(HTMLFILENAME));
      JSONArray jsonArrayHTML=(JSONArray) obj;
      startTheQuiz(jsonArrayHTML);
  }

  private static void startTheQuiz(JSONArray jsonArray) throws IOException {
    int correctAnswer = 0;
    for (int i = 1; i <= 5; i++) {
      JSONObject jsonObject=(JSONObject) jsonArray.get(i);
        System.out.println((String)jsonObject.get("Question"));
        System.out.println( "a. " + jsonObject.get("a"));
        System.out.println( "b. " + jsonObject.get("b"));
        System.out.println( "c. " + jsonObject.get("c"));
        System.out.println( "d. " + jsonObject.get("d"));
        System.out.println("\nInput your answer");
        String answer= Game.getUserChoice();
        String actualAnswer= (String)jsonObject.get("answer");
        correctAnswer = checkCorrectAnswerAndReturnCounter(correctAnswer, answer, actualAnswer);
        System.out.printf("Result:You got: %d out of 5", correctAnswer);
        System.out.println("\n\n");
      }
  }

  private static int checkCorrectAnswerAndReturnCounter(int correctAnswer, String answer, String actualAnswer) {
    if(answer.equals(actualAnswer)){
      System.out.println("Correct!");
      correctAnswer +=1;
    }
    else {
      System.out.println("Not correct");
    }
    return correctAnswer;
  }
}



