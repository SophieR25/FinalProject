import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyInput keyH;

    public Player(GamePanel gamePanel, KeyInput keyH) { // Create a player object
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        setDefaultValues();
    }
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update() {
        if(keyH.upPressed == true){
            y = y - speed;
        }
        if(keyH.downPressed == true){
            y = y + speed;
        }
        if(keyH.leftPressed == true){
            x = x - speed;
        }
        if(keyH.rightPressed == true){
            x = x + speed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize); // Mock player character
    }
}
