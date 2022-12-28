package obiektowe_1;

public class Potion extends Stuff {
    protected int healAmount;

    public Potion(String name, int weight, int healAmount) {
        super(name, weight);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
