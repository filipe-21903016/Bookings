import java.net.Socket;
import java.rmi.*;

public class HotelClient{
    public static void main(String args[]) {
        try {
            String serverURL = "rmi://" + args[0] + "/HotelServer";
            HotelServerIntf HotelServerIntf = (HotelServerIntf)Naming.lookup(serverURL);

            String res = HotelServerIntf.ping(args[1]);
            System.out.println(res);
        }
        catch(Exception e){
            System.out.println("Exception:" + e);
        }
    }
}