package obiektowe_1;

public class Warrior extends Avatar {


    public Warrior(String characterName, int health, Stuff hand, int capacity) {
        super(characterName, health, hand, capacity);
    }

    @Override
    public int attack() {
        if (this.hand instanceof Weapon) {
            return ((Weapon) this.hand).baseAttack + ((Weapon) this.hand).bonus;
        } else if (this.hand instanceof Potion) {
            return ((Potion) this.hand).getHealAmount();
        } else {
            return 0;
        }
    }

}
