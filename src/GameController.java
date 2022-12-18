import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class GameController implements MouseListener, ActionListener, Runnable {
    //    private MapView mapView;
    private Setting setting;
    private GameView gameView;
    private MainMapView mapView;
    private boolean isOpeningSetting = false;
    private int randomNum;
    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = 1280, height = 720;
    //    private int width = (int) dimension.getWidth(), height = (int) dimension.getHeight();
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
    private MainView mainview;
    private EventView pokemonFightview, test;


    public int CheckFirstRound = 0;
    private int random = 0;
    private int warring = 0;


    // State
    private boolean boolCatching = false,
            boolFighting = false,
            boolBeforeFight = false;
    public int CountRound = 0;
    private boolean stopfight = true;

    // JoptinPlane
    private String[] response = {"Fight, Catch"};
    private int input;
    private JOptionPane MyJOptionPane;


    // Player
    private Player playerA;
    private Player playerB;
    private int FirstPerson = 0;

    private Pokemon enemyPokemon;

    // Rolling
    private int CountRoll = 0;

    // Test ระบบเกม
    int HP = 100;
    private ArrayList<EventView> eventView = new ArrayList<EventView>();
    private EventView testpokemonFightview = new EventView(-1,
            false,
            true,
            false,
            playerA);

    //<-------------------------------------------------------------------------------------------------------------------------------------------------------------->

    public GameController() {
        gameView = new GameView(width, height);
        mapView = new MainMapView(width, height);
        Thread thread = new Thread(gameView);
        thread.start();
        gameView.getMenuView().getStartPanel().addMouseListener(this);
        gameView.getMenuView().getTutorialPanel().addMouseListener(this);
        gameView.getMenuView().getSettingPanel().addMouseListener(this);
        gameView.getMenuView().getExitPanel().addMouseListener(this);
        //<-------------------------------------Game Control------------------------------------------------>

        playerA = new Player(1);
        playerB = new Player(2);
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
            setting = new Setting(gameView.getMapView().getWidth(), gameView.getMapView().getHeight(), gameView);
            setting.getOk().addActionListener(this);
            setting.getExit().addActionListener(this);
        } else if (e.getSource().equals(gameView.getMapView().getRollPanel())) {
            randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            this.random = randomNum;
//            currentPosition += randomNum;
            currentPosition1 %= 20;
            currentPosition2 %= 20;
            //<------------------------------------------Event Controll-------------------------------------------------------------------=>

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
                isPlayer1 = !isPlayer1;
            }
            CountRoll += 1;
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
    public static void main(String[] args) {
        new ControlGame();
    }

    // ActionListener ------------------------------------------------------------------------------------------------


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mainview.getBtnRoll())) {

        }
        if (e.getSource().equals(setting.getOk())) {
            setting.getWindow().dispose();
            isOpeningSetting = false;
        } else if (e.getSource().equals(setting.getExit())) {
            System.exit(0);
        }
    }

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
        System.out.println("Check kuay"+FirstPerson);
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
            if (isPlayer1 == false && FirstPerson == 0) {
                FirstPerson+=1;
                System.out.println("<<<<<<<<<<<<<<FistTime>>>>>>>>>>>>>");
                // wait ตามจำนวนเวลาที่ถอยลูกเต๋า
                try {
                    Thread.sleep(350);
                } catch (Exception i) {
                    i.printStackTrace();
                }
                pokemonFightview = new EventView(p.getCurrentPoint(),
                        false,
                        false,
                        false,
                        p);
                System.out.println("Change!!!");
                gameView.getMapView().getMapPanel().remove(gameView.getMapView().getEventView());
                gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
                gameView.getMapView().getMapPanel().revalidate();
                gameView.getMapView().getMapPanel().repaint();
                gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                gameView.getPlayer1().repaint();
                // สั้งให้ต่อสู้
                System.out.println("Enemy pokemon =" + pokemonFightview.getEnemyPokemon().getName());
                System.out.println("Attack!");
                if (gameView.getMapView().getMapPanel().isDisplayable()) {
                    move(gameView,  pokemonFightview, p);
                }
                // ขยับ CheckRound

            }
            // ถ้าCatching ไม่เท่ากับ true หมายความว่า animation ที่กำลังจะสรา้งจะเป็น อนิเมชั่นต่อสู้ทันที่
            if (FirstPerson!=0) {
                //<-------------------------Two----------------------------------------------------------->
                // หยุดการทำงานของ Thread และ ลบ Thread ตัวนั้นออกจาก List
                BorderLayout layout = (BorderLayout) gameView.getMapView().getMapPanel().getLayout();
                gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                gameView.getMapView().getMapPanel().revalidate();
                gameView.getMapView().getMapPanel().repaint();
                gameView.getPlayer1().setBounds(mapPositionWidth[currentPosition1] - height / 48, mapPositionHeight[currentPosition1] - height / 48, height / 24 * 3 / 2, height / 12 * 3 / 2);
                gameView.getPlayer2().setBounds(mapPositionWidth[currentPosition2] + height / 48, mapPositionHeight[currentPosition2] - height / 24, height / 24 * 3 / 2, height / 12 * 3 / 2);
                gameView.getPlayer1().repaint();
                pokemonFightview = new EventView(-2, false, false, true, p);
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
                            p);
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
                    saveThread.get(0).interrupt();
                    saveThread.remove(0);
                    System.out.println("Attack!");
                    if (gameView.getMapView().getMapPanel().isDisplayable() && FirstPerson !=0) {
                        move(gameView,  pokemonFightview, p);
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
                    p);
            gameView.getMapView().getMapPanel().add(pokemonFightview, BorderLayout.CENTER);
            gameView.getMapView().getMapPanel().revalidate();
            gameView.getMapView().getMapPanel().repaint();
        }
    }

    //RepainView ===========================================================


    // Move โปนเกม่อน>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public void move(JFrame gameView, EventView eventView, Player player) {
        try {
            // อยากจะให้เริ่มเดินเมื่อไหร่ ปรับตรงนี้ ถ้าตอนการให้เดินเลย ปรับให้เท่ากับข้างบน
            Thread.sleep(5000);
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

        if (enemypokemon.getHP()<5 && warring==0) {
            warring +=1;
            // ไม่เข้าใจแม่งเหมือนกัน แค่รู้ว่าใช้แล้ว Thread ตัวนั้นหยุดทำงาน
            synchronized (saveThread.get(0)) {
                try {
                    Thread.sleep(10);
                    GetJoptionPlane();
                    System.out.println("Joptionpaint");
                    if (input == MyJOptionPane.YES_OPTION) {
                        saveThread.get(0).wait();
                        go(playerA, true);
                        System.out.println("fight");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public void PlayerAttack(Pokemon playerpokenon, Pokemon enmemypokemon) {
        playerpokenon.attack(enmemypokemon);
        if (enmemypokemon.getHP() < 30 && warring == 0) {
            warring +=1;
            // ไม่เข้าใจแม่งเหมือนกัน แค่รู้ว่าใช้แล้ว Thread ตัวนั้นหยุดทำงาน
            String[] options = new String[] {"Catch", "Fight"};
            int response = JOptionPane.showOptionDialog(null, "Enemy Pokemon LOW!", "Catch Or Fight",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            synchronized (saveThread.get(0)){
                if(response ==0){
                    System.out.println("Cathing");
                    try {
                        System.out.println("stop");
                        saveThread.get(0).interrupt();
                        saveThread.remove(0);
                    }catch (Exception i){

                    }
                    BorderLayout layout = (BorderLayout)gameView.getMapView().getMapPanel().getLayout();
                    gameView.getMapView().getMapPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                    if(isPlayer1 == false){
                        go(playerA, true);
                    }else{
                        go(playerB, true);
                    }
                }
            }

        }
        else if(enemyPokemon.getHP() < 0){
            synchronized (saveThread.get(0)){
                try {
                    saveThread.get(0).interrupt();
                    saveThread.remove(0);
                }catch(Exception i){

                }
            }
        }

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

