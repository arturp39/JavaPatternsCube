package edu.pattern.shapes.validator.impl;

import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.validator.RectangleDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleDataValidatorImpl implements RectangleDataValidator {
    private static final Logger logger = LogManager.getLogger(RectangleDataValidatorImpl.class);

    @Override
    public boolean isValid(String[] parts) {
        if (parts == null || parts.length != 4) {
            logger.warn("Invalid parts length: expected 4, got {}", parts == null ? 0 : parts.length);
            return false;
        }
        for (String part : parts) {
            String[] coordinates = part.split(",");
            if (coordinates.length != 2) {
                logger.warn("Invalid coordinate format in part: {}", part);
                return false;
            }
            try {
                Double.parseDouble(coordinates[0].trim());
                Double.parseDouble(coordinates[1].trim());
            } catch (NumberFormatException e) {
                logger.warn("Invalid number format in coordinates: {}", part, e);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Point[] points) {
        boolean valid = points != null && points.length == 4;
        if (!valid) {
            logger.warn("Invalid points array: expected 4 points, got {}", points == null ? 0 : points.length);
        }
        return valid;
    }
}
