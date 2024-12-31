package org.github.valtoni.matrix;

import org.github.valtoni.matrix.pill.SpawnPill;
import org.github.valtoni.matrix.pill.Pill;
import org.github.valtoni.matrix.reality.Singularity;

import java.util.Optional;
import java.util.Set;

public class Main {

    public static void talkAboutPill(Pill pill) {
        System.out.println(pill.about());
    }

    public static void main(String[] args) {
        var pillSpawner = new SpawnPill();
        var red = pillSpawner.create(SpawnPill.RED);
        var blue = pillSpawner.create(SpawnPill.BLUE);
        talkAboutPill(red);
        talkAboutPill(blue);

        String morpheus = null;
        Optional<String> optional = Optional.ofNullable(morpheus);


        try {
            String value = optional.orElseThrow(() -> new IllegalArgumentException("Morpheus not exist!"));
            System.out.println(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            morpheus = "Morpheus";
        }


        var singularity = new Singularity<>();
        var humansSenders = Set.of(morpheus);
        var humansRecipients = Set.of("Neo");
        var senders = Set.copyOf(humansSenders);
        var recipients = Set.copyOf(humansRecipients);
        senders.forEach(sender -> {
            recipients.forEach(recipient -> {
                singularity
                        .relationShip(sender, false, recipient, true)
                        .createDialog()
                        .senderTalk(red.about())
                        .senderTalk(blue.about());
            });
        });
    }

}


