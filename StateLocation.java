import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateLocation implements KeyListener{
    GamePanel gamePanel;
    Player player;
    
    public StateLocation(GamePanel gamePanel, Player player){
        this.gamePanel = gamePanel;
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
       
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // Determine what key is pressed
        if(code == KeyEvent.VK_P){
            if((gamePanel.gameState == gamePanel.playState) && (player.x < 220) && (player.x > 80) && (player.y > 340) && (player.y < 370)){
                gamePanel.gameState = gamePanel.fishShopState;
            }else if(gamePanel.gameState == gamePanel.fishShopState){
                gamePanel.gameState = gamePanel.playState;
            }else if((gamePanel.gameState == gamePanel.playState) && (player.x < 150) && (player.x > 100) && (player.y > 430)){
                gamePanel.gameState = gamePanel.fishingState;
            }
        }
    }
}
