package edu.pattern.shapes.main;


import edu.pattern.shapes.creator.RectangleFactory;
import edu.pattern.shapes.creator.impl.RectangleFactoryImpl;
import edu.pattern.shapes.model.Point;
import edu.pattern.shapes.model.Rectangle;
import edu.pattern.shapes.model.Warehouse;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        RectangleFactory factory = new RectangleFactoryImpl();
        List<Rectangle> result = factory.createRectangles("src/main/resources/rectangles.txt");
        System.out.println(result);
        Warehouse warehouse = Warehouse.getInstance();
        System.out.println(warehouse);
        Rectangle ob = result.get(0);
        ob.setP1(new Point(1,3));
        System.out.println(warehouse);
        ob.setP2(new Point(3,1));
        System.out.println(warehouse);
    }
}