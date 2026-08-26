package com.halukkilincer.adventure.characters;

public class Healer extends AbstractCharacter {
    private static final int BASE_DAMAGE = 20;
    private static final int BASE_HEALTH = 120;
    private static final int BASE_DEFENSE = 20;

    public Healer(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Medic";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║                    💚 MEDIC SELECTED 💚                  ║
               ║ Trauma implants and reinforced field gear keep you      ║
               ║ standing through the longest corporate firefights.      ║
               ╠══════════════════════════════════════════════════════════╝
               ║ 🗡️  Attack  : %d                                        ║
               ║ ❤️  Health  : %d                                        ║
               ║ 🛡️  Defense : %d                                        ║
               ╚══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 