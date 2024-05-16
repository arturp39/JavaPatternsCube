package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Rectangle;
import edu.pattern.shapes.observer.RectangleObserver;

public class RectangleObserverImpl implements RectangleObserver {

    @Override
    public void update(Rectangle rectangle) {
        System.out.println("Rectangle updated: " + rectangle);
    }
}
