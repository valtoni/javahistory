package org.github.valtoni.matrix;

import org.github.valtoni.matrix.pill.SpawnPill;
import org.github.valtoni.matrix.pill.Pill;
import org.github.valtoni.matrix.reality.Singularity;

public class Main {

    public static void talkAboutPill(Pill pill) {
        System.out.println(pill.about());
    }

    public static void main(String[] args) {
        SpawnPill pillSpawner = new SpawnPill();
        Pill red = pillSpawner.create(SpawnPill.RED);
        Pill blue = pillSpawner.create(SpawnPill.BLUE);
        talkAboutPill(red);
        talkAboutPill(blue);

        Singularity singularity = new Singularity();
        singularity
                .relationShip("Morpheus", false, "Neo", true)
                .createDialog()
                .senderTalk(red.about())
                .senderTalk(blue.about());
    }

}
