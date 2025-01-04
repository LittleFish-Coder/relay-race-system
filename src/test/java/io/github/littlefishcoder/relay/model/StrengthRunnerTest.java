package io.github.littlefishcoder.relay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrengthRunnerTest {
    private StrengthRunner runner;

    @BeforeEach
    void setUp() {
        runner = new StrengthRunner();
    }

    @Test
    void testInitialState() {
        assertEquals(10.0, runner.getSpeed(), "力量型跑者初始速度應為10");
        assertEquals(100.0, runner.getDistance(), "初始距離應為100");
        assertEquals("str", runner.getType(), "類型應為str");
    }

    @Test
    void testMove() {
        double time = 5.0;
        double moveDistance = runner.move(time);
        assertEquals(50.0, moveDistance, "應該移動50公尺");
        assertEquals(50.0, runner.getDistance(), "剩餘距離應為50");
    }

    @Test
    void testFrozenTime() {
        assertEquals(5, runner.getFrozenTime(), "力量型跑者的凍結時間應為5秒");
    }

    @Test
    void testMoveWithFieldEffect() {
        runner.setFieldEffect(true);
        double time = 5.0;
        double moveDistance = runner.move(time);
        assertEquals(50.0, moveDistance, "力量型跑者不受力場效果影響");
    }
}