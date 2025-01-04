package io.github.littlefishcoder.relay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgilityRunnerTest {
    private AgilityRunner runner;

    @BeforeEach
    void setUp() {
        runner = new AgilityRunner();
    }

    @Test
    void testInitialState() {
        assertEquals(20.0, runner.getSpeed(), "敏捷型跑者初始速度應為20");
        assertEquals(100.0, runner.getDistance(), "初始距離應為100");
        assertEquals("dex", runner.getType(), "類型應為dex");
    }

    @Test
    void testMove() {
        double time = 5.0;
        double expectedDistance = 100.0;
        double moveDistance = runner.move(time);
        assertEquals(100.0, moveDistance, "應該移動100公尺"); 
        assertEquals(0.0, runner.getDistance(), "移動後剩餘距離應為0");
    }

    @Test
    void testFrozenTime() {
        assertEquals(3, runner.getFrozenTime(), "敏捷型跑者的凍結時間應為3秒");
    }

    @Test
    void testMoveWithFieldEffect() {
        runner.setFieldEffect(true);
        double time = 5.0;
        double moveDistance = runner.move(time);
        assertEquals(50.0, moveDistance, "受到力場效果影響，移動距離應減半");
    }
}