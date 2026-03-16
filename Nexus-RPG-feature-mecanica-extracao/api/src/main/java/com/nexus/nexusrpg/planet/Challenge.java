package com.nexus.nexusrpg.planet;

/**
 * Representação simples de um desafio (não persistido).
 */
public class Challenge {
    private final String id;
    private final String title;
    private final String description;
    private final String difficulty;
    private final int xpReward;

    public Challenge(String id, String title, String description, String difficulty, int xpReward) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.xpReward = xpReward;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDifficulty() { return difficulty; }
    public int getXpReward() { return xpReward; }
}
