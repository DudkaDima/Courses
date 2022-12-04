package com.dudka.io.task2.parseFineToTotalFines;

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
        List<String> finesType = fines.stream().map(Fine::getType).distinct().collect(Collectors.toList());
        for (String typeOfFine : finesType) {
            double finesSum = 0.00;
            for (Fine fine : fines) {
                if (fine.getType().equals(typeOfFine)) {
                    finesSum += fine.getFineAmount();
                }
            }
            calculateFines.add(new CalculateFine(Double.valueOf(NUMBER_FORMAT.format(finesSum)), typeOfFine));
        }
        return calculateFines.stream().sorted(Comparator.comparing(CalculateFine::getFullFineAmount).reversed()).collect(Collectors.toList());
    }
}
