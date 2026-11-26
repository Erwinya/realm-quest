package com.halukkilincer.adventure.items;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addRareItem(MissionItem.ACCESS_KEY.getLabel());
        assert inventory.isAncientStone();
        assert inventory.getRareItems().contains("Access Key");

        inventory.setForestScroll(true);
        assert inventory.getRareItems().contains("Data Crystal");

        inventory.setDungeonKey(true);
        assert inventory.getRareItems().contains("Core Cipher");

        inventory.setAncientStone(false);
        assert !inventory.isAncientStone();
        assert !inventory.getRareItems().contains("Access Key");

        inventory.addRareItem("Data Crystal");
        long crystals = inventory.getRareItems().stream()
                .filter("Data Crystal"::equals)
                .count();
        assert crystals == 1;
    }
}
