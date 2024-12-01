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

public class FishingUI extends JPanel{


// Variables
    private JButton fish;
    private JButton rButton;

    GamePanel gamePanel;
    fishCounter fishCounter;
    AddToCurrency addToCurrency;
        
// Create Panel
    public FishingUI(GamePanel gamePanel, fishCounter fishCounter, AddToCurrency addToCurrency) {
        this.gamePanel = gamePanel;
        this.fishCounter = fishCounter;
        this.addToCurrency = addToCurrency;

        // super();
        initPanel();
    }

// All Action Listeners

    public class MouseHelper1 implements MouseListener{      
        @Override
        public void mouseClicked(MouseEvent e) {
            
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

    public void initPanel() {
        setPreferredSize(new Dimension(786,576));
        setBackground(Color.LIGHT_GRAY);

        fish = new JButton("Fish!");
        rButton = new JButton("Return");

        add(fish);
        add(rButton);

        fish.addMouseListener(new MouseHelper1());
        rButton.addMouseListener(new MouseHelper2());
    }
   
}

