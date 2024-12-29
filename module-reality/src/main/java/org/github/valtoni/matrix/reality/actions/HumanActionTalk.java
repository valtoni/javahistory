package org.github.valtoni.matrix.reality.actions;

import org.github.valtoni.matrix.reality.humans.RealHuman;
import org.github.valtoni.matrix.reality.humans.RealPerson;

public class HumanActionTalk<T extends RealPerson> implements HumanAction<T> {

    private final boolean think;
    private final String message;

    public HumanActionTalk(boolean think, String message) {
        this.think = think;
        this.message = message;
    }

    public String doAction(RealPerson person) {
        String message = String.format("%s: %s", person.getName(), this.message);
        if (!think) {
            System.out.printf("- %s", message);
        }
        return message;
    }

    public static void main(String[] args) {
        RealHuman human = new RealHuman("Neo");
        new HumanActionTalk<RealHuman>(false, "Hi! I don't know no what to say.").doAction(human);
    }

}
