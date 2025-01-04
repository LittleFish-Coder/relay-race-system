// FrozenSkill.java
package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.Runner;

public class FrozenSkill implements Skill {
    private final Effect effect;
    
    public FrozenSkill() {
        this.effect = new FrozenEffect();
    }
    
    @Override
    public void apply(Runner runner) {
        effect.applyEffect(runner);
    }
    
    @Override
    public String getName() {
        return "冰凍";
    }
    
    @Override
    public String getEffect() {
        return effect.getDescription();
    }
}