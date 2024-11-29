import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestFishShopUI {
    int currentLocationX;
    int currentLocationY;
    Point thirty;

        public class MouseHelper implements MouseListener{
            @Override
            public void mouseClicked(MouseEvent e) {
               currentLocationX = e.getX();
               currentLocationY = e.getY();
               thirty = e.getPoint();
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
