package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;
import com.booking.repositories.ServiceRepository;



public class MenuService {
    private static List<Person> personList = PersonRepository.getAllPerson();
    private static List<Service> serviceList = ServiceRepository.getAllService();
    private static List<Reservation> reservationList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        String[] mainMenuArr = {"Show Data", "Create Reservation", "Complete/cancel reservation", "Exit"};
        String[] subMenuArr = {"Recent Reservation", "Show Customer", "Show Available Employee", "Back to main menu"};
    
        int optionMainMenu;
        int optionSubMenu;

		boolean backToMainMenu = true;
        boolean backToSubMenu = true;
        do {
            PrintService.printMenu("Main Menu", mainMenuArr);
            optionMainMenu = ValidationService.validateInputNumberWithRange("Choose menu: ", "Input only number ", ValidationService.getRegexAngka(), 0, 3);
            switch (optionMainMenu) {
                case 1:
                    do {
                        PrintService.printMenu("Show Data", subMenuArr);
                        optionSubMenu = ValidationService.validateInputNumberWithRange("Choose menu: ", "Input only number ", ValidationService.getRegexAngka(), 0, 4);
                        // Sub menu - menu 1
                        switch (optionSubMenu) {
                            case 1:
                                // panggil fitur tampilkan recent reservation
                                PrintService.showRecentReservation(reservationList);
                                break;
                            case 2:
                                // panggil fitur tampilkan semua customer
                                PrintService.showAllCustomer("Data Customer", personList);
                                break;
                            case 3:
                                // panggil fitur tampilkan semua employee
                                PrintService.showAllEmployee("Data Employee", personList);
                                break;
                            case 4:
                                // panggil fitur tampilkan history reservation + total keuntungan
                                break;
                            case 0:
                                backToSubMenu = false;
                        }
                    } while (backToSubMenu);
                    break;
                case 2:
                    // panggil fitur menambahkan reservation
                    
                    reservationList.add(ReservationService.createReservation(InputService.inputPersonId("customer", personList), InputService.inputPersonId("employee", personList),personList, serviceList));
                    PrintService.showBookingRef(reservationList);
                    
                    
                    break;
                case 3:
                    // panggil fitur mengubah workstage menjadi finish/cancel
                    break;
                case 0:
                    backToMainMenu = false;
                    break;
            }
        } while (backToMainMenu);
		
	}
}
