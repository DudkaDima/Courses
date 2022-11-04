package com.dudka.courses.shapes;

import com.dudka.courses.Shape;

public class Cube implements Shape {
    private final double edgeLength;

    public Cube(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    public double volume() {
       return (int) Math.pow(edgeLength, 3);
    }

    public String toString() {
        return "Cube{" +
                "volume=" + volume() +
                '}';
    }
}
