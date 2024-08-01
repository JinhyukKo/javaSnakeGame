package Entity;

import java.awt.*;
import java.util.Random;

public class Apple {
    Random random;
    int appleX;
    int appleY;
    public Apple(int SCREEN_WIDTH, int SCREEN_HEIGHT,int UNIT_SIZE){
        random = new Random();
        generateNewApple(SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
    }
    public void generateNewApple(int SCREEN_WIDTH, int SCREEN_HEIGHT,int UNIT_SIZE){
        appleX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    public void draw (Graphics g, int UNIT_SIZE){
        g.setColor(Color.RED);
        g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
    }

}
