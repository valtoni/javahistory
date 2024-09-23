package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealPersonAnomaly;

public class HumanActionFly implements HumanAction<RealPersonAnomaly> {

    public String doAction(RealPersonAnomaly person) {
        return String.format("* Flying: %s", person.getName());
    }

}
