package com.halukkilincer.adventure.map;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.Location;

public class Safehouse extends Location {
    public Safehouse(AbstractCharacter player) {
        super(player, "Safehouse", "🏠");
    }

    @Override
    public boolean getLocation() {
        getPlayer().setHealth(getPlayer().getMaxHealth());
        System.out.println("\n✨ The safe flat's med-station restored your health.");
        return true;
    }
}
