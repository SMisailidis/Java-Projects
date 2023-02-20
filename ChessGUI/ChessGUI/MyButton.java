import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    private boolean hasCircle;
    private Color color;
    public MyButton() {
        super();
        hasCircle = false;
    }

    public void setHasCircle(boolean value, Color clr) {
        hasCircle = value;
        color = clr;
        repaint();
    }

    public boolean isHasCircle() {
        return hasCircle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (hasCircle) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(color);
            int diameter = Math.min(getWidth(), getHeight()) / 3;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g2d.fillOval(x, y, diameter, diameter);
        }
    }
}
