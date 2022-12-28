package obiektowe_1;

import java.util.Random;

public class Monster implements Metods_Monster_and_Avatar {
    Random random = new Random();
    int chance = random.nextInt(1, 100);
    private final String name;
    private int health;

    public void getHealth() {
        System.out.println("Akutalny poziom zdrowia " + name + " : " + health);
    }

    private int attackPower;
    private int attackChance;

    public String getName() {
        return name;
    }
    public Monster(int health, int attackPower, int attackChance, String name) {
        this.health = health;
        this.attackPower = attackPower;
        this.attackChance = attackChance;
        this.name = name;
    }

    @Override
    public void hurt(int attackPower) {
        health = health - attackPower;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public int attackPower() {
        if (chance >= attackChance) {
            return attackPower;
        } else {
            return 0;
        }
    }

}
