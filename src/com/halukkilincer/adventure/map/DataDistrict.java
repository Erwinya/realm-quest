package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.VoidMinion;
import com.halukkilincer.adventure.utils.BattleLoc;

public class DataDistrict extends BattleLoc {
    private static final VoidMinion STREET_DRONE = new VoidMinion();

    public DataDistrict(AbstractCharacter player) {
        super(player, "Data District", "🌐", STREET_DRONE, "Data Crystal", 3);
    }

    @Override
    public boolean getLocation() throws InterruptedException {
        System.out.println("""

                ╔══════════════════════════════════════════════════════════╗
                ║                     DATA DISTRICT                        ║
                ╠══════════════════════════════════════════════════════════╣
                ║ Holographic billboards flicker above abandoned servers. ║
                ║ The Data Crystal is close, but Street Drones have       ║
                ║ already tagged your signal.                             ║
                ╚══════════════════════════════════════════════════════════╝
                """);

        Thread.sleep(2000);
        return super.getLocation();
    }
}
