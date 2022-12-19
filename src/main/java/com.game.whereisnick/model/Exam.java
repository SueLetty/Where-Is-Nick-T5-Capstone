package com.game.whereisnick.model;

import com.game.whereisnick.view.Game;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

public class Exam {

  public static boolean passHTML =false;
  public static boolean passJs =false;
  public static boolean passPython =false;
  public static boolean passJava =false;
  public static final String HTMLFILENAME = "./src/main/resources/questionsHtml.json";
  public static final String JSFILENAME = "./src/main/resources/questionsJavascript.json";
  public static final String PYTHONFILENAME = "./src/main/resources/questionsPython.json";
  public static final String JAVAFILENAME = "./src/main/resources/questionsJava.json";

  public static void main(String[] args) throws IOException, ParseException {
    startQuiz("html");
  }

  public static void startQuiz(String quizType) throws IOException, ParseException {
    String filePath;
    switch (quizType){
      case "HTML Room":
        filePath = HTMLFILENAME;
        break;
      case"js":
        filePath = JSFILENAME;
        break;
      case "python":
        filePath = PYTHONFILENAME;
        break;
      case"java":
        filePath = JAVAFILENAME;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + quizType);
    }
    JSONParser jsonParser=new JSONParser();
    Object obj= jsonParser.parse(new FileReader(filePath));
    JSONArray jsonArray=(JSONArray) obj;
    parseQuizFromJson(jsonArray);

  }



  private static void parseQuizFromJson(JSONArray jsonArray) throws IOException {
    int correctAnswer = 0;

    while (correctAnswer <5){
      for (int i = 0; i < 5; i++) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
        System.out.println((String) jsonObject.get("Question"));
        System.out.println("a. " + jsonObject.get("a"));
        System.out.println("b. " + jsonObject.get("b"));
        System.out.println("c. " + jsonObject.get("c"));
        System.out.println("d. " + jsonObject.get("d"));
        System.out.println("\n  Enter your answer: ");
        String answer = Game.getUserChoice();
        String actualAnswer = (String) jsonObject.get("answer");
        correctAnswer = checkCorrectAnswerAndReturnCounter(correctAnswer, answer, actualAnswer);
      }
      if (correctAnswer < 4){
        System.out.println("\n\n You failed the exam. Please retake the exam! \n");
      } else{
//        System.out.println("you got it");
//        System.out.println("correct answer: " +correctAnswer);
        // TODO: 12/18/22 correctAnswer is not correct! 
        passHTML = true;
      }
    }

    System.out.printf("Result:You got: %d out of 5", correctAnswer);
    System.out.println("\n\n");
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



