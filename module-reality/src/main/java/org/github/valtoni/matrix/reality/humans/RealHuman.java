package org.github.valtoni.matrix.reality.humans;

public class RealHuman implements RealPerson {

    private final String name;

    public RealHuman(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
