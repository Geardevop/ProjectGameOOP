public class Pokeball extends Item {

    public Pokeball() {
        this(0);
    }

    public Pokeball(int amount) {
        this.amount = amount;
    }

    @Override
    public void use(Player player) {
        player.getPokeball().setAmount(-1);
    }

}