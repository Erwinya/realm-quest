package com.halukkilincer.adventure.characters;

public class Warrior extends AbstractCharacter {
    private static final int BASE_DAMAGE = 25;
    private static final int BASE_HEALTH = 100;
    private static final int BASE_DEFENSE = 15;

    public Warrior(String name) {
        super(name, BASE_DAMAGE, BASE_HEALTH, BASE_DEFENSE);
    }

    @Override
    public String getCharacterType() {
        return "Enforcer";
    }

    @Override
    public String getDescription() {
        return """
               ╔═══════════════════════════════════════════════════════════╗
               ║                 ⚔️ ENFORCER SELECTED ⚔️                  ║
               ║ Heavy plating and shock-frame implants make you the     ║
               ║ crew's front line when the alarms start screaming.      ║
               ╠══════════════════════════════════════════════════════════╝
               ║ 🗡️  Attack  : %d                                        ║
               ║ ❤️  Health  : %d                                        ║
               ║ 🛡️  Defense : %d                                        ║
               ╚══════════════════════════════════════════════════════════╝
               """.formatted(damage, health, defense);
    }
} 