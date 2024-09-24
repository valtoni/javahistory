package org.github.valtoni.matrix.reality;

import org.github.valtoni.matrix.reality.actions.HumanActionTalk;
import org.github.valtoni.matrix.reality.actions.HumanInteractionDialog;
import org.github.valtoni.matrix.reality.humans.HumanConceptor;
import org.github.valtoni.matrix.reality.humans.RealPerson;

public class Singularity<T extends RealPerson> {

    private T sender;
    private T recipient;
    private HumanInteractionDialog<T> interaction;

    private final HumanConceptor humanConceptor = new HumanConceptor();

    public Singularity<T> relationShip(String sender, boolean senderIsAnomaly, String recipient, boolean recipientIsAnomaly) {
        this.sender = humanConceptor.create(sender, senderIsAnomaly);
        this.recipient = humanConceptor.create(recipient, recipientIsAnomaly);
        return this;
    }

    public Singularity<T> createDialog() {
        this.interaction = new HumanInteractionDialog<T>(sender, recipient);
        return this;
    }

    public Singularity<T> senderTalk(String from) {
        HumanActionTalk<T> talk = new HumanActionTalk<>(false, from);
        interaction.interact(talk, null);
        return this;
    }

    public Singularity<T> recipientTalk(String to) {
        HumanActionTalk<T> talk = new HumanActionTalk<>(false, to);
        interaction.interact(null, talk);
        return this;
    }


}
