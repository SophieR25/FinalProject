import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BedAppearance {
    GamePanel gamePanel;
    public BufferedImage bed1;
    public BufferedImage bed2;
    public BufferedImage bed3;

    public BedAppearance(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        getBackgroundImage();
    }

    public void getBackgroundImage() { // Pull information about backgrounds from resource images
        try {
            bed1 = ImageIO.read(getClass().getResourceAsStream("/res/background/bedlevel1.png"));
            bed2 = ImageIO.read(getClass().getResourceAsStream("/res/background/bedlevel2.png"));
            bed3 = ImageIO.read(getClass().getResourceAsStream("/res/background/bedlevel3.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) { // Draw backgrounds
        g2.drawImage(bed1, 510, 120, 135, 95,null);
    }

}
