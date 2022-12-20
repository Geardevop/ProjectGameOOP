import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class GameController implements MouseListener, Runnable {
    //    private MapView mapView;
    private Setting setting;
    private GameView gameView ,testview;
    private MainMapView mapView;
    private boolean isOpeningSetting = false;
    private int randomNum;
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = 1280, height = 720;
//        private int width = (int) dimension.getWidth(), height = (int) dimension.getHeight();
    private int mapPositionWidth[] = {height / 8 * 7 - height / 24, height / 8 * 6 - height / 12, height / 8 * 5 - height / 12, height / 8 * 4 - height / 12, height / 8 * 3 - height / 12, height / 8 * 1 - height / 24,
            height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 3 - height / 12, height / 8 * 4 - height / 12,
            height / 8 * 5 - height / 12, height / 8 * 6 - height / 12, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24};
    ;
    private int mapPositionHeight[] = {height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 8 * 7 - height / 24,
            height / 8 * 6 - height / 12 * 3 / 2, height / 8 * 5 - height / 12 * 3 / 2, height / 8 * 4 - height / 12 * 3 / 2, height / 8 * 3 - height / 12 * 3 / 2, height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 1 - height / 24,
            height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 1 - height / 24, height / 8 * 3 - height / 12 * 3 / 2, height / 8 * 4 - height / 12 * 3 / 2, height / 8 * 5 - height / 12 * 3 / 2, height / 8 * 6 - height / 12 * 3 / 2};
    private int currentPosition1 = 0, currentPosition2 = 0;
    private boolean isSetting = false, isPlayer1 = true;

    //<---------------------------------------------------------------------------Game Control---------------------------------------------------------------------->
    private Thread counter;
    private ArrayList<Thread> saveThread = new ArrayList<>();
    static int CountThread = 0;

    //หน้าจอ
    private EventView pokemonFightview, test;


    public int CheckFirstRound = 0;
    private int random = 0;
    private int warring = 0;


    // State
    private boolean boolCatching = false,
            boolviewcatch = false,
            boolBeforeFight = false;
    public int CountRound = 0;
    private boolean stopfight = true;
    private boolean playerFight = false;


    private boolean state = true;

    // JoptinPlane
    private String[] response = {"Fight, Catch"};
    private int input;
    private JOptionPane MyJOptionPane;


    // Player
    private Player playerA;
    private Player playerB;
    private int FirstPerson = 0;
    private int CountRun = 0;

    private Pokemon enemyPokemon;

    // Rolling
    private int CountRoll = 0;

    // Test ระบบเกม
    int HP = 100;
    private ArrayList<EventView> eventView = new ArrayList<EventView>();


    //<-------------------------------------------------------------------------------------------------------------------------------------------------------------->

    public GameController() {

        //<-------------------------------------Game Control------------------------------------------------>
        playerA = new Player(1);
        playerB = new Player(2);
        gameView = new GameView(width, height, playerA, playerB);
        Thread thread = new Thread(gameView);
        thread.start();
        gameView.getMenuView().getStartPanel().addMouseListener(this);
        gameView.getMenuView().getTutorialPanel().addMouseListener(this);
        gameView.getMenuView().getSettingPanel().addMouseListener(this);
        gameView.getMenuView().getExitPanel().addMouseListener(this);
        System.out.println("==================================");
        System.out.println("=Player: name " + playerA.getName() + "=");
        System.out.println("=Have " + playerA.getPokemons().size() + " Pokemon=");
        for (int i = 0; i < playerA.getPokemons().size(); i++) {
            System.out.println(i + " POkemon" + playerA.getPokemon(i).getName());
            System.out.println("HP of Pokemon: " + i + " = " + playerA.getPokemon(i).getHP());
            System.out.println("ATK of Pokemon: " + i + " = " + playerA.getPokemon(i).getATK());
            System.out.println("Type of Pokemon: " + i + " = " + playerA.getPokemon(i).getType());
        }
        System.out.println("======================");
        System.out.println("=Player:name" + playerB.getName() + "=");
        System.out.println("=Have " + playerB.getPokemons().size() + " Pokemon=");
        for (int i = 0; i < playerA.getPokemons().size(); i++) {
            System.out.println(i + " POkemon" + playerB.getPokemon(i).getName());
            System.out.println("HP of Pokemon: " + i + " = " + playerB.getPokemon(i).getHP());
            System.out.println("ATK of Pokemon: " + i + " = " + playerB.getPokemon(i).getATK());
            System.out.println("Type of Pokemon: " + i + " = " + playerB.getPokemon(i).getType());
        }
        System.out.println("==================================");
    }

    public void run() {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(gameView.getMenuView().getStartPanel())) {
            gameView.remove(gameView.getMenuView());
            gameView.revalidate();
            gameView.repaint();
//                state = STATE.GAME;
            gameView.getPlayer1().setPreferredSize(new Dimension(height / 24 * 3 / 2, height / 12 * 3 / 2));
            gameView.getPlayer1().setBackground(new Color(0, 0, 0, 0));
            gameView.getPlayer1().setBounds(height / 8 * 7 - height / 24, height / 8 * 7 - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
            gameView.add(gameView.getPlayer1());

            gameView.getPlayer2().setPreferredSize(new Dimension(height / 24 * 3 / 2, height / 12 * 3 / 2));
            gameView.getPlayer1().setBackground(new Color(0, 0, 0, 0));
            gameView.getPlayer2().setBounds(height / 8 * 7 - height / 24 + height / 48, height / 8 * 7 - height / 24 * 2, height / 24 * 3 / 2, height / 12 * 3 / 2);
            gameView.add(gameView.getPlayer2());

            gameView.add(gameView.getMapView());
            gameView.getMapView().setBounds(0, 0, width, height);
            gameView.revalidate();
            gameView.repaint();
            gameView.getMapView().getSettingPanel().addMouseListener(this);
            gameView.getMapView().getRollPanel().addMouseListener(this);
        } else if (e.getSource().equals(gameView.getMenuView().getExitPanel())) {
            System.exit(0);
        } else if (e.getSource().equals(gameView.getMapView().getSettingPanel())) {
            currentPosition1 = 0;
            currentPosition2 = 0;
            gameView.dispose();
            gameView = new GameView(width, height, playerA, playerB);
            gameView.getMenuView().getStartPanel().addMouseListener(this);
            gameView.getMenuView().getTutorialPanel().addMouseListener(this);
            gameView.getMenuView().getSettingPanel().addMouseListener(this);
            gameView.getMenuView().getExitPanel().addMouseListener(this);
        }
        else if(e.getSource().equals(gameView.getMenuView().getSettingPanel()) && isSetting == false) {
            setting = new Setting(width, height, gameView);
            isSetting = true;
            setting.getFalseNotFullScreenPanel().addMouseListener(this);
            setting.getTrueNotFullScreenPanel().addMouseListener(this);
            setting.getFalseFullScreenPanel().addMouseListener(this);
            setting.getTrueFullScreenPanel().addMouseListener(this);
            setting.getSavePanel().addMouseListener(this);
            setting.getBackPanel().addMouseListener(this);
        }
        else if (e.getSource().equals(gameView.getMapView().getRollPanel())) {
            System.out.println("state" +state);
            randomNum = ThreadLocalRandom.current().nextInt(5, 6 + 1);
            this.random = randomNum;
//            currentPosition += randomNum;
            currentPosition1 %= 20;
            currentPosition2 %= 20;
            //<------------------------------------------Event Controll-------------------------------------------------------------------=>
            if(state == true) {
                if (isPlayer1 == true) {
                    gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                public void run() {
                                    //code run here
                                    go(playerA, false);
                                }
                            }, 10
                    );
                    isPlayer1 = !isPlayer1;
                    CountRun++;
                } else {
                    gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                public void run() {
                                    //code run here
                                    go(playerB, false);
                                }
                            }, 250
                    );
                    System.out.println(playerB.getName());
                    CountRun++;
                    isPlayer1 = !isPlayer1;
                }
                CountRoll += 1;
                state = false;
            }
        }
        else if(e.getSource().equals(setting.getFalseFullScreenPanel())){
            setting.getSetting().remove(setting.getFalseFullScreenPanel());
            setting.getSetting().remove(setting.getTrueNotFullScreenPanel());
            setting.getSetting().remove(setting.getSpace1());
            setting.getSetting().remove(setting.getSpace2());
            setting.getSetting().remove(setting.getSavePanel());
            setting.getSetting().remove(setting.getBackPanel());
            setting.getSetting().add(setting.getFalseNotFullScreenPanel());
            setting.getSetting().add(setting.getSpace1());
            setting.getSetting().add(setting.getTrueFullScreenPanel());
            setting.getSetting().add(setting.getSpace2());
            setting.getSetting().add(setting.getSavePanel());
            setting.getSetting().add(setting.getBackPanel());
            this.width = (int) dimension.getWidth();height = (int) dimension.getHeight();
            mapPositionWidth = new int[]{height/8*7-height/24, height/8*6-height/12,height/8*5-height/12,height/8*4-height/12,height/8*3-height/12,height/8*1-height/24,
                    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12,height/8*4-height/12,
                    height/8*5-height/12,height/8*6-height/12,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24};
            mapPositionHeight = new int[]{height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,
                    height/8*6-height/12*3/2, height/8*5-height/12*3/2, height/8*4-height/12*3/2,height/8*3-height/12*3/2,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,
                    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12*3/2,height/8*4-height/12*3/2,height/8*5-height/12*3/2,height/8*6-height/12*3/2};

            setting.getWindow().revalidate();
            setting.getWindow().repaint();
        }
        else if(e.getSource().equals(setting.getFalseNotFullScreenPanel())){
            setting.getSetting().remove(setting.getTrueFullScreenPanel());
            setting.getSetting().remove(setting.getFalseNotFullScreenPanel());
            setting.getSetting().remove(setting.getSpace1());
            setting.getSetting().remove(setting.getSpace2());
            setting.getSetting().remove(setting.getSavePanel());
            setting.getSetting().remove(setting.getBackPanel());
            setting.getSetting().add(setting.getTrueNotFullScreenPanel());
            setting.getSetting().add(setting.getSpace1());
            setting.getSetting().add(setting.getFalseFullScreenPanel());
            setting.getSetting().add(setting.getSpace2());
            setting.getSetting().add(setting.getSavePanel());
            setting.getSetting().add(setting.getBackPanel());
            this.width = 1280;height = 720;
            mapPositionWidth = new int[]{height/8*7-height/24, height/8*6-height/12,height/8*5-height/12,height/8*4-height/12,height/8*3-height/12,height/8*1-height/24,
                    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12,height/8*4-height/12,
                    height/8*5-height/12,height/8*6-height/12,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24};
            mapPositionHeight = new int[]{height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,height/8*7-height/24,
                    height/8*6-height/12*3/2, height/8*5-height/12*3/2, height/8*4-height/12*3/2,height/8*3-height/12*3/2,height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,
                    height/8*1-height/24,height/8*1-height/24,height/8*1-height/24,height/8*3-height/12*3/2,height/8*4-height/12*3/2,height/8*5-height/12*3/2,height/8*6-height/12*3/2};

            setting.getWindow().revalidate();
            setting.getWindow().repaint();
        }
        else if(e.getSource().equals(setting.getSavePanel())){
            setting.getWindow().dispose();
            gameView.dispose();
            gameView = new GameView(width, height, playerA, playerB);
            gameView.getMenuView().getStartPanel().addMouseListener(this);
            gameView.getMenuView().getTutorialPanel().addMouseListener(this);
            gameView.getMenuView().getSettingPanel().addMouseListener(this);
            gameView.getMenuView().getExitPanel().addMouseListener(this);
            isSetting = false;
        }
        else if(e.getSource().equals(setting.getBackPanel())){
            setting.getWindow().dispose();
            isSetting = false;
        }

    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource().equals(setting.getOk())){
//            setting.getWindow().dispose();
//            isOpeningSetting = false;
//        }else if(e.getSource().equals(setting.getExit())){
//            System.exit(0);
//        }
//
//    }

    //<----------------------------------------Event Control-------------------------------------------------------->
    public void SHowPokemon(Player p) {
        System.out.println("======================");
        System.out.println("=Player:name" + p.getName() + "=");
        System.out.println("=Have " + p.getPokemons().size() + " Pokemon=");
        for (int i = 0; i < p.getPokemons().size(); i++) {
            System.out.println(i + " POkemon" + p.getPokemon(i).getName());
            System.out.println("HP of Pokemon: " + i + " = " + p.getPokemon(i).getHP());
            System.out.println("ATK of Pokemon: " + i + " = " + p.getPokemon(i).getATK());
            System.out.println("Type of Pokemon: " + i + " = " + p.getPokemon(i).getType());
        }
    }

    ///Main xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


    // ActionListener ------------------------------------------------------------------------------------------------



    //MovePlayer++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    public void ramdomAndmove(Player p, boolean c){
//        //หน่วงเวลาเฉยๆๆ
//        new java.util.Timer().schedule(
//                new java.util.TimerTask(){
//                    public void run() {
//                        int random = (int) (Math.random() * (p.getMax() - p.getMin() - 1) + p.getMin()); //random
//
//                        //code run here
//                        LoopmoveMent(random, p);
//                        System.out.println(p.getName()+"สุ่มได้ "+random+" CurrentPoint is Player"+p.getName()+" are "+p.getCurrentPoint());
//
//                    }
//                },350
//        );
//    }
//    public void LoopmoveMent(int random , Player p){
//        p.setCurrentPoint(p.getBeforePoint()+random);
//        System.out.println("LoopmoveMent = "+p.getCurrentPoint());
//        if(p.getCurrentPoint()> 20){
//            p.setCurrentPoint(p.getCurrentPoint()%20);
//            p.setMyCountRound(1);
//            CountRound +=1;
//            EndRound(CountRound);
//        }
//        p.setBeforePoint(p.getCurrentPoint());
//
//    }
    public void EndRound(int checkround) {
        if (checkround == 2) {
            System.out.println("State Change");
            CountRound += 1;
            checkround = 0;
        } else {
            System.out.println("Same");
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // Go ================================================================================================
    private void go(Player p, boolean catching) {

        //สั้งให้สร้าง Thread เอาไว้สำหรับ ขยับ animation เวลาที่เราเปลี่ยนหน้าไปมา
        counter = new Thread(new movingPokemon(p, catching));
        System.out.println(CountThread);
        // เก็บ Thread ปัจจุบันไว้สำหรับ ทำง่าน และ kill เมื่อไม่ได้ใช้งาน
        saveThread.add(counter);
        System.out.println("===============================================");
        System.out.println("NOw size of SaveThread is" + saveThread.size());
        System.out.println("Now Thread " + CountThread + " is Running");
        // ั้งให้ Thread ตัวที่ 0 ทำงาน
        saveThread.get(saveThread.size() - 1).start();
        CountThread++;
        System.out.println("Counthread " + CountThread);
        System.out.println("================================================");
    }

    //MOviewPOkemon =========================================================================================
    class movingPokemon implements Runnable {
        private Player player;
        private boolean catching;

        public movingPokemon(Player p, boolean catching) {
            player = p;
            boolCatching = catching;

        }

        public void run() {
            AddView(player, boolCatching);
        }
    }

    // Addview ****************************************************************************************************
    public void AddView(Player p, boolean catching) {
        ChangeEvent(p, catching);
    }

    // เปลี่ยนหน้าตัวละคร -----------------------------------------------------------------------------------------------
    public void ChangeEvent(Player p, boolean catching) {
        System.out.println("=========================");
        System.out.println("รอบที่" +CountRound);
        System.out.println("=========================");
        if(CountRound >=2){
            BorderLayout layout = (BorderLayout) gameView.getMapView().getMapPanel().getLayout();
            gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
            gameView.getMapView().getMapPanel().revalidate();
            gameView.getMapView().getMapPanel().repaint();
            gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
            gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
            gameView.getPlayer1().repaint();
        }else{
            if (catching == false) {
                //<----------------------------------------------Rolling----------------------------------->
                //dddd
                p.setCurrentPoint(p.getBeforePoint() + random);
                if (isPlayer1 == false) {
                    currentPosition1 += random;
                    currentPosition1 %= 20;
                } else {
                    currentPosition2 += random;
                    currentPosition2 %= 20;
                }
                if (p.getCurrentPoint() > 20) {
                    p.setCurrentPoint(p.getCurrentPoint() % 20);
                    p.setMyCountRound(1);
                    CountRound += 1;
                    EndRound(CountRound);
                }
                System.out.println(p.getName() + "สุ่มได้ " + randomNum + " CurrentPoint is Player" + p.getName() + " are " + p.getCurrentPoint());
                p.setBeforePoint(p.getCurrentPoint());
                System.out.println("After Rolling :" + p.getCurrentPoint());
                //<----------------------------------------------Rolling----------------------------------->
                //ตาแรกนะครับ
                if (isPlayer1 == false) {

                    // ขยับ CheckRound
                    BorderLayout layout = (BorderLayout) gameView.getMapView().getMapPanel().getLayout();
                    gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    gameView.getMapView().getMapPanel().revalidate();
                    gameView.getMapView().getMapPanel().repaint();
                    gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer1().repaint();
                    pokemonFightview = new EventView(-2, false, false, true, p,playerB, false, width, height);
                    gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                    gameView.getMapView().getMapPanel().revalidate();
                    gameView.getMapView().getMapPanel().repaint();
                    gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer1().repaint();
                    try {
                        Thread.sleep(5000);
                    } catch (Exception i) {
                        i.printStackTrace();
                    }
                    try {
                        System.out.println("=============================Two========================");
                        System.out.println("this is Current" + p.getCurrentPoint());
                        pokemonFightview = new EventView(p.getCurrentPoint(),
                                false,
                                false,
                                false,
                                p,
                                playerB,
                                false,
                                width,
                                height);
                        gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                        gameView.getMapView().getMapPanel().revalidate();
                        gameView.getMapView().getMapPanel().repaint();
                        gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer1().repaint();
                        gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                        gameView.getMapView().getMapPanel().revalidate();
                        gameView.getMapView().getMapPanel().repaint();
                        gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer1().repaint();
                        if (p.getCurrentPoint() == 5 || p.getCurrentPoint() == 10 || p.getCurrentPoint() == 15) {
                            state = true;
                        }
                        if (gameView.getMapView().getMapPanel().isDisplayable() && (p.getCurrentPoint() != 5 && p.getCurrentPoint() != 10 && p.getCurrentPoint() != 15 && p.getCurrentPoint() != 20))
                            System.out.println("Attack!");
                        {
                            move(gameView, pokemonFightview, p);
                        }
                    } catch (Exception i) {
                        i.printStackTrace();
                    }

                }
                // ถ้าCatching ไม่เท่ากับ true หมายความว่า animation ที่กำลังจะสรา้งจะเป็น อนิเมชั่นต่อสู้ทันที่
                if (isPlayer1 == true) {

                    //<-------------------------Two----------------------------------------------------------->
                    // หยุดการทำงานของ Thread และ ลบ Thread ตัวนั้นออกจาก List
                    BorderLayout layout = (BorderLayout) gameView.getMapView().getMapPanel().getLayout();
                    gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    gameView.getMapView().getMapPanel().revalidate();
                    gameView.getMapView().getMapPanel().repaint();
                    gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer1().repaint();
                    pokemonFightview = new EventView(-2, false, false, true, p,playerA, false, width, height);
                    gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                    gameView.getMapView().getMapPanel().revalidate();
                    gameView.getMapView().getMapPanel().repaint();
                    gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                    gameView.getPlayer1().repaint();
                    try {
                        Thread.sleep(5000);
                    } catch (Exception i) {
                        i.printStackTrace();
                    }
                    try {
                        System.out.println("=============================Two========================");
                        System.out.println("this is Current" + p.getCurrentPoint());
                        pokemonFightview = new EventView(p.getCurrentPoint(),
                                false,
                                false,
                                false,
                                p,
                                playerA,
                                false,
                                width,
                                height);

                        gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                        gameView.getMapView().getMapPanel().revalidate();
                        gameView.getMapView().getMapPanel().repaint();
                        gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer1().repaint();
                        gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                        gameView.getMapView().getMapPanel().revalidate();
                        gameView.getMapView().getMapPanel().repaint();
                        gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                        gameView.getPlayer1().repaint();
                        if (p.getCurrentPoint() == 5 || p.getCurrentPoint() == 10 || p.getCurrentPoint() == 15) {
                            state = true;
                        }
                        if (gameView.getMapView().getMapPanel().isDisplayable() && (p.getCurrentPoint() != 5 && p.getCurrentPoint() != 10 && p.getCurrentPoint() != 15 && p.getCurrentPoint() != 20))
                            System.out.println("Attack!");
                        {
                            move(gameView, pokemonFightview, p);
                        }
                    } catch (Exception i) {
                        i.printStackTrace();
                    }

                }
                CheckFirstRound += 1;
                gameView.getPlayer1().repaint();

            }
            // สำหรับหน้าที่กำลังจับโปเกม่อน
            if (catching == true) {
                System.out.println("Catching in ChangeEvent");
                pokemonFightview = new EventView(-1,
                        false,
                        true,
                        false,
                        p,
                        playerA,
                        false,
                        width,
                        height);
                BorderLayout layout = (BorderLayout) gameView.getMapView().getMapPanel().getLayout();
                gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                gameView.getMapView().getMapPanel().revalidate();
                gameView.getMapView().getMapPanel().repaint();

            }
        }
    }


    //Player Fighting ==========================================================================================================================================================================
    public void playerFight(JFrame gameView, EventView eventView, Player playerA, Player PlayerB) {
        try {
            // อยากจะให้เริ่มเดินเมื่อไหร่ ปรับตรงนี้ ถ้าตอนการให้เดินเลย ปรับให้เท่ากับข้างบน
            Thread.sleep(50);
            if (stopfight) {
                while (true) {
                    if (eventView.first) {
                        FightingA(gameView, eventView, playerA, PlayerB);
                    } else {
                        FightingB(gameView, eventView, playerA, PlayerB);
                    }
                }
            } else {
                System.out.println("not run");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void FightingA(JFrame gameView, EventView eventView, Player A, Player B){
        try {
            TimeUnit.MILLISECONDS.sleep(5);
            if (eventView.right) {
                eventView.xEnemyPokemon++;
                if (eventView.xEnemyPokemon == 100) {
                    //Fighting
                    eventView.right = false;
                }
            }
            if (!eventView.right) {
                eventView.xEnemyPokemon--;
                if (eventView.xEnemyPokemon == 0) {
                    gameView.repaint();
                    pauseBlack();
                    eventView.right = true;
                    eventView.first = false;
                }
            }
            gameView.repaint();

        }
        catch (InterruptedException i) {
            Thread.currentThread().interrupt();
        }

    }
    public void FightingB(JFrame gameView, EventView eventView, Player A, Player B){
        try {
            TimeUnit.MILLISECONDS.sleep(5);
            if (eventView.left) {
                eventView.xPlayerPokenom--;
                if (eventView.xPlayerPokenom == 150) {
                        //Fighting
                    eventView.left = false;
                }
            }
            if (!eventView.left) {
                eventView.xPlayerPokenom++;
                if (eventView.xPlayerPokenom == 200) {
                    gameView.repaint();
                    pauseBlack();
                    eventView.left = true;
                    eventView.first = true;
                }
            }
            gameView.repaint();
        } catch (InterruptedException i) {
            Thread.currentThread().interrupt();
        }

    }



    // Move โปนเกม่อน>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void move(JFrame gameView, EventView eventView, Player player) {
        try {
            boolviewcatch = false;
            warring = 0;
            // อยากจะให้เริ่มเดินเมื่อไหร่ ปรับตรงนี้ ถ้าตอนการให้เดินเลย ปรับให้เท่ากับข้างบน
            Thread.sleep(50);
            if (stopfight) {
                while (true) {
                    if (eventView.first) {
                        moveEnemy(gameView, eventView, player);
                    } else {
                        PlayerPokemon(gameView, eventView, player);
                    }
                }
            } else {
                System.out.println("not run");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ชยับโปรเก่มอนศัตรู มุมบนขวา
    public   void moveEnemy(JFrame f ,EventView eventView, Player player){
        try {
            TimeUnit.MILLISECONDS.sleep(5);
            if (eventView.right) {
                eventView.xEnemyPokemon++;
                if (eventView.xEnemyPokemon == 100)
                {
                    if(eventView.getEnemyPokemon().getName() != null) {
                        System.out.println("--------------------------------");
                        System.out.println("Enemy Pokemo : "+eventView.getEnemyPokemon().getName());
                        System.out.println("Attck : "+player.getPokemon(0).getName());
                        System.out.println("ATK EnemyPokemon "+ eventView.getEnemyPokemon().getATK());
                        if(player.getPokemon(0).getHP()>0) {
                            EnemyAttack(eventView.getEnemyPokemon(), player.getPokemon(0));
                        }
                        else{
                            System.out.println("stop");
                        }
                        System.out.println("HP EnemyPokkemon : "+eventView.getEnemyPokemon().getHP());
                        System.out.println("HP PlayerPokkemon : "+player.getPokemon(0).getHP());
                        System.out.println("--------------------------------");
                    }
                    eventView.right = false;
                }
            }
            if (!eventView.right) {
                eventView.xEnemyPokemon--;
                if (eventView.xEnemyPokemon == 0) {
                    f.repaint();
                    pauseBlack();
                    eventView.right = true;
                    eventView.first = false;
                }
            }
            f.repaint();

        }
        catch (InterruptedException i) {
            Thread.currentThread().interrupt();
        }

    }
    public   void PlayerPokemon(JFrame internalFrame , EventView eventView, Player player) {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
            if (eventView.left) {
                eventView.xPlayerPokenom--;
                if (eventView.xPlayerPokenom == 150) {
                    if(eventView.getEnemyPokemon().getName() != null) {
                        System.out.println("--------------------------------");
                        System.out.println("Player Pokemon : " + player.getPokemon(0).getName());
                        System.out.println("Attck : " + eventView.getEnemyPokemon().getName());
                        System.out.println("ATK PlayerPokemon " + player.getPokemon(0).getATK());
                        if(eventView.getEnemyPokemon().getHP()>0) {
                            PlayerAttack(player.getPokemon(0), eventView.getEnemyPokemon());
                        }
                        System.out.println("HP EnemyPokkemon : "+eventView.getEnemyPokemon().getHP());
                        System.out.println("HP PlayerPokkemon : "+player.getPokemon(0).getHP());
                        System.out.println("--------------------------------");
                    }
                    eventView.left = false;
                }
            }
            if (!eventView.left) {
                eventView.xPlayerPokenom++;
                if (eventView.xPlayerPokenom == 200) {
                    internalFrame.repaint();
                    pauseBlack();
                    eventView.left = true;
                    eventView.first = true;
                }
            }
            internalFrame.repaint();
        } catch (InterruptedException i) {
            Thread.currentThread().interrupt();
        }

    }

    public void pauseBlack(){
        try {
            Thread.sleep((long) (1900));
        } catch(InterruptedException  e){
            Thread.currentThread().interrupt();
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    // ทำหน้าจับหรือปล่อย โปรเกม่อน
    public void EnemyAttack(Pokemon enemypokemon, Pokemon playerpokemon) {
        if(enemypokemon.getHP() > 30) {
            enemypokemon.attack(playerpokemon);
        }

    }
    public void PlayerAttack(Pokemon playerpokenon, Pokemon enmemypokemon) {
        BorderLayout layout = (BorderLayout) gameView.getMapView().getMapPanel().getLayout();
        System.out.println("boolviewCatch"+boolviewcatch);
        playerpokenon.attack(enmemypokemon);
        if (enmemypokemon.getHP() < 30 && warring == 0) {
            warring += 1;
            // ไม่เข้าใจแม่งเหมือนกัน แค่รู้ว่าใช้แล้ว Thread ตัวนั้นหยุดทำงาน
            String[] options = new String[]{"Catch", "Fight"};
            int response = JOptionPane.showOptionDialog(null, "Enemy Pokemon LOW!", "Catch Or Fight",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if(response == 0) {
                if(CountRound >=3){
                    playerFight = true;
                }
                boolviewcatch = true;
                if (isPlayer1 == false) {
                    playerA.getPokemons().add(enmemypokemon);
                    if(playerA.getPokemons().size()==2){
                        JPanel pokemon2_1 = new ImagePanel(playerA.getPokemons().get(1).getPokemonImage(), height/12, height/12);
                        pokemon2_1.setPreferredSize(new Dimension(height/12, height/12));
                        pokemon2_1.setBackground(new Color(0,0,0,0));
                        gameView.getMapView().setPokemon2_1(pokemon2_1);
                        gameView.getMapView().getPokemon2Panel1().add(gameView.getMapView().getPokemon2_1());
                        gameView.getMapView().revalidate();
                        gameView.getMapView().repaint();
                    }else if(playerA.getPokemons().size()==3){
                        JPanel pokemon3_1 = new ImagePanel(playerA.getPokemons().get(2).getPokemonImage(), height/12, height/12);
                        pokemon3_1.setPreferredSize(new Dimension(height/12, height/12));
                        pokemon3_1.setBackground(new Color(0,0,0,0));
                        gameView.getMapView().setPokemon3_1(pokemon3_1);
                        gameView.getMapView().getPokemon3Panel1().add(gameView.getMapView().getPokemon3_1());
                        gameView.getMapView().revalidate();
                        gameView.getMapView().repaint();
                    }else{
                        playerA.removePokemon();
                        gameView.getMapView().getPokemon1Panel1().remove(gameView.getMapView().getPokemon1_1());
                        JPanel pokemon1_1 = new ImagePanel(playerA.getPokemons().get(0).getPokemonImage(), height/12, height/12);
                        pokemon1_1.setPreferredSize(new Dimension(height/12, height/12));
                        pokemon1_1.setBackground(new Color(0,0,0,0));
                        gameView.getMapView().setPokemon1_1(pokemon1_1);
                        gameView.getMapView().getPokemon1Panel1().add(pokemon1_1);

                        gameView.getMapView().getPokemon2Panel1().remove(gameView.getMapView().getPokemon2_1());
                        JPanel pokemon2_1 = new ImagePanel(playerA.getPokemons().get(1).getPokemonImage(), height/12, height/12);
                        pokemon2_1.setPreferredSize(new Dimension(height/12, height/12));
                        pokemon2_1.setBackground(new Color(0,0,0,0));
                        gameView.getMapView().setPokemon2_1(pokemon2_1);
                        gameView.getMapView().getPokemon2Panel1().add(pokemon2_1);

                        gameView.getMapView().getPokemon3Panel1().remove(gameView.getMapView().getPokemon3_1());
                        JPanel pokemon3_1 = new ImagePanel(playerA.getPokemons().get(2).getPokemonImage(), height/12, height/12);
                        pokemon3_1.setPreferredSize(new Dimension(height/12, height/12));
                        pokemon3_1.setBackground(new Color(0,0,0,0));
                        gameView.getMapView().setPokemon3_1(pokemon3_1);
                        gameView.getMapView().getPokemon3Panel1().add(pokemon3_1);

                        gameView.getMapView().getVariousMenuPanel().revalidate();
                        gameView.getMapView().getVariousMenuPanel().repaint();
                    }

                    System.out.println("Now A have pokemon "+playerB.getPokemons().size());
                    gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    pokemonFightview = new EventView(-1,
                            false,
                            true,
                            false,
                            playerA,
                            playerB,
                            false,
                            width,
                            height);
                    try{
                        Thread.sleep(5);
                        saveThread.get(0).interrupt();
                        saveThread.remove(0);
                    }catch(Exception e){
                        Thread.currentThread().interrupt(); // propagate interrupt
                    }

                    gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                    gameView.getMapView().getMapPanel().revalidate();
                    gameView.getMapView().getMapPanel().repaint();


                } else {
                    playerB.getPokemons().add(enmemypokemon);
                    if (playerB.getPokemons().size() == 2) {
                        JPanel pokemon2_2 = new ImagePanel(playerB.getPokemons().get(1).getPokemonImage(), height / 12, height / 12);
                        pokemon2_2.setPreferredSize(new Dimension(height / 12, height / 12));
                        pokemon2_2.setBackground(new Color(0, 0, 0, 0));
                        gameView.getMapView().setPokemon2_2(pokemon2_2);
                        gameView.getMapView().getPokemon2Panel2().add(gameView.getMapView().getPokemon2_2());
                        gameView.getMapView().revalidate();
                        gameView.getMapView().repaint();
                    } else if (playerB.getPokemons().size() == 3) {
                        JPanel pokemon3_2 = new ImagePanel(playerB.getPokemons().get(2).getPokemonImage(), height / 12, height / 12);
                        pokemon3_2.setPreferredSize(new Dimension(height / 12, height / 12));
                        pokemon3_2.setBackground(new Color(0, 0, 0, 0));
                        gameView.getMapView().setPokemon3_2(pokemon3_2);
                        gameView.getMapView().getPokemon3Panel2().add(gameView.getMapView().getPokemon3_2());
                        gameView.getMapView().revalidate();
                        gameView.getMapView().repaint();
                    } else {
                        playerB.removePokemon();

                        gameView.getMapView().getPokemon1Panel2().remove(gameView.getMapView().getPokemon1_2());
                        JPanel pokemon1_2 = new ImagePanel(playerB.getPokemons().get(0).getPokemonImage(), height / 12, height / 12);
                        pokemon1_2.setPreferredSize(new Dimension(height / 12, height / 12));
                        pokemon1_2.setBackground(new Color(0, 0, 0, 0));
                        gameView.getMapView().setPokemon1_2(pokemon1_2);
                        gameView.getMapView().getPokemon1Panel2().add(pokemon1_2);

                        gameView.getMapView().getPokemon2Panel2().remove(gameView.getMapView().getPokemon2_2());
                        JPanel pokemon2_2 = new ImagePanel(playerB.getPokemons().get(1).getPokemonImage(), height / 12, height / 12);
                        pokemon2_2.setPreferredSize(new Dimension(height / 12, height / 12));
                        pokemon2_2.setBackground(new Color(0, 0, 0, 0));
                        gameView.getMapView().setPokemon2_2(pokemon2_2);
                        gameView.getMapView().getPokemon2Panel2().add(pokemon2_2);

                        gameView.getMapView().getPokemon3Panel2().remove(gameView.getMapView().getPokemon3_2());
                        JPanel pokemon3_2 = new ImagePanel(playerB.getPokemons().get(2).getPokemonImage(), height / 12, height / 12);
                        pokemon3_2.setPreferredSize(new Dimension(height / 12, height / 12));
                        pokemon3_2.setBackground(new Color(0, 0, 0, 0));
                        gameView.getMapView().setPokemon3_2(pokemon3_2);
                        gameView.getMapView().getPokemon3Panel2().add(pokemon3_2);

                        gameView.getMapView().getVariousMenuPanel().revalidate();
                        gameView.getMapView().getVariousMenuPanel().repaint();
                    }
                    System.out.println("Now b have pokemon " + playerB.getPokemons().size());
                    gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    pokemonFightview = new EventView(-1,
                            false,
                            true,
                            false,
                            playerB,
                            playerA,
                            false,
                            width,
                            height);
                    try{
                        Thread.sleep(5);
                        saveThread.get(0).interrupt();
                        saveThread.remove(0);
                    }catch(Exception e){
                        Thread.currentThread().interrupt(); // propagate interrupt
                    }
                    gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                    gameView.getMapView().getMapPanel().revalidate();
                    gameView.getMapView().getMapPanel().repaint();

                }
                try{
                    saveThread.get(0).interrupt();
                    saveThread.remove(0);
                }catch(Exception e){
                    Thread.currentThread().interrupt(); // propagate interrupt
                }
            }
            try{
                saveThread.get(0).interrupt();
                saveThread.remove(0);
            }catch(Exception e){
                Thread.currentThread().interrupt(); // propagate interrupt
            }

        }
        if(enmemypokemon.getHP() <= 0 && boolviewcatch == false){
            System.out.println("DIED");
            gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
            if(isPlayer1 == false){
                //เพิ่ม HP Pokemon ของ Player A
                for(int i = 0; i<playerA.getPokemons().size(); i++) {
                    playerA.getPokemon(i).setHP(60);
                    playerA.getPokemon(i).setATK(60);

                }

                // สร้างหน้าที่บอกว่าโปเกม่อนตาย
                pokemonFightview = new EventView(-3,
                        false,
                        false,
                        false,
                        playerA,
                        playerB,
                        true,
                        width,
                        height);
                gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                gameView.getMapView().getMapPanel().revalidate();
                gameView.getMapView().getMapPanel().repaint();
                try {
                    saveThread.get(0).interrupt();
                    saveThread.remove(0);
                } catch (Exception i) {
                    i.printStackTrace();
                }
                state = true;
            }
            else if(isPlayer1 == true){
                // เพิ่ม HP pokomon ของ Player B
                for(int i = 0; i<playerA.getPokemons().size(); i++) {
                    playerB.getPokemon(i).setHP(60);
                    playerB.getPokemon(i).setATK(60);
                }
                System.out.println("player + kill enemy");
                pokemonFightview = new EventView(-3,
                        false,
                        false,
                        false,
                        playerB,
                        playerA,
                        true,
                        width,
                        height);
                gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                gameView.getMapView().getMapPanel().revalidate();
                gameView.getMapView().getMapPanel().repaint();

                try {
                    saveThread.get(0).interrupt();
                    saveThread.remove(0);
                } catch (Exception i) {
                    i.printStackTrace();
                }
                state = true;
            }

        }

        if(CountRound  >= 2 && playerFight == true){

            gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
            pokemonFightview = new EventView(-200,
                    true,
                    false,
                    false,
                    playerB,
                    playerA,
                    true,
                    width,
                    height);
            gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
            gameView.getMapView().getMapPanel().revalidate();
            gameView.getMapView().getMapPanel().repaint();
            try{
                saveThread.get(0).interrupt();
                saveThread.remove(0);
            }catch(Exception e){
                Thread.currentThread().interrupt(); // propagate interrupt
            }

        }
        state = true;

    }
    // JoptionPlane =======================================================================
    public  void GetJoptionPlane(){
        ImageIcon Icon= new ImageIcon("C:\\Users\\wallr\\Downloads\\pokeball-gif.gif");
        Image image = Icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        Icon = new ImageIcon(newimg);  // transform it back
        input = JOptionPane.showOptionDialog(gameView,
                "HP enemyPokemon are low!",
                "Choses!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.YES_NO_OPTION,
                Icon,
                response,
                0
        );

    }
}

