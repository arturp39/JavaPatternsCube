package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Rectangle;
import java.util.List;

public interface RectangleFactory {
    List<Rectangle> createRectangles(String file);
}
