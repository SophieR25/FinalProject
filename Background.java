import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
    GamePanel gamePanel;
    public BufferedImage testImage;

    public Background(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        getBackgroundImage();
    }

    public void getBackgroundImage() {
        try {
            testImage = ImageIO.read(getClass().getResourceAsStream("/res/background/startingbase.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(testImage, 0, 0, 768, 575,null);
    }

}
