package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Warrior;
import com.halukkilincer.adventure.items.MissionItem;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameSaveManagerTest {
    public static void main(String[] args) throws IOException {
        Path tempDirectory = Files.createTempDirectory("realm-quest-save-test");
        try {
            testRoundTrip(tempDirectory.resolve("round-trip.properties"));
            testCorruptSave(tempDirectory.resolve("corrupt.properties"));
        } finally {
            try (var paths = Files.walk(tempDirectory)) {
                paths.sorted((left, right) -> right.compareTo(left))
                        .forEach(GameSaveManagerTest::delete);
            }
        }
    }

    private static void testRoundTrip(Path saveFile) throws IOException {
        Warrior original = new Warrior("Vega");
        original.setHealth(63);
        original.getInventory().setMoney(245);
        original.getInventory().setWeaponDamage(12);
        original.getInventory().setArmorDefense(8);
        original.getInventory().addRareItem(MissionItem.ACCESS_KEY.getLabel());
        original.getInventory().addRareItem(MissionItem.DATA_CRYSTAL.getLabel());
        original.getInventory().setDungeonKey(true);

        GameSaveManager.saveGame(original, saveFile);
        AbstractCharacter loaded = GameSaveManager.loadGame(saveFile);

        assert GameSaveManager.saveExists(saveFile);
        assert loaded.getName().equals("Vega");
        assert loaded.getCharacterType().equals("Enforcer");
        assert loaded.getHealth() == 63;
        assert loaded.getInventory().getMoney() == 245;
        assert loaded.getInventory().getWeaponDamage() == 12;
        assert loaded.getInventory().getArmorDefense() == 8;
        assert loaded.getDamage() == 37;
        assert loaded.getDefense() == 23;
        assert loaded.getInventory().isAncientStone();
        assert loaded.getInventory().isForestScroll();
        assert loaded.getInventory().isDungeonKey();
        assert loaded.getInventory().getRareItems().contains("Core Cipher");

        String saveContents = Files.readString(saveFile);
        assert !saveContents.contains("player.damage");
        assert !saveContents.contains("player.defense");
    }

    private static void testCorruptSave(Path saveFile) throws IOException {
        Files.writeString(saveFile, "player.type=UnknownRole\n");
        boolean failed = false;
        try {
            GameSaveManager.loadGame(saveFile);
        } catch (GameException expected) {
            failed = true;
        }
        assert failed : "A corrupt character type must be rejected";
    }

    private static void delete(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
