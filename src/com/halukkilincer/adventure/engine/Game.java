package com.halukkilincer.adventure.engine;

import com.halukkilincer.adventure.characters.*;
import com.halukkilincer.adventure.map.*;
import com.halukkilincer.adventure.ui.GameUI;
import com.halukkilincer.adventure.utils.GameLogger;
import com.halukkilincer.adventure.utils.GameSaveManager;
import com.halukkilincer.adventure.utils.Location;

import java.util.Scanner;

public class Game implements AutoCloseable {
	private AbstractCharacter player;
	private final Scanner scanner;
	private boolean isRunning;

	public Game() {
		this.scanner = new Scanner(System.in);
		this.isRunning = true;
	}

	public void start() throws InterruptedException {
		initializeGame();
		gameLoop();
	}

	private void initializeGame() throws InterruptedException {
		// Load saved game if exists
		if (GameSaveManager.saveExists()) {
			System.out.println("\nA saved run was found. Load it? (Y/N)");
			if (scanner.nextLine().equalsIgnoreCase("Y")) {
				loadGame();
				return;
			}
		}

		// Create new game
		String playerName = GameUI.getPlayerName();
		showStory();
		String characterChoice = GameUI.showCharacterSelection();
		
		switch (characterChoice.toLowerCase()) {
			case "s" -> player = new Warrior(playerName);
			case "a" -> player = new Assassin(playerName);
			case "b" -> player = new Mage(playerName);
			case "h" -> player = new Healer(playerName);
			case "q" -> {
				isRunning = false;
				return;
			}
			default -> {
				System.out.println("Invalid role selection. Closing Realm Quest...");
				isRunning = false;
				return;
			}
		}

		GameLogger.log("New game started with character: " + player.getCharacterType());
		System.out.println(player.getDescription());
		Thread.sleep(3000);
	}

	private void showStory() {
		System.out.println("""

				Neo-Circuit never sleeps. Its towers burn electric blue above streets
				owned by the Helix Corporation and watched by tireless security drones.

				Deep inside the Corp Vault, Helix keeps the Core Cipher: a master key
				capable of breaking the systems that hold the megacity under corporate rule.

				Your contract is simple and nearly impossible. Cross the Data District,
				steal a Data Crystal, recover an Access Key in the Undercity Tunnels,
				breach the vault, defeat the Overseer, and escape with the Core Cipher.

				Choose your role. Tonight, Neo-Circuit changes hands.
				""");
	}

	private void gameLoop() throws InterruptedException {
		while (isRunning) {
			String choice = GameUI.showMainMenu();
			Location location = null;

			switch (choice) {
				case "1" -> location = new Safehouse(player);
				case "2" -> location = new BlackMarket(player);
				case "3" -> location = new DataDistrict(player);
				case "4" -> location = new UndercityTunnels(player);
				case "5" -> location = new CorpVault(player);
				case "6" -> saveGame();
				case "q" -> {
					System.out.println("\nDisconnecting from Neo-Circuit...");
					isRunning = false;
					return;
				}
				default -> {
					System.out.println("\n❌ Invalid selection!");
					continue;
				}
			}

			if (location != null) {
				if (!location.getLocation()) {
					System.out.println("\n💀 Run terminated. Game over.");
					isRunning = false;
					return;
				}
			}
		}
	}

	private void saveGame() {
		try {
			GameSaveManager.saveGame(player);
			System.out.println("\n✨ Run saved successfully!");
		} catch (Exception e) {
			System.out.println("\n❌ Could not save the run: " + e.getMessage());
			GameLogger.logError("Failed to save game", e);
		}
	}

	private void loadGame() {
		try {
			player = GameSaveManager.loadGame();
			System.out.println("\n✨ Run loaded successfully!");
		} catch (Exception e) {
			System.out.println("\n❌ Could not load the run: " + e.getMessage());
			GameLogger.logError("Failed to load game", e);
			isRunning = false;
		}
	}

	@Override
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
		GameLogger.log("Game closed");
	}
}



