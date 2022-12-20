import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class MainMapView extends JPanel{
    private JPanel northPanel1, southPanel1, northPanel2, southPanel2, mapPanel, variousMenuPanel;
    private JPanel northPanel, southPanel, eastPanel, westPanel, centerPanel;
    private JPanel pokemonPanel1, pokemon1Panel1, pokemon2Panel1, pokemon3Panel1, roundPanel, namePanel1, bagPanel1, rollPanel, settingPanel;
    private JPanel northImage1, northImage2, northImage3, northImage4, southImage1, southImage2, southImage3, southImage4;
    private JPanel westImage1, westImage2, westImage3, westImage4, eastImage1, eastImage2, eastImage3, eastImage4;
    private JPanel northWestImage, northEastImage, southWestImage, southEastImage;
    private JPanel pokeballImage1, potionImage1, diceImage, pokemon1Panel2, pokemon2Panel2, pokemon3Panel2;
    private JPanel leftVariousPanel1, leftVariousPanel2, namePanel2, bagPanel2, pokemonPanel2, pokeballImage2, potionImage2;
    private JLabel roundLabel, nameLabel1, pokeballLabel1, potionLabel1, rollLabel, settingLabel;
    private JLabel nameLabel2, pokeballLabel2, potionLabel2;
    private JLabel pokemon1Name, pokemon2Name, pokemon3Name, pokemon1Image, pokemon2Image, pokemon3Image;
    private Border blackline;
    private JTextField HPTextField, maxHPTextField;
    private JPanel pokemon1_1, pokemon2_1, pokemon3_1, pokemon1_2, pokemon2_2, pokemon3_2;

    /// Gear
    private EventView eventView;

    public MainMapView(int width, int height, Player playerA, Player playerB){
        // Event view
        eventView =  new EventView(-2, false, false, true, null, null,false,width,height );
        //<--------------------------------------------End Event View---------------------------------------------------->
        //<------------------------------------------------Create JSwing------------------------------------------------>
        //<-------------Images------------->
        Image variousBackground = Toolkit.getDefaultToolkit().createImage("img/VariousPanel-wood.png");
        Image roundBackground = Toolkit.getDefaultToolkit().createImage("img/RoundPanel.png");
        Image nameBackground = Toolkit.getDefaultToolkit().createImage("img/NamePanel.png");
        Image bagBackground = Toolkit.getDefaultToolkit().createImage("img/BagPanel.png");
        Image pokemonIndexBackground = Toolkit.getDefaultToolkit().createImage("img/PokemonIndex.png");
        Image rollBackground = Toolkit.getDefaultToolkit().createImage("img/BagPanel.png");
        Image settingBackground = Toolkit.getDefaultToolkit().createImage("img/SettingPanel.png");
        Image fire = Toolkit.getDefaultToolkit().createImage("img/fire-01_270x135.png");
        Image water = Toolkit.getDefaultToolkit().createImage("img/water-01_135x270.png");
        Image rock = Toolkit.getDefaultToolkit().createImage("img/rock-01_135x270.png");
        Image grass = Toolkit.getDefaultToolkit().createImage("img/grass-01_270x135.png");
        Image start = Toolkit.getDefaultToolkit().createImage("img/start-01_270x270.png");
        Image hospital = Toolkit.getDefaultToolkit().createImage("img/hospital-01_270x270.png");
        Image shop = Toolkit.getDefaultToolkit().createImage("img/shop-01_270x270.png");
        Image island = Toolkit.getDefaultToolkit().createImage("img/island-01_270x270.png");
        Image pokeball = Toolkit.getDefaultToolkit().createImage("img/pokeball_65x65.png");
        Image potion = Toolkit.getDefaultToolkit().createImage("img/potion_65x65.png");
        Image dice = Toolkit.getDefaultToolkit().createImage("img/dice-01_55x62.png");

        //<-------------JPanel------------->
        northPanel = new JPanel();
        northPanel1 = new JPanel();northPanel2 = new JPanel();
        southPanel = new JPanel();
        southPanel1 = new JPanel();southPanel2 = new JPanel();
        eastPanel = new JPanel();westPanel = new JPanel();
        centerPanel = new JPanel();
        // Add Event
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(eventView);
        // ==========================
        mapPanel = new JPanel();variousMenuPanel = new ImagePanel(variousBackground, width-height+1, height);
        pokemonPanel1 = new ImagePanel(pokemonIndexBackground, (width-height)/2-height/24, height/24*15/2);
        pokemon1Panel1 = new RoundJPanel();pokemon2Panel1 = new RoundJPanel();pokemon3Panel1 = new RoundJPanel();
        pokemonPanel2 = new ImagePanel(pokemonIndexBackground, (width-height)/2-height/24, height/24*15/2);
        pokemon1Panel2 = new RoundJPanel();pokemon2Panel2 = new RoundJPanel();pokemon3Panel2 = new RoundJPanel();
        roundPanel = new ImagePanel(roundBackground, width-height-height/9*2, height/8);
        namePanel1 = new ImagePanel(nameBackground, (width-height)/2-height/24, height/9);bagPanel1 = new ImagePanel(bagBackground,(width-height)/2-height/24, height/8);
        namePanel2 = new ImagePanel(nameBackground, (width-height)/2-height/24, height/9);bagPanel2 = new ImagePanel(bagBackground,(width-height)/2-height/24, height/8);
        rollPanel = new ImagePanel(rollBackground, (width-height)/2-height/24, height/8);
        settingPanel = new ImagePanel(settingBackground, (width-height)/2-height/24, height/12);
        northImage1 = new ImagePanel(water, height/8, height/4);northImage2 = new ImagePanel(water, height/8, height/4);
        northImage3 = new ImagePanel(water, height/8, height/4);northImage4 = new ImagePanel(water, height/8, height/4);
        southImage1 = new ImagePanel(rock, height/8, height/4);southImage2 = new ImagePanel(rock, height/8, height/4);
        southImage3 = new ImagePanel(rock, height/8, height/4);southImage4 = new ImagePanel(rock, height/8, height/4);
        westImage1 = new ImagePanel(fire, height/4, height/8);westImage2 = new ImagePanel(fire, height/4, height/8);
        westImage3 = new ImagePanel(fire, height/4, height/8);westImage4 = new ImagePanel(fire, height/4, height/8);
        eastImage1 = new ImagePanel(grass, height/4, height/8);eastImage2 = new ImagePanel(grass, height/4, height/8);
        eastImage3 = new ImagePanel(grass, height/4, height/8);eastImage4 = new ImagePanel(grass, height/4, height/8);
        northEastImage = new ImagePanel(hospital, height/4, height/4);northWestImage = new ImagePanel(shop, height/4, height/4);
        southEastImage = new ImagePanel(start, height/4, height/4);southWestImage = new ImagePanel(island, height/4, height/4);
        pokeballImage1 = new ImagePanel(pokeball, height/16, height/16);
        potionImage1 = new ImagePanel(potion, height/16, height/16);
        pokeballImage2 = new ImagePanel(pokeball, height/16, height/16);
        potionImage2 = new ImagePanel(potion, height/16, height/16);
        diceImage = new ImagePanel(dice, height/19, height/17);
        leftVariousPanel1 = new JPanel();leftVariousPanel2 = new JPanel();

        //<-------------JLabel------------->
        roundLabel = new JLabel("Round"+" 1");nameLabel1 = new JLabel("Player 1");
        pokeballLabel1 = new JLabel("x3");potionLabel1 = new JLabel("x1");
        nameLabel2 = new JLabel("Player 2");
        pokeballLabel2 = new JLabel("x3");potionLabel2 = new JLabel("x1");
        rollLabel = new JLabel("ROLL!");
        settingLabel = new JLabel("Back to Menu");
        //<-------------Border------------->
        blackline = BorderFactory.createLineBorder(Color.black);

        //<------------------------------------------------Display Setting------------------------------------------------>

        roundLabel.setFont(new Font("Tahoma", Font.BOLD, height/12));
        roundLabel.setForeground(Color.black);

//        nameTextField.setEnabled(false);
//        nameTextField.setBackground(new Color(117, 117, 117));
//        nameTextField.setFont(new Font("Tahoma", Font.BOLD, 30));
//        nameTextField.setDisabledTextColor(Color.white);
//        nameTextField.setText("Player 1");
//        nameTextField.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(new Color(0, 0, 0, 0), 0, true),
//                BorderFactory.createEmptyBorder(10, 100, 10, -65)
//        ));

        pokemonPanel1.setBackground(new Color(117, 117, 117));
        pokemonPanel1.setPreferredSize(new Dimension((width-height)/2-height/24, height/24*15/2));

        pokemon1Panel1.setBackground(Color.white);
        pokemon2Panel1.setBackground(Color.white);
        pokemon3Panel1.setBackground(Color.white);
        pokemon1Panel1.setPreferredSize(new Dimension((width-height)/2-height/12*4/3, height/15));
        pokemon2Panel1.setPreferredSize(new Dimension((width-height)/2-height/12*4/3, height/15));
        pokemon3Panel1.setPreferredSize(new Dimension((width-height)/2-height/12*4/3, height/15));
        pokemon1Panel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), height/360, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        pokemon2Panel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), height/360, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        pokemon3Panel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), height/360, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));

        pokemonPanel2.setBackground(new Color(117, 117, 117));
        pokemonPanel2.setPreferredSize(new Dimension((width-height)/2-height/24, height/24*15/2));

        pokemon1Panel2.setBackground(Color.white);
        pokemon2Panel2.setBackground(Color.white);
        pokemon3Panel2.setBackground(Color.white);
        pokemon1Panel2.setPreferredSize(new Dimension((width-height)/2-height/12*4/3, height/15));
        pokemon2Panel2.setPreferredSize(new Dimension((width-height)/2-height/12*4/3, height/15));
        pokemon3Panel2.setPreferredSize(new Dimension((width-height)/2-height/12*4/3, height/15));
        pokemon1Panel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), height/360, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        pokemon2Panel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), height/360, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        pokemon3Panel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204), height/360, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));

        roundPanel.setBackground(new Color(0, 0, 0, 0));
        roundPanel.setPreferredSize(new Dimension(width-height-height/9*2, height/8));

        namePanel1.setBackground(new Color(0, 0, 0, 0));
        namePanel1.setPreferredSize(new Dimension((width-height)/2-height/24, height/9));
        nameLabel1.setForeground(Color.black);
        nameLabel1.setFont(new Font("Tahoma", Font.BOLD, height/24));

        namePanel2.setBackground(new Color(0, 0, 0, 0));
        namePanel2.setPreferredSize(new Dimension((width-height)/2-height/24, height/9));
        nameLabel2.setForeground(Color.black);
        nameLabel2.setFont(new Font("Tahoma", Font.BOLD, height/24));

        bagPanel1.setPreferredSize(new Dimension((width-height)/2-height/24, height/8));
        bagPanel1.setBackground(new Color(0, 0, 0, 0));

        bagPanel2.setPreferredSize(new Dimension((width-height)/2-height/24, height/8));
        bagPanel2.setBackground(new Color(0, 0, 0, 0));

        pokeballLabel1.setForeground(Color.black);
        pokeballLabel1.setFont(new Font("Tahoma", Font.BOLD, height/24));

        pokeballLabel2.setForeground(Color.black);
        pokeballLabel2.setFont(new Font("Tahoma", Font.BOLD, height/24));

        potionLabel1.setForeground(Color.black);
        potionLabel1.setFont(new Font("Tahoma", Font.BOLD, height/24));

        potionLabel2.setForeground(Color.black);
        potionLabel2.setFont(new Font("Tahoma", Font.BOLD, height/24));

        rollPanel.setPreferredSize(new Dimension((width-height)/2-height/24, height/8));
        rollPanel.setBackground(new Color(0, 0, 0, 0));

        rollLabel.setForeground(Color.black);
        rollLabel.setFont(new Font("Tahoma", Font.BOLD, height/24));

        settingPanel.setBackground(new Color(0, 0, 0, 0));
        settingPanel.setPreferredSize(new Dimension((width-height)/2-height/24, height/12));

        settingLabel.setForeground(Color.black);
        settingLabel.setFont(new Font("Tahoma", Font.BOLD, height/48*3/2));

        pokeballImage1.setPreferredSize(new Dimension(height/16, height/16));
        pokeballImage1.setBackground(new Color(0,0,0,0));

        pokeballImage2.setPreferredSize(new Dimension(height/16, height/16));
        pokeballImage2.setBackground(new Color(0,0,0,0));

        potionImage1.setPreferredSize(new Dimension(height/16, height/16));
        potionImage1.setBackground(new Color(0,0,0,0));

        potionImage2.setPreferredSize(new Dimension(height/16, height/16));
        potionImage2.setBackground(new Color(0,0,0,0));

        diceImage.setPreferredSize(new Dimension(height/19, height/17));
        diceImage.setBackground(new Color(0,0,0,0));
        //<------------------------------------------------Layout Setting------------------------------------------------>
        //<-------------NorthPanel------------->
        northPanel.setBackground(Color.black);
        northPanel.setPreferredSize(new Dimension(height, height/4));
        northPanel1.setLayout(new GridLayout(1,2));
        northPanel1.add(northImage1);   northPanel1.add(northImage2);
        northPanel2.setLayout(new GridLayout(1,2));
        northPanel2.add(northImage3);   northPanel2.add(northImage4);
        northPanel.setBackground(Color.black);
        northPanel.setLayout(new GridLayout(1,4));
        northPanel.add(northWestImage); northPanel.add(northPanel1);
        northPanel.add(northPanel2);    northPanel.add(northEastImage);

        //<-------------SouthPanel------------->
        southPanel.setBackground(Color.black);
        southPanel.setPreferredSize(new Dimension(height, height/4));
        southPanel1.setLayout(new GridLayout(1,2));
        southPanel1.add(southImage1);   southPanel1.add(southImage2);
        southPanel2.setLayout(new GridLayout(1,2));
        southPanel2.add(southImage3);   southPanel2.add(southImage4);
        southPanel.setBackground(Color.black);
        southPanel.setLayout(new GridLayout(1,4));
        southPanel.add(southWestImage); southPanel.add(southPanel1);
        southPanel.add(southPanel2);    southPanel.add(southEastImage);

        //<-------------WestPanel------------->
        westPanel.setBackground(Color.black);
        westPanel.setPreferredSize(new Dimension(height/4, height/2));
        westPanel.setLayout(new GridLayout(4,1));
        westPanel.add(westImage1);  westPanel.add(westImage2);
        westPanel.add(westImage3);  westPanel.add(westImage4);

        //<-------------EastPanel------------->
        eastPanel.setBackground(Color.black);
        eastPanel.setPreferredSize(new Dimension(height/4, height/2));
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(eastImage1);  eastPanel.add(eastImage2);
        eastPanel.add(eastImage3);  eastPanel.add(eastImage4);

        //<-------------MapPanel------------->
        centerPanel.setBackground(new Color(18, 18, 18));
        mapPanel.setLayout(new BorderLayout());
        mapPanel.add(northPanel, BorderLayout.NORTH);
        mapPanel.add(southPanel, BorderLayout.SOUTH);
        mapPanel.add(eastPanel, BorderLayout.EAST);
        mapPanel.add(westPanel, BorderLayout.WEST);
        mapPanel.add(eventView, BorderLayout.CENTER);

        //<-------------PokemonPanel1------------->
        pokemon1Panel1.setLayout(new FlowLayout());
        pokemon1_1 = new ImagePanel(playerA.getPokemons().get(0).getPokemonImage(), height/12, height/12);
        pokemon1_1.setPreferredSize(new Dimension(height/12, height/12));
        pokemon1_1.setBackground(new Color(0,0,0,0));
        pokemon1Panel1.add(pokemon1_1);
        pokemon2Panel1.setLayout(new FlowLayout());
        pokemon3Panel1.setLayout(new FlowLayout());

        //<-------------PokemonPanel2------------->
        pokemon1Panel2.setLayout(new FlowLayout());
        pokemon1_2 = new ImagePanel(playerB.getPokemons().get(0).getPokemonImage(), height/12, height/12);
        pokemon1_2.setPreferredSize(new Dimension(height/12, height/12));
        pokemon1_2.setBackground(new Color(0,0,0,0));
        pokemon1Panel2.add(pokemon1_2);
        pokemon2Panel2.setLayout(new FlowLayout());
        pokemon3Panel2.setLayout(new FlowLayout());

        //<-------------AllPokemonPanel------------->
        pokemonPanel1.setLayout(new FlowLayout());
        pokemonPanel1.setBackground(new Color(18,18,18,0));
        pokemonPanel1.add(Box.createRigidArea(new Dimension(height/12, height/30)));
        pokemonPanel1.add(pokemon1Panel1);
        pokemonPanel1.add(Box.createRigidArea(new Dimension(height/12, 0)));
        pokemonPanel1.add(pokemon2Panel1);
        pokemonPanel1.add(Box.createRigidArea(new Dimension(height/12, 0)));
        pokemonPanel1.add(pokemon3Panel1);

        pokemonPanel2.setLayout(new FlowLayout());
        pokemonPanel2.setBackground(new Color(18,18,18,0));
        pokemonPanel2.add(Box.createRigidArea(new Dimension(height/12, height/30)));
        pokemonPanel2.add(pokemon1Panel2);
        pokemonPanel2.add(Box.createRigidArea(new Dimension(height/12, 0)));
        pokemonPanel2.add(pokemon2Panel2);
        pokemonPanel2.add(Box.createRigidArea(new Dimension(height/12, 0)));
        pokemonPanel2.add(pokemon3Panel2);

        //<-------------RoundPanel------------->
        roundPanel.setLayout(new FlowLayout());
        roundPanel.add(roundLabel);

        //<-------------NamePanel------------->
        namePanel1.setLayout(new FlowLayout());
        namePanel1.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48+(height-1080)/120)));
        namePanel1.add(nameLabel1);

        namePanel2.setLayout(new FlowLayout());
        namePanel2.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48+(height-1080)/120)));
        namePanel2.add(nameLabel2);

        //<-------------BagPanel------------->
        bagPanel1.setLayout(new FlowLayout());
        bagPanel1.add(Box.createRigidArea(new Dimension(height/3*3, (height-720)/15+height/360+(1080-height)/40)));
        bagPanel1.add(pokeballImage1);bagPanel1.add(pokeballLabel1);
        bagPanel1.add(potionImage1);bagPanel1.add(potionLabel1);

        bagPanel2.setLayout(new FlowLayout());
        bagPanel2.add(Box.createRigidArea(new Dimension(height/3*3, (height-720)/15+height/360+(1080-height)/40)));
        bagPanel2.add(pokeballImage2);bagPanel2.add(pokeballLabel2);
        bagPanel2.add(potionImage2);bagPanel2.add(potionLabel2);

        //<-------------RollPanel------------->
        rollPanel.setLayout((new FlowLayout()));
        rollPanel.add(Box.createRigidArea(new Dimension(height/3*3, (height-690)/15+height/360+(1080-height)/40)));
        rollPanel.add(diceImage);
        rollPanel.add(Box.createRigidArea(new Dimension(height/48, 2)));
        rollPanel.add(rollLabel);

        //<-------------SettingPanel------------->
        settingPanel.setLayout(new FlowLayout());
        settingPanel.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48*2/3+(height-1080)/96)));
        settingPanel.add(settingLabel);

        //<-------------leftVariousPanel------------->
        leftVariousPanel1.setBackground(new Color(0,0,0,0));
        leftVariousPanel1.setPreferredSize(new Dimension((width-height)/2-height/24, height/24*15/2));
        leftVariousPanel1.setLayout(new FlowLayout());
        leftVariousPanel1.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48*2/3+(height-1080)/96)));
        leftVariousPanel1.add(namePanel1);
        leftVariousPanel1.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48*2/3+(height-1080)/96)));
        leftVariousPanel1.add(bagPanel1);

        leftVariousPanel2.setBackground(new Color(0,0,0,0));
        leftVariousPanel2.setPreferredSize(new Dimension((width-height)/2-height/24, height/24*15/2));
        leftVariousPanel2.setLayout(new FlowLayout());
        leftVariousPanel2.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48*2/3+(height-1080)/96)));
        leftVariousPanel2.add(namePanel2);
        leftVariousPanel2.add(Box.createRigidArea(new Dimension(height/3*5/6, height/48*2/3+(height-1080)/96)));
        leftVariousPanel2.add(bagPanel2);

        //<-------------VariousMenuPanel------------->
        variousMenuPanel.setBackground(new Color(18, 18, 18));
        variousMenuPanel.setPreferredSize(new Dimension(width-height, height));

        variousMenuPanel.setLayout(new FlowLayout());
        variousMenuPanel.add(roundPanel);
        variousMenuPanel.add(leftVariousPanel1);
        variousMenuPanel.add(pokemonPanel1);
        variousMenuPanel.add(leftVariousPanel2);
        variousMenuPanel.add(pokemonPanel2);
        variousMenuPanel.add(Box.createRigidArea(new Dimension(height, height/24+(height-1080)/96)));
        variousMenuPanel.add(rollPanel);
        variousMenuPanel.add(settingPanel);


        //<-------------MainMapPanel------------->
        this.setLayout(new BorderLayout());
        this.add(mapPanel, BorderLayout.WEST);
        this.add(variousMenuPanel, BorderLayout.EAST);

        this.setBounds(0, 0, width, height);
    }

    public void paintComponent(Graphics g){

    }

    public JPanel getNorthPanel1() {
        return northPanel1;
    }

    public JPanel getSouthPanel1() {
        return southPanel1;
    }

    public JPanel getNorthPanel2() {
        return northPanel2;
    }

    public JPanel getSouthPanel2() {
        return southPanel2;
    }

    public JPanel getMapPanel() {
        return mapPanel;
    }

    public JPanel getVariousMenuPanel() {
        return variousMenuPanel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public JPanel getWestPanel() {
        return westPanel;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public JPanel getPokemonPanel1() {
        return pokemonPanel1;
    }

    public JPanel getPokemon1Panel1() {
        return pokemon1Panel1;
    }

    public JPanel getPokemon2Panel1() {
        return pokemon2Panel1;
    }

    public JPanel getPokemon3Panel1() {
        return pokemon3Panel1;
    }

    public JPanel getRoundPanel() {
        return roundPanel;
    }

    public JPanel getNamePanel1() {
        return namePanel1;
    }

    public JPanel getBagPanel1() {
        return bagPanel1;
    }

    public JPanel getRollPanel() {
        return rollPanel;
    }

    public JPanel getSettingPanel() {
        return settingPanel;
    }

    public JPanel getNorthImage1() {
        return northImage1;
    }

    public JPanel getNorthImage2() {
        return northImage2;
    }

    public JPanel getNorthImage3() {
        return northImage3;
    }

    public JPanel getNorthImage4() {
        return northImage4;
    }

    public JPanel getSouthImage1() {
        return southImage1;
    }

    public JPanel getSouthImage2() {
        return southImage2;
    }

    public JPanel getSouthImage3() {
        return southImage3;
    }

    public JPanel getSouthImage4() {
        return southImage4;
    }

    public JPanel getWestImage1() {
        return westImage1;
    }

    public JPanel getWestImage2() {
        return westImage2;
    }

    public JPanel getWestImage3() {
        return westImage3;
    }

    public JPanel getWestImage4() {
        return westImage4;
    }

    public JPanel getEastImage1() {
        return eastImage1;
    }

    public JPanel getEastImage2() {
        return eastImage2;
    }

    public JPanel getEastImage3() {
        return eastImage3;
    }

    public JPanel getEastImage4() {
        return eastImage4;
    }

    public JPanel getNorthWestImage() {
        return northWestImage;
    }

    public JPanel getNorthEastImage() {
        return northEastImage;
    }

    public JPanel getSouthWestImage() {
        return southWestImage;
    }

    public JPanel getSouthEastImage() {
        return southEastImage;
    }

    public JPanel getPokeballImage1() {
        return pokeballImage1;
    }

    public JPanel getPotionImage1() {
        return potionImage1;
    }

    public JPanel getDiceImage() {
        return diceImage;
    }

    public JPanel getPokemon1Panel2() {
        return pokemon1Panel2;
    }

    public JPanel getPokemon2Panel2() {
        return pokemon2Panel2;
    }

    public JPanel getPokemon3Panel2() {
        return pokemon3Panel2;
    }

    public JPanel getLeftVariousPanel1() {
        return leftVariousPanel1;
    }

    public JPanel getLeftVariousPanel2() {
        return leftVariousPanel2;
    }

    public JPanel getNamePanel2() {
        return namePanel2;
    }

    public JPanel getBagPanel2() {
        return bagPanel2;
    }

    public JPanel getPokemonPanel2() {
        return pokemonPanel2;
    }

    public JPanel getPokeballImage2() {
        return pokeballImage2;
    }

    public JPanel getPotionImage2() {
        return potionImage2;
    }

    public JLabel getRoundLabel() {
        return roundLabel;
    }

    public JLabel getNameLabel1() {
        return nameLabel1;
    }

    public JLabel getPokeballLabel1() {
        return pokeballLabel1;
    }

    public JLabel getPotionLabel1() {
        return potionLabel1;
    }

    public JLabel getRollLabel() {
        return rollLabel;
    }

    public JLabel getSettingLabel() {
        return settingLabel;
    }

    public JLabel getNameLabel2() {
        return nameLabel2;
    }

    public JLabel getPokeballLabel2() {
        return pokeballLabel2;
    }

    public JLabel getPotionLabel2() {
        return potionLabel2;
    }

    public JLabel getPokemon1Name() {
        return pokemon1Name;
    }

    public JLabel getPokemon2Name() {
        return pokemon2Name;
    }

    public JLabel getPokemon3Name() {
        return pokemon3Name;
    }

    public JLabel getPokemon1Image() {
        return pokemon1Image;
    }

    public JLabel getPokemon2Image() {
        return pokemon2Image;
    }

    public JLabel getPokemon3Image() {
        return pokemon3Image;
    }

    public Border getBlackline() {
        return blackline;
    }

    public JTextField getHPTextField() {
        return HPTextField;
    }

    public JTextField getMaxHPTextField() {
        return maxHPTextField;
    }

    public EventView getEventView() {
        return eventView;
    }

    public void setEventView(EventView eventView) {
        this.eventView = eventView;
    }

    public void setPokemon1_1(JPanel pokemon1_1) {
        this.pokemon1_1 = pokemon1_1;
    }

    public void setPokemon2_1(JPanel pokemon2_1) {
        this.pokemon2_1 = pokemon2_1;
    }

    public void setPokemon3_1(JPanel pokemon3_1) {
        this.pokemon3_1 = pokemon3_1;
    }

    public void setPokemon1_2(JPanel pokemon1_2) {
        this.pokemon1_2 = pokemon1_2;
    }

    public void setPokemon2_2(JPanel pokemon2_2) {
        this.pokemon2_2 = pokemon2_2;
    }

    public void setPokemon3_2(JPanel pokemon3_2) {
        this.pokemon3_2 = pokemon3_2;
    }

    public JPanel getPokemon1_1() {
        return pokemon1_1;
    }

    public JPanel getPokemon2_1() {
        return pokemon2_1;
    }

    public JPanel getPokemon3_1() {
        return pokemon3_1;
    }

    public JPanel getPokemon1_2() {
        return pokemon1_2;
    }

    public JPanel getPokemon2_2() {
        return pokemon2_2;
    }

    public JPanel getPokemon3_2() {
        return pokemon3_2;
    }

}

