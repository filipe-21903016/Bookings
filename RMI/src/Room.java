public class Room {
    private int id;
    private int floor;
    private String bookingId;

    public Room(int id, int floor, String bookingId){
        this.id = id;
        this.floor = floor;
        this.bookingId = bookingId;
    }

    public int getId()
    {
        return this.id;
    }

    public int getFloor()
    {
        return this.floor;
    }

    public String getBookingId()
    {
        return this.bookingId;
    }

    public boolean isReserved()
    {
        return bookingId != null;
    }
}
