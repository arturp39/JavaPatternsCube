package edu.pattern.shapes.reader.impl;

import edu.pattern.shapes.exception.RectangleException;
import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.reader.RectangleFileReader;
import edu.pattern.shapes.validator.RectangleDataValidator;
import edu.pattern.shapes.validator.impl.RectangleDataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RectangleFileReaderImpl implements RectangleFileReader {
    private static final Logger logger = LogManager.getLogger(RectangleFileReaderImpl.class);
    private final RectangleDataValidator dataValidator = new RectangleDataValidatorImpl();

    @Override
    public List<Point[]> parseRectangleParameters(String file) throws RectangleException {
        List<Point[]> rectangles = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length != 4 || !dataValidator.isValid(parts)) {
                    logger.warn("Invalid line: {}", line);
                    continue;
                }
                try {
                    Point p1 = parsePoint(parts[0]);
                    Point p2 = parsePoint(parts[1]);
                    Point p3 = parsePoint(parts[2]);
                    Point p4 = parsePoint(parts[3]);
                    rectangles.add(new Point[]{p1, p2, p3, p4});
                } catch (NumberFormatException e) {
                    logger.warn("Invalid number format in line: {}", line, e);
                }
            }
        } catch (IOException e) {
            logger.error("Failed to parse rectangle from file", e);
            throw new RectangleException("Failed to parse rectangle from file", e);
        }
        return rectangles;
    }

    private Point parsePoint(String part) {
        String[] coordinates = part.split(",");
        if (coordinates.length != 2) {
            logger.error("Invalid coordinate format: {}", part);
            return null;
        }
        try {
            return new Point(Double.parseDouble(coordinates[0].trim()), Double.parseDouble(coordinates[1].trim()));
        } catch (NumberFormatException e) {
            logger.error("Invalid number format: {}", part, e);
            return null;
        }
    }
}
