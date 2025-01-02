package org.github.valtoni.matrix;

import org.github.valtoni.matrix.pill.SpawnPill;
import org.github.valtoni.matrix.pill.Pill;
import org.github.valtoni.matrix.reality.Singularity;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void talkAboutPill(Pill pill) {
        System.out.println(pill.about());
    }

    public static void main(String[] args) throws IOException {
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

        // Agent Smith and java 11 String
        var agent = " Agent ".stripLeading();
        var smith = " Smith ".stripTrailing();
        var agentSmith = agent.strip() + " " + smith.strip() + System.lineSeparator();

        if (!agentSmith.isBlank()) {
            System.out.println("MrSmith is ready in Matrix");
        }

        var agentSmithSet = agentSmith
                .repeat(10000)
                .lines()
                .collect(Collectors.toList());

        System.out.format("%d of %s will attack Neo now!", agentSmithSet.size(), agentSmithSet.stream().findFirst().orElseThrow());

        // Agent Smith and java 12 String
        var agentSmithSet2 = agentSmith
                .transform(string -> "--" + string + "--")
                .repeat(10000)
                .lines()
                .map(currentMrSmith -> currentMrSmith.indent(4))
                .collect(Collectors.toList());

        System.out.format("%d of %s will attack Neo now! (wave2)\n", agentSmithSet2.size(), agentSmithSet2.stream().findFirst().orElseThrow());

        // Agent Smith and java 11 Files
        Path path = Files.writeString(
                Files.createTempFile("agentSmith", ".mtrx"),
                agentSmithSet.stream().reduce("ListPhase1AgentSmith: ", (x, y) -> x + y),
                StandardCharsets.UTF_8,
                StandardOpenOption.WRITE
        );
        String readString = Files.readString(path);
        System.out.println("Readed from temp Phase1: " + readString);

    }

}


