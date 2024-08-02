import Entity.Apple;
import Entity.Snake;
import UI.GameFrame;
import UI.GamePanel;
import Controller.GameController;
import UI.StartPanel;
import domain.*;


public class Main {


    public static void main(String[] args) {
        Mode mode = Mode.START;
        GameController controller = new GameController();
        GameFrame frame;
        GamePanel gamePanel = new GamePanel(controller);
        StartPanel startPanel = new StartPanel(mode);
        switch (mode){
            case START:
                frame = new GameFrame(startPanel);
                break;
            case GAME:
                frame = new GameFrame(gamePanel);
                break;

        }



    }


}