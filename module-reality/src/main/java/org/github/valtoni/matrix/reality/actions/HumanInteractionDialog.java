package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealPerson;

public class HumanInteractionDialog<T extends RealPerson> implements HumanInteraction<T> {

    private final T sender;
    private final T recipient;

    public HumanInteractionDialog(T sender, T recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public void interact(HumanAction<T> actionSender, HumanAction<T> actionRecipient) {
        if (actionSender == null && actionRecipient == null) {
            System.out.println("Anyone must say something");
        }
        System.out.printf("Dialog between %s and %s: \n", sender.getName(), recipient.getName());
        if (actionSender != null) {
            System.out.printf(actionSender.doAction(sender));
        }
        if (actionRecipient != null) {
            System.out.printf(actionRecipient.doAction(recipient));
        }
    }

}
