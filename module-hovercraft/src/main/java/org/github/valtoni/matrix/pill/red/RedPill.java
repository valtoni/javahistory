package org.github.valtoni.matrix.pill.red;

import org.github.valtoni.matrix.pill.Pill;

public class RedPill implements Pill {

    public String about() {
        return "You take the red pill, you stay in Wonderland, and I show you how deep the rabbit hole does";
    }

    public void take() {
        System.out.println("Disrupting the carrier signal of the pod-human's mind ...");
    }

}
