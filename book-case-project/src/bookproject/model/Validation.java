package bookproject.model;

import java.util.Scanner;

public class Validation {

    public static String regexNumber = "^[0-9]+$";
    public static String regexWord = "^[a-zA-Z ]+$";
    public static Scanner in = new Scanner(System.in);

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

    public static int validateNumberWithRange(String question, String errorMessage, String regex, int min, int max) {
        int result = 0;
        boolean isLooping = true;

        do {
            result = Integer.valueOf(validateInput(question, errorMessage, regex));
            if (result >= min && result <= max) {
                isLooping = false;
            } else {
                System.out.println("Only accept number from " + min + " to " + max);
            }

        } while (isLooping);

        return result;
    }
}
