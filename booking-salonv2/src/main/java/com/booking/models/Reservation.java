package com.booking.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    private String reservationId;
    private Customer customer;
    private Employee employee;
    private List<Service> services;
    private double reservationPrice;
    private String workstage;
    //   workStage (In Process, Finish, Canceled)

    public Reservation(String reservationId, Customer customer, Employee employee, List<Service> services,
            String workstage) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.employee = employee;
        this.services = services;
        this.reservationPrice = calculateReservationPrice();
        this.workstage = workstage;
    };

    private double calculateReservationPrice(){
        double discSilver = 0.05;
        double discGold = 0.10;
        double price = 0;

        for (Service service : services) {
            price += service.getPrice();
        }

        if (customer.getMember().getMembershipName().equalsIgnoreCase("silver")) {
             return price - (price * discSilver);
        } else if(customer.getMember().getMembershipName().equalsIgnoreCase("gold")){
            return price - (price * discGold);
        }
        return price;
    }
}
