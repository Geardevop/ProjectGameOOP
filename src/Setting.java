import javax.swing.*;
import java.awt.*;
public class Setting{
    private JFrame window;
    private JPanel allPanel, setting, savePanel, backPanel, falseNotFullScreenPanel, trueNotFullScreenPanel, falseFullScreenPanel, trueFullScreenPanel, volumePanel, space1, space2;
    private JSlider volume;

    public Setting(int width, int height, JFrame parent){
        Image settingBackground = Toolkit.getDefaultToolkit().createImage("img/new-02.png");
        Image volumeBackground = Toolkit.getDefaultToolkit().createImage("img/button-01.png");
        Image falseRadioBackground = Toolkit.getDefaultToolkit().createImage("img/button-02.png");
        Image trueRadioBackground = Toolkit.getDefaultToolkit().createImage("img/yes-01.png");
        Image saveBackground = Toolkit.getDefaultToolkit().createImage("img/hahahaha-01.png");
        Image backBackground = Toolkit.getDefaultToolkit().createImage("img/hahahaha-02.png");

        setting = new ImagePanel(settingBackground, height-height/12, height-height/12);
        setting.setPreferredSize(new Dimension(height-height/12, height-height/12));

        volumePanel = new ImagePanel(volumeBackground, height/2, height/12);
        volumePanel.setPreferredSize(new Dimension(height/2, height/12));
        volumePanel.setBackground(new Color(0,0,0,0));

        falseNotFullScreenPanel = new ImagePanel(falseRadioBackground, height/12, height/12);
        falseNotFullScreenPanel.setPreferredSize(new Dimension(height/12, height/12));
        falseNotFullScreenPanel.setBackground(new Color(0,0,0,0));

        trueNotFullScreenPanel = new ImagePanel(trueRadioBackground, height/12, height/12);
        trueNotFullScreenPanel.setPreferredSize(new Dimension(height/12, height/12));
        trueNotFullScreenPanel.setBackground(new Color(0,0,0,0));

        falseFullScreenPanel = new ImagePanel(falseRadioBackground, height/12, height/12);
        falseFullScreenPanel.setPreferredSize(new Dimension(height/12, height/12));
        falseFullScreenPanel.setBackground(new Color(0,0,0,0));

        trueFullScreenPanel = new ImagePanel(trueRadioBackground, height/12, height/12);
        trueFullScreenPanel.setPreferredSize(new Dimension(height/12, height/12));
        trueFullScreenPanel.setBackground(new Color(0,0,0,0));

        savePanel = new ImagePanel(saveBackground, height/3, height/12);
        savePanel.setBackground(new Color(0,0,0,0));
        savePanel.setPreferredSize(new Dimension(height/3, height/12));

        backPanel = new ImagePanel(backBackground, height/3, height/12);
        backPanel.setBackground(new Color(0,0,0,0));
        backPanel.setPreferredSize(new Dimension(height/3, height/12));

        window = new JFrame();
        allPanel = new JPanel();
        volume = new JSlider();
        space1 = new JPanel();
        space1.setBackground(new Color(0,0,0,0));
        space1.setPreferredSize(new Dimension(height/4, 1));
        space2 = new JPanel();
        space2.setBackground(new Color(0,0,0,0));
        space2.setPreferredSize(new Dimension(height, height/48*3/2));

        volume.setValue(100);
        volume.setBackground(Color.white);

        allPanel.setLayout(new FlowLayout());
        allPanel.add(setting);

        volumePanel.setLayout(new FlowLayout());
        volumePanel.add(Box.createRigidArea(new Dimension(height, height/48)));
        volumePanel.add(volume);

        setting.setLayout(new FlowLayout());
        setting.add(Box.createRigidArea(new Dimension(height, height/2*2/3)));
        setting.add(volumePanel);
        setting.add(Box.createRigidArea(new Dimension(height, height/24*3/2)));
        if(width == 1280){
            setting.add(trueNotFullScreenPanel);
        }else{
            setting.add(falseNotFullScreenPanel);
        }
        setting.add(space1);
        if(width == 1280){
            setting.add(falseFullScreenPanel);
        }else{
            setting.add(trueFullScreenPanel);
        }
        setting.add(space2);
        setting.add(savePanel);
        setting.add(backPanel);


        allPanel.setBackground(new Color(0, 0, 0, 200));
        allPanel.setPreferredSize(new Dimension(width/3*2, height/3*2));

        window.add(allPanel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.setBackground(new Color(0,0,0, 0));
        window.setSize(width, height);
        window.setLocation(parent.getX(), parent.getY());
        window.setVisible(true);
    }



    public JPanel getSpace1() {
        return space1;
    }

    public JPanel getSpace2() {
        return space2;
    }

    public JFrame getWindow() {
        return window;
    }

    public JPanel getAllPanel() {
        return allPanel;
    }

    public JPanel getSetting() {
        return setting;
    }

    public JPanel getSavePanel() {
        return savePanel;
    }

    public JPanel getBackPanel() {
        return backPanel;
    }

    public JPanel getFalseNotFullScreenPanel() {
        return falseNotFullScreenPanel;
    }

    public JPanel getTrueNotFullScreenPanel() {
        return trueNotFullScreenPanel;
    }

    public JPanel getFalseFullScreenPanel() {
        return falseFullScreenPanel;
    }

    public JPanel getTrueFullScreenPanel() {
        return trueFullScreenPanel;
    }

    public JPanel getVolumePanel() {
        return volumePanel;
    }

    public JSlider getVolume() {
        return volume;
    }


}
