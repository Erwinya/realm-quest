package com.halukkilincer.adventure.characters;

import java.util.Random;
import com.halukkilincer.adventure.interfaces.ICombat;

public class Enemy implements ICombat {
    private String name;
    private int damage;
    private int health;
    private int maxHealth;
    private int gold;
    private int originalHealth;
    private static final Random random = new Random();

    public Enemy(String name, int damage, int health, int gold) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.originalHealth = health;
        this.gold = gold;
    }

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public int getOriginalHealth() {
        return originalHealth;
    }
    
    public void resetHealth() {
        this.health = this.originalHealth;
    }

    public String dropRareItem() {
        int chance = random.nextInt(100); // 0-99 arası rastgele sayı
        
        if (chance < 5) { // %5 şans
            if (random.nextBoolean()) {
                return "Access Key";
            } }

            if (5>chance && chance < 15) { // %5 şans
                if (random.nextBoolean()) {
                    return "Data Crystal";
                } }
        
        return null;
    }
} 