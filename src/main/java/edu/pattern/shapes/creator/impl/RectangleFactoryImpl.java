package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.RectangleFactory;
import edu.pattern.shapes.exception.RectangleException;
import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.model.Rectangle;
import edu.pattern.shapes.reader.RectangleFileReader;
import edu.pattern.shapes.reader.impl.RectangleFileReaderImpl;
import edu.pattern.shapes.validator.RectangleDataValidator;
import edu.pattern.shapes.validator.impl.RectangleDataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RectangleFactoryImpl implements RectangleFactory {
    private static final Logger logger = LogManager.getLogger(RectangleFactoryImpl.class);

    @Override
    public List<Rectangle> createRectangles(String file) {
        RectangleDataValidator dataValidator = new RectangleDataValidatorImpl();
        List<Point[]> parameters;

        try {
            RectangleFileReader reader = new RectangleFileReaderImpl();
            parameters = reader.parseRectangleParameters(file);
        } catch (RectangleException e) {
            logger.error("Failed to parse rectangle parameters from file: {}", file, e);
            throw new RuntimeException(e);
        }

        List<Rectangle> newRectangles = new ArrayList<>();
        for (Point[] points : parameters) {
            if (dataValidator.isValid(points)) {
                Rectangle rectangle = new Rectangle(points[0], points[1], points[2], points[3]);
                newRectangles.add(rectangle);
                logger.info("Created rectangle: {}", rectangle);
            } else {
                logger.warn("Invalid rectangle points: {}", (Object) points);
            }
        }

        logger.info("Total rectangles created: {}", newRectangles.size());
        return newRectangles;
    }
}
