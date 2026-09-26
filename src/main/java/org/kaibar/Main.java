package org.kaibar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, please enter a number (decimal ok, if you enter \",\" it will be changed to \".\"):");

        Scanner scanner = new Scanner(System.in);

        String numberStr = scanner.nextLine();
        String cleanedNumStr = getCleanedNumStr(numberStr);
        Number evaluatedNumber = evaluateNumber(cleanedNumStr);

        doHello(evaluatedNumber);

        System.out.println("Enter the name: ");

        String name = scanner.nextLine();

        if(name.equals("John")) {
            System.out.println("Hello, John");
        } else
            System.out.println("There is no such name");

        boolean isPopulating = true;

        List<Number> numbers = new ArrayList<>();

        System.out.println("Enter numeric values for array, input \"n\" to stop populating");

        while(isPopulating) {
            System.out.println("Enter value: ");
            String input = scanner.nextLine();
            Number number = evaluateNumber(getCleanedNumStr(input));
            numbers.add(number);
            System.out.println("Enter \"n\" to stop inputting numbers, or press anything to continue");
            if(scanner.nextLine().equals("n")) {
                isPopulating = false;
            }
        }

        for(Number n : numbers) {
            if(n instanceof Double) {
                double number = (double) n;
                System.out.println((number*3));
            } else if (n instanceof Long) {
                long number = (long) n;
                System.out.println(number*3);
            }
        }

    }

    private static final Pattern PATTERN_LONG = Pattern.compile("\\d+");
    private static final Pattern PATTERN_DOUBLE = Pattern.compile("\\d+[,.]\\d+");


    private static void doHello(Number evaluatedNumber){
        if(evaluatedNumber instanceof Double) {
            double number = (double) evaluatedNumber;
            if(number > 7) {
                System.out.println("Hello");
            }
        } else if (evaluatedNumber instanceof Long) {
            long number = (long) evaluatedNumber;
            if(number > 7) {
                System.out.println("Hello");
            }
        }
    }

    private static Number evaluateNumber(String cleanedNumStr) {

        Matcher matcherLong = PATTERN_LONG.matcher(cleanedNumStr);
        Matcher matcherDouble = PATTERN_DOUBLE.matcher(cleanedNumStr);

        if(matcherLong.matches()) {
            return Long.parseLong(cleanedNumStr);
        } else if (matcherDouble.matches()) {
            return Double.parseDouble(cleanedNumStr);
        } else {
            throw new IllegalArgumentException("Your input: " + cleanedNumStr + " doesn't match any allowed numeric patterns\nAllowed patterns: 123; 123.123; 123,123");
        }
    }

    private static String getCleanedNumStr(String numberStr) {
        String cleanedNumStr;
        if(!numberStr.isEmpty()) {

            cleanedNumStr = numberStr.trim();
            cleanedNumStr = cleanedNumStr.replace(",", ".");

        } else {
            throw new IllegalArgumentException("Number should not be empty");
        }
        return cleanedNumStr;
    }
}