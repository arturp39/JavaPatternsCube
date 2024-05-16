package edu.pattern.shapes.reader;

import edu.pattern.shapes.exception.RectangleException;
import edu.pattern.shapes.model.Point;
import java.util.List;

public interface RectangleFileReader {
    List<Point[]> parseRectangleParameters(String file) throws RectangleException;
}
