package edu.pattern.shapes.service.impl;

import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.model.Rectangle;
import edu.pattern.shapes.service.RectangleService;
import static edu.pattern.shapes.util.GeometryUtils.distance;
import static edu.pattern.shapes.util.GeometryUtils.isOnSameAxis;


public class RectangleServiceImpl implements RectangleService {
    @Override
    public double calculatePerimeter(Rectangle rectangle) {
        Point[] points = {rectangle.getP1(), rectangle.getP2(), rectangle.getP3(), rectangle.getP4()};
        double side1 = 0;
        double side2 = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (isOnSameAxis(points[i], points[j])) {
                    double distance = distance(points[i], points[j]);
                    if (side1 == 0) {
                        side1 = distance;
                    } else if (side1 != distance) {
                        side2 = distance;
                    }
                }
            }
        }
        return (side1 + side2) * 2;
    }

}
