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

    GamePanel gamePanel;
    fishCounter fishCounter;
        
// Create Panel
    public FishingUI(GamePanel gamePanel, fishCounter fishCounter) {
        this.gamePanel = gamePanel;
        this.fishCounter = fishCounter;

        // super();
        initPanel();
    }

// All Action Listeners

    public class MouseHelper1 implements MouseListener{
         double totalFish = fishCounter.currency;
        
        @Override
        public void mouseClicked(MouseEvent e) {
            totalFish = totalFish + 1;
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

        add(fish);

        fish.addMouseListener(new MouseHelper1());
    }
   
}

