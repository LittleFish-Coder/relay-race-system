// Game.java
package io.github.littlefishcoder.relay.game;

import io.github.littlefishcoder.relay.model.*;
import io.github.littlefishcoder.relay.skill.*;

import java.util.Scanner;

public class Game {
    private final GameState gameState;
    private final GameRenderer renderer;
    private final InputValidator validator;
    private final Scanner scanner;
    
    public Game(GameState gameState) {
        this.gameState = gameState;
        this.renderer = new GameRenderer();
        this.validator = new InputValidator();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        // 顯示遊戲說明
        renderer.showGameInstructions();
        
        // 初始化玩家設定
        initializePlayer(gameState.getPlayer1());
        initializePlayer(gameState.getPlayer2());
        
        // 開始比賽
        renderer.showGameStart();
        runGameLoop();
    }
    
    private void initializePlayer(Player player) {
        System.out.println(player.getName() + "請進行選擇");
        
        // 設置跑者
        Runner[] runners;
        while (true) {
            System.out.println("請輸入跑者代碼");
            String input = scanner.nextLine();
            try {
                runners = validator.validateAndCreateRunners(input);
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        player.setRunners(runners);
        
        // 設置技能
        while (true) {
            System.out.println("技能選擇");
            String input = scanner.nextLine();
            try {
                int[] skills = validator.validateSkillInput(input);
                player.setSkills(skills[0], skills[1]);
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private void runGameLoop() {
        // 顯示初始狀態
        renderer.showInitialState(gameState);
        
        while (!gameState.isGameFinished()) {
            // 讀取並處理玩家技能輸入
            handlePlayerSkillInput(gameState.getPlayer1(), gameState.getPlayer2().getCurrentRunner());
            handlePlayerSkillInput(gameState.getPlayer2(), gameState.getPlayer1().getCurrentRunner());
            
            // 更新遊戲狀態
            updateGameState();
            
            // 顯示當前狀態
            renderer.showGameState(gameState);
            
            // 檢查是否需要換人
            checkAndHandleRunnerChange(gameState.getPlayer1());
            checkAndHandleRunnerChange(gameState.getPlayer2());
        }
        
        // 顯示遊戲結果
        renderer.showGameResult(gameState);
    }
    
    private void handlePlayerSkillInput(Player player, Runner targetRunner) {
        while (true) {
            System.out.println(player.getName() + "請輸入欲使用的技能");
            System.out.println("冰凍技能剩餘數量：" + player.getRemainingFrozenSkills());
            System.out.println("力場技能剩餘數量：" + player.getRemainingFieldSkills());
            
            String input = scanner.nextLine();
            try {
                int[] skills = validator.validateSkillUseInput(input, player);
                applySkills(skills, player, targetRunner);
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    void applySkills(int[] skills, Player player, Runner targetRunner) {
        if (skills[0] == 1) {
            new FrozenSkill().apply(targetRunner);
            player.useFrozenSkill();
        }
        if (skills[1] == 1) {
            new FieldSkill().apply(targetRunner);
            player.useFieldSkill();
        }
    }
    
    void updateGameState() {
        gameState.incrementTime(5.0);
        Player p1 = gameState.getPlayer1();
        Player p2 = gameState.getPlayer2();
        
        // 更新跑者位置
        p1.getCurrentRunner().move(5.0);
        p2.getCurrentRunner().move(5.0);
    }
    
    void checkAndHandleRunnerChange(Player player) {
        Runner currentRunner = player.getCurrentRunner();
        if (currentRunner.getDistance() <= 0 && player.hasNextRunner()) {
            renderer.showRunnerChange(player);
            player.nextRunner();
        }
    }
}