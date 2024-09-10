package org.github.valtoni.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Neo", "Morpheus", "Trinity", "Smith", "Oracle", "Cypher");
        names.forEach(name -> System.out.println(name));
    }

}
