package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.VoidLord;
import com.halukkilincer.adventure.utils.BattleLoc;

public class CorpVault extends BattleLoc {
    private static final VoidLord OVERSEER = new VoidLord();

    public CorpVault(AbstractCharacter player) {
        super(player, "Corp Vault", "🔐", OVERSEER, "Core Cipher", 1);
    }

    @Override
    public boolean getLocation() throws InterruptedException {
        if (!player.getInventory().isForestScroll() || !player.getInventory().isAncientStone()) {
            System.out.println("""

                    ╔══════════════════════════════════════════════════════════╗
                    ║                    ⚠ ACCESS DENIED ⚠                    ║
                    ╠══════════════════════════════════════════════════════════╣
                    ║ The Corp Vault rejected your breach attempt.            ║
                    ║ Acquire both infiltration assets first:                 ║
                    ║ • Data Crystal                                           ║
                    ║ • Access Key                                             ║
                    ╚══════════════════════════════════════════════════════════╝
                    """);
            return true;
        }

        System.out.println("""

                ╔══════════════════════════════════════════════════════════╗
                ║                       CORP VAULT                         ║
                ╠══════════════════════════════════════════════════════════╣
                ║ The breach tools burn through the final security gate. ║
                ║ The Overseer activates between you and the Core Cipher.║
                ║ Finish the heist.                                      ║
                ╚══════════════════════════════════════════════════════════╝
                """);

        Thread.sleep(2000);
        boolean battleResult = super.getLocation();

        if (battleResult && enemy.getHealth() <= 0) {
            System.out.println("""

                    ╔══════════════════════════════════════════════════════════╗
                    ║                    ✨ HEIST COMPLETE ✨                  ║
                    ╠══════════════════════════════════════════════════════════╣
                    ║ The Overseer is down. You seize the Core Cipher and     ║
                    ║ vanish into Neo-Circuit before Helix seals the district.║
                    ║ Tonight, the megacity gets a chance to fight back.      ║
                    ╚══════════════════════════════════════════════════════════╝
                    """);
            Thread.sleep(5000);
            System.exit(0);
        }

        return true;
    }
}
