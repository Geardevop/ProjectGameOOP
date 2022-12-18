import java.awt.*;
import javax.swing.*;
public class GameView extends JFrame implements Runnable{
    private JPanel player1, player2;
    private MainMapView mapView;
    private MainMenuView menuView;
    private int width, height;
    public GameView(int width, int height){
        this.width = width;
        this.height = height;

        Image playerImage1 = Toolkit.getDefaultToolkit().createImage("img/player red.gif");
        Image playerImage2 = Toolkit.getDefaultToolkit().createImage("img/player blue.gif");

        player1 = new ImagePanel(playerImage1, height/24*3/2, height/12*3/2);
        player2 = new ImagePanel(playerImage2, height/24*3/2, height/12*3/2);

        menuView = new MainMenuView(width, height);

        mapView = new MainMapView(width, height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void run() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.setLayout(null);
        this.setBounds((int)((dimension.getWidth()-width)/2), (int)((dimension.getHeight()-height)/2), width, height);
        Container container = this.getContentPane();
        container.setLayout(null);

        this.add(menuView);
        menuView.setBounds(0, 0, width, height);
    }

    public JPanel getPlayer1() {
        return player1;
    }

    public MainMapView getMapView() {
        return mapView;
    }

    public MainMenuView getMenuView() {
        return menuView;
    }
    public JPanel getPlayer2() {
        return player2;
    }
}

