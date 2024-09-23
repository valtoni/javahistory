package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealPerson;

public interface HumanAction<T extends RealPerson> {

    String doAction(T person);

}
