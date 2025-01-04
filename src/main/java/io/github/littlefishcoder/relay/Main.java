package io.github.littlefishcoder.relay;

import io.github.littlefishcoder.relay.model.GameState;
import io.github.littlefishcoder.relay.game.Game;

public class Main {
    public static void main(String[] args) {
        // 初始化遊戲狀態
        GameState gameState = new GameState();
        
        // 初始化遊戲控制器
        Game game = new Game(gameState);
        
        // 開始遊戲
        game.start();
    }
}