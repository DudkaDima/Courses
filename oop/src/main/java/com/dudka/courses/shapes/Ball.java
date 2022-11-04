package com.dudka.courses.shapes;

import com.dudka.courses.Shape;

public class Ball implements Shape {

    private static double Pi = 3.14;
    private final double radius;

    public Ball(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return radius * Pi * (4.0/3.0);
    }
    public String toString() {
        return "Ball{" +
                "volume=" + volume() +
                '}';
    }

}
