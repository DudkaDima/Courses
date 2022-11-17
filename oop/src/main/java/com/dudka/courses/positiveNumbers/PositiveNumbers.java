package com.dudka.courses.positiveNumbers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static List<Integer> findPositiveNumbers(List<Integer> numbers) {
        if(numbers == null ) {
            throw new NullPointerException("List of numbers is null");
        } else if(numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty");
        } else
            return numbers.stream()
                    .filter(e -> e >= 0)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }

    }
