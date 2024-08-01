import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import Entity.Apple;
import Entity.Snake;


import domain.Direction;
public class GamePanel extends JPanel  implements ActionListener{
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int DELAY= 75;
    static final int SNAKE_HEAD = 0;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;


    int applesEaten=0;
    boolean running = false;
    Timer timer;

    Apple apple ;
    Snake snake;




    GamePanel(){
//        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        apple = new Apple(SCREEN_WIDTH,SCREEN_HEIGHT,UNIT_SIZE);
        snake = new Snake(UNIT_SIZE,GAME_UNITS);
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        drawLine(g);
        apple.draw(g,UNIT_SIZE);
        snake.draw(g,UNIT_SIZE);
    }

    public void drawLine(Graphics g){
        for(int i =0 ; i < SCREEN_HEIGHT/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }

    }

    public void checkApple(){

    }
    public void checkCollisions(){
        // check if head collides with body
//        for(int i =bodyParts; i>0; i--){
//            if ((x[0]==x[i])&&(y[0]==y[i])){
//                running = false;
//            }
//        }
//        //check if head touches left border
//        if(x[SNAKE_HEAD]<0||x[SNAKE_HEAD]>SCREEN_WIDTH|| y[SNAKE_HEAD] <0 || y[SNAKE_HEAD] >SCREEN_WIDTH){
//            running = false;
//        }
//        if(!running){
//            timer.stop();
//        }


    }
    public void gameOver(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            snake.move();
            checkApple();
            checkCollisions();
            repaint();
        }


    }


    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(snake.getDirection()!=Direction.RIGHT){
                        snake.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(snake.getDirection()!=Direction.LEFT){
                        snake.setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(snake.getDirection()!=Direction.DOWN){
                        snake.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(snake.getDirection()!=Direction.UP){
                        snake.setDirection(Direction.DOWN);
                    }
                    break;

            }
        }
    }
}
