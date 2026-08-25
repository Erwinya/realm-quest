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
		System.out.printf("\n%d adet %s burada!\n", enemyCount, enemy.getName());
		System.out.print("\n<S>avaş veya <K>aç: ");
		String selectCase = scanner.nextLine().toUpperCase();
		
		if (selectCase.equals("S") && combat(enemyCount)) {
			System.out.println("\n" + this.getName() + " bölgesindeki tüm düşmanları yendin!");
			earnReward();
			return true;
		}
		
		if (player.getHealth() <= 0) {
			System.out.println("\n💀 Öldün!");
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
				System.out.print("\n<V>ur veya <K>aç: ");
				String selectCombat = scanner.nextLine().toUpperCase();
				
				if (selectCombat.equals("V")) {
					System.out.println("\nSen vurdun!");
					enemy.takeDamage(player.attack());
					Thread.sleep(1000);
					
					if (enemy.getHealth() > 0) {
						System.out.println("\nCanavar sana vurdu!");
						player.takeDamage(enemy.attack());
						Thread.sleep(1000);
					}
				} else {
					System.out.println("\n🏃 Savaştan kaçtın!");
					return false;
				}
			}
			
			if (enemy.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("\n🎯 Düşmanı yendin!");
				player.getInventory().setMoney(player.getInventory().getMoney() + enemy.getGold());
				System.out.println("💰 " + enemy.getGold() + " altın kazandın!");
			} else {
				return false;
			}
		}
		return true;
	}

	protected void earnReward() {
		if (reward.equals("Orman Parşömeni")) {
			player.getInventory().setForestScroll(true);
			player.getInventory().addRareItem("Orman Parşömeni");
		} else if (reward.equals("Kadim Taş")) {
			player.getInventory().setAncientStone(true);
			player.getInventory().addRareItem("Kadim Taş");
		} else if (reward.equals("Void Kristali")) {
			player.getInventory().setDungeonKey(true);
			player.getInventory().addRareItem("Void Kristali");
		}
	}

	protected void playerStats() {
		System.out.println("\n══════════ Oyuncu Değerleri ══════════");
		System.out.println("❤️ Can: " + player.getHealth());
		System.out.println("🗡️ Hasar: " + player.getDamage());
		System.out.println("🛡️ Zırh: " + player.getDefense());
		System.out.println("💰 Para: " + player.getInventory().getMoney());
	}

	protected void enemyStats() {
		System.out.println("\n══════════ " + enemy.getName() + " Değerleri ══════════");
		System.out.println("❤️ Can: " + enemy.getHealth());
		System.out.println("⚔️ Hasar: " + enemy.getDamage());
		System.out.println("🏆 Ödül: " + enemy.getGold() + " Altın");
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
