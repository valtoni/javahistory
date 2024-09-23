package org.github.valtoni.matrix.pill;

import org.github.valtoni.matrix.pill.blue.BluePill;
import org.github.valtoni.matrix.pill.red.RedPill;

import javax.validation.constraints.NotEmpty;

public final class SpawnPill {

    public static final String RED = "red";
    public static final String BLUE = "blue";

    public static Pill create(@NotEmpty String name) {
        if (name.equals(RED)) {
            return new RedPill();
        }
        else if (name.equals(BLUE)) {
            return new BluePill();
        }
        else {
            throw new RuntimeException("You must choose red or blue pill");
        }
    }

}
