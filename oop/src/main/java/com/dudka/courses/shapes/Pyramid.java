package com.dudka.courses.shapes;

import com.dudka.courses.Shape;

public class Pyramid implements Shape {

    private final double baseArea;

    private final double height;


    public Pyramid(double baseArea, double height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    public double volume() {
        return (int) (baseArea * height);
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "volume=" + volume() +
                '}';
    }
}
