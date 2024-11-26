import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyInput keyH;

    public Player(GamePanel gamePanel, KeyInput keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;
    }
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }
}
