package main.java.com.skypay.hotel.models;
import java.time.LocalDate;

public class Booking {

    private int userId;
    private int roomNumber;
    private RoomType roomType;
    private int pricePerNight;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int totalPrice;

    public Booking(int userId, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.userId = userId;
        this.roomNumber = room.getRoomNumber();
        this.roomType = room.getType();
        this.pricePerNight = room.getPricePerNight();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice =
                (int) (checkOut.toEpochDay() - checkIn.toEpochDay()) * pricePerNight;
    }

    public boolean overlaps(LocalDate start, LocalDate end) {
        return !(end.isEqual(checkIn) || end.isBefore(checkIn)
                || start.isEqual(checkOut) || start.isAfter(checkOut));
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Booking{user=" + userId +
                ", room=" + roomNumber +
                ", type=" + roomType +
                ", price/night=" + pricePerNight +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", total=" + totalPrice + "}";
    }
}

