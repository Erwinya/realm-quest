package com.halukkilincer.adventure.utils;

public class ObstacleTest {
    public static void main(String[] args) {
        assertSpawnCountInRange(1);
        assertSpawnCountInRange(5);
        assertSpawnCountInRange(100);
    }

    private static void assertSpawnCountInRange(int spawnLimit) {
        Obstacle obstacle = new TestObstacle(spawnLimit);
        for (int attempt = 0; attempt < 100; attempt++) {
            int monsterCount = obstacle.spawnMonsterCount();
            assert monsterCount >= 1 && monsterCount <= spawnLimit;
        }
    }

    private static class TestObstacle extends Obstacle {
        TestObstacle(int spawnLimit) {
            super("TestMonster", 10, 50, 100, spawnLimit);
        }
    }
}
