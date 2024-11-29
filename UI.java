import java.awt.GradientPaint;
import java.awt.Graphics2D;

public class UI {
 GamePanel gamePanel;
 Graphics2D g2;

 public UI(GamePanel gamePanel){
    this.gamePanel = gamePanel;
 }

 public void draw(Graphics2D g2){
    this.g2 = g2;
    if(gamePanel.gameState == gamePanel.playState){

    }
    if(gamePanel.gameState == gamePanel.fishShopState){
        drawFishShopMenu();
    }
 }

 public void drawFishShopMenu(){
    g2.fillRect(300, 300, 100, 100);
 }
}
