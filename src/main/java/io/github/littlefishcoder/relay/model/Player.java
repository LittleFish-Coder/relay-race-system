// Player.java
package io.github.littlefishcoder.relay.model;

public class Player {
    private Runner[] runners;
    private int currentRunnerIndex;
    private int frozenSkills;
    private int fieldSkills;
    private String name;
    
    public Player(String name) {
        this.name = name;
        this.runners = new Runner[5];
        this.currentRunnerIndex = 0;
        this.frozenSkills = 0;
        this.fieldSkills = 0;
    }
    
    public void setRunners(Runner[] runners) {
        if (runners.length != 5) {
            throw new IllegalArgumentException("必須設定5名跑者");
        }
        this.runners = runners;
    }
    
    public void setSkills(int frozen, int field) {
        if (frozen + field != 5) {
            throw new IllegalArgumentException("技能總數必須為5");
        }
        this.frozenSkills = frozen;
        this.fieldSkills = field;
    }
    
    public Runner getCurrentRunner() {
        return runners[currentRunnerIndex];
    }
    
    public boolean hasNextRunner() {
        return currentRunnerIndex < 4;
    }
    
    public void nextRunner() {
        if (hasNextRunner()) {
            currentRunnerIndex++;
        }
    }
    
    public int getRemainingFrozenSkills() {
        return frozenSkills;
    }
    
    public int getRemainingFieldSkills() {
        return fieldSkills;
    }
    
    public void useFrozenSkill() {
        if (frozenSkills > 0) {
            frozenSkills--;
        }
    }
    
    public void useFieldSkill() {
        if (fieldSkills > 0) {
            fieldSkills--;
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getCurrentRunnerIndex() {
        return currentRunnerIndex + 1;  // 為了顯示從1開始的棒次
    }
}