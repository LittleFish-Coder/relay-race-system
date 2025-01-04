// StrengthRunner.java
package io.github.littlefishcoder.relay.model;

public class StrengthRunner extends Runner {
    public StrengthRunner() {
        super();
        this.type = "str";
        this.speed = 10.0;
    }
    
    @Override
    public double move(double time) {
        if (isAffectedByFrozen) {
            return 0.0;
        }
        // 力量型跑者不受力場影響
        double distance = speed * time;
        this.distance -= distance;
        return distance;
    }
    
    @Override
    public int getFrozenTime() {
        return 5;  // 力量型跑者被冰凍5秒
    }
}