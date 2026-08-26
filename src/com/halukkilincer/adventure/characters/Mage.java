package com.halukkilincer.adventure.characters;

public class Mage extends AbstractCharacter {
    private static final int BASE_DAMAGE = 40;
    private static final int BASE_HEALTH = 65;
    private static final int BASE_DEFENSE = 5;

    public Mage(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Netrunner";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║                 💻 NETRUNNER SELECTED 💻                 ║
               ║ Your neural deck turns cameras, drones, and corporate   ║
               ║ defenses into weapons before they can lock on.          ║
               ╠══════════════════════════════════════════════════════════╝
               ║ 🗡️  Attack  : %d                                        ║
               ║ ❤️  Health  : %d                                        ║
               ║ 🛡️  Defense : %d                                        ║
               ╚══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 