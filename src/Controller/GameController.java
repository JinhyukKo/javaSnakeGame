package Controller;

import Entity.Apple;
import Entity.Snake;
import domain.Configs;
import domain.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameController
{
    Apple apple ;
    Snake snake;


    int score=0;




    boolean running = false;
    public GameController(){}


    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void startGame(){
        apple = new Apple();
        snake = new Snake();
        running = true;
    }
    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public Snake getSnake() {
        return snake;
    }
    public Apple getApple() {
        return apple;
    }
    public void checkApple(){
        if((snake.getHeadX() == apple.getX())&& (snake.getHeadY()== apple.getY())){
            score++;
            snake.increaseBodyParts();
            apple.generateNewApple();
        }
    }
    public boolean checkCollisions(){
//         check if head collides with body
        for(int i =snake.bodyParts; i>0; i--){
            if ((snake.getHeadX()==snake.getBodyX(i))&&(snake.getHeadY())==snake.getBodyY(i)){
                running = false;
            }
        }
        //check if head touches left border
        if(snake.getHeadX()<0||snake.getHeadX()> Configs.SCREEN_WIDTH||snake.getHeadY()<0 || snake.getHeadY() >Configs.SCREEN_WIDTH){
            running = false;
        }
       return running;
    }
    public void moveSnake(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if(snake.getDirection()!= Direction.RIGHT){
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
                    System.out.println("down");
                }
                break;

        }
    }

}
