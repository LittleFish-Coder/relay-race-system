// AgilityRunner.java
package io.github.littlefishcoder.relay.model;

public class AgilityRunner extends Runner {
    public AgilityRunner() {
        super();
        this.type = "dex";
        this.speed = 20.0;
    }
    
    @Override
    public double move(double time) {
        if (isAffectedByFrozen) {
            return 0.0;
        }
        double currentSpeed = isAffectedByField ? speed / 2 : speed;
        double distance = currentSpeed * time;
        this.distance -= distance;
        return distance;
    }
    
    @Override
    public int getFrozenTime() {
        return 3;  // 敏捷型跑者被冰凍3秒
    }
}