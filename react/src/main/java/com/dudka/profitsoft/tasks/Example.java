package com.dudka.profitsoft.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Example {


    public static List<String> buildExamples(Integer count) {

        List<String> tasks = new ArrayList<>();
        Random random = new Random();
        int firstNumber;
        int secondNumber;
        String sign;

        List<String> signs = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

        for(int i = 0; i < count; i++) {
            firstNumber = random.nextInt(((100) ) + 2);
            secondNumber = random.nextInt(((100) ) + 2);
            sign = signs.get(random.nextInt((3) +1));
            if(firstNumber < secondNumber && sign.equals("-") || firstNumber < secondNumber && sign.equals("/")) {
                count++;
                continue;
            } else tasks.add(firstNumber + sign + secondNumber);

        }
        return tasks;
    }

}
