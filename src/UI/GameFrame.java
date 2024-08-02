package UI;

import javax.swing.*;
import domain.Configs;
public class GameFrame extends JFrame {

    public GameFrame(GamePanel panel){
        this.add(panel);
        this.setTitle("Snake");
        this.setSize(Configs.SCREEN_WIDTH, Configs.SCREEN_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
