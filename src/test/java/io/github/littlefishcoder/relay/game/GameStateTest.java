package io.github.littlefishcoder.relay.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.littlefishcoder.relay.model.GameState;
import io.github.littlefishcoder.relay.model.Player;
import io.github.littlefishcoder.relay.model.Runner;
import io.github.littlefishcoder.relay.model.StrengthRunner;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {
    private GameState gameState;

    @BeforeEach
    void setUp() {
        gameState = new GameState();
    }

    @Test
    void testInitialState() {
        assertEquals(0.0, gameState.getGameTime(), "遊戲初始時間應為0");
        assertNotNull(gameState.getPlayer1(), "玩家1不應為空");
        assertNotNull(gameState.getPlayer2(), "玩家2不應為空");
    }

    @Test
    void testIncrementTime() {
        gameState.incrementTime(5.0);
        assertEquals(5.0, gameState.getGameTime(), "遊戲時間應增加5秒");
    }

    @Test
    void testIsGameFinished() {
        assertFalse(gameState.isGameFinished(), "遊戲初始時不應結束");

        // 模擬玩家1完成比賽
        Player player1 = gameState.getPlayer1();
        Runner[] runners = new Runner[5];
        for(int i = 0; i < 5; i++) {
            runners[i] = new StrengthRunner();
        }
        player1.setRunners(runners);
        Runner currentRunner = player1.getCurrentRunner();
        currentRunner.setDistance(0);  // 設置距離為0表示完成

        assertTrue(gameState.isGameFinished(), "當有玩家完成時遊戲應該結束");
    }
}