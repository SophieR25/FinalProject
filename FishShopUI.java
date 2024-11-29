import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FishShopUI extends JPanel{
    private JLabel testLabel;

    public void MouseKeyEventPanel(){
        initPanel();
    }

    public void initPanel(){
        setPreferredSize(new Dimension(300,300));
        testLabel = new JLabel();
        add(testLabel);
        testLabel.addMouseListener(new MouseHelper());
    }

    public class MouseHelper implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("The label was clicked");
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
}
