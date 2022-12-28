package obiektowe_1;

public class Arena {
    private Monster monster;
    private Avatar avatar;

    public Arena(Monster monster, Avatar avatar) {
        this.monster = monster;
        this.avatar = avatar;
    }

    public void fightRound(Avatar avatar, Monster monster) {
        monster.hurt(avatar.attack());
        avatar.hurt(monster.attackPower());
    }

    public void showRound(Avatar avatar, Monster monster) {

        fightRound(avatar, monster);
        System.out.println(avatar.getCharacterName() + " atakuje " + monster.getName() + " i zadaje " + avatar.attack() + " obra�e�!");
        if (monster.attackPower() > 0) {
            System.out.println(monster.getName() + " atakuje " + avatar.getCharacterName() + " i zadaje " + monster.attackPower() + " obra�e�!");
        } else {
            System.out.println(monster.getName() + " chybia i nie zadaje obra�e�!");
        }
    }
}
