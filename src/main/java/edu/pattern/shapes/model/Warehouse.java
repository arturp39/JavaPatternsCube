package edu.pattern.shapes.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger(Warehouse.class);
    private static final Warehouse instance = new Warehouse();
    private final HashMap<Integer, List<Double>> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public List<Double> get(Integer key) {
        return map.get(key);
    }

    public Double calculatePerimeter(Integer key) {
        return map.get(key).get(0);
    }

    public List<Double> put(Integer key, Double perimeter, Double area) {
        List<Double> parameters = new ArrayList<>();
        parameters.add(perimeter);
        parameters.add(area);
        List<Double> result = map.put(key, parameters);
        logger.info("Stored rectangle with key {}: perimeter={}, area={}", key, perimeter, area);
        return result;
    }

    public List<Double> put(Integer key, List<Double> parameters) {
        List<Double> result = map.put(key, parameters);
        logger.info("Stored rectangle with key {}: parameters={}", key, parameters);
        return result;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "map=" + map +
                '}';
    }
}
