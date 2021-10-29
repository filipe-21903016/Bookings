import java.rmi.*;

public interface HotelServerIntf extends Remote{
    public String bookRoom(String uuid, String userId); //return reservation id
    public String[] listAvailableRooms(); //return list of rooms
    public boolean cancelReservation(String reservationId);
    public boolean registerUser(String email, String password);
}