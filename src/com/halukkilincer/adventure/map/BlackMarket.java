package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.Location;

import java.util.Scanner;

public class BlackMarket extends Location {
    private final Scanner scanner = new Scanner(System.in);

    public BlackMarket(AbstractCharacter player) {
        super(player, "Black Market", "🛒");
    }

    @Override
    public boolean getLocation() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║               BLACK MARKET // NIGHT SHIFT               ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("\n1. Weapons");
            System.out.println("2. Armor augments");
            System.out.println("3. Return to the city");
            System.out.println("\n💳 Available credits: " + player.getInventory().getMoney());
            System.out.print("Select category: ");

            switch (scanner.nextLine()) {
                case "1" -> {
                    printWeapons();
                    buyWeapon();
                }
                case "2" -> {
                    printArmor();
                    buyArmor();
                }
                case "3" -> {
                    System.out.println("\nLeaving the Black Market...");
                    showMenu = false;
                }
                default -> System.out.println("\n❌ Invalid selection. Choose 1-3.");
            }
        }
        return true;
    }

    private void printWeapons() {
        System.out.println("\n1. Arc Baton       | Attack: +2 | 25 credits");
        System.out.println("2. Smart Pistol    | Attack: +3 | 35 credits");
        System.out.println("3. Monowire Blade  | Attack: +7 | 45 credits");
        System.out.println("4. Back");
    }

    private void printArmor() {
        System.out.println("\n1. Reflex Weave    | Defense: +1 | 15 credits");
        System.out.println("2. Chrome Vest     | Defense: +3 | 25 credits");
        System.out.println("3. Aegis Exoshell  | Defense: +5 | 40 credits");
        System.out.println("4. Back");
    }

    private void buyWeapon() {
        System.out.print("\nSelect a weapon: ");
        String choice = scanner.nextLine();
        int damage;
        int price;
        String item;

        switch (choice) {
            case "1" -> { damage = 2; price = 25; item = "Arc Baton"; }
            case "2" -> { damage = 3; price = 35; item = "Smart Pistol"; }
            case "3" -> { damage = 7; price = 45; item = "Monowire Blade"; }
            case "4" -> { return; }
            default -> {
                System.out.println("\n❌ Invalid weapon selection.");
                return;
            }
        }

        if (!canAfford(price)) {
            return;
        }
        player.getInventory().setMoney(player.getInventory().getMoney() - price);
        player.getInventory().setWeaponDamage(damage);
        printReceipt(item);
    }

    private void buyArmor() {
        System.out.print("\nSelect an armor augment: ");
        String choice = scanner.nextLine();
        int defense;
        int price;
        String item;

        switch (choice) {
            case "1" -> { defense = 1; price = 15; item = "Reflex Weave"; }
            case "2" -> { defense = 3; price = 25; item = "Chrome Vest"; }
            case "3" -> { defense = 5; price = 40; item = "Aegis Exoshell"; }
            case "4" -> { return; }
            default -> {
                System.out.println("\n❌ Invalid armor selection.");
                return;
            }
        }

        if (!canAfford(price)) {
            return;
        }
        player.getInventory().setMoney(player.getInventory().getMoney() - price);
        player.getInventory().setArmorDefense(defense);
        printReceipt(item);
    }

    private boolean canAfford(int price) {
        if (price > player.getInventory().getMoney()) {
            System.out.println("\n❌ Not enough credits.");
            return false;
        }
        return true;
    }

    private void printReceipt(String item) {
        System.out.println("\n✨ " + item + " acquired.");
        System.out.println("💳 Remaining credits: " + player.getInventory().getMoney());
    }
}
