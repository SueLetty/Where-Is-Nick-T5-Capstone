package com.game.whereisnick.view;

import com.game.whereisnick.controller.Game;
import com.game.whereisnick.model.Direction;
import com.game.whereisnick.model.Exam;
import com.game.whereisnick.model.ImageImport;
import com.game.whereisnick.model.Room;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;


public class GUIDetail extends JFrame implements ActionListener {

  private Game game;
  private Room currentRoom;
  private JPanel imagePanel;

  private JPanel introPanel;

  private JPanel optionPanel;
  private JLabel imageLabel;
  private JPanel controllerPanel;
  private JTextPane introInfo;
  private ImageIcon image;
  private ImageIcon chad;
  private ImageIcon donte;

  private ImageIcon jeanette;
  private ImageIcon nelly;
  private ImageIcon nick;


  private JTextPane optionInfo;

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
  private JRadioButton answer4 = new JRadioButton(){
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(new Color(255, 255, 255, 180));
      g.fillRect(0,0,getWidth(),getHeight());
      super.paintComponent(g);
    }
  };
  private boolean condition = false;
  private JTextArea examChoice1 = new JTextArea(25, 50){
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(new Color(255, 255, 255, 180));
      g.fillRect(0,0,getWidth(),getHeight());
      super.paintComponent(g);
    }
  };
  private JTextArea examChoice2 = new JTextArea(25, 50){
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(new Color(255, 255, 255, 180));
      g.fillRect(0,0,getWidth(),getHeight());
      super.paintComponent(g);
    }
  };
  private JTextArea examChoice3 = new JTextArea(25, 50){
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(new Color(255, 255, 255, 180));
      g.fillRect(0,0,getWidth(),getHeight());
      super.paintComponent(g);
    }
  };
  private JTextArea examChoice4 = new JTextArea(25, 50){
    @Override
    protected void paintComponent(Graphics g) {
      g.setColor(new Color(255, 255, 255, 180));
      g.fillRect(0,0,getWidth(),getHeight());
      super.paintComponent(g);
    }
  };
  private ButtonGroup group = new ButtonGroup();
  private static int musicPanelCount = 0;


  public GUIDetail(Game game) throws IOException, ParseException {
    this.game = game;

    imagePanel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        currentRoom = game.getStudent().getLocation();
        Image backgroundImage = ImageImport.importImage("images/backgrounds/lobby.jpg");
        if (currentRoom.getName().equals("Lobby")) {
          g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
        } else if (currentRoom.getName().equals("HTML Room")) {
          backgroundImage = ImageImport.importImage("images/backgrounds/html.jpg");
          g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
        } else if (currentRoom.getName().equals("JavaScript Room")) {
          backgroundImage = ImageImport.importImage("images/backgrounds/javascript.jpg");
          g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
        } else if (currentRoom.getName().equals("Python Room")) {
          backgroundImage = ImageImport.importImage("images/backgrounds/python.jpg");
          g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
        } else if (currentRoom.getName().equals("Java Room")) {
          backgroundImage = ImageImport.importImage("images/backgrounds/java.jpg");
          g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
        } else if (currentRoom.getName().equals("studyRoom Room")) {
          backgroundImage = ImageImport.importImage("images/backgrounds/studyroom.jpg");
          g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
        }
      }
    };
    imagePanel.setBounds(0, 0, 1000, 600);
    imagePanel.setVisible(true);

    introPanel = new JPanel(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255, 200));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    introPanel.setBounds(10, 10, 680, 300);
    introPanel.setBackground(new Color(255, 255, 255, 200));
    introPanel.setOpaque(false);
    introInfo = new JTextPane();
    introInfo.setText(game.greetingFromJeanette());
    introInfo.setFont(new Font("MV Bole", Font.PLAIN, 14));
    introInfo.setOpaque(false);
    introInfo.setBounds(100, 10, 500, 480);
    centerText(introInfo);
    introInfo.setEditable(false);
    introInfo.setVisible(true);
    introInfo.revalidate();
    introPanel.add(introInfo);

    chad = ImageImport.importIcon("images/resized/Chad_Gale.jpg", 280, 250);
    donte = ImageImport.importIcon("images/resized/Donte_Tyrus.png", 280, 250);
    jeanette = ImageImport.importIcon("images/resized/jeanette.jpg", 280, 250);
    nelly = ImageImport.importIcon("images/resized/Nelly_Gus.jpg", 280, 250);
    nick = ImageImport.importIcon("images/resized/Nick_Walter.jpg", 280, 250);

    imageLabel = new JLabel();
    imageLabel.setIcon(jeanette);

    imageLabel.setBounds(700, -5, 280, 280);
    imageLabel.setVisible(true);

    optionPanel = new JPanel(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255, 100));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    optionPanel.setBounds(10, 320, 680, 235);
    optionPanel.setBackground(new Color(255, 255, 255, 100));
    optionPanel.setOpaque(false);

    optionInfo = new JTextPane(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255, 200));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    optionInfo.setText("Using the direction buttons, accesses a different room.");
    optionInfo.setFont(new Font("MV Bole", Font.PLAIN, 14));
    optionInfo.setBounds(0, 10, 680, 30);
    optionInfo.setBackground(new Color(255, 255, 255, 200));
    optionInfo.setOpaque(false);
    centerText(optionInfo);
    optionInfo.setVisible(true);
    optionInfo.setEditable(false);
    optionPanel.setLayout(null);
    optionPanel.add(optionInfo);

    controllerPanel = new JPanel();
    controllerPanel.setBounds(700, 270, 280, 284);
    controllerPanel.setBackground(new Color(255, 255, 255, 100));

    mapButton = new JButton("Map");
    mapButton.setBounds(10, 10, 100, 30);
    mapButton.setFocusable(false);
    mapButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        ImageIcon map = ImageImport.importIcon("images/map.jpg", 711, 400);
        JOptionPane.showMessageDialog(null, null, "Map", JOptionPane.PLAIN_MESSAGE, map);
      }
    });

    helpButton = new JButton("Help");
    helpButton.setBounds(175, 10, 100, 30);
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
    musicButton.setBounds(175, 250, 100, 30);
    musicButton.setFocusable(false);
    musicButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (musicPanelCount == 0) {
          musicPanelCount++;
          SwingUtilities.invokeLater(musicWindow());
        }
      }
    });

    northButton = new JButton("N");
    northButton.setBounds(115, 75, 50, 50);
    northButton.setFocusable(false);
    northButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.getStudent().getLocation();
        if (currentRoom.getName().equals("Lobby")) {
          currentRoom = game.moveTo(Direction.NORTH);
          changeRoom();
        } else if (currentRoom.getName().equals("HTML Room") && game.isHtmlKey()) {
          currentRoom = game.moveTo(Direction.NORTH);
          changeRoom();
        } else if (currentRoom.getName().equals("Java Room")) {
          currentRoom = game.moveTo(Direction.NORTH);
          changeRoom();
        } else if (currentRoom.getName().equals("JavaScript Room")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else if (currentRoom.getName().equals("Python Room")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else if (currentRoom.getName().equals("studyRoom Room")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "You need to pass the exam first!", "Warning",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    southButton = new JButton("S");
    southButton.setBounds(115, 175, 50, 50);
    southButton.setFocusable(false);
    southButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.getStudent().getLocation();
        if (currentRoom.getName().equals("Lobby")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else if (currentRoom.getName().equals("HTML Room")) {
          currentRoom = game.moveTo(Direction.SOUTH);
          changeRoom();
        } else if (currentRoom.getName().equals("JavaScript Room")) {
          currentRoom = game.moveTo(Direction.SOUTH);
          changeRoom();
        } else if (currentRoom.getName().equals("Python Room") && game.isHtmlKey() && game.isJsKey()
            && game.isPythonKey()) {
          currentRoom = game.moveTo(Direction.SOUTH);
          changeRoom();
        } else if (currentRoom.getName().equals("Java Room")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else if (currentRoom.getName().equals("studyRoom Room")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "You need to pass the exam first!", "Warning",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    westButton = new JButton("W");
    westButton.setBounds(65, 125, 50, 50);
    westButton.setFocusable(false);
    westButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.getStudent().getLocation();

        if (currentRoom.getName().equals("Python Room")) {
          currentRoom = game.moveTo(Direction.WEST);
          changeRoom();
        } else if (currentRoom.getName().equals("Java Room")) {
          currentRoom = game.moveTo(Direction.WEST);
          changeRoom();
        } else if (currentRoom.getName().equals("studyRoom Room")) {
          currentRoom = game.moveTo(Direction.WEST);
          changeRoom();
        } else {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    eastButton = new JButton("E");
    eastButton.setBounds(165, 125, 50, 50);
    eastButton.setFocusable(false);
    eastButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        currentRoom = game.getStudent().getLocation();
        if (currentRoom.getName().equals("Lobby")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else if (currentRoom.getName().equals("HTML Room") && game.isHtmlKey() && game.isJsKey()
            && game.isPythonKey()) {
          currentRoom = game.moveTo(Direction.EAST);
          changeRoom();
        } else if (currentRoom.getName().equals("JavaScript Room") && game.isHtmlKey()
            && game.isJsKey()) {
          currentRoom = game.moveTo(Direction.EAST);
          changeRoom();
        } else if (currentRoom.getName().equals("Python Room") && game.isHtmlKey() && game.isJsKey()
            && game.isPythonKey()) {
          currentRoom = game.moveTo(Direction.EAST);
          changeRoom();
        } else if (currentRoom.getName().equals("Java Room")) {
          JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
              JOptionPane.WARNING_MESSAGE);
        } else {
          if (currentRoom.getName().equals("HTML Room")) {
            JOptionPane.showMessageDialog(null, "You need to pass three exams first!", "Warning",
                JOptionPane.WARNING_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null, "You need to pass the exam first!", "Warning",
                JOptionPane.WARNING_MESSAGE);
          }

        }
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

    imagePanel.setLayout(null);
    imagePanel.add(introPanel);
    imagePanel.add(imageLabel);
    imagePanel.add(optionPanel);
    imagePanel.add(controllerPanel);

    this.setTitle("Where is Nick");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setResizable(false);
    this.setSize(1000, 600);
    this.setLayout(null);
    this.add(imagePanel);
    this.setVisible(true);

    this.setLocationRelativeTo(imagePanel);

  }

  /**
   * Runnable to display and control audio.
   *
   * @return null
   */
  public Runnable musicWindow() {
    MusicPanel musicPanel = new MusicPanel();
    if (game.getMusicObject().isSoundOn()) {
      musicPanel.getMuteMusicButton().setText("Mute Music");
    } else {
      musicPanel.getMuteMusicButton().setText("Unmute Music");
    }
    if (Exam.audio.isMutedAudio()) {
      musicPanel.getMuteAudioButton().setText("Unmute SFX");
    } else {
      musicPanel.getMuteAudioButton().setText("Mute SFX");
    }

    musicPanel.getMuteMusicButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Press the mute/unmute.");
        if (game.getMusicObject().isSoundOn()) {
          game.getMusicObject().stopMusic();
          musicPanel.getMuteMusicButton().setText("Unmute Music");
        } else {
          game.getMusicObject().turnSoundOn();
          musicPanel.getMuteMusicButton().setText("Mute Music");
        }
      }
    });

    musicPanel.getMuteAudioButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Press the mute/unmute.");
        if (Exam.audio.isMutedAudio()) {
          Exam.audio.setMutedAudio(false);
          musicPanel.getMuteAudioButton().setText("Mute SFX");
          System.out.println("Is muted? " + Exam.audio.isMutedAudio());
        } else {
          Exam.audio.setMutedAudio(true);
          musicPanel.getMuteAudioButton().setText("Unmute SFX");
          System.out.println("Is muted? " + Exam.audio.isMutedAudio());
        }
      }
    });

    musicPanel.getIncreaseVolumeButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.getMusicObject().increaseVolume();
        System.out.println("Music volume increased.");
      }
    });

    musicPanel.getDecreaseVolumeButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.getMusicObject().decreaseVolume();
        System.out.println("Music volume decreased.");
      }
    });

    return null;
  }

  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
  }
  private void centerText(JTextPane textPane){
    StyledDocument doc = textPane.getStyledDocument();
    SimpleAttributeSet center1 = new SimpleAttributeSet();
    StyleConstants.setAlignment(center1, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center1, false);
  }

  private void changeRoom() {
    if (currentRoom != null) {

      if (currentRoom.getName().equals("Lobby")) {
        introInfo.setText(game.greetingFromJeanette());

      } else if (currentRoom.getName().equals("HTML Room")) {

        imageLabel.setIcon(donte);
        if (Exam.passHTML) {
          introInfo.setText("You have passed HTML course.\n Go you different room.");
          introInfo.setOpaque(false);
          introInfo.revalidate();
          optionPanel.removeAll();
          optionPanel.revalidate();
          repaint();
        } else {
          introInfo.setText(game.greetingFromDonte());
          confirmTakingExam(currentRoom);
          update(getGraphics());
        }

      } else if (currentRoom.getName().equals("JavaScript Room") && Exam.passHTML) {
        imageLabel.setIcon(nelly);
        if (Exam.passJs) {
          introInfo.setText("You have passed JavaScript course.\n Go you different room.");
          introInfo.setOpaque(false);
          introInfo.revalidate();
          optionPanel.removeAll();
          optionPanel.revalidate();
          repaint();
        } else {
          introInfo.setText(game.greetingFromNelly());
          confirmTakingExam(currentRoom);
          update(getGraphics());
        }

      } else if (currentRoom.getName().equals("Python Room") && Exam.passJs) {
        imageLabel.setIcon(chad);
        imageLabel.setVisible(true);
        if (Exam.passPython) {
          introInfo.setText("You have passed Python course.\n Go you different room.");
          introInfo.setOpaque(false);
          introInfo.revalidate();
          optionPanel.removeAll();
          optionPanel.revalidate();
          repaint();
        } else {
          introInfo.setText(game.greetingFromChad());
          confirmTakingExam(currentRoom);
          update(getGraphics());
        }
      } else if (currentRoom.getName().equals("Java Room") && Exam.passPython) {
        imageLabel.setIcon(null);
        imageLabel.setVisible(false);
        imageLabel.revalidate();
        game.setWentToJavaWithoutNick(true);
        introInfo.setText(game.encryptedmessage() + "\nYou need to find Nick!");
        introInfo.revalidate();
        repaint();
        update(getGraphics());

      } else if (currentRoom.getName().equals("studyRoom Room") && Exam.passPython) {
        imageLabel.setIcon(nick);
        imageLabel.setVisible(true);
        if (game.isWentToJavaWithoutNick()) {
          introInfo.setText(game.greetingFromNick());
          confirmTakingExam(game.getSchool().getRooms().get(5));
          update(getGraphics());

        } else {
          introInfo.setText("SHH...Nick is playing guitar.");
          repaint();
          update(getGraphics());
        }

      } else {
        JOptionPane.showMessageDialog(null, "You need to pass the exam first!", "Warning",
            JOptionPane.WARNING_MESSAGE);
      }

    } else {
      JOptionPane.showMessageDialog(null, game.getNO_DIRECTION_MESSAGE(), "Warning",
          JOptionPane.WARNING_MESSAGE);

    }
  }


  public void confirmTakingExam(Room current) {

    optionInfo.setText("Are you ready to take the exam?");
    optionInfo.setBackground(new Color(255, 255, 255, 200));
    optionInfo.revalidate();
    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(300, 60, 100, 30);
    yesButton.setFocusable(false);
    yesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        yesButton.setVisible(false);
        optionPanel.removeAll();
        optionPanel.revalidate();
        setQuestion(current);
      }
    });
    optionPanel.setLayout(null);
    optionPanel.add(optionInfo);
    optionPanel.add(yesButton);
    optionPanel.setVisible(true);
    repaint();

  }

  public void retakeExam(Room current) {

    optionInfo.setText("Do you want to re-take the exam?");
    optionInfo.setBackground(new Color(255, 255, 255, 200));
    optionInfo.revalidate();
    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(300, 60, 100, 30);
    yesButton.setFocusable(false);
    yesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        yesButton.setVisible(false);
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        eastButton.setEnabled(false);
        westButton.setEnabled(false);
        setQuestion(current);
      }
    });

    optionPanel.removeAll();
    optionPanel.revalidate();
    optionPanel.add(optionInfo);
    optionPanel.setLayout(null);
    optionPanel.add(yesButton);
    optionPanel.revalidate();
    optionPanel.setVisible(true);
    repaint();
  }

  public void setQuestion(Room current) {
    northButton.setEnabled(false);
    southButton.setEnabled(false);
    westButton.setEnabled(false);
    eastButton.setEnabled(false);

    Exam.startQuiz(current);
    group.clearSelection();

    optionInfo.setText(Exam.question);
    optionInfo.setBackground(new Color(255, 255, 255, 200));
    optionInfo.revalidate();
    repaint();

    answer1 = new JRadioButton(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    answer1.setOpaque(false);
    answer1.setText("A:");
    answer1.setBounds(50, 50, 40, 30);

    answer1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctCount = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctCount,
            Exam.answer1.substring(0, 1), Exam.actualAnswer);
        getQuestion(current);
      }
    });

    answer2 = new JRadioButton(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    answer2.setOpaque(false);
    answer2.setText("B:");
    answer2.setBounds(50, 100, 40, 30);
    answer2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctCount = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctCount,
            Exam.answer2.substring(0, 1), Exam.actualAnswer);
        getQuestion(current);
      }
    });
    answer3 = new JRadioButton(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    answer3.setOpaque(false);
    answer3.setText("C:");
    answer3.setBounds(50, 150, 40, 30);
    answer3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctCount = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctCount,
            Exam.answer3.substring(0, 1), Exam.actualAnswer);
        getQuestion(current);
      }
    });
    answer4 = new JRadioButton(){
      @Override
      protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
      }
    };
    answer4.setOpaque(false);
    answer4.setText("D:");
    answer4.setBounds(50, 200, 40, 30);
    answer4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Exam.correctCount = Exam.checkCorrectAnswerAndReturnCounter(Exam.correctCount,
            Exam.answer4.substring(0, 1), Exam.actualAnswer);
        getQuestion(current);
      }
    });

    drawExamChoices(90, 50);

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
    optionPanel.add(examChoice1);
    optionPanel.add(examChoice2);
    optionPanel.add(examChoice3);
    optionPanel.add(examChoice4);
    optionPanel.setVisible(true);
    optionPanel.revalidate();
    repaint();

  }

  /**
   * Fills the data for JTextAreas for exam options. y coordinate is added 50 for spacing.
   *
   * @param x int coordinate to first string choice.
   * @param y int coordinate for first choice option.
   */
  private void drawExamChoices(int x, int y) {
    int opacity = 180;
    examChoice1.setLineWrap(true);
    examChoice1.setEnabled(false);
    examChoice1.setFont(new Font("MV Bole", Font.PLAIN, 14));
    examChoice1.setDisabledTextColor(Color.black);
    examChoice1.setBounds(x, y, 550, 30);
    examChoice1.setVisible(true);
    examChoice1.setText(Exam.answer1.substring(3));
    examChoice1.setBackground(new Color(255, 255, 255, opacity));
    examChoice1.setOpaque(false);

    examChoice2.setLineWrap(true);
    examChoice2.setEnabled(false);
    examChoice2.setFont(new Font("MV Bole", Font.PLAIN, 14));
    examChoice2.setDisabledTextColor(Color.black);
    examChoice2.setBounds(x, y + 50, 550, 30);
    examChoice2.setVisible(true);
    examChoice2.setText(Exam.answer2.substring(3));
    examChoice2.setBackground(new Color(255, 255, 255, opacity));
    examChoice2.setOpaque(false);

    examChoice3.setLineWrap(true);
    examChoice3.setEnabled(false);
    examChoice3.setFont(new Font("MV Bole", Font.PLAIN, 14));
    examChoice3.setDisabledTextColor(Color.black);
    examChoice3.setBounds(x, y + 100, 550, 30);
    examChoice3.setVisible(true);
    examChoice3.setText(Exam.answer3.substring(3));
    examChoice3.setBackground(new Color(255, 255, 255, opacity));
    examChoice3.setOpaque(false);

    examChoice4.setLineWrap(true);
    examChoice4.setEnabled(false);
    examChoice4.setFont(new Font("MV Bole", Font.PLAIN, 14));
    examChoice4.setDisabledTextColor(Color.black);
    examChoice4.setBounds(x, y + 150, 550, 30);
    examChoice4.setVisible(true);
    examChoice4.setText(Exam.answer4.substring(3));
    examChoice4.setBackground(new Color(255, 255, 255, opacity));
    examChoice4.setOpaque(false);

  }

  public void getQuestion(Room currentRoom) {
    if (Exam.count < 5) {
      setQuestion(currentRoom);
    } else if (Exam.count == 5) {
      if (Exam.correctCount > 3) {
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
            break;
        }
        JOptionPane.showMessageDialog(null,
            "You got " + Exam.correctCount + "/5. " + currentRoom.conclusionForPassingExam(),
            "Warning",
            JOptionPane.INFORMATION_MESSAGE);
        northButton.setEnabled(true);
        southButton.setEnabled(true);
        eastButton.setEnabled(true);
        westButton.setEnabled(true);
        introInfo.setText("Congratulations! You passed " + currentRoom.getName()
            .substring(0, currentRoom.getName().length() - 5));
        introInfo.setOpaque(false);
        repaint();

        Exam.correctCount = 0;
        Exam.count = 0;
        optionPanel.removeAll();
        optionPanel.revalidate();
        repaint();
        if (game.isJavaKey() && Exam.passJava) {
          this.dispose();
          new GraduationPanel();
        }

      } else {
        Exam.correctCount = 0;
        Exam.count = 0;

        JOptionPane.showMessageDialog(null, currentRoom.conclusionForNotPassingExam(), "Warning",
            JOptionPane.INFORMATION_MESSAGE);
        retakeExam(currentRoom);
      }

    }
  }

  public static int getMusicPanelCount() {
    return musicPanelCount;
  }

  public static void setMusicPanelCount(int count) {
    musicPanelCount = count;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}