import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;

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