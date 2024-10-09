package main;
import UI.GameFrame;
import UI.GamePanel;
import Controller.GameController;
import UI.MainPanel;
import UI.StartPanel;
import domain.*;


public class Main implements Mode {


    public static void main(String[] args) throws Exception {
        GameController controller = new GameController();

        MainPanel mainPanel = new MainPanel();
        GamePanel gamePanel = new GamePanel(mainPanel,controller);
        StartPanel startPanel = new StartPanel(mainPanel,gamePanel);

        mainPanel.addPanel(startPanel,START);
        mainPanel.addPanel(gamePanel,GAME);
        GameFrame frame = new GameFrame(mainPanel);





    }


}