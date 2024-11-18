import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatGameMain {
    public static void main(String[] args) {
    JFrame myFrame = new JFrame("Cat Game!");  
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    JPanel primary = new JPanel();  
    myFrame.getContentPane().add(primary);

    //implement specification 11
    PanelWindow studentPanel = new PanelWindow();
    primary.add(studentPanel);
    myFrame.pack();  
    myFrame.setVisible(true);
}
}