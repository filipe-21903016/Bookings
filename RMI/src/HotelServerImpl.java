import javax.xml.crypto.Data;
import java.rmi.*;
import java.rmi.server.*;

public class HotelServerImpl extends UnicastRemoteObject implements HotelServerIntf {

    public HotelServerImpl() throws RemoteException {
    }

    public String ping() throws RemoteException{
        return "Pong!";
    }
  
    //return reservation id
    public String bookRoom(String checkInDate, String checkOutDate
            , String clientEmail, int numberOfPeople, int roomId) throws RemoteException{
        return Database.registerBooking(checkInDate,checkOutDate,clientEmail,numberOfPeople,roomId);
    }

    //return list of rooms
    public String[] listAvailableRooms(String checkInDate, String checkOutDate) throws RemoteException{
        return Database.listAvailableRooms(checkInDate, checkOutDate);
    }

    public boolean cancelReservation(String reservationId) throws RemoteException
    {
        return Database.cancelBooking(reservationId);
    }

    public boolean registerUser(String email, String password) throws RemoteException{
        return Database.registerClient(email,password);
    }

    public boolean loginUser(String email, String password) throws RemoteException{
        Client client = Database.getClientByEmail(email);
        return client.authenticate(password);
    }

	public String[] bookingsByUser(String email) throws RemoteException{
		return Database.getBookingsByEmail(email);
	}
	
	public String reservationDetails(String id) throws RemoteException
	{
		return Database.getReservationDetails(id);
	}

	public String getFloorAndCapacity(int roomId) throws RemoteException
	{
		return Database.getFloorAndCapacity(roomId);
	}
}

