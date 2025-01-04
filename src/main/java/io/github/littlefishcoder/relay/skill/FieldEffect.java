// FieldEffect.java
package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.Runner;

public class FieldEffect implements Effect {
    @Override
    public void applyEffect(Runner runner) {
        runner.setFieldEffect(true);
    }
    
    @Override
    public String getDescription() {
        return "受力場技能影響";
    }
}