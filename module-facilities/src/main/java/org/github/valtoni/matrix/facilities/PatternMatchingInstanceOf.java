package org.github.valtoni.matrix.facilities;

public class PatternMatchingInstanceOf {

    public static enum PointType { CLASS, RECORD };

    public static class PointClass {

        private final int x;
        private final int y;

        public PointClass(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public record PointRecord(int x, int y) {}

    public static void main(String[] args) {
        Object objRecord = createPoint(PointType.RECORD);
        Object objClass = createPoint(PointType.CLASS);
        if (objRecord instanceof PointRecord point) {
            System.out.format("Record - x: %d, y: %d \n", point.x, point.y);
        }
        if (objClass instanceof PointClass point) {
            System.out.format("Class - x: %d, y: %d \n", point.x, point.y);
        }
    }

    private static Object createPoint(PointType type) {
        if (type == PointType.RECORD) {
            return new PointRecord(1, 2);
        }
        return new PointClass(1, 2);
    }

}
