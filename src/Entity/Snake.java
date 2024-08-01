package Entity;


import java.awt.*;
import domain.Direction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Snake   {
    static final int SNAKE_HEAD = 0;
    static final int bodyParts = 6;
    int GAME_UNITS;
    int[] x;
    int[] y;
    int UNIT_SIZE;
    Direction direction;
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    public Snake(int UNIT_SIZE, int GAME_UNITS) {
        direction = Direction.RIGHT;
        this.GAME_UNITS = GAME_UNITS;
        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];
        this.UNIT_SIZE = UNIT_SIZE;
    }


    public void draw(Graphics g, int UNIT_SIZE) {
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
