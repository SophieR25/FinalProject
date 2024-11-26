import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class GamePanel extends JPanel implements Runnable{
    // Screen Settings
    final int originalTileSize = 16; // 16 x 16 tile for characters, npcs, etc
    final int scale = 3; // Scale up tile size so they are visible on large screens
    final int tileSize = originalTileSize * scale; // Actual tile size
    final int maxScreenColumn = 16; // Columns on game window
    final int maxScreenRow = 12; // Rows on game window
    final int screenWidth = tileSize * maxScreenColumn; // 786 pixels, size of game window
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels, size of game window
    // Player Settings
    int playerX = 100; // Initial player x position
    int playerY = 100; // Initial player y position
    int playerSpeed = 4;
    // Setting FPS
    int FPS = 60; // Restrict game loop to 60 frames per second (otherwise its too fast)

    KeyInput keyH = new KeyInput();
    Thread gameThread; // Thread will allow multiple programs to run at once without interrupting the main program
    Player player = new Player(this, keyH);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Set size of game window
        this.setDoubleBuffered(true); // Aids in rendering performance
        this.addKeyListener(keyH); // Recognize key input
        this.setFocusable(true);

    }

    public void startGameThread() { // Run the thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override // This is where information for the thread is
    public void run() {
        double drawInterval = 1000000000/FPS; // 1 second (in nanoseconds, as program measures time)/FPS, aka 1/60th of a second
        double nextDrawTime = System.nanoTime() + drawInterval; // Current time as measured by system + 1 game loop
       
        while(gameThread != null) { // As long as the gameThread exists, this loop will repeat. This is my game loop
            // Update character positions
            update(); // Call the update method
            // Draw screen with updated information
            repaint(); // Call the paintComponent method
            try {
                double remainingTime = nextDrawTime - System.nanoTime(); // How much time until next game loop?
                remainingTime = remainingTime/1000000; // Convert from nanoseconds to milliseconds
                if (remainingTime < 0) { // If previous update and draw took more than our drawInterval, immediately update again
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime); // Do not run game loop until nextDrawTime (put it to sleep for the remainingTime interval), limiting the frequency at which the loop runs
                nextDrawTime += drawInterval; // Create new draw time for next loop
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void update() {
        if(keyH.upPressed == true){
            playerY = playerY - playerSpeed;
        }
        if(keyH.downPressed == true){
            playerY = playerY + playerSpeed;
        }
        if(keyH.leftPressed == true){
            playerX = playerX - playerSpeed;
        }
        if(keyH.rightPressed == true){
            playerX = playerX + playerSpeed;
        }
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; // Extend graphics class for more functionality
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize); // Mock player character
        g2.dispose(); // Clear up memory
    }
}
