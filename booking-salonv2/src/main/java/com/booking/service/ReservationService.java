package com.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class ReservationService {

    private static int num = 1;

    private static String crateId(int num) {
        if (num < 10) {
            return "00" + num;
        } else {
            return "0" + num;
        }
    }

    public static Reservation createReservation(String customerid, String employeeId, List<Person> personList,
            List<Service> serviceList) {
        Customer customer = getCustomerByCustomerId(customerid, personList);
        Employee employee = getEmployeeByEmployeeId(employeeId, personList);
        List<Service> dataServiceList = InputService.inputDataServiceList(serviceList);

        double resvCost;
        Reservation reservation = new Reservation("Resv-" + crateId(num), customer, employee, dataServiceList,
                "In Process");

        resvCost = customer.getWallet() - reservation.getReservationPrice();
        customer.setWallet(resvCost);
        
        num++;

        return reservation;
    }

    

    public static Customer getCustomerByCustomerId(String customerId, List<Person> personList) {
        Customer customer = new Customer();

        for (Person person : personList) {
            if (person instanceof Customer) {
                if (((Customer) person).getId().equals(customerId)) {
                    customer = ((Customer) person);
                }
            }
        }

        return customer;
    }

    public static Employee getEmployeeByEmployeeId(String employeeId, List<Person> personList) {
        Employee employee = new Employee();

        for (Person person : personList) {
            if (person instanceof Employee) {
                if (((Employee) person).getId().equals(employeeId)) {
                    employee = ((Employee) person);
                }
            }
        }

        return employee;
    }

    public static Service getServiceByServiceId(String serviceId, List<Service> serviceList) {
        Service service = new Service();

        for (Service services : serviceList) {
            if (services.getServiceId().equals(serviceId)) {
                service = services;
            }
        }

        return service;
    }

    public static List<String> getListPersonId(String type, List<Person> personList) {
        List<String> result = new ArrayList<>();

        for (Person person : personList) {
            if (type.equalsIgnoreCase("customer")) {
                if (person instanceof Customer) {
                    result.add(((Customer) person).getId());
                }
            } else if (type.equalsIgnoreCase("employee")) {
                if (person instanceof Employee) {
                    result.add(((Employee) person).getId());
                }
            }
        }

        return result;
    }

    public static List<String> getListServiceId(List<Service> serviceList){
        List<String> result = new ArrayList<>();

        for (Service service : serviceList) {
            result.add(service.getServiceId());
        }

        return result;
    }

    public static void editReservationWorkstage() {

    }

    // Silahkan tambahkan function lain, dan ubah function diatas sesuai kebutuhan
}
