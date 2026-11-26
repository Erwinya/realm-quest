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
		setMissionItem(MissionItem.CORE_CIPHER, dungeonKey);
	}
	
	public boolean isForestScroll() {
		return forestScroll;
	}

	public void setForestScroll(boolean forestScroll) {
		setMissionItem(MissionItem.DATA_CRYSTAL, forestScroll);
	}

	public boolean isAncientStone() {
		return ancientStone;
	}

	public void setAncientStone(boolean ancientStone) {
		setMissionItem(MissionItem.ACCESS_KEY, ancientStone);
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
			MissionItem.fromLabel(item).ifPresent(missionItem -> setFlag(missionItem, true));
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

	public void setMissionItem(MissionItem item, boolean owned) {
		if (item == null) {
			return;
		}

		setFlag(item, owned);
		if (owned) {
			if (!rareItems.contains(item.getLabel())) {
				rareItems.add(item.getLabel());
			}
		} else {
			rareItems.remove(item.getLabel());
		}
	}

	private void setFlag(MissionItem item, boolean owned) {
		switch (item) {
			case ACCESS_KEY -> ancientStone = owned;
			case DATA_CRYSTAL -> forestScroll = owned;
			case CORE_CIPHER -> dungeonKey = owned;
		}
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
