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

    // get the room number
    public int getRoomNumber() {
        return roomNumber;
    }

    // get the room type
    public RoomType getType() {
        return type;
    }

    // get the price per night
    public int getPricePerNight() {
        return pricePerNight;
    }

    // update the room type and price per night
    public void update(RoomType type, int pricePerNight) {
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    // print a room with the room number, type and price per night
    @Override
    public String toString() {
        return "Room{number=" + roomNumber +
                ", type=" + type +
                ", price/night=" + pricePerNight + "}";
    }
}
