import java.awt.*;
import javax.swing.*;
public class MainMenuView extends JPanel{
    private JPanel menuBackground;
    private JPanel startPanel, tutorialPanel, settingPanel, exitPanel;

    public MainMenuView(int width, int height){
        Image mainMenuBackground = Toolkit.getDefaultToolkit().createImage("img/Main_Menu.gif");
        Image startBackground = Toolkit.getDefaultToolkit().createImage("img/StartButton.png");
        Image tutorialBackground = Toolkit.getDefaultToolkit().createImage("img/TutorialButton.png");
        Image settingBackground = Toolkit.getDefaultToolkit().createImage("img/SettingButton.png");
        Image exitBackground = Toolkit.getDefaultToolkit().createImage("img/ExitButton.png");

        menuBackground = new ImagePanel(mainMenuBackground, width, height);
        startPanel = new ImagePanel(startBackground, height/4, height/6);
        tutorialPanel = new ImagePanel(tutorialBackground, height/4, height/6);
        settingPanel = new ImagePanel(settingBackground, height/4, height/6);
        exitPanel = new ImagePanel(exitBackground, height/4, height/6);


        startPanel.setBackground(new Color(0,0,0,0));
        startPanel.setPreferredSize(new Dimension(height/4, height/6));

        tutorialPanel.setBackground(new Color(0,0,0,0));
        tutorialPanel.setPreferredSize(new Dimension(height/4, height/6));

        settingPanel.setBackground(new Color(0,0,0,0));
        settingPanel.setPreferredSize(new Dimension(height/4, height/6));

        exitPanel.setBackground(new Color(0,0,0,0));
        exitPanel.setPreferredSize(new Dimension(height/4, height/6));

        menuBackground.setLayout(new FlowLayout());
        menuBackground.add(Box.createRigidArea(new Dimension(width, height/3*2)));
        menuBackground.add(startPanel);
        menuBackground.add(Box.createRigidArea(new Dimension(height/12, height/6)));
        menuBackground.add(tutorialPanel);
        menuBackground.add(Box.createRigidArea(new Dimension(height/12, height/6)));
        menuBackground.add(settingPanel);
        menuBackground.add(Box.createRigidArea(new Dimension(height/12, height/6)));
        menuBackground.add(exitPanel);

        this.setLayout(new BorderLayout());
        this.add(menuBackground, BorderLayout.CENTER);
    }

    public JPanel getMenuBackground() {
        return menuBackground;
    }

    public JPanel getStartPanel() {
        return startPanel;
    }

    public JPanel getTutorialPanel() {
        return tutorialPanel;
    }

    public JPanel getSettingPanel() {
        return settingPanel;
    }

    public JPanel getExitPanel() {
        return exitPanel;
    }


}

