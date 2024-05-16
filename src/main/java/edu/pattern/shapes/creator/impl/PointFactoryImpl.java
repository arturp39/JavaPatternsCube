package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.PointFactory;
import edu.pattern.shapes.model.Point;


public class PointFactoryImpl implements PointFactory {

    @Override
    public Point createPoint(String coordinates) {
        String[] parts = coordinates.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid point coordinates: " + coordinates);
        }
        double x = Double.parseDouble(parts[0].trim());
        double y = Double.parseDouble(parts[1].trim());
        return new Point(x, y);
    }


}
