import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    GamePanel gamePanel;

    public KeyInput(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) { // Move player when key is pressed
        int code = e.getKeyCode(); // Determine what key is pressed
        if(code == KeyEvent.VK_W){ // If the key pressed is W...
            upPressed = true;
        }
        if(code == KeyEvent.VK_A){ // If the key pressed is A...
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S){ // If the key pressed is S...
            downPressed = true;
        }
        if(code == KeyEvent.VK_D){ // If the key pressed is D...
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P){
            // if(gamePanel.gameState == gamePanel.playState){
            //     gamePanel.gameState = gamePanel.fishShopState;
            // }else if(gamePanel.gameState == gamePanel.fishShopState){
            //     gamePanel.gameState = gamePanel.playState;
            // }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { // Stop moving player when key is no longer pressed
        int code = e.getKeyCode(); // Determine what key is pressed
        if(code == KeyEvent.VK_W){ // If the key released is W...
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){ // If the key released is A...
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){ // If the key released is S...
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){ // If the key released is D...
            rightPressed = false;
        }
    }
    
}
