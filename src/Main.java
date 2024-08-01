import javax.swing.*;

public class Main {
    final int boardWidth  = 600;
    final int boardHeight = 600;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}