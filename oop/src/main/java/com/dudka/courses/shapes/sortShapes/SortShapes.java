package com.dudka.courses.shapes.sortShapes;

import com.dudka.courses.shapes.Shape;

import java.util.Collections;
import java.util.List;

public class SortShapes {
    public static List<Shape> sortFiguresByVolume(List<Shape> shapes) {
        for(int i = 0; i < shapes.size(); i++) {
            for(int j = 1; j < shapes.size(); j++) {
                if(shapes.get(j-1).volume() > shapes.get(j).volume()) {
                    Collections.swap(shapes, j-1, j);
                }
            }
        }
        return shapes;
    }
}
