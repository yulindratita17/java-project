package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class InputService {
    private static Scanner in = new Scanner(System.in);

    public static String inputUser() {
        String id = in.nextLine();

        return id;
    }

    public static String inputPersonId(String typeId, List<Person> personList) {
        String personId = "";

        if (typeId.equalsIgnoreCase("customer")) {
            personId = ValidationService.validatePersonId("Customer", "Masukkan Customer Id: ",
                    "yang Dicari Tidak Tersedia!!", ValidationService.getRegexId(), personList);
        } else if (typeId.equalsIgnoreCase("employee")) {
            personId = ValidationService.validatePersonId("Employee", "Masukkan Employee Id: ",
                    "yang Dicari Tidak Tersedia!!", ValidationService.getRegexId(), personList);
        }

        return personId;
    }

    public static String inputServiceId(List<Service> serviceList) {
        String serviceId;

        serviceId = ValidationService.validateServiceId("Masukkan Service Id: ",
                "Service ID yang Dicari Tidak Ditemukan", ValidationService.getRegexId(), serviceList);

        return serviceId;

    }

    public static List<Service> inputDataServiceList(List<Service> serviceList) {
        List<Service> result = new ArrayList<>();

        boolean isLooping = true;
        String serviceId;

        do {
            serviceId = inputServiceId(serviceList);
            // validate service is choosen
            if (result.contains(ReservationService.getServiceByServiceId(serviceId, serviceList))) {
                System.out.println("Servis sudah dipilih");
            } else {
                // add object service to list
                result.add(ReservationService.getServiceByServiceId(serviceId, serviceList));
                // validate all service selected
                if ((result.size() == serviceList.size())) {
                    isLooping = false;
                    break;
                } else {
                    String reInputService = ValidationService.validateInput("Ingin Pilih Service yang Lain? (Y/T)",
                            "Hanya menerima inputan Y atau T", "^[yYtT]+$");
                    if (reInputService.equalsIgnoreCase("t")) {
                        isLooping = false;
                    }
                }

            }

        } while (isLooping);

        return result;
    }

}
