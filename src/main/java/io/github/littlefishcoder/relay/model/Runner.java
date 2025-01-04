// Runner.java
package io.github.littlefishcoder.relay.model;

public abstract class Runner {
    protected String type;
    protected double speed;
    protected double distance;
    protected boolean isAffectedByField;
    protected boolean isAffectedByFrozen;
    
    public Runner() {
        this.distance = 100.0;  // 初始距離100公尺
        this.isAffectedByField = false;
        this.isAffectedByFrozen = false;
    }
    
    public abstract double move(double time);
    public abstract int getFrozenTime();
    
    public double getSpeed() {
        return this.speed;
    }
    
    public String getType() {
        return this.type;
    }
    
    public double getDistance() {
        return this.distance;
    }
    
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFieldEffect(boolean affected) {
        this.isAffectedByField = affected;
    }
    
    public void setFrozenEffect(boolean affected) {
        this.isAffectedByFrozen = affected;
    }
}