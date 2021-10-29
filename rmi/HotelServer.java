import java.rmi.*;
import java.security.spec.ECGenParameterSpec;
import java.net.*;

public class HotelServer{
    public static void main(String args[]){
        try{
            HotelServerImpl HotelServerImpl = new HotelServerImpl();
            Naming.rebind("HotelServer", HotelServerImpl);
        }catch(Exception exception){
            System.out.println("Exception:" + exception);
        }
    }
}