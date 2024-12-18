import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
import javax.swing.plaf.nimbus.State;

public class GamePanel extends JPanel implements Runnable{
    // Screen Settings
    final int originalTileSize = 16; // 16 x 16 tile for characters, npcs, etc
    final int scale = 3; // Scale up tile size so they are visible on large screens
    final int tileSize = originalTileSize * scale; // Actual tile size
    final int maxScreenColumn = 16; // Columns on game window
    final int maxScreenRow = 12; // Rows on game window
    final int screenWidth = tileSize * maxScreenColumn; // 786 pixels, size of game window
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels, size of game window

    // Setting FPS
    int FPS = 60; // Restrict game loop to 60 frames per second (otherwise its too fast)

    // Pulling in information from other classes
    CollisionChecker collisionChecker = new CollisionChecker();
    KeyInput keyH = new KeyInput(this);
    Thread gameThread; // Thread will allow multiple programs to run at once without interrupting the main program
    Player player = new Player(this, keyH);
    Background testBackground = new Background(this);
    PanelWindow panelWindow;

    public void setPanelWindow(PanelWindow panelWindow) {
        this.panelWindow = panelWindow;
    }

    public void setFishShopUI(FishShopUIFinal fishShopUI) {
        this.fishShopUI = fishShopUI;
    }
    
    public void setFishCounter(fishCounter fishCounter){
        this.fishCounter = fishCounter;
    }

    public void setAddToCurrency(AddToCurrency addToCurrency){
        this.addToCurrency = addToCurrency;
    }

    public void setFishingUI(FishingUI fishingUI){
        this.fishingUI = fishingUI;
    }

    public void setBedAppearance(GamePanel gamePanel){
        this.bedAppearance = bedAppearance;
        // BedAppearance bedAppearance = new BedAppearance(this);
    }
    
    FishshopAppearance fishShop = new FishshopAppearance(this);
    BedAppearance bedAppearance = new BedAppearance(this);
    UI ui = new UI(this);
    FindName findName = new FindName();
    FishShopUIFinal fishShopUI;
    fishCounter fishCounter;
    AddToCurrency addToCurrency;
    FishingUI fishingUI;
    StateLocation stateLocation = new StateLocation(this, player);

    // Game states
    public final int introState = 0;
    public final int playState = 1;
    public final int fishShopState = 2;
    public final int fishingState = 3;
    public int gameState = introState;

    // GamePanel is the window the game is in
    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Set size of game window
        this.setDoubleBuffered(true); // Aids in rendering performance
        this.addKeyListener(keyH); // Recognize key input
        this.addKeyListener(stateLocation);
        this.setFocusable(true);
        }

    public void startGameThread() { // Run the game thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override // This is where information for the thread is
    public void run() {
        double drawInterval = 1000000000/FPS; // 1 second (in nanoseconds, as program measures time)/FPS, aka 1/60th of a second
        double nextDrawTime = System.nanoTime() + drawInterval; // Current time as measured by system + 1 game loop
       
        while(gameThread != null) { // As long as the gameThread exists, this loop will repeat. This is my game loop
            update(); // Update player position
            fishCounter.currencyUpdate(fishShopUI);
            double fauxCurrency = Math.floor(fishCounter.currency);
            System.out.println("Currency: " + fishCounter.currency + " Faux Currency: " + fauxCurrency);
            repaint(); // Update sprites and background assets
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
        if(gameState == playState){
            player.update(); // Update player position
        }
        if((gameState == fishShopState) || (gameState == introState) || (gameState == fishingState)){
          // Player does not move
        }
    }

    public void paintComponent (Graphics g){ // Draw all sprites on screen
        double roundedCurrency = Math.floor(fishCounter.currency);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; // Extend graphics class for more functionality
        testBackground.draw(g2); // Draw background
        fishShop.draw(g2); // Draw fish shop
        bedAppearance.draw(g2); // Draw bed
        player.draw(g2); // Draw player
        g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        g2.drawString("Fish: " + roundedCurrency, 30, 60); // Draw amount of currency
        g2.dispose(); // Clear up memory
    }
}
