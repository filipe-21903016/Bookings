import java.rmi.*;

public interface HotelServerIntf extends Remote{
    public String ping();
    public String bookRoom(String uuid, String userId); //return reservation id
    public String[] listAvailableRooms(); //return list of rooms
    public boolean cancelReservation(String reservationId); //cancels booking
    public boolean registerUser(String email, String password); //register user
    public boolean loginUser(String email, String password); //login user
}