package io.github.littlefishcoder.relay.skill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SkillSetTest {
    private SkillSet skillSet;

    @BeforeEach
    void setUp() {
        skillSet = new SkillSet(3, 2); // 3個冰凍技能，2個力場技能
    }

    @Test
    void testInitialization() {
        assertEquals(3, skillSet.getRemainingFrozenSkills(), "初始冰凍技能數量應為3");
        assertEquals(2, skillSet.getRemainingFieldSkills(), "初始力場技能數量應為2");
    }

    @Test
    void testUseFrozenSkill() {
        assertTrue(skillSet.useFrozenSkill(), "使用冰凍技能應該成功");
        assertEquals(2, skillSet.getRemainingFrozenSkills(), "剩餘冰凍技能數量應為2");
    }

    @Test
    void testUseFieldSkill() {
        assertTrue(skillSet.useFieldSkill(), "使用力場技能應該成功");
        assertEquals(1, skillSet.getRemainingFieldSkills(), "剩餘力場技能數量應為1");
    }

    @Test
    void testUseSkillWhenEmpty() {
        skillSet = new SkillSet(0, 0);
        assertFalse(skillSet.useFrozenSkill(), "使用空的冰凍技能應該失敗");
        assertFalse(skillSet.useFieldSkill(), "使用空的力場技能應該失敗");
    }

    @Test
    void testCanUseSkill() {
        assertTrue(skillSet.canUseSkill("frozen"), "應該能使用冰凍技能");
        assertTrue(skillSet.canUseSkill("field"), "應該能使用力場技能");
    }
}