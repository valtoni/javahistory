package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealPerson;

public interface HumanInteraction {

    void interact(HumanAction senderAction, HumanAction recipientAction);

}
