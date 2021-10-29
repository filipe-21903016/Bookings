import java.rmi.*;
import java.rmi.server.*;

public class HotelServerImpl extends UnicastRemoteObject implements HotelServerIntf {

  public HotelServerImpl() throws RemoteException {
  }

    public String ping(){
        return "Pong!";
    }
  
    //return reservation id
    public String bookRoom(String uuid, String userId){
        
        return null;
    }

    //return list of rooms
    public String[] listAvailableRooms(){
        return null;
    }
    
    
    public boolean cancelReservation(String reservationId)
    {
        return false;
    }

    public boolean registerUser(String email, String password){
        return false;
    }

    public boolean loginUser(String email, String password){
        return false;
    }

}

