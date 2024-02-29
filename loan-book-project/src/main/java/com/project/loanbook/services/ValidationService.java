package com.project.loanbook.services;

import java.util.Scanner;

public class ValidationService {
    public static Scanner in = new Scanner(System.in);
    public static String regexNumber = "^[0-9]+$";
    public static String regexWord = "^[a-zA-Z ]";
    public static String regexId = "^[a-zA-Z0-9_-]+$";

    public static String validateInput(String question, String errorMessage, String regex) {
        String result = "";
        boolean isLooping = true;

        do {
            System.out.println(question);
            result = in.nextLine();
            if (result.matches(regex)) {
                isLooping = false;
            } else {
                System.out.println(errorMessage);
            }
        } while (isLooping);

        return result;
    }

    public static int validateNumberWithRange(String question, String errorMessage, String regex, int min, int max){
        int result = 0;
        boolean isLooping = true;

        do {
            result = Integer.valueOf(validateInput(question, errorMessage, regex));
            if (result >= min && result <= max) {
                isLooping = false;
            } else {System.out.println(errorMessage);
                System.out.println("Only enter number beetwen " + min + " and " + max);
            }
        } while (isLooping);

        return result;
    }
}
