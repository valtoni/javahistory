package org.github.valtoni.matrix.facilities;

public class MultilineText {

    public static void main(String[] args) {
        String text = """
                This is the first of three lines, \
                this is the second of three lines \
                and that are the third of three lines.
                This is an additional one with break line in the final.
                """;
        System.out.println(text);

    }

}
