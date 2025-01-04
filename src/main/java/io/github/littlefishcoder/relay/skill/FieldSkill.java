// FieldSkill.java
package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.Runner;

public class FieldSkill implements Skill {
    private final Effect effect;
    
    public FieldSkill() {
        this.effect = new FieldEffect();
    }
    
    @Override
    public void apply(Runner runner) {
        effect.applyEffect(runner);
    }
    
    @Override
    public String getName() {
        return "力場";
    }
    
    @Override
    public String getEffect() {
        return effect.getDescription();
    }
}