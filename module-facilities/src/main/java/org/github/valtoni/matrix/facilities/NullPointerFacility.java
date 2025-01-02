package org.github.valtoni.matrix.facilities;

public class NullPointerFacility {

    private static class ThePoweredClass {
        private String name;
    }

    public static void main(String[] args) {
        // In java 15 the message "Cannot assign field "name" because "poweredClass" is null" is show! Wow!
        ThePoweredClass poweredClass = null;
        try {
            poweredClass.name = "5";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
