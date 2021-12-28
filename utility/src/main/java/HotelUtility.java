import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;


@WebService(targetNamespace = "http://utility.hotel.com/", portName = "HotelUtilityPort", serviceName = "HotelUtilityService")
public class HotelUtility {
	
	public String[] listRooms(String date1, String date2){
		try {
            HotelServerIntf server = RMIServer.getConnection();
            String[] res = server.listAvailableRooms(date1, date2);
        	return res;
        }
        catch(Exception e){
            System.out.println("Exception:" + e);
            return null;
        }
	}
	
	public String bookRoom(String inDate, String outDate, String clientEmail, int numberOfPeople, int roomId)
	{
		String reservationId = null;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			reservationId = server.bookRoom(inDate, outDate, clientEmail, numberOfPeople, roomId);
			return reservationId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getRoomFloorAndCapacity(int roomId)
	{
		String response;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response = server.getFloorAndCapacity(roomId);
			String[] data = response.split(",");
			return data[0] + "," + data[1];
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public boolean cancelReservation(String reservationId)
	{
		try {
			HotelServerIntf server = RMIServer.getConnection();
			boolean res = server.cancelReservation(reservationId);
			return res;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean registerUser(String email, String password)
	{
		boolean response;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response  = server.registerUser(email, password);
			return response;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean loginUser(String email, String password)
	{
		boolean response;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response  = server.loginUser(email, password);
			return response;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public List<String> bookingsByEmail(String email)
	{
		try {
			HotelServerIntf server = RMIServer.getConnection();
			String[] reservationIds = server.bookingsByUser(email);
			List<String> details  = new ArrayList<>();
			for (String id: reservationIds)
			{
				String response = server.reservationDetails(id);
				details.add(response + "," + id);
			}
			return details;
		}catch(Exception e)
		{
			return null;
		}
	}	
}
