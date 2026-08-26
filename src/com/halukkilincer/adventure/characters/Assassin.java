package com.halukkilincer.adventure.characters;

public class Assassin extends AbstractCharacter {
    private static final int BASE_DAMAGE = 35;
    private static final int BASE_HEALTH = 80;
    private static final int BASE_DEFENSE = 8;

    public Assassin(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Ghost";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║                   🗡️ GHOST SELECTED 🗡️                   ║
               ║ Optical camouflage and silent blades let you cross      ║
               ║ guarded sectors before anyone sees the breach.          ║
               ╠══════════════════════════════════════════════════════════╝
               ║ 🗡️  Attack  : %d                                        ║
               ║ ❤️  Health  : %d                                        ║
               ║ 🛡️  Defense : %d                                        ║
               ╚══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 