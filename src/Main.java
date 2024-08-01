import UI.GameFrame;
import UI.GamePanel;
import Controller.GameController;

public class Main {

    public static void main(String[] args) {
        GamePanel panel = new GamePanel(new GameController());
        GameFrame frame = new GameFrame(panel);


    }


}