package com.halukkilincer.adventure.engine;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.utils.Location;

public class GameManager {
    private AbstractCharacter player;
    private Location currentLocation;
    private boolean gameRunning;

    public GameManager() {
        this.gameRunning = true;
    }

    public void setPlayer(AbstractCharacter player) {
        this.player = player;
    }

    public AbstractCharacter getPlayer() {
        return player;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void checkGameOver() {
        if (!player.isAlive()) {
            System.out.println("""
                    
                    ╔═════════════════════════════════════════════════════════════════════╗
                    ║                    RUN TERMINATED                                   ║
                    ╠═════════════════════════════════════════════════════════════════════╣
                    ║ Operative %s flatlined during the heist.                           ║
                    ║ Helix has sealed the district and recovered the breach trail.      ║
                    ║                                                                     ║
                    ║                    GAME OVER ☠️                                     ║
                    ╚═════════════════════════════════════════════════════════════════════╝
                    """.formatted(player.getName()));
            gameRunning = false;
        }
    }
} 