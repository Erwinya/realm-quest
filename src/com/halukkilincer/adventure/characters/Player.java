package com.halukkilincer.adventure.characters;

import com.halukkilincer.adventure.items.Inventory;

public class Player {

	private int damage, health, defense, firstHealth;
	private String name, charName;
	private Inventory inventory = new Inventory();
	private int initialMoney = 10;
	private int Money = initialMoney;
	
	public void initializeCharacter() throws InterruptedException {
		switch (this.getCharName().toLowerCase()) {
		case "s" -> {
			setStats(25, 100, 15);
			setCharName("Enforcer");
			System.out.println("\n══════════════════════════════════════════════════════════╗");
			System.out.println("║                  ⚔️ ENFORCER SELECTED ⚔️                 ║");
			System.out.println("║ Heavy armor makes you the crew's front-line operative.   ║");
			System.out.println("╠═══════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Attack  : " + this.damage +"                                          ║");
			System.out.println(  "║ ❤️  Health  : " + this.health +"                                         ║");
			System.out.println(  "║ 🛡️  Defense : " + this.defense+"                                          ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}
		case "a" -> {
			setStats(35, 80, 8);
			setCharName("Ghost");
			System.out.println("\n═══════════════════════════════════════════════════════════╗");
			System.out.println("║                    🗡️ GHOST SELECTED 🗡️                 ║");
			System.out.println("║ Stealth systems make silence your sharpest weapon.       ║");
			System.out.println("╠══════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Attack  : " + this.damage +"                                          ║");
			System.out.println(  "║ ❤️  Health  : " + this.health +"                                          ║");
			System.out.println(  "║ 🛡️  Defense : " + this.defense+"                                           ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}
		case "b" -> {
			setStats(40, 65, 5);
			setCharName("Netrunner");
			System.out.println("\n═══════════════════════════════════════════════════════════╗");
			System.out.println("║                  💻 NETRUNNER SELECTED 💻                ║");
			System.out.println("║ Your neural deck turns hostile systems into weapons.     ║");
			System.out.println("╠═══════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Attack  : " + this.damage +"                                          ║");
			System.out.println(  "║ ❤️  Health  : " + this.health +"                                          ║");
			System.out.println(  "║ 🛡️  Defense : " + this.defense+"                                           ║");
			System.out.println("╚══════════════════════════════════════════════════════════╝");
		}
		case "h" -> {
			setStats(20, 120, 20);
			setCharName("Medic");
			System.out.println("\n══════════════════════════════════════════════════════════╗");
			System.out.println("║                    💚 MEDIC SELECTED 💚                 ║");
			System.out.println("║ Trauma implants keep you alive under heavy fire.       ║");
			System.out.println("╠═════════════════════════════════════════════════════════╝");
			System.out.println(  "║ 🗡️  Attack  : " + this.damage +"                                         ║");
			System.out.println(  "║ ❤️  Health  : " + this.health +"                                         ║");
			System.out.println(  "║ 🛡️  Defense : " + this.defense+"                                          ║");
			System.out.println("╚═════════════════════════════════════════════════════════╝");
		}
		case "q" -> {
			System.out.println("\n👋 Disconnecting from Neo-Circuit...");
			Thread.sleep(1500);
			System.exit(0);
		}
		default -> System.out.println("❌ Invalid role. Choose S, A, B, H, or Q to disconnect.");
		}
		Thread.sleep(3000);
	}

	public int getTotalDamage() {
		return getDamage() + getInventory().getWeaponDamage();
	}
	
	public int getTotalDefense() {
		return getDefense() + getInventory().getArmorDefense();
	}
	
	private void setStats(int damage, int health, int defense) {
		this.damage = damage;
		this.health = health;
		this.defense = defense;
		this.firstHealth = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String selectCharInput) {
		this.charName = selectCharInput;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getFirstHealth() {
		return firstHealth;
	}

	public void setFirstHealth(int firstHealth) {
		this.firstHealth = firstHealth;
	}

	public int getMoneyStart() {
		return initialMoney;
	}

	public void setMoneyStart(int moneyStart) {
		this.initialMoney = moneyStart;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

}
