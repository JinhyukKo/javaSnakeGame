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

    Timer timer;
    GameController controller;




    public GamePanel(GameController controller){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.controller= controller;

        timer = new Timer(Configs.DELAY,this);
        timer.start();
        controller.startGame();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        drawLine(g);
        controller.getApple().draw(g);
        controller.getSnake().draw(g);
    }

    public void drawLine(Graphics g){
        for(int i =0 ; i < SCREEN_HEIGHT/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }

    }


    public void gameOver(Graphics g){

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
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(controller.getSnake().getDirection()!=Direction.RIGHT){
                        controller.getSnake().setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(controller.getSnake().getDirection()!=Direction.LEFT){
                        controller.getSnake().setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(controller.getSnake().getDirection()!=Direction.DOWN){
                        controller.getSnake().setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(controller.getSnake().getDirection()!=Direction.UP){
                        controller.getSnake().setDirection(Direction.DOWN);
                    }
                    break;

            }
        }
    }
}
