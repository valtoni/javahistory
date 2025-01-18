package org.github.valtoni.matrix.facilities;

public class ColoredPointMain {

    record Point(int x, int y) {}

    enum Color { RED, GREEN, BLUE }

    enum PolygonType { RECTANGLE, TRIANGLE, NONE }

    record ColoredPoint(Point p, Color c) {}

    interface Polygon {}

    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) implements Polygon {}

    record Triangle(ColoredPoint firstPoint, ColoredPoint secondPoint, ColoredPoint thirdPoint) implements Polygon {}


    public static void main(String[] args) {
        var polygon = createPolygon(PolygonType.RECTANGLE, Color.RED);
        if (polygon instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.printf("RECTANGLE Color ul: %s, color lr: %s\n", ul.c, lr.c);
        }
        polygon = createPolygon(PolygonType.TRIANGLE, Color.GREEN);
        if (polygon instanceof Triangle(ColoredPoint cp1, ColoredPoint cp2, ColoredPoint cp3)) {
            System.out.printf("TRIANGLE Color cp1: %s, color cp2: %s, color cp3: %s\n", cp1.c, cp2.c, cp3.c);
        }
    }

    private static Polygon createUnpredictablePolygon() {
        return new Polygon() {
        };
    }

    private static Polygon createPolygon(PolygonType polygonType, Color color) {
        return switch (polygonType) {
            case TRIANGLE -> switch (color) {
                case RED -> createRedTriangle();
                case GREEN -> createGreenTriangle();
                case BLUE -> createBlueTriangle();
            };
            case RECTANGLE -> switch (color) {
                    case RED -> createRedRectangle();
                    case GREEN -> createGreenRectangle();
                    case BLUE -> createBlueRectangle();
            };
            default -> createUnpredictablePolygon();
        };
    }

    private static Rectangle createBlueRectangle() {
        return createRectangle(4, 3, 2, 1, Color.BLUE);
    }

    private static Rectangle createGreenRectangle() {
        return createRectangle(3, 1, 4, 2, Color.GREEN);
    }

    private static Rectangle createRedRectangle() {
        return createRectangle(1, 2, 2, 1, Color.RED);
    }

    private static Rectangle createRectangle(int x1, int y1, int x2, int y2, Color color) {
        return new Rectangle(new ColoredPoint(new Point(x1, y1), color), new ColoredPoint(new Point(x2, y2), color));
    }

    private static Triangle createBlueTriangle() {
        return createTriangle(4, 3, 2, 1, 4, 2, Color.BLUE);
    }

    private static Triangle createGreenTriangle() {
        return createTriangle(3, 1, 4, 2, 1, 2, Color.GREEN);
    }

    private static Triangle createRedTriangle() {
        return createTriangle(1, 2, 2, 1, 0, 4, Color.RED);
    }

    private static Triangle createTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        return new Triangle(new ColoredPoint(new Point(x1, y1), color), new ColoredPoint(new Point(x2, y2), color), new ColoredPoint(new Point(x3, y3), color));
    }

}
