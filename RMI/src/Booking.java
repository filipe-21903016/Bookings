import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Booking {
    private String id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String clientEmail;
    private int numberOfPeople;
    private int roomId;
    private static String fileHeader = "id,checkInDate,checkOutDate,clientEmail,numberOfPeople,roomId";

    public Booking(LocalDate checkInDate, LocalDate checkOutDate, String clientEmail, int numberOfPeople)
    {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.clientEmail = clientEmail;
        this.numberOfPeople = numberOfPeople;
        this.id = UUID.randomUUID().toString();
    }

    public Booking(String id, LocalDate checkInDate, LocalDate checkOutDate, String clientEmail, int numberOfPeople, int roomId) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.clientEmail = clientEmail;
        this.numberOfPeople = numberOfPeople;
        this.roomId = roomId;
    }

    public Booking(LocalDate checkInDate, LocalDate checkOutDate, String clientEmail, int numberOfPeople, int roomId) {
        this.id = UUID.randomUUID().toString();
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.clientEmail = clientEmail;
        this.numberOfPeople = numberOfPeople;
        this.roomId = roomId;
    }

    public String getId()
    {
        return this.id;
    }

    public String getClientEmail(){
        return this.clientEmail;
    }

    public LocalDate getCheckInDate()
    {
        return this.checkInDate;
    }

    public LocalDate getCheckOutDate()
    {
        return this.checkOutDate;
    }

    public static String getFileHeader() {
        return fileHeader;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        return id + "," + checkInDate.format(formatter) + "," + checkOutDate.format(formatter) + "," + clientEmail
                + "," + numberOfPeople + (roomId != -1 ? "," + roomId : "");
    }


}
