//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//
//public class ControlGame implements ActionListener {
//
//    //Thread
//    private Thread counter;
//    private ArrayList <Thread> saveThread = new ArrayList<>();
//    static  int CountThread = 0;
//
//    //หน้าจอ
//    private MainView mainview;
//    private EventView pokemonFightview ,test;
//    private boolean SecondMoreRound = true;
//
//    private JInternalFrame internalFrame;
//
//    public int CheckFirstRound = 0;
//
//
//    // State
//    private boolean boolCatching = false,
//                    boolFighting = false,
//                    boolBeforeFight = false;
//    public int CountRound  =0;
//
//    // JoptinPlane
//    private String[] response = {"Fight, Catch"};
//    private int input;
//    private JOptionPane MyJOptionPane;
//
//
//    // Player
//
//
//    private Player playerA;
//    private Player playerB;
//
//    private Pokemon enemyPokemon;
//
//    // Rolling
//    private int CountRoll = 0;
//
//    // Test ระบบเกม
//    int HP = 100;
//    private ArrayList<EventView> eventView = new ArrayList<EventView>();
//
//    //**********************************************************************************************************************
//
//    // Constructor --------------------------------------------------------------------------------------------------
//    public ControlGame(){
//        playerA = new Player(1);
//        playerB = new Player(2);
//        internalFrame = new JInternalFrame();
//        mainview = new MainView();
//        internalFrame.setVisible(true);
//        mainview.getBtnRoll().addActionListener(this);
//        System.out.println("==================================");
//        System.out.println("=Player: name " +playerA.getName()+"=");
//        System.out.println("=Have "+playerA.getPokemons().size()+" Pokemon=");
//        for(int i = 0; i<playerA.getPokemons().size();i++){
//            System.out.println(i+" POkemon"+playerA.getPokemon(i).getName());
//            System.out.println("HP of Pokemon: "+i+" = "+ playerA.getPokemon(i).getHP());
//            System.out.println("ATK of Pokemon: "+i+" = "+ playerA.getPokemon(i).getATK());
//            System.out.println("Type of Pokemon: "+i+" = "+ playerA.getPokemon(i).getType());
//        }
//        System.out.println("======================");
//        System.out.println("=Player:name" +playerB.getName()+"=");
//        System.out.println("=Have "+playerB.getPokemons().size()+" Pokemon=");
//        for(int i = 0; i<playerA.getPokemons().size();i++){
//            System.out.println(i+" POkemon"+playerB.getPokemon(i).getName());
//            System.out.println("HP of Pokemon: "+i+" = "+ playerB.getPokemon(i).getHP());
//            System.out.println("ATK of Pokemon: "+i+" = "+ playerB.getPokemon(i).getATK());
//            System.out.println("Type of Pokemon: "+i+" = "+ playerB.getPokemon(i).getType());
//        }
//        System.out.println("==================================");
//
//    }
//    public void SHowPokemon(Player p){
//        System.out.println("======================");
//        System.out.println("=Player:name" +p.getName()+"=");
//        System.out.println("=Have "+p.getPokemons().size()+" Pokemon=");
//        for(int i = 0; i<p.getPokemons().size();i++){
//            System.out.println(i+" POkemon"+p.getPokemon(i).getName());
//            System.out.println("HP of Pokemon: "+i+" = "+ p.getPokemon(i).getHP());
//            System.out.println("ATK of Pokemon: "+i+" = "+ p.getPokemon(i).getATK());
//            System.out.println("Type of Pokemon: "+i+" = "+ p.getPokemon(i).getType());
//        }
//    }
//
//    ///Main xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//    public static void main(String[] args) {
//        new ControlGame();
//    }
//
//    // ActionListener ------------------------------------------------------------------------------------------------
//
//
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource().equals(mainview.getBtnRoll())){
//            if(CountRoll % 2 == 0){
//                new java.util.Timer().schedule(
//                        new java.util.TimerTask() {
//                            public void run() {
//                                //code run here
//                                go(playerA, false);
//                            }
//                        }, 10
//                );
//            }
//            else{
//                new java.util.Timer().schedule(
//                        new java.util.TimerTask() {
//
//                            public void run() {
//                                //code run here
//                                go(playerB ,false);
//                            }
//                        }, 250
//                );
//                System.out.println(playerB.getName());
//            }
//            CountRoll+=1;
//        }
//    }
//
//    //MovePlayer++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
////    public void ramdomAndmove(Player p, boolean c){
////        //หน่วงเวลาเฉยๆๆ
////        new java.util.Timer().schedule(
////                new java.util.TimerTask(){
////                    public void run() {
////                        int random = (int) (Math.random() * (p.getMax() - p.getMin() - 1) + p.getMin()); //random
////
////                        //code run here
////                        LoopmoveMent(random, p);
////                        System.out.println(p.getName()+"สุ่มได้ "+random+" CurrentPoint is Player"+p.getName()+" are "+p.getCurrentPoint());
////
////                    }
////                },350
////        );
////    }
////    public void LoopmoveMent(int random , Player p){
////        p.setCurrentPoint(p.getBeforePoint()+random);
////        System.out.println("LoopmoveMent = "+p.getCurrentPoint());
////        if(p.getCurrentPoint()> 20){
////            p.setCurrentPoint(p.getCurrentPoint()%20);
////            p.setMyCountRound(1);
////            CountRound +=1;
////            EndRound(CountRound);
////        }
////        p.setBeforePoint(p.getCurrentPoint());
////
////    }
//    public void EndRound(int checkround){
//        if(checkround == 2){
//            System.out.println("State Change");
//            CountRound +=1;
//            checkround =0;
//        }else{
//            System.out.println("Same");
//        }
//    }
//    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//    // Go ================================================================================================
//    private void go(Player p, boolean catching){
//
//        //สั้งให้สร้าง Thread เอาไว้สำหรับ ขยับ animation เวลาที่เราเปลี่ยนหน้าไปมา
//        counter = new Thread(new movingPokemon(p, catching));
//        System.out.println(CountThread);
//        // เก็บ Thread ปัจจุบันไว้สำหรับ ทำง่าน และ kill เมื่อไม่ได้ใช้งาน
//        saveThread.add(counter);
//        System.out.println("===============================================");
//        System.out.println("NOw size of SaveThread is"+saveThread.size());
//        System.out.println("Now Thread "+ CountThread+" is Running");
//        // ั้งให้ Thread ตัวที่ 0 ทำงาน
//        saveThread.get(saveThread.size()-1).start();
//        CountThread++;
//        System.out.println("Counthread "+CountThread);
//        System.out.println("================================================");
//    }
//
//    //MOviewPOkemon =========================================================================================
//    class movingPokemon implements  Runnable {
//        private Player player;
//        private boolean catching;
//
//        public movingPokemon(Player p, boolean catching) {
//            player = p;
//            boolCatching = catching;
//
//        }
//        public void run() {
//            AddView(player, boolCatching);
//        }
//    }
//
//    // Addview ****************************************************************************************************
//    public void AddView(Player p , boolean catching ){
//        ChangeEvent(p, catching);
//    }
//
//    // เปลี่ยนหน้าตัวละคร -----------------------------------------------------------------------------------------------
//    public void ChangeEvent(Player p, boolean catching) {
//        if(catching == false) {
//            System.out.println("Catching " + catching);
//            System.out.println("Before Rolling :" + p.getCurrentPoint());
//            int random = (int) (Math.random() * (p.getMax() - p.getMin() - 1) + p.getMin()); //random
//            p.setCurrentPoint(p.getBeforePoint() + random);
//            System.out.println("LoopmoveMent = " + p.getCurrentPoint());
//            if(p.getCurrentPoint()> 20 && catching == false){
//                p.setCurrentPoint(p.getCurrentPoint()%20);
//                p.setMyCountRound(1);
//                CountRound +=1;
//                EndRound(CountRound);
//            }
//            System.out.println(p.getName()+"สุ่มได้ "+random+" CurrentPoint is Player"+p.getName()+" are "+p.getCurrentPoint());
//            p.setBeforePoint(p.getCurrentPoint());
//            System.out.println("After Rolling :"+ p.getCurrentPoint());
//            //ตาแรกนะครับ
//            if (CheckFirstRound == 0) {
//                System.out.println("<<<<<<<<<<<<<<FistTime>>>>>>>>>>>>>");
//                // wait ตามจำนวนเวลาที่ถอยลูกเต๋า
//                try {
//                    Thread.sleep(350);
//                } catch (Exception i) {
//                    i.printStackTrace();
//                }
//                mainview.getJf().remove(mainview.getInternalFrame());
//                // สร้างหน้าจอใหม่
//                pokemonFightview =  new EventView(p.getCurrentPoint(),
//                        false,
//                        false,
//                        false,
//                        p,
//                        false);
//                internalFrame.dispose();
//                // รีหน้าจอใหม่
//                RepaintNewEventview(pokemonFightview, catching);
//                this.CheckFirstRound += 1;
//                // สั้งให้ต่อสู้
//                System.out.println("Enemy pokemon =" + pokemonFightview.getEnemyPokemon().getName());
//                System.out.println("Attack!");
//                if (internalFrame.isDisplayable()) {
//                    move(internalFrame, true, pokemonFightview, p, catching);
//                }
//                // ขยับ CheckRound
//
//
//            }
//            // ถ้าCatching ไม่เท่ากับ true หมายความว่า animation ที่กำลังจะสรา้งจะเป็น อนิเมชั่นต่อสู้ทันที่
//            else if (CheckFirstRound != 0 && catching == false) {
//                // หยุดการทำงานของ Thread และ ลบ Thread ตัวนั้นออกจาก List
//                internalFrame.dispose();
//                pokemonFightview = new EventView(-2, false, false, true, p, false);
//                RepaintNewEventview(pokemonFightview, catching);
//                // Thread หยุดทำงานก่อนเผื่อรอผู้เล่นเดินทางไปถึง ช่อง
//                try {
//                    Thread.sleep(5000);
//                } catch (Exception i) {
//                    i.printStackTrace();
//                }
//                try {
//                    System.out.println("=============================Two========================");
//                    System.out.println("this is Current"+p.getCurrentPoint());
//                    pokemonFightview  = new EventView(p.getCurrentPoint(),
//                            false,
//                            false,
//                            false,
//                            p,
//                            false);
//                    saveThread.get(0).interrupt();
//                    saveThread.remove(0);
//                    // รีหน้าจอใหม่
//                    internalFrame.dispose();
//                    RepaintNewEventview(pokemonFightview, catching);
//                    // สั่งให้ขัยบ
//                    System.out.println("Attack!");
//                    if (internalFrame.isDisplayable()) {
//                        move(internalFrame, true, pokemonFightview, p, catching);
//                    }
//                } catch (Exception i) {
//                    i.printStackTrace();
//                }
//            }
//
//        }
//        // สำหรับหน้าที่กำลังจับโปเกม่อน
//        if(catching == true){
//            System.out.println("Catching in ChangeEvent");
//            pokemonFightview = new EventView(-1,
//                    false,
//                    true,
//                    false,
//                    p,
//                    false);
//            saveThread.remove(0);
//            internalFrame.dispose();
//            // ลบThread ไปก่อน แล้วจึ่งสั้งให้ delay จะดีเลยเท่าไหร่ขึ้นอยู่กับ ความนานของการเดิน
//            RepaintNewEventview(pokemonFightview , catching);
//            if(internalFrame.isDisplayable()){
//                move(internalFrame, true, pokemonFightview, p, catching);
//            }
//
//        }
//    }
//
//    //RepainView ===========================================================
//    public void RepaintNewEventview(EventView newEventview , boolean cathing){
//        if(cathing != true) {
//            mainview.getJf().remove(mainview.getInternalFrame());
//            internalFrame = new JInternalFrame();
//            internalFrame.setLayout(new GridLayout());
//            internalFrame.pack();
//            internalFrame.add(newEventview);
//            internalFrame.revalidate();
//            internalFrame.repaint();
//            internalFrame.setVisible(true);
//            mainview.getJf().revalidate();
//            mainview.getJf().repaint();
//            mainview.getJf().add(internalFrame);
//        }
//        else{
//            mainview.getJf().remove(mainview.getInternalFrame());
//            mainview.getJf().add(newEventview);
//            mainview.getJf().revalidate();
//            mainview.getJf().repaint();
//
//        }
//    }
//
//
//    // Move โปนเกม่อน>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    public  void move(JInternalFrame internalFrame ,boolean t, EventView eventView, Player player, boolean catching) {
//        if (catching == false) {
//            try {
//                // อยากจะให้เริ่มเดินเมื่อไหร่ ปรับตรงนี้ ถ้าตอนการให้เดินเลย ปรับให้เท่ากับข้างบน
//                Thread.sleep(5000);
//                if (t) {
//                    while (true) {
//                        if (eventView.first) {
//                            moveEnemy(internalFrame, eventView, player);
//                        } else {
//                            PlayerPokemon(internalFrame, eventView, player);
//                        }
//                    }
//                } else {
//                    System.out.println("not run");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        else{
//                try {
//                    TimeUnit.MILLISECONDS.sleep(10);
//                    while (true){
//
//                    }
//                }
//                catch (Exception i){
//
//                }
//            }
//
//    }
//
//    // ชยับโปรเก่มอนศัตรู มุมบนขวา
//    public   void moveEnemy(JInternalFrame f ,EventView eventView, Player player){
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(5);
//            if (eventView.right) {
//                eventView.xEnemyPokemon++;
//                if (eventView.xEnemyPokemon == 100)
//                {
//                    System.out.println("--------------------------------");
//                    System.out.println("Enemy Pokemo : "+eventView.getEnemyPokemon().getName());
//                    System.out.println("Attck : "+player.getPokemon(0).getName());
//                    System.out.println("ATK EnemyPokemon "+ eventView.getEnemyPokemon().getATK());
//                    if(player.getPokemon(0).getHP()>0) {
//                        EnemyAttack(eventView.getEnemyPokemon(), player.getPokemon(0));
//                    }
//                    else{
//                        System.out.println("stop");
//                    }
//                    System.out.println("HP EnemyPokkemon : "+eventView.getEnemyPokemon().getHP());
//                    System.out.println("HP PlayerPokkemon : "+player.getPokemon(0).getHP());
//                    System.out.println("--------------------------------");
//                    eventView.right = false;
//                }
//            }
//            if (!eventView.right) {
//                eventView.xEnemyPokemon--;
//                if (eventView.xEnemyPokemon == 0) {
//                    f.repaint();
//                    pauseBlack();
//                    eventView.right = true;
//                    eventView.first = false;
//                }
//            }
//            f.repaint();
//
//        }
//        catch (InterruptedException i) {
//            Thread.currentThread().interrupt();
//        }
//
//    }
//    public   void PlayerPokemon(JInternalFrame internalFrame , EventView eventView, Player player) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(5);
//                if (eventView.left) {
//                    eventView.xPlayerPokenom--;
//                    if (eventView.xPlayerPokenom == 150) {
//                        System.out.println("--------------------------------");
//                        System.out.println("Player Pokemon : " + player.getPokemon(0).getName());
//                        System.out.println("Attck : " + eventView.getEnemyPokemon().getName());
//                        System.out.println("ATK PlayerPokemon " + player.getPokemon(0).getATK());
//                        if(eventView.getEnemyPokemon().getHP()>0) {
//                            PlayerAttack(player.getPokemon(0), eventView.getEnemyPokemon());
//                        }
//                        System.out.println("HP EnemyPokkemon : "+eventView.getEnemyPokemon().getHP());
//                        System.out.println("HP PlayerPokkemon : "+player.getPokemon(0).getHP());
//                        System.out.println("--------------------------------");
//                        eventView.left = false;
//                    }
//                }
//                if (!eventView.left) {
//                    eventView.xPlayerPokenom++;
//                    if (eventView.xPlayerPokenom == 300) {
//                        internalFrame.repaint();
//                        pauseBlack();
//                        eventView.left = true;
//                        eventView.first = true;
//                    }
//                }
//                internalFrame.repaint();
//            } catch (InterruptedException i) {
//                Thread.currentThread().interrupt();
//            }
//
//    }
//
//    public void pauseBlack(){
//        try {
//            Thread.sleep((long) (1900));
//        } catch(InterruptedException  e){
//            Thread.currentThread().interrupt();
//        }
//    }
//    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//
//
//    // ทำหน้าจับหรือปล่อย โปรเกม่อน
//    public void EnemyAttack(Pokemon enemypokemon, Pokemon playerpokemon) {
//
////        if (enemy.getHP()<5) {
////            // ไม่เข้าใจแม่งเหมือนกัน แค่รู้ว่าใช้แล้ว Thread ตัวนั้นหยุดทำงาน
////            synchronized (saveThread.get(0)) {
////                try {
////                    Thread.sleep(10);
////                    GetJoptionPlane();
////                    System.out.println("Joptionpaint");
////                    if (input == MyJOptionPane.YES_OPTION) {
////                        saveThread.get(0).wait();
////                        go(playerA, true);
////                        System.out.println("fight");
////                    }
////
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
////        }
//
//    }
//    public void PlayerAttack(Pokemon playerpokenon, Pokemon enmemypokemon) {
//        playerpokenon.attack(enmemypokemon);
//        if (enmemypokemon.getHP() < 30) {
//            // ไม่เข้าใจแม่งเหมือนกัน แค่รู้ว่าใช้แล้ว Thread ตัวนั้นหยุดทำงาน
//            String[] options = new String[] {"Catch", "Fight"};
//            int response = JOptionPane.showOptionDialog(null, "Enemy Pokemon LOW!", "Catch Or Fight",
//                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
//                    null, options, options[0]);
//            synchronized (saveThread.get(0)) {
//                try {
//
//                    if (response == 0) {
//                        internalFrame.dispose();
//                        go(playerA, true);
//                        saveThread.get(0).wait();
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//    }
//    // JoptionPlane =======================================================================
//    public  void GetJoptionPlane(){
//        ImageIcon Icon= new ImageIcon("C:\\Users\\wallr\\Downloads\\pokeball-gif.gif");
//        Image image = Icon.getImage(); // transform it
//        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//        Icon = new ImageIcon(newimg);  // transform it back
//        input = JOptionPane.showOptionDialog(internalFrame,
//                "HP enemyPokemon are low!",
//                "Choses!",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.YES_NO_OPTION,
//                Icon,
//                response,
//                0
//        );
//
//    }
//
//
//
//}
