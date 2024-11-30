import javax.swing.JFrame;

public class CatGameMain {
    public static void main(String[] args) {
        JFrame window = new JFrame("Cat Game!"); // Create new JFrame
        JFrame fishShopUI = new JFrame("Fish Shop!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        window.setResizable(false); //Cannot change window size
        fishShopUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        fishShopUI.setResizable(false); //Cannot change window size

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); // add gamePanel to the window
        window.pack();
        window.setLocationRelativeTo(null); // Display window at center of screen

        FishShopUIFinal fishShopUIFinal = new FishShopUIFinal();
        fishShopUI.add(fishShopUIFinal);
        fishShopUI.pack();
        fishShopUI.setLocationRelativeTo(null); // Display window at center of screen
    
        gamePanel.startGameThread();

            double drawInterval = 1000000000/60; // 1 second (in nanoseconds, as program measures time)/FPS, aka 1/60th of a second
            double nextDrawTime = System.nanoTime() + drawInterval; // Current time as measured by system + 1 game loop
           
            while(gamePanel.gameThread != null) { // As long as the gameThread exists, this loop will repeat. This is my game loop
                // Update character positions
                if(gamePanel.gameState == gamePanel.playState){
                    fishShopUI.setVisible(false);
                    window.setVisible(true); 
                    System.out.println("Game state");
                }
                if(gamePanel.gameState == gamePanel.fishShopState){
                    fishShopUI.setVisible(true);
                    window.setVisible(false); 
                    System.out.println("Pause state");
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