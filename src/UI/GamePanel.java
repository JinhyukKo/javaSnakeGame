package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Controller.GameController;
import Entity.Apple;
import Entity.Snake;
import domain.Configs;

import domain.Direction;
public class GamePanel extends JPanel  implements ActionListener{

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




    public GamePanel(GameController controller){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.controller= controller;

        startGame();
    }
    private void startGame (){
        timer = new Timer(Configs.DELAY,this);
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
        }
        else {
            gameOver(g);
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
        SCORE_MSG = "Score : " + controller.getApplesEaten();
        g.drawString(SCORE_MSG,30,30);
    }
    private void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(GAME_OVER_MSG,(SCREEN_WIDTH-metrics.stringWidth(GAME_OVER_MSG) )/2,SCREEN_HEIGHT/2);

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,20));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString(SCORE_MSG,(SCREEN_WIDTH-metrics2.stringWidth(SCORE_MSG))/2,SCREEN_HEIGHT/4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(controller.isRunning()) {
            controller.getSnake().move();
            controller.checkApple();
            controller.checkCollisions();
            repaint();
        }
    }


    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            controller.moveSnake(e);

        }
    }
}
