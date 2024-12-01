import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class FishShopUIFinal extends JPanel{


// Variables
    private JButton rButton;
    private JButton upgradeFishButton;
    private JButton upgradeBed;
    private JLabel levelLabel;
    private JLabel buyingFishLabel;
    private JLabel buyingBedLabel;
    private JLabel name;

    GamePanel gamePanel;
        
    int fishShopLevel = 0;
    int bedLevel = 0;
    boolean legalPurchase = true;

// Create Panel
    public FishShopUIFinal(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        // super();
        initPanel();
    }

// All Action Listeners

    public class MouseHelper1 implements MouseListener{
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if(fishShopLevel < 3){
                legalPurchase = true;
                fishShopLevel = fishShopLevel + 1;
                levelLabel.setText("Fish Shop Level: " + fishShopLevel);
            }
            if (fishShopLevel >= 3){
                legalPurchase = false;
                buyingFishLabel.setText("You have bought all fish shop upgrades!");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }

    public class MouseHelper2 implements MouseListener{


        @Override
        public void mouseClicked(MouseEvent e) {
            gamePanel.gameState = gamePanel.playState;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }

    
    public class MouseHelper3 implements MouseListener{
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if(bedLevel < 3){
                legalPurchase = true;
                bedLevel = bedLevel + 1;
            }
            if (bedLevel >= 3){
                legalPurchase = false;
                buyingBedLabel.setText("You have bought all bed upgrades!");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }

    public void initPanel() {
        setPreferredSize(new Dimension(786,576));
        setBackground(Color.LIGHT_GRAY);

        upgradeFishButton = new JButton("Upgrade Fish Shop");
        name = new JLabel("Welcome to the shop (name)! Thank you for your purchases :)                                                                                          ");
        rButton = new JButton("Return");
        levelLabel = new JLabel("Fish Shop Level: " + fishShopLevel);
        buyingFishLabel = new JLabel();
        buyingBedLabel = new JLabel();
        upgradeBed = new JButton("Upgrade Cat Bed");

        add(name);
        add(levelLabel);
        add(upgradeFishButton);
        add(buyingFishLabel);
        add(upgradeBed);
        add(buyingBedLabel);
        add(rButton);

        upgradeFishButton.addMouseListener(new MouseHelper1());
        rButton.addMouseListener(new MouseHelper2());
        upgradeBed.addMouseListener(new MouseHelper3());
        // nameDisplay = new JLabel("Name: ");
        // nameInput = new JTextField("Input Name");
        // randomizeName = new JButton("Randomize");

        // add(nameDisplay);
        // add(nameInput);
        // add(randomizeName);

        // nameInput.addActionListener(new NameListener());

        // nameInput.setColumns(10);
    }
   
}
