import java.awt.GradientPaint;
import java.awt.Graphics2D;

public class UI {
 GamePanel gamePanel;
 Graphics2D g2;
 FishShopUI fishShopUI;

 public UI(GamePanel gamePanel){
    this.gamePanel = gamePanel;
 }

 public void draw(FishShopUI fishShopUI){
    this.fishShopUI = fishShopUI;
    this.g2 = g2;
    if(gamePanel.gameState == gamePanel.playState){
        
    }
    if(gamePanel.gameState == gamePanel.fishShopState){
        drawFishShopMenu();
    }
 }

 public void drawFishShopMenu(){
    String text = "PAUSED";
    System.out.println(text);
 }
}
