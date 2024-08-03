package UI;

import domain.Mode;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements Mode {
    CardLayout cardLayout;
    JPanel mainPanel;
    public MainPanel() {

        cardLayout = new CardLayout();
        this.setLayout(cardLayout);



    }
    public void showPanel(String panelName){
        cardLayout.show(this,panelName);
    }

    public void addPanel (JPanel panel,String mode){
        this.add(panel,mode);
    }
    public void switchToGamePanel() {
        showPanel(GAME);
        // Request focus for the game panel to ensure it receives key events
        ((GamePanel) getComponent(1)).requestFocusInWindow();
    }
}
