package com.dudka.courses.shapes.sortShapes;

import com.dudka.courses.shapes.Shape;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortShapes {
    public static List<Shape> sortFiguresByVolume(List<Shape> shapes) {
        return shapes.stream().sorted(Comparator.comparing(Shape::getVolume)).collect(Collectors.toList());
    }
}
