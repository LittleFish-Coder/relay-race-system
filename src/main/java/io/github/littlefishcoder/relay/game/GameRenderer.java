// GameRenderer.java
package io.github.littlefishcoder.relay.game;

import io.github.littlefishcoder.relay.model.*;

public class GameRenderer {
    public void showGameInstructions() {
        System.out.println("歡迎來到<成英大學 超能力接力大賽>");
        System.out.println("");
        System.out.println("以下為遊戲說明");
        System.out.println("每位玩家有五名跑者、五項技能，每位跑者的完賽距離為100公尺");
        System.out.println("*********************************************************");
        // ... (其餘說明內容與原本相同)
        System.out.println("*********************************************************");
    }
    
    public void showGameStart() {
        System.out.println("");
        System.out.println("比賽開始");
    }
    
    public void showInitialState(GameState state) {
        System.out.println("第0秒時");
        showPlayerState(state.getPlayer1());
        System.out.println("");
        showPlayerState(state.getPlayer2());
        System.out.println("");
    }
    
    public void showGameState(GameState state) {
        System.out.println("");
        System.out.println("************第" + state.getGameTime() + "秒時賽況**************");
        showPlayerState(state.getPlayer1());
        System.out.println("");
        showPlayerState(state.getPlayer2());
        System.out.println("");
    }
    
    public void showPlayerState(Player player) {
        Runner runner = player.getCurrentRunner();
        System.out.println(player.getName() + "第" + player.getCurrentRunnerIndex() + "棒");
        System.out.println("跑者類型: " + runner.getType());
        System.out.println("剩餘距離: " + String.format("%.1f", runner.getDistance()));
    }
    
    public void showRunnerChange(Player player) {
        System.out.println(player.getName() + "第" + player.getCurrentRunnerIndex() + "棒完成!");
        if (player.hasNextRunner()) {
            System.out.println("接棒給第" + (player.getCurrentRunnerIndex() + 1) + "棒");
        }
    }
    
    public void showGameResult(GameState state) {
        Player p1 = state.getPlayer1();
        Player p2 = state.getPlayer2();
        
        System.out.println("比賽結束！");
        System.out.println("總時間：" + String.format("%.1f", state.getGameTime()) + "秒");
        
        // 判定勝負
        double p1Distance = p1.getCurrentRunner().getDistance();
        double p2Distance = p2.getCurrentRunner().getDistance();
        
        if (p1Distance <= 0 && p2Distance <= 0) {
            System.out.println("比賽結果：平手！");
        } else if (p1Distance <= 0) {
            System.out.println("比賽結果：" + p1.getName() + "獲勝！");
        } else {
            System.out.println("比賽結果：" + p2.getName() + "獲勝！");
        }
    }
}