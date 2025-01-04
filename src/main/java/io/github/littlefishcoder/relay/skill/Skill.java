// Skill.java
package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.Runner;

public interface Skill {
    void apply(Runner runner);
    String getName();
    String getEffect();
}