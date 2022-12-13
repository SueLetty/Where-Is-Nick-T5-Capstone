package com.game.whereisnick.model;

import java.util.ArrayList;

public class Room {
  private String name;
  private String description;
  private ArrayList<Room> path;
  private Instructor instructor;
  private Item key;
  private Exam exam;

  public Room(String name, String description,
      ArrayList<Room> path) {
    this.name = name;
    this.description = description;
    this.path = path;
  }

  public String welcome(){
    return "Welcome to "+ name;
  }

  public String conclusionForPassingExam(){
    return "Congratulations! You passed the exam.";
  }

  public String conclusionForNotPassingExam(){
    return "On no. You got it wrong. But don't worry, I'll give you a second chance and try you best this time!";
  }


  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public Item getKey() {
    return key;
  }

  public void setKey(Item key) {
    this.key = key;
  }

  public Exam getExam() {
    return exam;
  }

  public void setExam(Exam exam) {
    this.exam = exam;
  }
}
