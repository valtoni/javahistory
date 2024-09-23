package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealPerson;

public class HumanInteractionDialog implements HumanInteraction {

    private RealPerson sender;
    private RealPerson recipient;

    public HumanInteractionDialog(RealPerson sender, RealPerson recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public void interact(HumanAction actionSender, HumanAction actionRecipient) {
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
