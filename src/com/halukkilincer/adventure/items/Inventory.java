package com.halukkilincer.adventure.items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private boolean dungeonKey;
	private boolean forestScroll;
	private boolean ancientStone;
	private int money;
	private List<String> rareItems;
	private boolean hasWeapon;
	private boolean hasArmor;
	private int weaponDamage;
	private int armorDefense;

	public Inventory() {
		this.dungeonKey = false;
		this.forestScroll = false;
		this.ancientStone = false;
		this.money = 100; // Starting money
		this.rareItems = new ArrayList<>();
		this.hasWeapon = false;
		this.hasArmor = false;
		this.weaponDamage = 0;
		this.armorDefense = 0;
	}

	public boolean isDungeonKey() {
		return dungeonKey;
	}

	public void setDungeonKey(boolean dungeonKey) {
		this.dungeonKey = dungeonKey;
	}
	
	public boolean isForestScroll() {
		return forestScroll;
	}

	public void setForestScroll(boolean forestScroll) {
		this.forestScroll = forestScroll;
	}

	public boolean isAncientStone() {
		return ancientStone;
	}

	public void setAncientStone(boolean ancientStone) {
		this.ancientStone = ancientStone;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addRareItem(String item) {
		if (item != null && !rareItems.contains(item)) {
			rareItems.add(item);
			System.out.println("\nMISSION ITEM ACQUIRED: " + item + "!");
			
			if (item.equals("Access Key")) {
				System.out.println("Its encrypted signature matches the Corp Vault security grid.");
			} else if (item.equals("Data Crystal")) {
				System.out.println("The crystal contains the exploit needed to breach Helix systems.");
			} else if (item.equals("Core Cipher")) {
				System.out.println("Neo-Circuit's most powerful corporate secret is now yours.");
			}
		}
	}

	public List<String> getRareItems() {
		return rareItems;
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
		this.hasWeapon = true;
	}

	public int getArmorDefense() {
		return armorDefense;
	}

	public void setArmorDefense(int armorDefense) {
		this.armorDefense = armorDefense;
		this.hasArmor = true;
	}
}
