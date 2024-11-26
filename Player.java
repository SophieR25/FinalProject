import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyInput keyH;

    public Player(GamePanel gamePanel, KeyInput keyH) { // Create a player object
        this.gamePanel = gamePanel;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            // up1 = ImageIO.read(Player.class.getResource("/blackcat_backward_leftpaw.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_backward_leftpaw.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_backward_rightpaw.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_forward_leftpaw.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_forward_rightpaw.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_left_leftpaw.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_left_rightpaw.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_right_leftpaw.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/blackcat_right_rightpaw.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(keyH.upPressed == true){
            y = y - speed;
            direction = "up";
        }
        if(keyH.downPressed == true){
            y = y + speed;
            direction = "down";
        }
        if(keyH.leftPressed == true){
            x = x - speed;
            direction = "left";
        }
        if(keyH.rightPressed == true){
            x = x + speed;
            direction = "right";
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize,null);
    
        // g2.setColor(Color.white);
        // g2.fillRect(x,y,gamePanel.tileSize,gamePanel.tileSize); // Mock player character
    }
}
