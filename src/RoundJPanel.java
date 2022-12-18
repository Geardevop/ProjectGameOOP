import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
public class RoundJPanel extends JPanel {
    private Shape shape;
    public RoundJPanel() {
        setOpaque(false); // As suggested by @AVD in comment.

    }
    protected void paintComponent(Graphics g) {
        Image variousBackground = Toolkit.getDefaultToolkit().createImage("img/VariousPanel_400x720.png");
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        g.drawImage(variousBackground, 0, 0, null);
        super.paintComponent(g);
    }
    //    protected void paintBorder(Graphics g) {
//         g.setColor(new Color(204, 204, 204));
//         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
//    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
