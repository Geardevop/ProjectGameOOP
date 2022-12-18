import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.concurrent.ThreadLocalRandom;
public class EventView extends JPanel {

    // atribite ที่ใช้ในการขยับ animations
    public int xEnemyPokemon = 10, yEnemyPokemon = 10, xPlayerPokenom = 200, yPlayerPokenom = 200, hight = 100, width = 100, xpokeball = 250, ypokeball = 250;
    // atribute เอาไว้ เช๋็ค  state ต่างๆ
    public boolean right = true, left = true, top=true, bottom;
    // atribute บอกว่า first เพื่อใช้ ในการต่อสู้ปกติ ของโปรเรม่อน
    public boolean first = true;

    //attribute จะ
    private Image enemyPokemon, playerPokemon, pokeball, backgroudFighting;
    private String nameEpokemon;

    private boolean fighting, catching, beforeFight;
    private int index , randomNum;

    private Image Efire1, Efire2, Efire3, Efire4, Eplant1, Eplant2, Eplant3, Eplant4, Erock1, Erock2, Erock3, Erock4, Ewater1, Ewater2,Ewater3, Ewater4,
    Pfire1, Pfire2, Pfire3, Pfire4, Pplant1, Pplant2, Pplant3, Pplant4, Prock1, Prock2, Prock3, Prock4, Pwater1, Pwater2,Pwater3, Pwater4,
    jail, heal, potion, backgroudFight ,catched;

    private Image[] EFirearr= new Image[4], Eplantarr= new Image[4],Erockarr= new Image[4],Ewaterarr= new Image[4];
    private Pokemon EnemyPokemon;

    private Player p = new Player(2);





    //Constructor=================================================================================================================
    public  EventView(int index, boolean fight, boolean catching, boolean beforeFight, Player p) {
        if(p!=null) {
            playerPokemon = p.getPokemon(0).getPokemonpic();
        }
        catched = new ImageIcon("Event\\cathed-01.png").getImage();

        //Ememy Pickture

        Efire1 =  new ImageIcon("EmemyAsset\\fire1 flip.gif").getImage();
        Efire2 = new ImageIcon("EmemyAsset\\fire2 flip.gif").getImage();
        Efire3 = new ImageIcon("EmemyAsset\\fire3 flip.gif").getImage();
        Efire4 = new ImageIcon("EmemyAsset\\fire4 flip.gif").getImage();
        EFirearr[0] = Efire1;
        EFirearr[1] = Efire2;
        EFirearr[2] = Efire3;
        EFirearr[3] = Efire4;
        Eplant1 = new ImageIcon("EmemyAsset\\plant1 flip.gif").getImage();
        Eplant2 = new ImageIcon("EmemyAsset\\plant2 flip.gif").getImage();
        Eplant3 = new ImageIcon("EmemyAsset\\plant3 flip.gif").getImage();
        Eplant4 = new ImageIcon("EmemyAsset\\plant4 flip.gif").getImage();
        Eplantarr[0] = Eplant1;
        Eplantarr[1] = Eplant2;
        Eplantarr[2] = Eplant3;
        Eplantarr[3] = Eplant4;
        Erock1 = new ImageIcon("EmemyAsset\\rock1 flip.gif").getImage();
        Erock2 = new ImageIcon("EmemyAsset\\rock2 flip.gif").getImage();
        Erock3 = new ImageIcon("EmemyAsset\\rock3 flip.gif").getImage();
        Erock4 = new ImageIcon("EmemyAsset\\rock4 flip.gif").getImage();
        Erockarr[0] = Erock1;
        Erockarr[1] = Erock2;
        Erockarr[2] = Erock3;
        Erockarr[3] = Erock4;
        Ewater1 = new ImageIcon("EmemyAsset\\water1 flip.gif").getImage();
        Ewater2 = new ImageIcon("EmemyAsset\\water2 flip.gif").getImage();
        Ewater3 = new ImageIcon("EmemyAsset\\water3 flip.gif").getImage();
        Ewater4 = new ImageIcon("EmemyAsset\\water4 flip.gif").getImage();
        Ewaterarr[0] = Ewater1;
        Ewaterarr[1] = Ewater2;
        Ewaterarr[2] = Ewater3;
        Ewaterarr[3] = Ewater4;
        //Player Picture
        Pfire1 = new ImageIcon("EmemyAsset\\fire1.gif").getImage();
        Pfire2 = new ImageIcon("EmemyAsset\\fire2.gif").getImage();
        Pfire3 = new ImageIcon("EmemyAsset\\fire3.gif").getImage();
        Pfire4 = new ImageIcon("EmemyAsset\\fire4.gif").getImage();
        Pplant1 = new ImageIcon("EmemyAsset\\plant1.gif").getImage();
        Pplant2 = new ImageIcon("EmemyAsset\\plant2.gif").getImage();
        Pplant3 = new ImageIcon("EmemyAsset\\plant3.gif").getImage();
        Pplant4 = new ImageIcon("EmemyAsset\\plant4.gif").getImage();
        Prock1 = new ImageIcon("EmemyAsset\\rock1.gif").getImage();
        Prock2 = new ImageIcon("EmemyAsset\\rock2.gif").getImage();
        Prock3 = new ImageIcon("EmemyAsset\\rock3.gif").getImage();
        Prock4 = new ImageIcon("EmemyAsset\\rock4.gif").getImage();
        Pwater1 = new ImageIcon("EmemyAsset\\water1.gif").getImage();
        Pwater2 = new ImageIcon("EmemyAsset\\water2.gif").getImage();
        Pwater3 = new ImageIcon("EmemyAsset\\water3.gif").getImage();
        Pwater4 = new ImageIcon("EmemyAsset\\water4.gif").getImage();

        //Event
        jail = new ImageIcon("Event\\jail-gif.gif").getImage();
        potion = new ImageIcon("Event\\potion-gif.gif").getImage();
        heal = new ImageIcon("Event\\heal-gif.gif").getImage();
        backgroudFight = new ImageIcon("Event\\center-01.png").getImage();


        // index ช่องปัจจุบันที่ผู็เล่นอยู๋
        // fight  เช็คว่าค่าต่อสู้หรือป่าว
        // catching  เช็คว่าจะจับโปรเกม่อนมั้ย
        // before fight  เช็คว่าเป็นหน้าก่อนตกต่อสู้หรือป่าว

        this.beforeFight = beforeFight;
        this.fighting = fight;
        this.catching = catching;
        this.index = index;
        if (index >= 0 && index < 5 && fight == false && catching == false) {
            System.out.println("เงือ่นไข 1");
            // 4 ช่องแรก หิน
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);

            System.out.println("Random Pokemon"+randomNum);
            enemyPokemon = Erockarr[randomNum];
            switch (randomNum){
                case 0:
                    nameEpokemon = "rock1";
                    break;
                case 1:
                    nameEpokemon = "rock2";
                    break;
                case 2:
                    nameEpokemon = "rock";
                    break;
                case 3:
                    nameEpokemon = "rock4";
                    break;
            }
            backgroudFighting = backgroudFight;
            EnemyPokemon = new Pokemon(nameEpokemon, "fire",50,5, enemyPokemon);

        } else if (index > 5 && index < 10 && fight == false && catching == false) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            System.out.println("Random Pokemon"+randomNum);
            switch (randomNum){
                case 0:
                    nameEpokemon = "fire1";
                    break;
                case 1:
                    nameEpokemon = "fire2";
                    break;
                case 2:
                    nameEpokemon = "fire3";
                    break;
                case 3:
                    nameEpokemon = "fire4";
                    break;
            }
            backgroudFighting = backgroudFight;
            System.out.println("เงือ่นไข 1");
            enemyPokemon = EFirearr[randomNum];
            EnemyPokemon = new Pokemon(nameEpokemon, "fire",50,5, enemyPokemon);
            // สีช่องที่สอง ไฟ
        } else if (index > 10 && index < 15 && fight == false && catching == false) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3+ 1);
            System.out.println("Random Pokemon"+randomNum);
            switch (randomNum){
                case 0:
                    nameEpokemon = "water1";
                    break;
                case 1:
                    nameEpokemon = "water2";
                    break;
                case 2:
                    nameEpokemon = "water3";
                    break;
                case 3:
                    nameEpokemon = "water4";
                    break;
            }
            backgroudFighting = backgroudFight;
            System.out.println("เงือ่นไข 2");
            enemyPokemon = Ewaterarr[randomNum];
            EnemyPokemon = new Pokemon(nameEpokemon, "fire",50,5, enemyPokemon);
            // สี่ช่องที่สาม น้ำ
        } else if (index > 15 && index < 20 && fight == false && catching == false) {
            backgroudFighting = backgroudFight;
            System.out.println("Random Pokemon"+randomNum);
            switch (randomNum){
                case 0:
                    nameEpokemon = "plant1";
                    break;
                case 1:
                    nameEpokemon = "plant1";
                    break;
                case 2:
                    nameEpokemon = "plant1";
                    break;
                case 3:
                    nameEpokemon = "plant1";
                    break;
            }

            int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            System.out.println("เงือ่นไข 3");
            enemyPokemon = Eplantarr[randomNum];
            EnemyPokemon = new Pokemon(nameEpokemon, "fire",50,5, enemyPokemon);
            System.out.println("Name of Epokenon"+EnemyPokemon.getName());
            //สี่ช่องที่ สี่ ปกติ
        } else if (index == 5 && index < 20 && fight == false && catching == false) {
            System.out.println("เงือ่นไข 4");
            //ตกที่คุก
            backgroudFighting = jail;
            EnemyPokemon = new Pokemon(null, null,50,5,null);
        } else if (index == 10 && fight == false && catching == false) {
            System.out.println("เงือ่นไข 5");
            // shopping
            backgroudFighting = potion;
            EnemyPokemon = new Pokemon(null, null,50,5,null);
        } else if (index == 15 && fight == false && catching == false) {
            System.out.println("เงือ่นไข 6");
            // โรงบาล
            backgroudFighting = heal;
            EnemyPokemon = new Pokemon(null, null,50,5,null);
        } else if (index == 20 && fight == false && catching == false) {
            System.out.println("เงือ่นไข 7");
            //start
            EnemyPokemon = new Pokemon(null, null,50,5,null);
            enemyPokemon = Ewater3;
        }
        if (catching == true) {
            //จับ
        }
        if (fight = true) {
            //ต่อสู้

        }
        if (beforeFight == true && catching == false && fighting == false) {
            backgroudFighting = new ImageIcon("Event\\bg_bf_roll (3).gif").getImage();
        }

        if (this.catching == true && this.index == -1 && this.fighting != true) {
            System.out.println("Catching in Eventview");
            backgroudFighting = backgroudFight;
            catched = new ImageIcon("Event\\cathed-01.png").getImage();
        }


    }

    // PaintComponet =========================================================================================================
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        // ต่อสู้ปกติ หลังจากRoll btn


        if(index >= 0 &&!this.catching && !this.fighting && index != 5 && index != 10  && index != 15  && index != 20) {
            // map ต่อสู่้ ขนาด 470 x 390
            g2d.drawImage(backgroudFighting, 0, 0, 380, 380, this);
            g2d.drawImage(enemyPokemon, xEnemyPokemon, yEnemyPokemon, 150, 150, this);// player
            g2d.drawImage(playerPokemon ,xPlayerPokenom, yPlayerPokenom, 150, 150, this);
        }
        if(index == 5 &&!this.catching && !this.fighting){
            g2d.drawImage(backgroudFighting, 0, 0, 380, 380, this);
        }
        if(index == 10 &&!this.catching && !this.fighting){
            g2d.drawImage(backgroudFighting, 0, 0, 380, 380, this);
        }
        if(index == 15 &&!this.catching && !this.fighting){
            g2d.drawImage(backgroudFighting, 0, 0, 380, 380, this);
        }
        if(index == 20 &&!this.catching && !this.fighting){
            g2d.drawImage(backgroudFighting, 0, 0, 380, 380, this);
        }

        // จับโปเกม่อน
        if(catching == true && !fighting && index == -1){
            g.drawImage(backgroudFighting, 0, 0, 360, 360, this);
            g.drawImage(catched, 80,100, 200,200,this);


        }
        //หน้าโหลด
        if(beforeFight == true){
            g.drawImage(backgroudFighting, 0, 0, 360, 360, this);

        }

    }

    public Pokemon getEnemyPokemon() {
        return EnemyPokemon;
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        EnemyPokemon = enemyPokemon;
    }

//    public static void main(String[] args) {
//            JFrame test = new JFrame();
//            Player p1 = new Player(2);
//            EventView test1 = new EventView(-1,false,true,false,p1 );
//            test.add(test1);
//            test.setSize(500,500);
//            test.setVisible(true);
//
//
//    }

}