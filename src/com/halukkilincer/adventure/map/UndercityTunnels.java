package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.ShadowBeast;
import com.halukkilincer.adventure.utils.BattleLoc;

public class UndercityTunnels extends BattleLoc {
    private static final ShadowBeast CHROME_GUARD = new ShadowBeast();

    public UndercityTunnels(AbstractCharacter player) {
        super(player, "Undercity Tunnels", "🚇", CHROME_GUARD, "Access Key", 2);
    }

    @Override
    public boolean getLocation() throws InterruptedException {
        System.out.println("""

                ╔══════════════════════════════════════════════════════════╗
                ║                  UNDERCITY TUNNELS                       ║
                ╠══════════════════════════════════════════════════════════╣
                ║ Dead transit lines run beneath Neo-Circuit's towers.    ║
                ║ The Corp Vault's Access Key is down here, guarded by    ║
                ║ Helix Chrome Guards built for close-quarters combat.    ║
                ╚══════════════════════════════════════════════════════════╝
                """);

        Thread.sleep(2000);
        return super.getLocation();
    }
}
