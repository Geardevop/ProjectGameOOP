import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
public class Pokemon {

    private String name;
    private String type;
    private int HP;
    private int ATK;

    private Image pokemonpic, pokemonImage;

    public Pokemon() {
        this("", "", 0, 0, null, null);
    }

    public Pokemon(String name, String type, int HP, int ATK, Image pokomonpic, Image pokemonImage) {
        this.pokemonpic = pokomonpic;
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.ATK = ATK;
        this.pokemonImage = pokemonImage;
    }

    public void attack(Pokemon p) {
        int myATKofpokemon = this.getATK();
        if (this.type.equals("fire") && p.type.equals("rock")) {
            System.out.println("fire");
            System.out.println("X2");
            myATKofpokemon *= 2;
        } else if (this.type.equals("water") && p.type.equals("fire")) {
            System.out.println("water");
            System.out.println("X2");
            myATKofpokemon *= 2;
        } else if (this.type.equals("grass") && p.type.equals("water")) {
            System.out.println("grass");
            System.out.println("X2");
            myATKofpokemon *= 2;
        } else if (this.type.equals("rock") && p.type.equals("grass")) {
            System.out.println("water");
            System.out.println("X2");
            myATKofpokemon *= 2;
        }
        p.setHP(-myATKofpokemon);
    }

    @Override
    public String toString() {
        return String.format("Name : %s, Type : %s, HP : %s, ATK : %s", this.name, this.type, this.HP, this.ATK);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHP() {
        return HP;
    }

    public Image getPokemonpic() {
        return pokemonpic;
    }

    public void setPokemonpic(Image pokemonpic) {
        this.pokemonpic = pokemonpic;
    }

    public void setHP(int HP) {
        this.HP += HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK += ATK;
    }

    public Image getPokemonImage() {
        return pokemonImage;
    }


}