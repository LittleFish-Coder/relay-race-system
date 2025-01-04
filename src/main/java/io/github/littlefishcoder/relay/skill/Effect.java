// Effect.java
package io.github.littlefishcoder.relay.skill;

import io.github.littlefishcoder.relay.model.Runner;

public interface Effect {
    void applyEffect(Runner runner);
    String getDescription();
}