package edu.pattern.shapes.util;

import edu.pattern.shapes.model.Point;

public class GeometryUtils {

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public static boolean isOnSameAxis(Point p1, Point p2) {
        return p1.getX() == p2.getX() || p1.getY() == p2.getY();
    }
}
