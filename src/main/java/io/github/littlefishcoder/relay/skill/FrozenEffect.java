// EffectImpl.java
package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.Runner;

public class FrozenEffect implements Effect {
    @Override
    public void applyEffect(Runner runner) {
        runner.setFrozenEffect(true);
    }
    
    @Override
    public String getDescription() {
        return "受冰凍技能影響";
    }
}