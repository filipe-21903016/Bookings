import java.net.Socket;
import java.rmi.*;

public class HotelClient{
    public static void main(String args[]) {
        try {
            String serverURL = "rmi://" + args[0] + "/HotelServer";
            HotelServerIntf HotelServerIntf = (HotelServerIntf)Naming.lookup(serverURL);

            
            if (args[1].equals("list"))
            {
                String[] res = HotelServerIntf.listAvailableRooms();
                for (String room : res)
                    System.out.println(room);
            }
            else if (args[1].equals("book"))
            {
                System.out.println(HotelServerIntf.bookRoom(args[2], args[3], args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6])));
            }
            else if (args[1].equals("cancel"))
            {
                HotelServerIntf.cancelReservation(args[2]);
            }
			else if (args[1].equals("check"))
			{
//				String[] res = HotelServerIntf
			}
        }
        catch(Exception e){
            System.out.println("Exception:" + e);
        }
    }
}
