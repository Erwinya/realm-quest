package com.halukkilincer.adventure.ui;

import java.util.Scanner;

public class GameUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static String showMainMenu() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                 REALM QUEST // RUN MAP                   ║
                ╚══════════════════════════════════════════════════════════╝
                
                Neon rain cuts through Neo-Circuit. Helix patrols are moving.
                Secure the breach tools, enter the Corp Vault, and get out alive.

                ╔════════════════════════════════════════════════════════╗
                ║ 1. 🏠 SAFEHOUSE                                        ║
                ╠════════════════════════════════════════════════════════╣
                ║   Patch wounds and restore health                      ║
                ╠════════════════════════════════════════════════════════╣
                ║ 2. 🛒 BLACK MARKET                                     ║
                ╠════════════════════════════════════════════════════════╣
                ║   Buy weapons and protective augments                  ║
                ╠════════════════════════════════════════════════════════╣
                ║ 3. 🌐 DATA DISTRICT                                    ║
                ╠════════════════════════════════════════════════════════╣
                ║   Recover the Data Crystal from Street Drones          ║
                ╠════════════════════════════════════════════════════════╣
                ║ 4. 🚇 UNDERCITY TUNNELS                                ║
                ╠════════════════════════════════════════════════════════╣
                ║   Seize the Access Key from Chrome Guards              ║
                ╠════════════════════════════════════════════════════════╣
                ║ 5. 🔐 CORP VAULT                                       ║
                ╠════════════════════════════════════════════════════════╣
                ║   Defeat the Overseer and steal the Core Cipher        ║
                ╠════════════════════════════════════════════════════════╣
                ║ 6. 💾 SAVE RUN                                         ║
                ║ [Q] DISCONNECT                                         ║
                ╚════════════════════════════════════════════════════════╝
                """);

        System.out.print("\nSelect destination: ");
        return scanner.nextLine().toLowerCase();
    }

    public static String showCharacterSelection() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║                 CHOOSE YOUR OPERATIVE                    ║
                ╚══════════════════════════════════════════════════════════╝
                
                ╔════════════════════════════════════════════════════════╗
                ║                     [S] ENFORCER                       ║
                ╠════════════════════════════════════════════════════════╣
                ║  Health: 100 | Defense: 15 | Attack: 25                 ║
                ║  Armored tank built to survive direct assaults         ║
                ╠════════════════════════════════════════════════════════╣
                ║                       [A] GHOST                        ║
                ╠════════════════════════════════════════════════════════╣
                ║  Health: 80  | Defense: 8  | Attack: 35                 ║
                ║  Stealth specialist with lethal precision              ║
                ╠════════════════════════════════════════════════════════╣
                ║                    [B] NETRUNNER                       ║
                ╠════════════════════════════════════════════════════════╣
                ║  Health: 65  | Defense: 5  | Attack: 40                 ║
                ║  Hacker who weaponizes hostile systems                 ║
                ╠════════════════════════════════════════════════════════╣
                ║                       [H] MEDIC                        ║
                ╠════════════════════════════════════════════════════════╣
                ║  Health: 120 | Defense: 20 | Attack: 20                 ║
                ║  Combat surgeon with reinforced field gear             ║
                ╚════════════════════════════════════════════════════════╝
                """);

        System.out.print("\nChoose your role (S/A/B/H): ");
        return scanner.nextLine().toLowerCase();
    }

    public static String getPlayerName() {
        System.out.println("""
                
                ╔══════════════════════════════════════════════════════════╗
                ║              REALM QUEST: NEO-CIRCUIT HEIST              ║
                ╚══════════════════════════════════════════════════════════╝
                """);
        System.out.print("\nEnter your operative codename: ");
        return scanner.nextLine();
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showError(String message) {
        System.out.println("❌ " + message);
    }

    public static void close() {
        scanner.close();
    }
} 