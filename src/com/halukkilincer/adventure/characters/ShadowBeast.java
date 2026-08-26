package com.halukkilincer.adventure.characters;

import java.util.Random;

public class ShadowBeast extends Enemy {
    private static final Random random = new Random();
    
    public ShadowBeast() {
        super("Chrome Guard", 15, 100, 30);
    }
} 