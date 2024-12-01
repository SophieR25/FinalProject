import javax.swing.JFrame;

public class CatGameMain {
    public static void main(String[] args) {
        JFrame window = new JFrame("Cat Game!"); // Create new JFrame
        JFrame fishShopUI = new JFrame("Fish Shop!");
        JFrame fishingUI1 = new JFrame("Fish!");
        JFrame introWindow = new JFrame("Welcome");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        window.setResizable(false); //Cannot change window size
        fishShopUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        fishShopUI.setResizable(false); //Cannot change window size
        fishingUI1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        fishingUI1.setResizable(false); //Cannot change window size
        introWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        introWindow.setResizable(false); //Cannot change window size

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); // add gamePanel to the window
        window.pack();
        window.setLocationRelativeTo(null); // Display window at center of screen

        PanelWindow panelWindow = new PanelWindow(gamePanel);
        FishShopUIFinal fishShopUIFinal = new FishShopUIFinal(gamePanel, panelWindow);
        fishShopUI.add(fishShopUIFinal);
        fishShopUI.pack();
        fishShopUI.setLocationRelativeTo(null); // Display window at center of screen
        
        fishCounter fishCounter;
        AddToCurrency addToCurrency;
        fishCounter = new fishCounter();
        addToCurrency = new AddToCurrency(fishCounter);
        FishingUI fishingUI2 = new FishingUI(gamePanel, fishCounter, addToCurrency);
        fishingUI1.add(fishingUI2);
        fishingUI1.pack();
        fishingUI1.setLocationRelativeTo(null);

        PanelWindow introPanelWindow = new PanelWindow(gamePanel);
        introWindow.add(introPanelWindow);
        introWindow.pack();
        introWindow.setLocationRelativeTo(null); // Display window at center of screen
    
        gamePanel.startGameThread();

            double drawInterval = 1000000000/60; // 1 second (in nanoseconds, as program measures time)/FPS, aka 1/60th of a second
            double nextDrawTime = System.nanoTime() + drawInterval; // Current time as measured by system + 1 game loop
           
            while(gamePanel.gameThread != null) { // As long as the gameThread exists, this loop will repeat. This is my game loop
                // Update character positions
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


// import javax.swing.JFrame;
// import javax.swing.JPanel;

// public class CatGameMain {
//     public static void main(String[] args) {
//     JFrame myFrame = new JFrame("Cat Game!");  
//     myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//     JPanel primary = new JPanel();  
//     myFrame.getContentPane().add(primary);

//     //implement specification 11
//     PanelWindow studentPanel = new PanelWindow();
//     primary.add(studentPanel);
//     myFrame.pack();  
//     myFrame.setVisible(true);
// }
// }