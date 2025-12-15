package main.java.com.skypay.hotel.models;

public class Room {
    private int roomNumber;
    private RoomType type;
    private int pricePerNight;

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void update(RoomType type, int pricePerNight) {
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{number=" + roomNumber +
                ", type=" + type +
                ", price/night=" + pricePerNight + "}";
    }
}
