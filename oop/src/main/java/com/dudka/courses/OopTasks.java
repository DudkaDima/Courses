package com.dudka.courses;

import com.dudka.courses.shapes.Cube;
import com.dudka.courses.shapes.Pyramid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OopTasks {
    public static List<Integer> findPositiveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(e -> e >= 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static LinkedHashMap<String, Integer> findMostPopularHashtag(List<String> tags) {
        Map<String, Integer> tagsAndCount = new HashMap<>();
        for(int i = 0; i < tags.size(); i++) {
            int count = 0;
            tags.set(i, Stream.of(tags.get(i).split("#"))
                    .distinct()
                    .collect(Collectors
                            .joining("#")));

            for(int j = 0; j < tags.size(); j++) {
                if(tags.get(i).contains(tags.get(j))) {
                    count++;
                }
                tagsAndCount.put(tags.get(i), count);
            }
        }
        return tagsAndCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public static List<Shape> sortShapesByVolume(List<Shape> shapes) {
        for(int i = 0; i < shapes.size(); i++) {
            for(int j = 1; j < (shapes.size() - 1); j++) {
                if(shapes.get(j-1).volume() > shapes.get(j).volume()) {
                    Collections.swap(shapes, j-1, j);
                }
            }
        }
       return shapes;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(11);
        numbers.add(-3);
        numbers.add(-1);
        numbers.add(3);
        numbers.add(2);

        System.out.println(numbers);

        numbers = findPositiveNumbers(numbers);

        System.out.println(numbers);


        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Cube(3));
        shapes.add(new Pyramid(2, 3));
        shapes.add(new Cube(5));



        System.out.println(Arrays.toString(shapes.toArray()));
        Shape tmp;


        System.out.println(sortShapesByVolume(shapes));

        List<String> s= new ArrayList<>();
        s.add("#Hui#Hui");
        s.add("#Hui");
        s.add("#Pizda");
        s.add("#Pizda");
        s.add("#Jopa");
        s.add("#Hui");
        s.add("#Hui");
        s.add("#Pss");
        s.add("#Pss");
        s.add("#Pss");
        s.add("#Pss");
        s.add("#Pss");
        s.add("#Pss");
        s.add("#Pss#Pss");
        s.add("#Pss");
        s.add("#Clouse");
        s.add("#Clouse");
        s.add("#Clouse");
        s.add("#Clouse");
        s.add("#Clouse");


        String a = "#Hui";
        String aa = "#Hui#Hui";

        System.out.println(findMostPopularHashtag(s));


    }
}
