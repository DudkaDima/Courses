package com.dudka.courses.shapes.shapesImpl;

import com.dudka.courses.shapes.Shape;

import java.util.Objects;

public class Cube implements Shape {
    private final double edgeLength;

    public Cube(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    public double volume() {
       return (int) Math.pow(edgeLength, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.edgeLength, edgeLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeLength);
    }

    public String toString() {
        return "Cube{" +
                "volume=" + volume() +
                '}';
    }
}
