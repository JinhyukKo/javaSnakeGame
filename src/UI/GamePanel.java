package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Controller.GameController;
import Entity.Apple;
import Entity.Snake;
import domain.Configs;

import domain.Direction;
import domain.Mode;

public class GamePanel extends JPanel  implements ActionListener, Mode {

    static final int SCREEN_WIDTH = Configs.SCREEN_WIDTH;
    static final int SCREEN_HEIGHT = Configs.SCREEN_HEIGHT;
    static final int UNIT_SIZE = Configs.UNIT_SIZE;
    static final int DELAY= Configs.DELAY;
    static final int SNAKE_HEAD = Configs.SNAKE_HEAD;
    static final int GAME_UNITS = Configs.GAME_UNITS;

    String SCORE_MSG = "Score : " + 0;

    final String GAME_OVER_MSG = "Game Over";
    Timer timer;
    GameController controller;
    MainPanel mainPanel;
    JButton button ;


    public GamePanel(MainPanel mainPanel,GameController controller){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.controller= controller;
        this.mainPanel=mainPanel;
        button = new JButton("Redo");
        timer = new Timer(Configs.DELAY,this);
    }
    void startGame (){
        mainPanel.switchToGamePanel();
        timer.start();
        controller.startGame();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(controller.isRunning()){
            drawLine(g);
            controller.getApple().draw(g);
            controller.getSnake().draw(g);
            drawScore(g);
            button.setVisible(false);

        }
        else {
            drawGameOver(g);
            drawRedoButton();
        }

    }

    private void drawLine(Graphics g){
        g.setColor(Color.darkGray);
        for(int i =0 ; i < SCREEN_HEIGHT/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }
    }

    private void drawScore(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        SCORE_MSG = "Score : " + controller.getScore();
        g.drawString(SCORE_MSG,30,30);
    }
    private void drawGameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(GAME_OVER_MSG,(SCREEN_WIDTH-metrics.stringWidth(GAME_OVER_MSG) )/2,SCREEN_HEIGHT/2);

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,20));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString(SCORE_MSG,(SCREEN_WIDTH-metrics2.stringWidth(SCORE_MSG))/2,SCREEN_HEIGHT/4);




    }
    private void drawRedoButton(){
        button.setVisible(true);
        button.setFont(new Font("new Ink",Font.BOLD,30));
        FontMetrics buttonMetrics = button.getFontMetrics(button.getFont());
        int buttonWidth = buttonMetrics.stringWidth(button.getText()) +50; // Adding some padding
        int buttonHeight = buttonMetrics.getHeight(); // Adding some padding
        button.setBounds((Configs.SCREEN_WIDTH - buttonWidth) / 2,
                (Configs.SCREEN_HEIGHT - buttonHeight) / 4 *3 ,
                Configs.SCREEN_WIDTH, buttonHeight);
        button.addActionListener(this);
        button.setSize(new Dimension(buttonWidth,buttonHeight));
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false); // Removes background
        button.setBorderPainted(false); // Removes border
        button.setOpaque(false); // Ensures opacity is turned off
        this.add(button);
    }
//    private void drawGameStart
    @Override
    public void actionPerformed(ActionEvent e) {
        if(controller.isRunning()) {
            controller.getSnake().move();
            controller.checkApple();
            if(!controller.checkCollisions()){
                timer.stop();
            };
            repaint();
        } if(e.getSource()==button){
            System.out.println("hello");
            controller.setScore(0);
            startGame();
        }
    }


    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            controller.moveSnake(e);

        }
    }
}
