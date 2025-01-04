// SkillSet.java
package io.github.littlefishcoder.relay.skill;

public class SkillSet {
    private int frozenCount;
    private int fieldCount;
    private final int TOTAL_SKILLS = 5;
    
    public SkillSet(int frozenCount, int fieldCount) {
        if (frozenCount + fieldCount != TOTAL_SKILLS) {
            throw new IllegalArgumentException("技能總數必須為" + TOTAL_SKILLS);
        }
        this.frozenCount = frozenCount;
        this.fieldCount = fieldCount;
    }
    
    public boolean useFrozenSkill() {
        if (frozenCount > 0) {
            frozenCount--;
            return true;
        }
        return false;
    }
    
    public boolean useFieldSkill() {
        if (fieldCount > 0) {
            fieldCount--;
            return true;
        }
        return false;
    }
    
    public int getRemainingFrozenSkills() {
        return frozenCount;
    }
    
    public int getRemainingFieldSkills() {
        return fieldCount;
    }
    
    public boolean canUseSkill(String skillType) {
        if (skillType.equals("frozen")) {
            return frozenCount > 0;
        } else if (skillType.equals("field")) {
            return fieldCount > 0;
        }
        return false;
    }
    
    public boolean isEmpty() {
        return frozenCount == 0 && fieldCount == 0;
    }
}