package io.github.littlefishcoder.relay.game;

import io.github.littlefishcoder.relay.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private GameState gameState;

    @BeforeEach
    void setUp() {
        gameState = new GameState();
        game = new Game(gameState);
    }

    @Test
    void testUpdateGameState() {
        // 設置初始狀態
        Player p1 = gameState.getPlayer1();
        Player p2 = gameState.getPlayer2();
        
        // 設置跑者
        Runner[] runners = new Runner[5];
        for (int i = 0; i < 5; i++) {
            runners[i] = new StrengthRunner();
        }
        p1.setRunners(runners);
        p2.setRunners(runners.clone());

        // 執行更新
        game.updateGameState();

        // 驗證時間增加
        assertEquals(5.0, gameState.getGameTime());
        
        // 驗證跑者移動
        double expectedDistance = 100 - (10 * 5); // 力量型跑者速度 * 時間
        assertEquals(expectedDistance, p1.getCurrentRunner().getDistance(), 0.01);
        assertEquals(expectedDistance, p2.getCurrentRunner().getDistance(), 0.01);
    }

    @Test
    void testCheckAndHandleRunnerChange() throws InvalidInputException {
        Player player = gameState.getPlayer1();
        
        // 設置跑者
        String runnerInput = "str-dex-str-dex-str";
        InputValidator validator = new InputValidator();
        Runner[] runners = validator.validateAndCreateRunners(runnerInput);
        player.setRunners(runners);

        // 設置當前跑者已完成
        Runner currentRunner = player.getCurrentRunner();
        while(currentRunner.getDistance() > 0) {
            currentRunner.move(5.0);
        }

        int originalIndex = player.getCurrentRunnerIndex();
        game.checkAndHandleRunnerChange(player);
        
        assertTrue(player.getCurrentRunnerIndex() > originalIndex, 
            "跑者編號應該增加");
    }

    @Test
    void testApplySkills() {
        Player player = gameState.getPlayer1();
        Runner targetRunner = new AgilityRunner();
        
        // 設置技能
        player.setSkills(2, 2);
        
        // 使用兩種技能
        int[] skills = {1, 1};  // 使用一個冰凍和一個力場技能
        game.applySkills(skills, player, targetRunner);

        // 驗證技能效果：透過移動距離來判斷技能效果
        double initialDistance = targetRunner.getDistance();
        double moveTime = 5.0;
        double movedDistance = targetRunner.move(moveTime);
        
        // 應該被技能影響，移動距離應該變少
        assertTrue(movedDistance < GameConstants.DEX_SPEED * moveTime, 
            "跑者應該受到技能影響而移動較慢");
        
        // 驗證技能數量減少
        assertEquals(1, player.getRemainingFrozenSkills(), "凍結技能應該減少一個");
        assertEquals(1, player.getRemainingFieldSkills(), "力場技能應該減少一個");
    }
    
    @Test
    void testGameFinishCondition() {
        Player p1 = gameState.getPlayer1();
        Player p2 = gameState.getPlayer2();

        // 設置玩家1完成比賽
        Runner[] runners = new Runner[5];
        for (int i = 0; i < 5; i++) {
            runners[i] = new StrengthRunner();
        }
        p1.setRunners(runners);
        
        // 設置最後一位跑者距離為0
        while(p1.getCurrentRunner().getDistance() > 0) {
            p1.getCurrentRunner().move(5.0);
        }

        assertTrue(gameState.isGameFinished(), "當有玩家完成時遊戲應結束");
    }
}