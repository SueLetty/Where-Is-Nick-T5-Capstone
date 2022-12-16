package com.game.whereisnick.model;

import java.util.ArrayList;

public class Room {
  private String name;
  private String description;
  private Room nRoom;
  private Room sRoom;
  private Room wRoom;
  private Room eRoom;
  private Instructor instructor;
  private Item key;
  private Exam exam;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Room(String name) {
    this.name = name;
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

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Room getnRoom() {
    return nRoom;
  }

  public void setnRoom(Room nRoom) {
    this.nRoom = nRoom;
  }

  public Room getsRoom() {
    return sRoom;
  }

  public void setsRoom(Room sRoom) {
    this.sRoom = sRoom;
  }

  public Room getwRoom() {
    return wRoom;
  }

  public void setwRoom(Room wRoom) {
    this.wRoom = wRoom;
  }

  public Room geteRoom() {
    return eRoom;
  }

  public void seteRoom(Room eRoom) {
    this.eRoom = eRoom;
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
