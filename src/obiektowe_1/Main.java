package obiektowe_1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Weapon sword = new Weapon("miecz", 50, 20, 5);
        Weapon katana = new Weapon("katana", 60, 50, 9);
        Potion redPot = new Potion("redPot", 20, 50);
        Stuff bread = new Stuff("chleb", 50);
        Warrior warrior = new Warrior("Miros³aw", 400, katana, 150);
        Monster monster = new Monster(500, 40, 10, "Dzik");
        warrior.addToBackpack(redPot);
        warrior.addToBackpack(bread);
        warrior.addToBackpack(redPot);
        warrior.addToBackpack(sword);

        Arena arena = new Arena(monster, warrior);
        Scanner scanner = new Scanner(System.in);
        boolean contiuneGame = true;
        System.out.println("gra toczy sie w stystemie turowym");
        while (contiuneGame) {
            System.out.println("wybierz opcje");
            System.out.println("1. rozpocznij ture");
            System.out.println("2. zmieñ broñ");
            System.out.println("3. wypij potkê");
            System.out.println("4. zakoñcz");
            int userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice) {
                case 1 -> {
                    if (warrior.isAlive() && monster.isAlive()) {
                        arena.showRound(warrior, monster);
                        warrior.getHealth();
                        monster.getHealth();
                    }
                    if (!warrior.isAlive()) {
                        System.out.println(monster.getName().toUpperCase(Locale.ROOT) + " WYGRA£ POTYCZKÊ!");
                        contiuneGame = false;
                        System.out.println("zakonczono rozgrywkê");
                    }
                    if (!monster.isAlive()) {
                        System.out.println(warrior.getCharacterName().toUpperCase(Locale.ROOT) + " WYGRA£ POTYCZKÊ!");
                        contiuneGame = false;
                        System.out.println("zakoñczono rozgrywkê");
                    }
                }
                case 2 -> {
                    System.out.println("wpisz jak¹ broñ chcesz wybraæ");
                    System.out.println("dostêpne opcje");
                    for (Stuff s : warrior.getBackpack()) {
                        if (s instanceof Weapon) {
                            System.out.println(s.name);
                        }
                    }
                    String text = scanner.nextLine();
                    warrior.getItemsFromBackpack(text);
                }
                case 3 -> {
                    warrior.getItemsFromBackpack(redPot.name);
                    warrior.getHealth();
                }
                case 4 -> {
                    contiuneGame = false;
                    System.out.println("przewano rozgrywkê");
                }
            }
        }
    }
}
