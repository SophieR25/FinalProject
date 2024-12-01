import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import org.w3c.dom.events.MouseEvent;

public class PanelWindow extends JPanel{

    GamePanel gamePanel;

// Variables
    private JLabel nameDisplay;
    private JTextField nameInput;
    private JButton randomizeName;
    private JButton startGame;

    String inputName;

// Create Panel
    public PanelWindow(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        // super();
        initPanel();
    }

// Name Randomizer
    public String createName() {
    Random rand = new Random();
    String[] random = {"Pumpkin", "Smudge", "Boo", "Bubbles", "Fudge", "Patches", "Poppy", "Misty"};
    String randomName = random[rand.nextInt(8)];
    return randomName;
}

    public String getName(){
        inputName = nameInput.getText();
        if (inputName.equals( "Sophie")) {
            nameDisplay.setText("You can't take my name!");
        } else if (inputName.equals( "Luc")) {
            nameDisplay.setText("An error in the system. A cosmic mistake");
        } else if (inputName.equals( "Miriam")) {
            nameDisplay.setText("Do you dread tomorrow?");
        } else if (inputName.equals( "Roulette")) {
            nameDisplay.setText("A little gambler");
        } else if (inputName.equals( "Michael")) {
            nameDisplay.setText("Cat NPC (programmer god)");
        } else {
            nameDisplay.setText("Name: " + inputName);
        }
        return inputName;
    }

// All Action Listeners
    private class NameListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String inputName = nameInput.getText();
            System.out.println(inputName);
            getName();
        }
    }

    private class RandomizerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            nameDisplay.setText("Name: " + createName());
        }
    }

    public class MouseHelper2 implements MouseListener{
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            gamePanel.gameState = gamePanel.playState;
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
           
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            
        }
    }

// Intro Panel

    public void initPanel() {
        setPreferredSize(new Dimension(1250,630));
        setBackground(Color.LIGHT_GRAY);
        nameDisplay = new JLabel("Name: ");
        nameInput = new JTextField("Input Name");
        randomizeName = new JButton("Randomize");
        startGame = new JButton("Start Game");

        add(nameDisplay);
        add(nameInput);
        add(randomizeName);
        add(startGame);

        nameInput.addActionListener(new NameListener());
        randomizeName.addActionListener(new RandomizerListener());
        startGame.addMouseListener(new MouseHelper2());

        nameInput.setColumns(10);
    }
   
}
