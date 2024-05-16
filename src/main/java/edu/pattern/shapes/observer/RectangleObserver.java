package edu.pattern.shapes.observer;

import edu.pattern.shapes.model.Rectangle;

public interface RectangleObserver {
    void update(Rectangle rectangle);
}
