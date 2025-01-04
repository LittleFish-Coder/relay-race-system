// GameState.java
package io.github.littlefishcoder.relay.model;

public class GameState {
    private Player player1;
    private Player player2;
    private double gameTime;
    
    public GameState() {
        this.player1 = new Player("玩家一");
        this.player2 = new Player("玩家二");
        this.gameTime = 0.0;
    }
    
    public void incrementTime(double seconds) {
        this.gameTime += seconds;
    }
    
    public double getGameTime() {
        return gameTime;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
    
    public boolean isGameFinished() {
        Runner runner1 = player1.getCurrentRunner();
        Runner runner2 = player2.getCurrentRunner();
        return (runner1.getDistance() <= 0 && !player1.hasNextRunner()) || 
               (runner2.getDistance() <= 0 && !player2.hasNextRunner());
    }
}