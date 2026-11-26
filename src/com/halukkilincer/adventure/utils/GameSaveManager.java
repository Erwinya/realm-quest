package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Assassin;
import com.halukkilincer.adventure.characters.Healer;
import com.halukkilincer.adventure.characters.Mage;
import com.halukkilincer.adventure.characters.Warrior;
import com.halukkilincer.adventure.items.Inventory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Properties;

public class GameSaveManager {
    public static final int SAVE_VERSION = 1;
    private static final Path DEFAULT_SAVE_FILE = Path.of("savegame.properties");

    private GameSaveManager() {} // Prevent instantiation

    public static void saveGame(AbstractCharacter player) {
        saveGame(player, DEFAULT_SAVE_FILE);
    }

    public static void saveGame(AbstractCharacter player, Path saveFile) {
        Properties props = new Properties();

        Inventory inventory = player.getInventory();
        props.setProperty("save.version", String.valueOf(SAVE_VERSION));
        props.setProperty("player.name", player.getName());
        props.setProperty("player.type", player.getCharacterType());
        props.setProperty("player.health", String.valueOf(player.getHealth()));
        props.setProperty("inventory.money", String.valueOf(inventory.getMoney()));
        props.setProperty("inventory.weaponDamage", String.valueOf(inventory.getWeaponDamage()));
        props.setProperty("inventory.armorDefense", String.valueOf(inventory.getArmorDefense()));
        props.setProperty("inventory.dungeonKey", String.valueOf(inventory.isDungeonKey()));
        props.setProperty("inventory.rareItems", String.join(",", inventory.getRareItems()));

        Path absoluteSaveFile = saveFile.toAbsolutePath();
        Path parent = absoluteSaveFile.getParent();
        Path tempFile = null;
        try {
            Files.createDirectories(parent);
            tempFile = Files.createTempFile(parent, absoluteSaveFile.getFileName().toString(), ".tmp");
            try (OutputStream out = Files.newOutputStream(tempFile)) {
            props.store(out, "Game Save Data");
            }
            moveIntoPlace(tempFile, absoluteSaveFile);
            GameLogger.log("Game saved successfully for player: " + player.getName());
        } catch (IOException e) {
            GameLogger.logError("Failed to save game", e);
            throw new GameException("Failed to save game", e);
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException ignored) {
                    // Best effort cleanup after a failed save.
                }
            }
        }
    }

    public static AbstractCharacter loadGame() {
        return loadGame(DEFAULT_SAVE_FILE);
    }

    public static AbstractCharacter loadGame(Path saveFile) {
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(saveFile)) {
            props.load(in);

            int version = parseInt(props, "save.version", SAVE_VERSION);
            if (version != SAVE_VERSION) {
                throw new GameException("Unsupported save version: " + version);
            }

            String playerName = props.getProperty("player.name", "Runner");
            String playerType = props.getProperty("player.type", "Enforcer");
            AbstractCharacter player = createCharacter(playerType, playerName);

            Inventory inventory = player.getInventory();
            player.setHealth(parseInt(props, "player.health", player.getMaxHealth()));
            inventory.setMoney(parseInt(props, "inventory.money", inventory.getMoney()));
            inventory.setWeaponDamage(parseInt(props, "inventory.weaponDamage", 0));
            inventory.setArmorDefense(parseInt(props, "inventory.armorDefense", 0));
            restoreRareItems(inventory, props.getProperty("inventory.rareItems", ""));
            inventory.setDungeonKey(Boolean.parseBoolean(
                    props.getProperty("inventory.dungeonKey", String.valueOf(inventory.isDungeonKey()))));

            GameLogger.log("Game loaded successfully for player: " + player.getName());
            return player;
        } catch (IOException | NumberFormatException e) {
            GameLogger.logError("Failed to load game", e);
            throw new GameException("Failed to load game", e);
        }
    }

    private static AbstractCharacter createCharacter(String playerType, String playerName) {
        return switch (playerType.toLowerCase()) {
            case "ghost" -> new Assassin(playerName);
            case "netrunner" -> new Mage(playerName);
            case "medic" -> new Healer(playerName);
            case "enforcer" -> new Warrior(playerName);
            default -> throw new GameException("Unknown character type: " + playerType);
        };
    }

    public static boolean saveExists() {
        return saveExists(DEFAULT_SAVE_FILE);
    }

    public static boolean saveExists(Path saveFile) {
        return Files.isRegularFile(saveFile);
    }

    private static int parseInt(Properties props, String key, int defaultValue) {
        return Integer.parseInt(props.getProperty(key, String.valueOf(defaultValue)));
    }

    private static void restoreRareItems(Inventory inventory, String savedItems) {
        Arrays.stream(savedItems.split(","))
                .map(String::trim)
                .filter(item -> !item.isEmpty())
                .forEach(inventory::addRareItem);
    }

    private static void moveIntoPlace(Path tempFile, Path saveFile) throws IOException {
        try {
            Files.move(tempFile, saveFile,
                    StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (AtomicMoveNotSupportedException e) {
            Files.move(tempFile, saveFile, StandardCopyOption.REPLACE_EXISTING);
        }
    }
} 