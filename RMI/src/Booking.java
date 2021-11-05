import java.time.LocalDate;
import java.util.UUID;

public class Booking {
    private String id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String clientId;

    public Booking(LocalDate checkInDate, LocalDate checkOutDate, String clientId)
    {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.clientId = clientId;
        this.id = UUID.randomUUID().toString();
    }

    public int getId()
    {
        return this.id;
    }

    public String getClientId(){
        return this.clientId;
    }

    public LocalDate getCheckInDate()
    {
        return this.checkInDate;
    }

    public LocalDate getCheckOutDate()
    {
        return this.checkOutDate;
    }
}
