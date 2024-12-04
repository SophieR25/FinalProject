import javax.swing.JFrame;

public class CatGameMain {
    public static void main(String[] args) {
        // Main game screen
        JFrame window = new JFrame("Cat Game!"); // Create new JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        window.setResizable(false); //Cannot change window size

        // Fish shop
        JFrame fishShopUI = new JFrame("Fish Shop!");
        fishShopUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        fishShopUI.setResizable(false); 

        // Fishing Game
        JFrame fishingUI1 = new JFrame("Fish!");
        fishingUI1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        fishingUI1.setResizable(false); 

        // Intro screen
        JFrame introWindow = new JFrame("Welcome");
        introWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        introWindow.setResizable(false); 

        // Add GamePanel to the JFrame window
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); 
        window.pack();
        window.setLocationRelativeTo(null); // Display window at center of screen

        // Add FishShopUIFinal to JFrame fishShopUI
        PanelWindow panelWindow = new PanelWindow(gamePanel);
        gamePanel.setPanelWindow(panelWindow);
        FishShopUIFinal fishShopUIFinal = new FishShopUIFinal(gamePanel, panelWindow);
        fishShopUI.add(fishShopUIFinal);
        fishShopUI.pack();
        fishShopUI.setLocationRelativeTo(null); 
        
        // Add FishingUI to JFrame fishingUI
        fishCounter fishCounter;
        AddToCurrency addToCurrency;
        fishCounter = new fishCounter(gamePanel, fishShopUIFinal);
        addToCurrency = new AddToCurrency(fishCounter);
        FishingUI fishingUI2 = new FishingUI(gamePanel, fishCounter, addToCurrency);
        fishingUI1.add(fishingUI2);
        fishingUI1.pack();
        fishingUI1.setLocationRelativeTo(null);

        // Add PanelWindow to JFrame introWindow
        PanelWindow introPanelWindow = new PanelWindow(gamePanel);
        introWindow.add(introPanelWindow);
        introWindow.pack();
        introWindow.setLocationRelativeTo(null); // Display window at center of screen
    
        fishShopUIFinal.setPanelWindow(introPanelWindow);
        introPanelWindow.setFishShopUI(fishShopUIFinal);

        gamePanel.startGameThread();

            double drawInterval = 1000000000/60; // 1 second (in nanoseconds, as program measures time)/FPS, aka 1/60th of a second
            double nextDrawTime = System.nanoTime() + drawInterval; // Current time as measured by system + 1 game loop
           
            while(gamePanel.gameThread != null) { // As long as the gameThread exists, this loop will repeat. This is my game loop
                if(gamePanel.gameState == gamePanel.playState){
                    fishShopUI.setVisible(false);
                    fishingUI1.setVisible(false);
                    window.setVisible(true); 
                    introWindow.setVisible(false);
                }
                if(gamePanel.gameState == gamePanel.fishShopState){
                    fishShopUI.setVisible(true);
                    window.setVisible(false); 
                    fishingUI1.setVisible(false);
                    introWindow.setVisible(false);
                    gamePanel.fishShopUI.updateInterface();
                }
                if(gamePanel.gameState == gamePanel.fishingState){
                    fishShopUI.setVisible(false);
                    window.setVisible(false); 
                    fishingUI1.setVisible(true);
                    introWindow.setVisible(false);
                }
                if(gamePanel.gameState == gamePanel.introState){
                    fishShopUI.setVisible(false);
                    window.setVisible(false); 
                    fishingUI1.setVisible(false);
                    introWindow.setVisible(true);
                }
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

}