package Controller;

import Entity.Apple;
import Entity.Snake;
import domain.Configs;

import javax.swing.*;

public class GameController
{


    Apple apple ;
    Snake snake;


    int applesEaten=0;
    boolean running = false;
    public GameController(){}

    public void startGame(){
        apple = new Apple();
        snake = new Snake();
        running = true;

    }
    public Snake getSnake() {
        return snake;
    }
    public Apple getApple() {
        return apple;
    }
    public void checkApple(){
        if((snake.getHeadX() == apple.getX())&& (snake.getHeadY()== apple.getY())){
            applesEaten++;
            snake.increaseBodyParts();
            apple.generateNewApple();
        }
    }
    public void checkCollisions(){
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
//        if(!running){
//            timer.stop();
//        }
    }
    public boolean isRunning() {
        return running;
    }
}
