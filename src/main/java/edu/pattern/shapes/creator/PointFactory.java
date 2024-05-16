package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Point;


public interface PointFactory {
    Point createPoint(String coordinates);
}
