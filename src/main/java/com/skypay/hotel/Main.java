package main.java.com.skypay.hotel;

import main.java.com.skypay.hotel.models.RoomType;
import main.java.com.skypay.hotel.services.Service;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();
    
        service.setRoom(1, RoomType.STANDARD_SUITE, 1000);
        service.setRoom(2, RoomType.JUNIOR_SUITE, 2000);
        service.setRoom(3, RoomType.MASTER_SUITE, 3000);

        service.setUser(1, 5000);
        service.setUser(2, 10000);

        // Not enough balance
        try {
            service.bookRoom(1, 2,
                    LocalDate.of(2026, 6, 30),
                    LocalDate.of(2026, 7, 7));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //  Invalid dates
        try {
            service.bookRoom(1, 2,
                    LocalDate.of(2026, 7, 7),
                    LocalDate.of(2026, 6, 30));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // OK
        service.bookRoom(1, 1,
                LocalDate.of(2026, 7, 7),
                LocalDate.of(2026, 7, 8));

        // Room already booked
        try {
            service.bookRoom(2, 1,
                    LocalDate.of(2026, 7, 7),
                    LocalDate.of(2026, 7, 9));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // OK
        service.bookRoom(2, 3,
                LocalDate.of(2026, 7, 7),
                LocalDate.of(2026, 7, 8));

        service.setRoom(1, RoomType.MASTER_SUITE, 10000);

        service.printAll();
        service.printAllUsers();
    }
}
