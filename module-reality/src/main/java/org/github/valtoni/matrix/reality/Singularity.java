package org.github.valtoni.matrix.reality;

import org.github.valtoni.matrix.reality.actions.HumanActionTalk;
import org.github.valtoni.matrix.reality.actions.HumanInteractionDialog;
import org.github.valtoni.matrix.reality.humans.HumanConceptor;
import org.github.valtoni.matrix.reality.humans.RealPerson;

public class Singularity {

    private RealPerson sender;
    private RealPerson recipient;
    private HumanInteractionDialog interaction;

    private final HumanConceptor humanConceptor = new HumanConceptor();

    public Singularity relationShip(String sender, boolean senderIsAnomaly, String recipient, boolean recipientIsAnomaly) {
        this.sender = humanConceptor.create(sender, senderIsAnomaly);
        this.recipient = humanConceptor.create(recipient, recipientIsAnomaly);
        return this;
    }

    public Singularity createDialog() {
        this.interaction = new HumanInteractionDialog(sender, recipient);
        return this;
    }

    public Singularity senderTalk(String from) {
        HumanActionTalk talk = new HumanActionTalk(false, from);
        interaction.interact(talk, null);
        return this;
    }

    public Singularity recipientTalk(String to) {
        HumanActionTalk talk = new HumanActionTalk(false, to);
        interaction.interact(null, talk);
        return this;
    }


}
