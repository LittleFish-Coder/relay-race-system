package io.github.littlefishcoder.relay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private static final String PLAYER_NAME = "玩家一";

    @BeforeEach
    void setUp() {
        player = new Player(PLAYER_NAME);
    }

    @Test
    void testInitialization() {
        assertEquals(PLAYER_NAME, player.getName(), "玩家名稱應該正確設定");
        assertEquals(0, player.getRemainingFrozenSkills(), "初始凍結技能數量應為0");
        assertEquals(0, player.getRemainingFieldSkills(), "初始力場技能數量應為0");
    }

    @Test
    void testSetSkills() {
        player.setSkills(3, 2);
        assertEquals(3, player.getRemainingFrozenSkills(), "凍結技能數量應為3");
        assertEquals(2, player.getRemainingFieldSkills(), "力場技能數量應為2");
    }

    @Test
    void testCurrentAndNextRunner() {
        Runner[] runners = new Runner[5];
        runners[0] = new StrengthRunner();
        runners[1] = new AgilityRunner();
        runners[2] = new StrengthRunner();
        runners[3] = new AgilityRunner();
        runners[4] = new StrengthRunner();
        
        player.setRunners(runners);
        
        assertTrue(player.getCurrentRunner() instanceof StrengthRunner, 
            "第一位跑者應該是力量型");
        assertEquals(1, player.getCurrentRunnerIndex(), 
            "當前跑者索引應為1");

        player.nextRunner();
        assertTrue(player.getCurrentRunner() instanceof AgilityRunner, 
            "第二位跑者應該是敏捷型");
        assertEquals(2, player.getCurrentRunnerIndex(), 
            "當前跑者索引應為2");
    }

    @Test
    void testSkillUsage() {
        player.setSkills(2, 3);
        player.useFrozenSkill();
        assertEquals(1, player.getRemainingFrozenSkills(), 
            "使用一次凍結技能後剩餘數量應為1");
        
        player.useFieldSkill();
        assertEquals(2, player.getRemainingFieldSkills(), 
            "使用一次力場技能後剩餘數量應為2");
    }

    @Test
    void testHasNextRunner() {
        Runner[] runners = new Runner[5];
        for(int i = 0; i < 5; i++) {
            runners[i] = new StrengthRunner();
        }
        player.setRunners(runners);

        for(int i = 0; i < 4; i++) {
            assertTrue(player.hasNextRunner(), 
                "應該還有下一位跑者");
            player.nextRunner();
        }
        assertFalse(player.hasNextRunner(), 
            "最後一位跑者後應該沒有下一位");
    }
}