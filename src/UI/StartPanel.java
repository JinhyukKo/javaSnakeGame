package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domain.Mode;
import domain.Configs;
public class StartPanel extends JPanel implements ActionListener {
    JButton button;

    Mode mode;
    public StartPanel(Mode mode){
        JLabel label = new JLabel("Snake Game");
        label.setFont(new Font("new Ink",Font.BOLD,40));
        int textSize = label.getFontMetrics(label.getFont()).stringWidth(label.getText());
//        label.setVerticalAlignment(JLabel.TOP);
//        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds((Configs.SCREEN_WIDTH-textSize)/2,0,Configs.SCREEN_WIDTH,Configs.SCREEN_HEIGHT/2);
        label.setForeground(Color.RED);


        this.createStartButton();



        this.mode=mode;



        this.setPreferredSize(new Dimension(Configs.SCREEN_WIDTH,Configs.SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
//        this.setBounds(0,100,Configs.SCREEN_WIDTH,Configs.SCREEN_HEIGHT-200);
        this.setLayout(null); // Set layout to BorderLayout
        this.setFocusable(true);
        this.add(label);
        this.add(button);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            mode = Mode.GAME;
        }
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

    }
}
