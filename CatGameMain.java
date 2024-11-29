import javax.swing.JFrame;

public class CatGameMain {
    public static void main(String[] args) {
        JFrame window = new JFrame("Cat Game!"); // Create new JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close JFrame when x is clicked
        window.setResizable(false); //Cannot change window size

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); // add gamePanel to the window
        // FishShopUI fishShopUI = new FishShopUI();
        // window.add(fishShopUI);
        window.pack();

        window.setLocationRelativeTo(null); // Display window at center of screen
        window.setVisible(true); // You can see the window

        gamePanel.startGameThread();
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