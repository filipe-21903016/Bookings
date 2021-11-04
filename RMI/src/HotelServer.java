import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class HotelServer{

     public static Connection getDatabaseConnection(){
        String url = "jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_db405341fd982f3";
        try{
            Connection connection = DriverManager.getConnection(url, "b932fa382c97c4", "508d6c10");
            return connection;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String args[]){
        try{
            HotelServerImpl HotelServerImpl = new HotelServerImpl();
            Naming.rebind("HotelServer", HotelServerImpl);

            getDatabaseConnection();
        }catch(Exception exception){
            System.out.println("Exception:" + exception);
        }
    }
}