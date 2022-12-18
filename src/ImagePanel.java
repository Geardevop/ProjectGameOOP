
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private Image image = null;
    private int iWidth2;
    private int iHeight2;
    private int width, height;
    private boolean isSize = false;

    public ImagePanel(Image image)
    {
        this.image = image;
        this.iWidth2 = image.getWidth(this)/2;
        this.iHeight2 = image.getHeight(this)/2;
    }
    public ImagePanel(Image image, int width, int height)
    {
        this.image = image;
        this.width = width;
        this.height = height;
        this.iWidth2 = image.getWidth(this)/2;
        this.iHeight2 = image.getHeight(this)/2;
        isSize = true;
        this.setBackground(Color.black);
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        if (image != null & !isSize){
            g2.drawImage(image,0,0,null);

        }else if(image != null & isSize){
            g2.drawImage(image,1,1,width,height,null);
        }
    }
}