package edu.pattern.shapes.model;

import edu.pattern.shapes.util.GeometryUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum RectangleState {
    INVALID,
    REGULAR,
    SQUARE;

    public static RectangleState detect(Point[] points) {
        if (points == null || points.length != 4) {
            return RectangleState.INVALID;
        }

        for (Point point : points) {
            if (point == null) {
                return RectangleState.INVALID;
            }
        }

        Set<Point> uniquePoints = new HashSet<>(Arrays.asList(points));
        if (uniquePoints.size() != 4) {
            return RectangleState.INVALID;
        }

        double[] distances = new double[6];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distances[index++] = GeometryUtils.distance(points[i], points[j]);
            }
        }

        Arrays.sort(distances);
        double side1 = distances[0];
        double side2 = distances[2];
        double diagonal = distances[5];

        if (Math.abs(diagonal - Math.sqrt(side1 * side1 + side2 * side2)) < 1e-6) {
            if (Math.abs(side1 - side2) < 1e-6) {
                return RectangleState.SQUARE;
            } else {
                return RectangleState.REGULAR;
            }
        }

        return RectangleState.INVALID;
    }
}
