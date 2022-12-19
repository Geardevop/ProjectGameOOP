//
//
//import javax.swing.*;
//import java.awt.*;
//
//public class MainView{
//    private JFrame jf;
//    private JInternalFrame internalFrame;
//    private JPanel  bottomPanel;
//    private JButton btnRoll;
//    private  EventView eventView;
//
//
//
//    //Main===========================================================================================
//    public static void main(String[] args) {
//        new MainView();
//    }
//
//
//
//    //Constructor=====================================================================================
//
//    public MainView(){
//        btnRoll = new JButton("ROll");
//        bottomPanel = new JPanel();
//        internalFrame = new JInternalFrame();
//        jf = new JFrame();
//        // EventView
//        eventView = new EventView(-2, false, false, true, null, false,);
//        // set Atribute
//        // JPanel
//        bottomPanel.setLayout(new BorderLayout());
//        bottomPanel.add(btnRoll);
//        // internalFrame
//        internalFrame.add(eventView);
//        internalFrame.setVisible(true);
//        //JFrame
//        jf.setLayout(new BorderLayout());
//        jf.add(internalFrame);
//        jf.add(bottomPanel, BorderLayout.SOUTH);
//        jf.setSize(500,500);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setVisible(true);
//
//    }
//
//    //Getter Setter=======================================================================================
//    public JButton getBtnRoll() {
//        return btnRoll;
//    }
//
//    public void setBtnRoll(JButton btnRoll) {
//        this.btnRoll = btnRoll;
//    }
//
//    public JFrame getJf() {
//        return jf;
//    }
//
//    public void setJf(JFrame jf) {
//        this.jf = jf;
//    }
//
//    public JInternalFrame getInternalFrame() {
//        return internalFrame;
//    }
//
//    public void setInternalFrame(JInternalFrame internalFrame) {
//        this.internalFrame = internalFrame;
//    }
//
//    public JPanel getBottomPanel() {
//        return bottomPanel;
//    }
//
//    public void setBottomPanel(JPanel bottomPanel) {
//        this.bottomPanel = bottomPanel;
//    }
//}
