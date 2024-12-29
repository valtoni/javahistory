package org.github.valtoni.matrix.reality;

import org.github.valtoni.matrix.reality.actions.HumanActionTalk;
import org.github.valtoni.matrix.reality.actions.HumanInteractionDialog;
import org.github.valtoni.matrix.reality.humans.HumanConceptor;
import org.github.valtoni.matrix.reality.humans.RealPerson;

/**
 * Represents a singularity in the Matrix, facilitating interactions between two real persons.
 *
 * @param <T> the type of RealPerson involved in the singularity
 */
public class Singularity<T extends RealPerson> {

    private T sender;
    private T recipient;
    private HumanInteractionDialog<T> interaction;

    private final HumanConceptor humanConceptor = new HumanConceptor();

    /**
     * Establishes a relationship between a sender and a recipient.
     *
     * @param sender the name of the sender
     * @param senderIsAnomaly whether the sender is an anomaly
     * @param recipient the name of the recipient
     * @param recipientIsAnomaly whether the recipient is an anomaly
     * @return the current instance of Singularity
     */
    public Singularity<T> relationShip(String sender, boolean senderIsAnomaly, String recipient, boolean recipientIsAnomaly) {
        this.sender = humanConceptor.create(sender, senderIsAnomaly);
        this.recipient = humanConceptor.create(recipient, recipientIsAnomaly);
        return this;
    }

    /**
     * Creates a dialog interaction between the sender and the recipient.
     *
     * @return the current instance of Singularity
     */
    public Singularity<T> createDialog() {
        this.interaction = new HumanInteractionDialog<T>(sender, recipient);
        return this;
    }

    /**
     * Facilitates the sender to talk.
     *
     * @param from the message from the sender
     * @return the current instance of Singularity
     */
    public Singularity<T> senderTalk(String from) {
        HumanActionTalk<T> talk = new HumanActionTalk<>(false, from);
        interaction.interact(talk, null);
        return this;
    }

    /**
     * Facilitates the recipient to talk.
     *
     * @param to the message to the recipient
     * @return the current instance of Singularity
     */
    public Singularity<T> recipientTalk(String to) {
        HumanActionTalk<T> talk = new HumanActionTalk<>(false, to);
        interaction.interact(null, talk);
        return this;
    }
}