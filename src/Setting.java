import javax.swing.*;
import java.awt.*;
public class Setting {
    private JFrame window;
    private JPanel allPanel, leftPanel;
    private JButton ok, exit;

    public Setting(int width, int height, JFrame parent){
        window = new JFrame();
        ok = new JButton("OK/Save Changed");
        exit = new JButton("Exit Game");
        allPanel = new JPanel();

        allPanel.setBackground(new Color(0, 0, 0, 200));
        allPanel.setPreferredSize(new Dimension(width/3*2, height/3*2));
        allPanel.add(ok);allPanel.add(exit);
        window.add(allPanel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setUndecorated(true);
        window.setBackground(new Color(0,0,0, 0));
        window.setSize(width, height);
        window.setLocation(parent.getX(), parent.getY());
        window.setVisible(true);
    }

    public JFrame getWindow() {
        return window;
    }

    public JPanel getAllPanel() {
        return allPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JButton getOk() {
        return ok;
    }

    public JButton getExit() {
        return exit;
    }


}

