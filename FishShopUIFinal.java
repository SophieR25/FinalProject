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
    private JButton upgradeButton;
    private JLabel levelLabel;
    private JLabel buyingLabel;

    GamePanel gamePanel;
        
    int fishShopLevel = 0;
    boolean legalPurchase = true;

// Create Panel
    public FishShopUIFinal() {
        super();
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
        GamePanel gamePanel;


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

    public void initPanel() {
        setPreferredSize(new Dimension(786,576));
        setBackground(Color.LIGHT_GRAY);

        upgradeButton = new JButton("Upgrade Fish Shop");
        rButton = new JButton("Return");
        levelLabel = new JLabel("Fish Shop Level: " + fishShopLevel);
        buyingLabel = new JLabel("Buying Label: " + legalPurchase);

        add(levelLabel);
        add(upgradeButton);
        add(buyingLabel);
        add(rButton);

        upgradeButton.addMouseListener(new MouseHelper1());
        rButton.addMouseListener(new MouseHelper2());
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
