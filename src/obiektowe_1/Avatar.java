package obiektowe_1;

import java.util.ArrayList;

public class Avatar implements Metods_Monster_and_Avatar {

    private final String characterName;
    protected Stuff hand;
    boolean onePot = true;
    private int backpackSum = 0;
    private int health;
    private final int capacity;
    private final ArrayList<Stuff> backpack;

    public Avatar(String characterName, int health, Stuff hand, int capacity) {
        this.characterName = characterName;
        this.health = health;
        this.hand = hand;
        this.capacity = capacity;
        this.backpack = new ArrayList<>();
    }

    public String getCharacterName() {
        return characterName;
    }

    public ArrayList<Stuff> getBackpack() {
        return backpack;
    }

    public void getHealth() {
        System.out.println("Aktualny poziom zdrowia " + characterName + " : " + health);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void hurt(int attackPower) {
        health = health - attackPower;
    }

    public void setHand(Stuff hand) {
        this.hand = hand;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        if (this.hand instanceof Weapon) {
            return ((Weapon) this.hand).baseAttack;
        } else if (this.hand instanceof Potion) {
            return ((Potion) this.hand).getHealAmount();
        } else
            return 0;
    }

    public void addToBackpack(Stuff stuff) {
        int weight = stuff.getWeight();
        backpackSum = backpackSum + weight;
        if (backpackSum < capacity) {
            backpack.add(stuff);
        } else {
            System.out.println("nie masz miejsca na przedmioty!");
        }
    }

    public void healAvatar(int health, Potion potion) {
        setHealth(health + potion.getHealAmount());
    }

    public void getItemsFromBackpack(String choose) {

        Stuff choosen = this.backpack.stream().filter(a -> a.name.equals(choose)).findFirst().orElse(null);
        if (choosen instanceof Potion potion && onePot && choose.equals(potion.name)) {
            healAvatar(health, potion);
            System.out.println("bohater wypi³ potke");
            backpack.remove(choosen);
            onePot = false;
        } else if (choosen instanceof Weapon weapon && choose.equals(weapon.name)) {
            setHand(weapon);
            System.out.println("mirek wyposa¿y³ sie w "+ weapon.name);
        } else if (!onePot) {
            System.out.println("nie mozesz wypiæ wiecej pot");
        } else {
            System.out.println("nie masz takiego przedmiotu w plecaku!");
        }
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "hand=" + hand +
                ", characterName='" + characterName + '\'' +
                ", health=" + health +
                '}';
    }
}



