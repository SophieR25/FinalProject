import java.awt.Rectangle;
import java.awt.image.BufferedImage;
// Generalized variables fed to player class, intended use for creating multiple sprites
public class Entity {
    public int x;
    public int y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle hitBox;
}
