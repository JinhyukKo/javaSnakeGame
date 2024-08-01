package UI;

import javax.swing.*;

public class GameFrame extends JFrame {
    static final int boardWidth  = 600;
    static final int boardHeight = 600;
    public GameFrame(GamePanel panel){
        this.add(panel);
        this.setTitle("Snake");
        this.setSize(boardWidth,boardHeight);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
