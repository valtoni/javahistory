package org.github.valtoni.matrix.reality.humans;

import javax.validation.constraints.NotBlank;

public class HumanConceptor {

    public <T extends RealPerson> T create(@NotBlank String name, boolean isAnomaly) {
        if (isAnomaly) {
            return (T) new RealHumanAnomaly(name);
        }
        return (T) new RealHuman(name);
    }

}
