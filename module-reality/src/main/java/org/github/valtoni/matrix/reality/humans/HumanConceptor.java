package org.github.valtoni.matrix.reality.humans;

import javax.validation.constraints.NotBlank;

public class HumanConceptor {

    public RealPerson create(@NotBlank String name, boolean isAnomaly) {
        if (isAnomaly) {
            return new RealHumanAnomaly(name);
        }
        return new RealHuman(name);
    }

}
