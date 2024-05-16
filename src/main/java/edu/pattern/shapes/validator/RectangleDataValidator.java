package edu.pattern.shapes.validator;

import edu.pattern.shapes.model.Point;

public interface RectangleDataValidator {
    boolean isValid(String[] data); // Existing method
    boolean isValid(Point[] points); // New method for validating Point objects
}
