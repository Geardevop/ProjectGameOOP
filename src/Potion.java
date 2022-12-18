public class Potion extends Item {

    public Potion() {
        this(0);
    }

    public Potion(int amount) {
        this.amount = amount;
    }

    @Override
    public void use(Player player) {
        player.getPotion().setAmount(-1);
        player.getPokemon(0).setHP(20); //change heal another
    }

}