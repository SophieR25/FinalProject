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

// Create Panel
    public FishShopUIFinal() {
        super();
        initPanel();
    }

// All Action Listeners

    public class MouseHelper implements MouseListener{
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
// Intro Panel

    public void initPanel() {
        setPreferredSize(new Dimension(786,576));
        setBackground(Color.LIGHT_GRAY);

        rButton = new JButton("Return");

        add(rButton);

        rButton.addMouseListener(new MouseHelper());
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
