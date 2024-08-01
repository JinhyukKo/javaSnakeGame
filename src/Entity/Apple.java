package Entity;

import java.awt.*;
        import java.util.Random;
import domain.Configs;
public class Apple {
    Random random;
    static final int SCREEN_WIDTH = Configs.SCREEN_WIDTH;
    static final int SCREEN_HEIGHT = Configs.SCREEN_HEIGHT;
    static final int UNIT_SIZE = Configs.UNIT_SIZE;
    static final int DELAY= Configs.DELAY;
    static final int SNAKE_HEAD = Configs.SNAKE_HEAD;
    static final int GAME_UNITS = Configs.GAME_UNITS;

    public int getX() {
        return appleX;
    }

    public int getY() {
        return appleY;
    }

    int appleX;
    int appleY;
    public Apple(){
        random = new Random();
        generateNewApple();
    }
    public void generateNewApple(){
        appleX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    public void draw (Graphics g){
        g.setColor(Color.RED);
        g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
    }


}
