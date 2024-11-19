import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PanelWindow extends JPanel{
// Variables
    private JLabel nameDisplay;
    private JTextField nameInput;
    private JButton randomizeName;

// Create Panel
    public PanelWindow() {
        super();
        initPanel();
    }

// Name Randomizer
    public String createName() {
    Random rand = new Random();
    String[] random = {"Pumpkin", "Smudge", "Boo", "Bubbles", "Fudge", "Patches", "Poppy", "Misty"};
    String randomName = random[rand.nextInt(8)];
    return randomName;
}

// All Action Listeners
    private class NameListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String inputName = nameInput.getText();
            System.out.println(inputName);
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
        }
    }

    private class RandomizerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            nameDisplay.setText("Name: " + createName());
        }
    }

// Intro Panel

    public void initPanel() {
        setPreferredSize(new Dimension(1250,630));
        setBackground(Color.LIGHT_GRAY);
        nameDisplay = new JLabel("Name: ");
        nameInput = new JTextField("Input Name");
        randomizeName = new JButton("Randomize");

        add(nameDisplay);
        add(nameInput);
        add(randomizeName);

        nameInput.addActionListener(new NameListener());
        randomizeName.addActionListener(new RandomizerListener());

        nameInput.setColumns(10);
    }
   
}
