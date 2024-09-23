package org.github.valtoni.matrix.pill.blue;

import org.github.valtoni.matrix.pill.Pill;

public class BluePill implements Pill {

    public String about() {
        return "You take the blue pill, the story ends. You wake up in your bed and believe whatever you want to believe.";
    }

    public void take() {
        throw new RuntimeException("Not do this man! Return ant take the red one!");
    }

}
