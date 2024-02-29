package com.booking.service;

import java.util.List;

import com.booking.models.Person;
import com.booking.models.Service;

import lombok.Getter;

public class ValidationService {
    // Buatlah function sesuai dengan kebutuhan
    @Getter
    private static String regexWord = "^[a-zA-Z ]+$";
    @Getter
    private static String regexAngka = "^[0-9]+$";
    @Getter
    private static String regexId = "^[a-zA-Z0-9_-]+";

    public static String validateInput(String question, String errorMessage, String regex) {
        String result;
        boolean isLooping = true;

        do {
            System.out.println(question);
            result = InputService.inputUser();
            if (result.matches(regex)) {
                isLooping = false;
            } else {
                System.out.println(errorMessage);
            }
        } while (isLooping);

        return result;
    }

    public static int validateInputNumberWithRange(String question, String errorMessage, String regex, int min,
            int max) {
        int result;
        boolean isLooping = true;

        do {
            result = Integer.valueOf(ValidationService.validateInput(question, errorMessage, regex));
            if (result >= min && result <= max) {
                isLooping = false;
            } else {
                System.out.println("Input Number With Range " + min + " to " + max);
            }
        } while (isLooping);

        return result;
    }

    public static boolean validateListId(String idInput, List<String> listId){

        for (String id : listId) {
            if (id.equals(idInput)) {
                return true;
            } 
        }
        return false;
    }

    public static String validatePersonId(String typeId, String question, String errorMessage, String regex, List<Person> personList) {
        String result;
        boolean isLooping = true;

        do {
            result = validateInput(question, errorMessage, regex);
            
                if (validateListId(result, ReservationService.getListPersonId(typeId,personList))) {
                     isLooping = false;
                     System.out.println("Ketemu");
                } else{
                    System.out.println(typeId + " ID " + errorMessage);
                }
            
        } while (isLooping);

        return result;
    }

    public static String validateServiceId(String question, String errorMessage, String regex, List<Service> serviceList){
        String result;
        boolean isLooping = true;

        do {
            result = validateInput(question, errorMessage, regex);
            if (validateListId(result, ReservationService.getListServiceId(serviceList))) {
                isLooping = false;
                System.out.println("Ketemu");
            } else {
                System.out.println(errorMessage);
            }
        } while (isLooping);



        return result;
    }

    // public static boolean validateMaxServiceList(List<Service> serviceList){

    // }

    
}
