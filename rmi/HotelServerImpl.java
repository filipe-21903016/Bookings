import java.rmi.*;
import java.rmi.server.*;

public class HotelServerImpl extends UnicastRemoteObject implements HotelServerIntf {

    public HotelServerImpl() throws RemoteException {
    }

    public String ping(String msg) throws RemoteException{
        return "Pong!";
    }
  
    //return reservation id
    public String bookRoom(String uuid, String userId) throws RemoteException{
        
        return null;
    }

    //return list of rooms
    public String[] listAvailableRooms() throws RemoteException{
        return null;
    }
    
    
    public boolean cancelReservation(String reservationId) throws RemoteException
    {
        return false;
    }

    public boolean registerUser(String email, String password) throws RemoteException{
        return false;
    }

    public boolean loginUser(String email, String password) throws RemoteException{
        return false;
    }

}

