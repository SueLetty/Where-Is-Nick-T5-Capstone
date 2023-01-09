package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Exam;
import com.game.whereisnick.model.ImageImport;
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
import javax.swing.JTextArea;



public class GUIDetail extends JFrame implements ActionListener {

  private Game game;
  private Room currentRoom;

  private JPanel introPanel;

  private JPanel optionPanel;
  private JLabel imageLabel;
  private JPanel controllerPanel;
  private JTextArea introInfo;
  private ImageIcon image;
  private ImageIcon chad;
  private ImageIcon donte;
  private ImageIcon richard;
  private ImageIcon jeanette;
  private ImageIcon nelly;
  private ImageIcon nick;
  private ImageIcon scott;
  private ImageIcon shang;
  private ImageIcon tom;
  private ImageIcon love;

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

    introInfo = new JTextArea(15,50);
    introInfo.setLineWrap(true);
    introInfo.setEnabled(false);
    introInfo.setText(game.greetingFromJeanette());
    introInfo.setFont(new Font("MV Bole", Font.PLAIN, 14));
    introInfo.setOpaque(true);
    introInfo.setBounds(100, 10, 500, 480);
    introInfo.setVisible(true);
    introPanel.add(introInfo);

//    image = ImageImport.importIcon("images/love.png");
//    image = ImageImport.importIcon("images/smile.png");
    // TODO: 1/5/2023 This image needs to be dependant on what room.
//    image = ImageImport.importIcon("images/jeanette.jpg"); //need to be less than 32bit color depth.
    chad = ImageImport.importIcon("images/Chad_Gale.jpg");
    donte = ImageImport.importIcon("images/Donte_Tyrus.png");
    richard = ImageImport.importIcon("images/Hank_Richard.png");
    jeanette = ImageImport.importIcon("images/jeanette.jpg");
    nelly = ImageImport.importIcon("images/Nelly_Gus.jpg");
    nick = ImageImport.importIcon("images/Nick_Walter.jpg");
    scott = ImageImport.importIcon("images/Scott_Mike.jpg");
    shang = ImageImport.importIcon("images/Shang_Hector.jpg");
    tom = ImageImport.importIcon("images/Tom_Saul.jpg");
    love = ImageImport.importIcon("images/love.jpg");

    imageLabel = new JLabel();
    imageLabel.setIcon(jeanette);

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

    eastButton = new JButton("W");
    eastButton.setBounds(75, 125, 50, 50);
    eastButton.setFocusable(false);
    eastButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.moveTo(Direction.WEST);
        changeRoom();

      }
    });

    westButton = new JButton("E");
    westButton.setBounds(175, 125, 50, 50);
    westButton.setFocusable(false);
    westButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.moveTo(Direction.EAST);
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
    this.getContentPane().add(imageLabel);
    this.add(optionPanel);
    this.add(controllerPanel);

    this.setLocationRelativeTo(null);

  }

  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = (Graphics2D) g;

  }

  private void changeRoom() {

    if (currentRoom != null) {
//      if (!currentRoom.getName().equals("Java Room") || (
//          currentRoom.getName().equals("Java Room") && game.isFindNick() && game.isJavaKey())) {

      if (currentRoom.getName().equals("Lobby")) {
        introInfo.setText(game.greetingFromJeanette());
        setQuestion();


      } else if (currentRoom.getName().equals("HTML Room")) {
        imageLabel.setIcon(donte);
        imageLabel.revalidate();
        if(Exam.passHTML){
          introInfo.setText("You have passed HTML course.\n Go you different room.");
          introInfo.revalidate();
        }else{
          introInfo.setText(game.greetingFromDonte());
          setQuestion();
        }

      } else if (currentRoom.getName().equals("JavaScript Room") && Exam.passHTML) {
        imageLabel.setIcon(nelly);
        imageLabel.revalidate();
        if(Exam.passJs){
          introInfo.setText("You have passed JavaScript course.\n Go you different room.");
          introInfo.revalidate();
        }else {
          introInfo.setText(game.greetingFromNelly());
          setQuestion();
        }

      } else if (currentRoom.getName().equals("Python Room") && Exam.passJs) {
        imageLabel.setIcon(chad);
        imageLabel.revalidate();
        if(Exam.passPython){
          introInfo.setText("You have passed Python course.\n Go you different room.");
          introInfo.revalidate();
        }else {
          introInfo.setText(game.greetingFromChad());
          setQuestion();
        }
      } else if (currentRoom.getName().equals("Java Room") && Exam.passPython) {
        imageLabel.setIcon(love);
        imageLabel.revalidate();
        game.setWentToJavaWithoutNick(true);
        introInfo.setText(game.encryptedmessage() + "\nYou need to find Nick!");
        introInfo.revalidate();
      } else if (currentRoom.getName().equals("studyRoom Room") && Exam.passPython) {
        imageLabel.setIcon(nick);
        imageLabel.revalidate();
        if (game.isWentToJavaWithoutNick()) {
          introInfo.setText(game.greetingFromNick());
          game.getStudent().setLocation(game.getSchool().getRooms().get(5));
          currentRoom = game.getSchool().getRooms().get(5);
          setQuestion();
        } else {
          introInfo.setText("SHH...Nick is playing guitar.");
        }

      } else {
        JOptionPane.showMessageDialog(null, "You have to pass the exam first.", "Warning",
            JOptionPane.WARNING_MESSAGE);
      }

    } else {
      JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
          JOptionPane.WARNING_MESSAGE);
      optionInfo.setText("Try different direction!");
    }
  }

<<<<<<< Updated upstream
=======
  public void confirmTakingExam() {

    optionInfo.setText("Are you ready to take the exam?");
    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(300, 60, 100, 30);
    yesButton.setFocusable(false);
    yesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        yesButton.setVisible(false);
        setQuestion();
      }
    });
    optionPanel.add(optionInfo);
    optionPanel.setLayout(null);
    optionPanel.add(yesButton);
    optionPanel.revalidate();
    optionPanel.setVisible(true);

  }
  public void retakeExam(){
    optionInfo.setText("Do you want to re-take the exam?");
    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(300, 60, 100, 30);
    yesButton.setFocusable(false);
    yesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        yesButton.setVisible(false);
        setQuestion();
      }
    });
    optionPanel.add(optionInfo);
    optionPanel.setLayout(null);
    optionPanel.add(yesButton);
    optionPanel.revalidate();
    optionPanel.setVisible(true);
  }

>>>>>>> Stashed changes
  public void setQuestion() {
    northButton.setEnabled(false);
    southButton.setEnabled(false);
    eastButton.setEnabled(false);
    westButton.setEnabled(false);

    Exam.startQuiz(currentRoom);
    introPanel.add(introInfo);
    introPanel.revalidate();

    optionInfo.setText(Exam.question);
    answer1 = new JRadioButton();
    answer1.setText(Exam.answer1);
    answer1.setBounds(50, 50, 260, 30);

    answer1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
            Exam.answer1.substring(0, 1), Exam.actualAnswer);
        getQuestion();
      }
    });

    answer2 = new JRadioButton();
    answer2.setText(Exam.answer2);
    answer2.setBounds(50, 100, 260, 30);
//      answer2.revalidate();
    answer2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
            Exam.answer2.substring(0, 1), Exam.actualAnswer);
        getQuestion();
      }
    });
    answer3 = new JRadioButton();
    answer3.setText(Exam.answer3);
    answer3.setBounds(50, 150, 260, 30);
//      answer3.revalidate();
    answer3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
            Exam.answer3.substring(0, 1), Exam.actualAnswer);
        getQuestion();
      }
    });
    answer4 = new JRadioButton();
    answer4.setText(Exam.answer4);
    answer4.setBounds(50, 200, 260, 30);
//      answer4.revalidate();
    answer4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctAnswer = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctAnswer,
            Exam.answer4.substring(0, 1), Exam.actualAnswer);
        getQuestion();
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


  }

  public void getQuestion() {
    if (Exam.count < 5) {
      setQuestion();
    } else if (Exam.count == 5) {
      if (Exam.correctAnswer > 3) {
        switch (currentRoom.getName()) {
          case "HTML Room":
            Exam.passHTML = true;
            game.setHtmlKey(true);
            break;
          case "JavaScript Room":
            Exam.passJs = true;
            game.setJsKey(true);
            break;
          case "Python Room":
            Exam.passPython = true;
            game.setPythonKey(true);
            break;
          case "Java Room":
            Exam.passJava = true;
            game.setJavaKey(true);
            //todo take the player to the graduation page
            break;
        }
        JOptionPane.showMessageDialog(null,
            "You got " + Exam.correctAnswer + "/5. " + currentRoom.conclusionForPassingExam(),
            "Warning",
            JOptionPane.INFORMATION_MESSAGE);
        northButton.setEnabled(true);
        southButton.setEnabled(true);
        eastButton.setEnabled(true);
        westButton.setEnabled(true);
        introInfo.setText("Congratulations! You passed " + currentRoom.getName().substring(0,currentRoom.getName().length()-5));
        introInfo.revalidate();
        Exam.correctAnswer = 0;
        Exam.count = 0;
        optionPanel.setVisible(false);
      } else {
        Exam.correctAnswer = 0;
        Exam.count = 0;

        JOptionPane.showMessageDialog(null, currentRoom.conclusionForNotPassingExam(), "Warning",
            JOptionPane.INFORMATION_MESSAGE);
        retakeExam();
      }



    }
  }
  public void setImage() {
    switch (currentRoom.getName()) {
      case "HTML Room":
        image = ImageImport.importIcon("images/love.png");
        break;
      case "JavaScript Room":
        ImageImport.importIcon("images/love.png");
        break;
      case "Python Room":
        ImageImport.importIcon("images/love.png");
        break;
      case "Java Room":
        ImageImport.importIcon("images/love.png");
        break;

<<<<<<< Updated upstream
    }
  }
=======

>>>>>>> Stashed changes
  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
