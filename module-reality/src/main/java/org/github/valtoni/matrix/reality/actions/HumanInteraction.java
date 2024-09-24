package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealPerson;

public interface HumanInteraction<T extends RealPerson> {

    void interact(HumanAction<T> senderAction, HumanAction<T> recipientAction);

}
