package obiektowe_1;

public class Weapon extends Stuff {

    int baseAttack;
    int bonus;

    public Weapon(String name, int weight, int baseAttack, int bonus) {
        super(name, weight);
        this.baseAttack = baseAttack;
        this.bonus = bonus;
    }
}
