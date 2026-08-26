package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;
import com.halukkilincer.adventure.characters.Enemy;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
	protected Enemy enemy;
	protected String reward;
	protected int maxEnemyCount;
	protected Scanner scanner = new Scanner(System.in);
	protected Random random = new Random();

	public BattleLoc(AbstractCharacter player, String name, String locationEmoji, Enemy enemy, String reward, int maxEnemyCount) {
		super(player, name, locationEmoji);
		this.enemy = enemy;
		this.reward = reward;
		this.maxEnemyCount = maxEnemyCount;
	}

	@Override
	public boolean getLocation() throws InterruptedException {
		int enemyCount = generateEnemyCount();
		System.out.printf("\n%d %s unit(s) detected!\n", enemyCount, enemy.getName());
		System.out.print("\n<F>ight or <R>un: ");
		String selectCase = scanner.nextLine().toUpperCase();
		
		if (selectCase.equals("F") && combat(enemyCount)) {
			System.out.println("\nYou cleared every hostile in " + this.getName() + "!");
			earnReward();
			return true;
		}
		
		if (player.getHealth() <= 0) {
			System.out.println("\n💀 Your signal went dark.");
			return false;
		}
		
		return true;
	}

	protected boolean combat(int enemyCount) throws InterruptedException {
		for (int i = 0; i < enemyCount; i++) {
			enemy.setHealth(enemy.getMaxHealth());
			playerStats();
			enemyStats();
			
			while (player.getHealth() > 0 && enemy.getHealth() > 0) {
				System.out.print("\n<A>ttack or <R>un: ");
				String selectCombat = scanner.nextLine().toUpperCase();
				
				if (selectCombat.equals("A")) {
					System.out.println("\nYou strike!");
					enemy.takeDamage(player.attack());
					Thread.sleep(1000);
					
					if (enemy.getHealth() > 0) {
						System.out.println("\n" + enemy.getName() + " counterattacks!");
						player.takeDamage(enemy.attack());
						Thread.sleep(1000);
					}
				} else {
					System.out.println("\n🏃 You escaped the fight.");
					return false;
				}
			}
			
			if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("\n🎯 Hostile neutralized!");
				player.getInventory().setMoney(player.getInventory().getMoney() + enemy.getGold());
				System.out.println("💳 You earned " + enemy.getGold() + " credits.");
			} else {
				return false;
			}
		}
		return true;
	}

	protected void earnReward() {
		if (reward.equals("Data Crystal")) {
			player.getInventory().setForestScroll(true);
			player.getInventory().addRareItem("Data Crystal");
		} else if (reward.equals("Access Key")) {
			player.getInventory().setAncientStone(true);
			player.getInventory().addRareItem("Access Key");
		} else if (reward.equals("Core Cipher")) {
			player.getInventory().setDungeonKey(true);
			player.getInventory().addRareItem("Core Cipher");
		}
	}

	protected void playerStats() {
		System.out.println("\n══════════ OPERATIVE STATUS ══════════");
		System.out.println("❤️ Health: " + player.getHealth());
		System.out.println("🗡️ Attack: " + player.getDamage());
		System.out.println("🛡️ Defense: " + player.getDefense());
		System.out.println("💳 Credits: " + player.getInventory().getMoney());
	}

	protected void enemyStats() {
		System.out.println("\n══════════ " + enemy.getName() + " STATUS ══════════");
		System.out.println("❤️ Health: " + enemy.getHealth());
		System.out.println("⚔️ Attack: " + enemy.getDamage());
		System.out.println("💳 Bounty: " + enemy.getGold() + " credits");
	}

	protected int generateEnemyCount() {
		return (int) (Math.random() * maxEnemyCount) + 1;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}
}
