package main.java.com.skypay.hotel.services;



import java.time.LocalDate;
import java.util.ArrayList;

import main.java.com.skypay.hotel.models.Booking;
import main.java.com.skypay.hotel.models.Room;
import main.java.com.skypay.hotel.models.RoomType;
import main.java.com.skypay.hotel.models.User;

public class Service {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType type, int price) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.update(type, price);
                return;
            }
        }
        rooms.add(new Room(roomNumber, type, price));
    }

    public void setUser(int userId, int balance) {
        for (User user : users) {
            if (user.getId() == userId) {
                return;
            }
        }
        users.add(new User(userId, balance));
    }

    public void bookRoom(int userId, int roomNumber,
                         LocalDate checkIn, LocalDate checkOut) {

        if (!checkIn.isBefore(checkOut)) {
            throw new IllegalArgumentException("Invalid booking dates");
        }

        User user = users.stream()
                .filter(u -> u.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Room room = rooms.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        for (Booking booking : bookings) {
            if (booking.getRoomNumber() == roomNumber &&
                    booking.overlaps(checkIn, checkOut)) {
                throw new IllegalStateException("Room already booked");
            }
        }

        int nights = (int) (checkOut.toEpochDay() - checkIn.toEpochDay());
        int totalPrice = nights * room.getPricePerNight();

        user.debit(totalPrice);
        bookings.add(new Booking(userId, room, checkIn, checkOut));
    }

    public void printAll() {
        System.out.println("=== ROOMS ===");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            System.out.println(rooms.get(i));
        }

        System.out.println("=== BOOKINGS ===");
        for (int i = bookings.size() - 1; i >= 0; i--) {
            System.out.println(bookings.get(i));
        }
    }

    public void printAllUsers() {
        System.out.println("=== USERS ===");
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i));
        }
    }
}

