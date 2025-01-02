package org.github.valtoni.matrix.facilities;

public class Main {

    public static String JAVA_13 = "Java 13";
    public static String NON_13 = "Else then 13";

    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();
        String descriptive = switch (version.feature()) {
            case 13 -> JAVA_13 +
              "(yes java 13)";
            default -> NON_13 +
              "(but...)" +
              "(...can be greater than 13)";
        };
        System.out.printf(" feature: %s%n interim: %s%n update: %s%n patch: %s%n (desc: %s)",
                version.feature(),
                version.interim(),
                version.update(),
                version.patch(),
                descriptive);
    }

}
