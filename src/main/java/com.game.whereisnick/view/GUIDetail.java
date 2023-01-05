package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Exam;
import com.game.whereisnick.model.Room;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class GUIDetail extends JFrame implements ActionListener {

  private Game game;
  private Exam exam;
  private Room currentRoom;


  private JPanel introPanel;

  private JPanel optionPanel;
  private JLabel imageLabel;
  private JPanel controllerPanel;
  private JLabel introInfo;
  private ImageIcon image;
  private JLabel optionInfo;

  private JButton mapButton;
  private JButton helpButton;
  private JButton quitButton;
  private JButton musicButton;
  private JButton northButton;
  private JButton southButton;
  private JButton eastButton;
  private JButton westButton;
  private JRadioButton answer1 = new JRadioButton();
  private JRadioButton answer2 = new JRadioButton();
  private JRadioButton answer3 = new JRadioButton();
  private JRadioButton answer4 = new JRadioButton();
  private boolean condition = false;

  public GUIDetail(Game game) throws IOException, ParseException {
    this.game = game;

    introPanel = new JPanel();
    introPanel.setBackground(Color.red);
    introPanel.setBounds(10, 10, 680, 300);

    introInfo = new JLabel(game.greetingFromJeanette());
    introInfo.setFont(new Font("MV Bole", Font.PLAIN, 14));
    introInfo.setOpaque(true);
    introInfo.setBounds(10, 10, 660, 4280);
    introInfo.setVisible(true);
    introPanel.add(introInfo);

    image = new ImageIcon("resources/love.png");
    imageLabel = new JLabel();
    imageLabel.setIcon(image);
    imageLabel.setBackground(Color.BLUE);
    imageLabel.setBounds(700, -10, 280, 280);
    imageLabel.setVisible(true);

    optionPanel = new JPanel();
    optionPanel.setBackground(Color.green);
    optionPanel.setBounds(10, 320, 680, 300);

    optionInfo = new JLabel("Using Direction button go to a different room.");
    optionInfo.setVerticalAlignment(JLabel.CENTER);
    optionInfo.setFont(new Font("MV Bole", Font.PLAIN, 14));
    optionInfo.setOpaque(true);
    optionInfo.setBounds(10, 10, 660, 4280);
    optionInfo.setVisible(true);
    optionPanel.add(optionInfo);

    controllerPanel = new JPanel();
    controllerPanel.setBackground(Color.yellow);
    controllerPanel.setBounds(700, 270, 300, 300);

    mapButton = new JButton("Map");
    mapButton.setBounds(10, 10, 100, 30);
    mapButton.setFocusable(false);
    mapButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, game.getMap(), "Map", JOptionPane.PLAIN_MESSAGE);
      }
    });

    helpButton = new JButton("Help");
    helpButton.setBounds(180, 10, 100, 30);
    helpButton.setFocusable(false);
    helpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, game.commandList(), "Help", JOptionPane.PLAIN_MESSAGE);
      }
    });

    quitButton = new JButton("Quit");
    quitButton.setBounds(10, 250, 100, 30);
    quitButton.setFocusable(false);
    quitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String[] responses = {"Yes", "No"};
        int reply = JOptionPane.showOptionDialog(null,
            "Are you sure",
            "Quit", JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);
        if (reply == JOptionPane.YES_OPTION) {
          JOptionPane.showMessageDialog(null, "GoodBye!");
          System.exit(0);
        }


      }
    });

    musicButton = new JButton("Music");
    musicButton.setBounds(180, 250, 100, 30);
    musicButton.setFocusable(false);
    musicButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (game.getMusicObject().isSoundOn()) {
          game.getMusicObject().stopMusic();
        } else {
          game.getMusicObject().turnSoundOn();
        }
      }
    });

    northButton = new JButton("N");
    northButton.setBounds(125, 75, 50, 50);
    northButton.setFocusable(false);
    northButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.moveTo(Direction.NORTH);
        changeRoom();
      }
    });

    southButton = new JButton("S");
    southButton.setBounds(125, 175, 50, 50);
    southButton.setFocusable(false);
    southButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.moveTo(Direction.SOUTH);
        changeRoom();
      }
    });

    eastButton = new JButton("E");
    eastButton.setBounds(75, 125, 50, 50);
    eastButton.setFocusable(false);
    eastButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.moveTo(Direction.EAST);
        changeRoom();
      }
    });

    westButton = new JButton("W");
    westButton.setBounds(175, 125, 50, 50);
    westButton.setFocusable(false);
    westButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.moveTo(Direction.WEST);
        changeRoom();
      }
    });

    controllerPanel.setLayout(null);

    controllerPanel.add(helpButton);
    controllerPanel.add(mapButton);
    controllerPanel.add(quitButton);
    controllerPanel.add(musicButton);
    controllerPanel.add(northButton);
    controllerPanel.add(southButton);
    controllerPanel.add(eastButton);
    controllerPanel.add(westButton);

    this.setTitle("Where is Nick");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setResizable(false);
    this.setSize(1000, 600);

    this.setVisible(true);
    this.add(introPanel);
    this.add(imageLabel);
    this.add(optionPanel);
    this.add(controllerPanel);

    this.setLocationRelativeTo(null);

  }

  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = (Graphics2D) g;

  }

  public static void main(String[] args) throws IOException, ParseException {
    new GUIDetail(new Game());
  }

  private void changeRoom() {
    if (currentRoom != null && (!currentRoom.getName().equals("Java Room")
        || currentRoom.getName().equals("Java Room") && Exam.passPython && game.isJavaKey()
        && game.isFindNick())) {

      if (currentRoom.equals(game.getSchool().getRooms().get(0))) {
        introInfo.setText(game.greetingFromJeanette());
        setQuestion();


      } else if (currentRoom.equals(game.getSchool().getRooms().get(1))) {
        introInfo.setText(game.greetingFromDonte());
        setQuestion();


      } else if (currentRoom.equals(game.getSchool().getRooms().get(2)) && Exam.passHTML) {
        introInfo.setText(game.greetingFromNelly());
        setQuestion();


      } else if (currentRoom.equals(game.getSchool().getRooms().get(3)) && Exam.passJs) {
        introInfo.setText(game.greetingFromChad());
        setQuestion();


      } else if (currentRoom.equals(game.getSchool().getRooms().get(4)) && Exam.passPython) {
        introInfo.setText(game.greetingFromNick());
        setQuestion();


      } else {
        JOptionPane.showMessageDialog(null, "You need to passed exam first!", "Warning",
            JOptionPane.WARNING_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
          JOptionPane.WARNING_MESSAGE);
    }
  }

  public void setQuestion() {
    do {
    introPanel.add(introInfo);
    introPanel.revalidate();

      condition = false;
      Exam.startQuiz(currentRoom);
      optionInfo.setText(Exam.question);
      optionInfo.revalidate();
      answer1.setText(Exam.answer1);
      answer1.setBounds(50, 50, 270, 30);
      answer1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
              Exam.answer1.substring(0, 1), Exam.actualAnswer);
          condition = true;

        }
      });

      answer2.setText(Exam.answer2);
      answer2.setBounds(50, 100, 270, 30);
      answer2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
              Exam.answer2.substring(0, 1), Exam.actualAnswer);
          condition = true;

        }
      });

      answer3.setText(Exam.answer3);
      answer3.setBounds(50, 150, 270, 30);
      answer3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
              Exam.answer3.substring(0, 1), Exam.actualAnswer);
          condition = true;
        }
      });

      answer4.setText(Exam.answer4);
      answer4.setBounds(50, 200, 270, 30);
      answer4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
              Exam.answer4.substring(0, 1), Exam.actualAnswer);
          condition = true;
        }

      });

      ButtonGroup group = new ButtonGroup();
      group.add(answer1);
      group.add(answer2);
      group.add(answer3);
      group.add(answer4);

      optionPanel.add(optionInfo);
      optionPanel.setLayout(null);
      optionPanel.add(answer1);
      optionPanel.add(answer2);
      optionPanel.add(answer3);
      optionPanel.add(answer4);
      optionPanel.setVisible(true);
      optionPanel.revalidate();

    } while (Exam.count < 5 && condition);

    if (Exam.count == 5 && Exam.correctAnswer > 3) {
      if (currentRoom.getName().equals("HTML Room")) {
        Exam.passHTML = true;
      } else if (currentRoom.getName().equals("JavaScript Room")) {
        Exam.passJs = true;
      } else if (currentRoom.getName().equals("Python Room")) {
        Exam.passPython = true;
      } else if (currentRoom.getName().equals("JavaRoom")) {
        Exam.passJava = true;
      }
      optionInfo.setText("You passed ");
      optionInfo.revalidate();
    } else if (Exam.count == 5 && Exam.correctAnswer <= 3) {
      Exam.correctAnswer = 0;
      Exam.count = 0;
      optionInfo.setText(currentRoom.conclusionForNotPassingExam());
      optionPanel.remove(answer1);
      optionPanel.remove(answer2);
      optionPanel.remove(answer3);
      optionPanel.remove(answer4);
      optionPanel.revalidate();
      Exam.startQuiz(currentRoom);
    } else {

    }

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
