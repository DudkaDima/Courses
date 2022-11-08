package com.dudka.courses.shapes.shapesImpl;

import com.dudka.courses.shapes.Shape;

import java.util.Objects;

public class Pyramid implements Shape {

    protected final double baseArea;
    protected final double height;


    public Pyramid(double baseArea, double height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return  (baseArea * height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pyramid)) return false;
        Pyramid pyramid = (Pyramid) o;
        return Double.compare(pyramid.baseArea, baseArea) == 0 && Double.compare(pyramid.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseArea, height);
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "volume=" + getVolume() +
                '}';
    }
}
