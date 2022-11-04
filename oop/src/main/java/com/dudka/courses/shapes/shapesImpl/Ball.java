package com.dudka.courses.shapes.shapesImpl;

import com.dudka.courses.shapes.Shape;

import java.util.Objects;

public class Ball implements Shape {

    protected static double PI = 3.14;
    protected final double radius;

    public Ball(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return radius * PI * (4.0/3.0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    public String toString() {
        return "Ball{" +
                "volume=" + volume() +
                '}';
    }
}
