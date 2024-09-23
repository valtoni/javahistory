package org.github.valtoni.matrix.pill;

import org.github.valtoni.matrix.pill.blue.BluePill;
import org.github.valtoni.matrix.pill.red.RedPill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpawnPillTests {

    @Test
    @DisplayName("Create Red Pill")
    void createRedPill() {
        assertEquals(SpawnPill.create(SpawnPill.RED).getClass(), RedPill.class);
    }

    @Test
    @DisplayName("Create Blue Pill")
    void createBluePill() {
        assertEquals(SpawnPill.create(SpawnPill.BLUE).getClass(), BluePill.class);
    }

}
