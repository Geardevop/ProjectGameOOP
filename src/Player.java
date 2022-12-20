import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Player {
//    private Pokemon pokemon;

    private ArrayList<Pokemon> pokemons = new ArrayList();
    private Pokeball pokeball;
    private Potion potion;
    public int max = 6, min = 1, range = max - min + 1;
    private Pokemon pokemon;
    private Pokemon pokemon1, pokemon2;
    private int MyCountRound;
    private Image startedPokemon;
    private String name;
    private int CurrentPoint = 0, BeforePoint = 0;

    public Player(int index) {
        this.MyCountRound = 0;
        this.name = "player "+index;
        startedPokemon = new ImageIcon("PlayerAsset\\water2.gif").getImage();
        Image startedPokemonImage = Toolkit.getDefaultToolkit().createImage("img/water2flip.png");

        pokemon = new Pokemon("OrnDoi","water",50,10,startedPokemon, startedPokemonImage);
        pokemons.add(pokemon);

        this.min = 1;
    }

    public Player(Pokemon pokemon, Pokeball pokeball, Potion potion) {
        pokemons.add(pokemon);
        this.pokeball = pokeball;
        this.potion = potion;
    }

    public void useItem(Item i) {
        i.use(this);
    }

    public Pokemon getPokemon(int index) {
        return this.pokemons.get(index);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(0, pokemon);
    }

    public void removePokemon(){
        this.pokemons.remove(0);
    }

    //    public Pokemon getPokemon() {
//        return pokemon;
//    }
//
//    public void setPokemon(Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }
    public Pokeball getPokeball() {
        return pokeball;
    }

    public void setPokeball(Pokeball pokeball) {
        this.pokeball = pokeball;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    public int getMyCountRound() {
        return MyCountRound;
    }

    public void setMyCountRound(int myCountRound) {
        MyCountRound += myCountRound;
    }
    public int getCurrentPoint() {
        return CurrentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        CurrentPoint = currentPoint;
    }

    public int getBeforePoint() {
        return BeforePoint;
    }

    public void setBeforePoint(int beforePoint) {
        BeforePoint = beforePoint;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}