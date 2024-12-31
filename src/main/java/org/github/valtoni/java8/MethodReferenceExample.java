package org.github.valtoni.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Neo", "Morpheus", "Trinity", "Smith", "Oracle", "Cypher");
        // Using method reference to print each name
        names.forEach(System.out::println);
    }

}
