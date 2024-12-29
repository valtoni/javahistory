package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.pill.Pill;
import org.github.valtoni.matrix.reality.humans.RealPerson;

public class HumanActionTakePill<T extends RealPerson> implements HumanAction<T> {

    private final Pill pill;

    public HumanActionTakePill(Pill pill) {
        this.pill = pill;
    }

    public String doAction(T person) {
        this.pill.take();
        return String.format("* The pill was take for person %s (pill info: %s)", person.getName(), pill.about());
    }

}
