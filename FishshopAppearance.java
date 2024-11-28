import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FishshopAppearance {
    GamePanel gamePanel;
    public BufferedImage fishShop;

    public FishshopAppearance(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        getBackgroundImage();
    }

    public void getBackgroundImage() { // Pull information about backgrounds from resource images
        try {
            fishShop = ImageIO.read(getClass().getResourceAsStream("/res/background/fishshop.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) { // Draw backgrounds
        g2.drawImage(fishShop, 110, 280, 135, 95,null);
    }

}
