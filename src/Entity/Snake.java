package Entity;


import java.awt.*;
import domain.Configs;
import domain.Direction;

public class Snake   {
    static final int SCREEN_WIDTH = Configs.SCREEN_WIDTH;
    static final int SCREEN_HEIGHT = Configs.SCREEN_HEIGHT;
    static final int UNIT_SIZE = Configs.UNIT_SIZE;
    static final int DELAY= Configs.DELAY;
    static final int SNAKE_HEAD = Configs.SNAKE_HEAD;
    static final int GAME_UNITS = Configs.GAME_UNITS;


    public int bodyParts = 6;
    int[] x;
    int[] y;
    Direction direction;
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public int getBodyParts() {
        return bodyParts;
    }

    public void increaseBodyParts() {
        this.bodyParts++;
    }
    public int getHeadX(){
        return x[SNAKE_HEAD];
    }
    public int getHeadY(){
        return y[SNAKE_HEAD];
    }
    public int getBodyX(int i){
        return x[i];
    }
    public int getBodyY(int i){
        return y[i];
    }
    public Snake() {
        direction = Direction.RIGHT;
        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];

    }


    public void draw(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == SNAKE_HEAD) {
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                System.out.println("repaint");
            } else {
                g.setColor(Color.BLUE);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case UP:
                y[SNAKE_HEAD] = y[SNAKE_HEAD] - UNIT_SIZE;
                break;
            case DOWN:
                y[SNAKE_HEAD] = y[SNAKE_HEAD] + UNIT_SIZE;
                break;
            case LEFT:
                x[SNAKE_HEAD] = x[SNAKE_HEAD] - UNIT_SIZE;
                break;
            case RIGHT:
                x[SNAKE_HEAD] = x[SNAKE_HEAD] + UNIT_SIZE;
//                System.out.println("Right");
                break;
        }
    }


}
