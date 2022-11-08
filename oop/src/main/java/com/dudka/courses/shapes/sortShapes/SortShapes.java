package com.dudka.courses.shapes.sortShapes;
import com.dudka.courses.shapes.Shape;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortShapes {
    public static List<Shape> sortFiguresByVolume(List<Shape> shapes) {
        if(shapes == null) {
            throw new NullPointerException("List of shapes is null");
        } else if(shapes.isEmpty()) {
            throw new IllegalArgumentException("List of shapes if empty");
        } else
            return shapes.stream().sorted(Comparator.comparing(Shape::getVolume)).collect(Collectors.toList());

    }
}
