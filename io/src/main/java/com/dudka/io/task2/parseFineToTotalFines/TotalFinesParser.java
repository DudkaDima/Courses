package com.dudka.io.task2.parseFineToTotalFines;

import ch.lambdaj.Lambda;
import com.dudka.io.task2.calculateFineAmountByType.CalculateFine;
import com.dudka.io.task2.entity.Fine;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TotalFinesParser {

    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#.00");

    public static List<CalculateFine> calculateFines(List<Fine> fines) {
        List<CalculateFine> calculateFines = new ArrayList<>();
        List<String> typeOfFines = Lambda.extract(fines, Lambda.on(Fine.class).getType()).stream().distinct().collect(Collectors.toList());

        for (String typeOfFine : typeOfFines) {
            double sumOfFines = 0.00;
            for (Fine fine : fines) {
                if (fine.getType().equals(typeOfFine)) {
                    sumOfFines += fine.getFineAmount();
                }
            }
            calculateFines.add(new CalculateFine(Double.valueOf(NUMBER_FORMAT.format(sumOfFines)), typeOfFine));
        }
        return calculateFines.stream().sorted(Comparator.comparing(CalculateFine::getFullFineAmount).reversed()).collect(Collectors.toList());
    }
}
