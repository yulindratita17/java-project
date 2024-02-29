package com.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class PrintService {
    public static void printMenu(String title, String[] menuArr) {
        int num = 1;
        System.out.println(title);
        for (int i = 0; i < menuArr.length; i++) {
            if (i == (menuArr.length - 1)) {
                num = 0;
            }
            System.out.println(num + ". " + menuArr[i]);
            num++;
        }
    }

    public static List<String> printServices(List<Service> serviceList) {
        List<String> result = new ArrayList<>();
        // Bisa disesuaikan kembali
        for (Service service : serviceList) {
            result.add(service.getServiceName());
        }
        return result;
    }

    // Function yang dibuat hanya sebgai contoh bisa disesuaikan kembali
    public static void showRecentReservation(List<Reservation> reservationList) {
        int num = 1;
        System.out.printf("| %-4s | %-6s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Biaya Service", "Pegawai", "Workstage");
        System.out
                .println("+========================================================================================+");
        for (Reservation reservation : reservationList) {
            if (reservation.getWorkstage().equalsIgnoreCase("Waiting")
                    || reservation.getWorkstage().equalsIgnoreCase("In process")) {
                System.out.printf("| %-4s | %-6s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                        num, reservation.getReservationId(), reservation.getCustomer().getName(),
                        printServices(reservation.getServices()), reservation.getReservationPrice(),
                        reservation.getEmployee().getName(), reservation.getWorkstage());
                num++;
            }
        }
    }

    public static void showBookingRef(List<Reservation> reservationList){
        double result = 0;

        for (Reservation reservation : reservationList) {
            result += reservation.getReservationPrice();
        }

        System.out.println("\nBooking Berhasil\n" + "Total Biaya Booking: Rp. " + result +"\n");
    }


    public static void showAllCustomer(String tittle, List<Person> personList) {
        int num = 1;
        System.out.println("+========================================================================+");
        System.out.printf("| %-70s |\n", tittle);
        System.out.println("+========================================================================+");
        System.out.printf("| %-4s | %-7s | %-11s | %-11s | %-11s | %-11s |\n", "No.", "ID", "Nama ", "Alamat",
                "Membership", "Uang");
        System.out.println("+========================================================================+");

        // iterate data
        for (Person person : personList) {
            if (person instanceof Customer) {
                System.out.printf("| %-4s | %-6s | %-11s | %-11s | %-11s | %-11s |\n", num, ((Customer) person).getId(),
                        ((Customer) person).getName(), ((Customer) person).getAddress(),
                        ((Customer) person).getMember().getMembershipName(), ((Customer) person).getWallet());
                num++;
            }

        }

        System.out.println("+========================================================================+");

    }

    public static void showAllEmployee(String tittle, List<Person> personList) {
        int num = 1;
        System.out.println("+========================================================+");
        System.out.printf("| %-54s |\n", tittle);
        System.out.println("+========================================================+");
        System.out.printf("| %-4s | %-6s | %-11s | %-11s | %-8s | \n", "No.", "ID", "Nama ", "Alamat", "Pengalaman");
        System.out.println("+========================================================+");

        // iterate data
        for (Person person : personList) {
            if (person instanceof Employee) {
                System.out.printf("| %-4s | %-6s | %-11s | %-11s | %-10s |\n", num, ((Employee) person).getId(),
                        ((Employee) person).getName(), ((Employee) person).getAddress(),
                        ((Employee) person).getExperience());
                num++;
            }         
        }
        System.out.println("+========================================================+");
    }

    public void showHistoryReservation() {

    }
}

    
