package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.GameController;
import domain.Mode;
import domain.Configs;
public class StartPanel extends JPanel implements ActionListener ,Mode{
    JButton button;
    MainPanel mainPanel;
    GamePanel gamePanel;
    public StartPanel(MainPanel mainPanel, GamePanel gamePanel){
        this.mainPanel=mainPanel;
        this.createText();
        this.createStartButton();
        this.createScreen();
        this.gamePanel=gamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            gamePanel.startGame();
            mainPanel.showPanel(GAME);
        }
    }
    private void createText(){
        JLabel label = new JLabel("Snake Game");
        label.setFont(new Font("new Ink",Font.BOLD,40));
        int textSize = label.getFontMetrics(label.getFont()).stringWidth(label.getText());
        label.setBounds((Configs.SCREEN_WIDTH-textSize)/2,0,Configs.SCREEN_WIDTH,Configs.SCREEN_HEIGHT/2);
        label.setForeground(Color.RED);
        this.add(label);
    }
    private void createScreen(){
        this.setPreferredSize(new Dimension(Configs.SCREEN_WIDTH,Configs.SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null); // Set layout to BorderLayout
        this.setFocusable(true);


    }
    private void createStartButton(){
        button = new JButton();
        button.setText("Game Start");
        button.setFont(new Font("new Ink",Font.BOLD,30));
        FontMetrics buttonMetrics = button.getFontMetrics(button.getFont());
        int buttonWidth = buttonMetrics.stringWidth(button.getText()) +50; // Adding some padding
        int buttonHeight = buttonMetrics.getHeight(); // Adding some padding
        button.setBounds((Configs.SCREEN_WIDTH - buttonWidth) / 2,
                (Configs.SCREEN_HEIGHT - buttonHeight) / 2,
                Configs.SCREEN_WIDTH, buttonHeight);
        button.addActionListener(this);
        button.setSize(new Dimension(buttonWidth,buttonHeight));
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false); // Removes background
        button.setBorderPainted(false); // Removes border
        button.setOpaque(false); // Ensures opacity is turned off
        this.add(button);

    }
}
