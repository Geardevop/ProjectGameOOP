import java.awt.*;
import javax.swing.*;
public class GameView extends JFrame implements Runnable{
    // <-------------------------------------------------- Change This -------------------------------------------------->
    private JLabel player1, player2;
    private MainMapView mapView;
    private MainMenuView menuView;
    private int width, height;
    private Icon playerIcon1, playerIcon2;// <-------------------------------------------------- Change This -------------------------------------------------->

    public GameView(int width, int height, Player playerA, Player playerB){
        this.width = width;
        this.height = height;

        if(width == 1280){
            playerIcon1 = new ImageIcon("img/player_red_small.gif");
            playerIcon2 = new ImageIcon("img/player_blue_small.gif");
        }else{
            playerIcon1 = new ImageIcon("img/player_red_big.gif");
            playerIcon2 = new ImageIcon("img/player_blue_big.gif");
        }

        player1 = new JLabel(playerIcon1);
        player2 = new JLabel(playerIcon2);


        menuView = new MainMenuView(width, height);

        mapView = new MainMapView(width, height, playerA, playerB);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.setLayout(null);
        this.setBounds((int)((dimension.getWidth()-width)/2), (int)((dimension.getHeight()-height)/2), width, height);
        Container container = this.getContentPane();
        container.setLayout(null);

        this.add(menuView);
        menuView.setBounds(0, 0, width, height);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void run() {
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//
//        this.setLayout(null);
//        this.setBounds((int)((dimension.getWidth()-width)/2), (int)((dimension.getHeight()-height)/2), width, height);
//        Container container = this.getContentPane();
//        container.setLayout(null);
//
//        this.add(menuView);
//        menuView.setBounds(0, 0, width, height);
    }

    public JLabel getPlayer1() {
        return player1;
    }

    public MainMapView getMapView() {
        return mapView;
    }

    public MainMenuView getMenuView() {
        return menuView;
    }

    public JLabel getPlayer2() {
        return player2;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
