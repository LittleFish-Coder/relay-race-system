package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.AgilityRunner;
import io.github.littlefishcoder.relay.model.Runner;
import io.github.littlefishcoder.relay.model.StrengthRunner;
import io.github.littlefishcoder.relay.game.GameConstants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SkillTest {
    
    @Test
    void testFrozenSkillOnAgilityRunner() {
        Skill frozenSkill = new FrozenSkill();
        Runner runner = new AgilityRunner();
        
        // 記錄原始移動距離
        double originalDistance = runner.getDistance();
        double time = 5.0;
        
        // 使用冰凍技能
        frozenSkill.apply(runner);
        
        // 移動並檢查距離
        double movedDistance = runner.move(time);
        assertEquals(0.0, movedDistance, "被凍結的跑者不應該移動");
        assertEquals(originalDistance, runner.getDistance(), "被凍結的跑者距離不應改變");
    }

    @Test
    void testFrozenSkillOnStrengthRunner() {
        Skill frozenSkill = new FrozenSkill();
        Runner runner = new StrengthRunner();
        double time = 5.0;
        
        // 使用冰凍技能
        frozenSkill.apply(runner);
        
        // 移動並檢查距離
        double movedDistance = runner.move(time);
        assertEquals(0.0, movedDistance, "被凍結的跑者不應該移動");
    }

    @Test
    void testFieldSkillOnAgilityRunner() {
        Skill fieldSkill = new FieldSkill();
        Runner runner = new AgilityRunner();
        double time = 5.0;
        
        // 記錄原始速度的移動距離
        double originalMoveDistance = GameConstants.DEX_SPEED * time;
        
        // 使用力場技能
        fieldSkill.apply(runner);
        
        // 移動並檢查距離
        double movedDistance = runner.move(time);
        assertEquals(GameConstants.DEX_FIELD_SPEED * time, movedDistance, 
            "受力場影響的敏捷型跑者應該以較慢速度移動");
        assertTrue(movedDistance < originalMoveDistance, 
            "受力場影響後的移動距離應該小於原始移動距離");
    }

    @Test
    void testFieldSkillOnStrengthRunner() {
        Skill fieldSkill = new FieldSkill();
        Runner runner = new StrengthRunner();
        double time = 5.0;
        
        // 記錄原始速度的移動距離
        double expectedDistance = GameConstants.STR_SPEED * time;
        
        // 使用力場技能
        fieldSkill.apply(runner);
        
        // 移動並檢查距離
        double movedDistance = runner.move(time);
        assertEquals(expectedDistance, movedDistance, 
            "力量型跑者不應該受到力場影響");
    }
}