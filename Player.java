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
        x = 100; // Initial Player X Position
        y = 100; // Initial Player Y Position
        speed = 4; // Player speed
        direction = "down"; // Initial Player Direction
    }
    public void getPlayerImage() { // Pull all player sprites from resource images
        try {
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
    public void update() { // Set player direction based on keyboard input

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

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            spriteCounter ++; // Animation changes every 10 frames
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2) { // Update player sprite based on direction
        BufferedImage image = null;
        switch(direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }                
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }                
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }                
                break;
        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize,null);
    }
}
