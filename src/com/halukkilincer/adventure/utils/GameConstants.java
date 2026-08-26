package com.halukkilincer.adventure.utils;

public final class GameConstants {
    private GameConstants() {} // Prevent instantiation

    // Operative constants
    public static final int INITIAL_MONEY = 100;
    
    // Weapon upgrade constants
    public static final int IRON_SWORD_DAMAGE = 2;
    public static final int STEEL_SWORD_DAMAGE = 3;
    public static final int MITHRIL_SWORD_DAMAGE = 7;
    public static final int IRON_SWORD_PRICE = 25;
    public static final int STEEL_SWORD_PRICE = 35;
    public static final int MITHRIL_SWORD_PRICE = 45;
    
    // Armor augment constants
    public static final int LIGHT_ARMOR_DEFENSE = 1;
    public static final int MEDIUM_ARMOR_DEFENSE = 3;
    public static final int HEAVY_ARMOR_DEFENSE = 5;
    public static final int LIGHT_ARMOR_PRICE = 15;
    public static final int MEDIUM_ARMOR_PRICE = 25;
    public static final int HEAVY_ARMOR_PRICE = 40;
    
    // Enemy Constants
    public static final int VOID_MINION_DAMAGE = 10;
    public static final int VOID_MINION_HEALTH = 50;
    public static final int VOID_MINION_GOLD = 10;
    
    public static final int SHADOW_BEAST_DAMAGE = 15;
    public static final int SHADOW_BEAST_HEALTH = 100;
    public static final int SHADOW_BEAST_GOLD = 30;
    
    public static final int VOID_LORD_DAMAGE = 25;
    public static final int VOID_LORD_HEALTH = 250;
    public static final int VOID_LORD_GOLD = 100;
    
    // Game Messages
    public static final String INVALID_CHOICE = "❌ Invalid selection!";
    public static final String NOT_ENOUGH_MONEY = "❌ Not enough credits!";
    public static final String PURCHASE_SUCCESS = "✨ %s acquired!";
    public static final String REMAINING_GOLD = "💳 Remaining credits: %d";
} 