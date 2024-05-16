package edu.pattern.shapes.model;

import edu.pattern.shapes.observer.Observable;
import edu.pattern.shapes.observer.RectangleObserver;
import edu.pattern.shapes.observer.impl.RectangleObserverImpl;
import edu.pattern.shapes.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rectangle implements Observable {
    private RectangleObserver observer = new RectangleObserverImpl();
    private static final Logger logger = LogManager.getLogger(Rectangle.class);

    private final int id;
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private RectangleState state;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.id = IdGenerator.increment();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.state = RectangleState.detect(new Point[]{p1, p2, p3, p4});
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
        updateState();
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        updateState();
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
        updateState();
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
        updateState();
    }

    private void updateState() {
        this.state = RectangleState.detect(new Point[]{p1, p2, p3, p4});
        notifyObservers();
    }

    @Override
    public void attach() {
        observer = new RectangleObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "id=" + id +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return id == rectangle.id &&
                p1.equals(rectangle.p1) &&
                p2.equals(rectangle.p2) &&
                p3.equals(rectangle.p3) &&
                p4.equals(rectangle.p4) &&
                state == rectangle.state;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + p1.hashCode();
        result = 31 * result + p2.hashCode();
        result = 31 * result + p3.hashCode();
        result = 31 * result + p4.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }

}
