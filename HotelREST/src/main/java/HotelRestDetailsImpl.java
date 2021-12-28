
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

@Consumes("application/json")
@Produces("application/json")
@WebService(targetNamespace = "http://hotel.com/", portName = "HotelRestDetailsImplPort", serviceName = "HotelRestDetailsImplService")
public class HotelRestDetailsImpl implements HotelRestDetails {
	
	
	@POST
	@Path("/book")
	public String bookRoom(Book book)
	{
		String reservationId = null;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			
			System.out.println(book.getCheckInDate());
			System.out.println(book.getCheckOutDate());
			System.out.println(book.getClientEmail());
			System.out.println(book.getNumberOfPeople());
			System.out.println(book.getRoomId());
			reservationId = server.bookRoom(book.getCheckInDate(), book.getCheckOutDate(), book.getClientEmail(), book.getNumberOfPeople(), book.getRoomId());
			System.out.println(reservationId);
			return "{\"id\":\"" + reservationId + "\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/rooms")
	public String listAvailableRooms(@QueryParam("checkInDate") String checkInDate, @QueryParam("checkOutDate") String checkOutDate)
	{
		String[] rooms;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			rooms = server.listAvailableRooms(checkInDate, checkOutDate);	
			JSONArray json = new JSONArray(new ArrayList<String>(Arrays.asList(rooms)));
			return json.toString();
		}catch(Exception e)
		{
			return null;
		}
	}
	
	
	@GET
	@Path("/room")
	public String getRoomFloorAndCapacity(@QueryParam("roomId") int roomId)
	{
		String response;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response = server.getFloorAndCapacity(roomId);
			String[] data = response.split(",");
			JSONObject jsonObject = new JSONObject("{\"capacity\":"+Integer.parseInt(data[0])+",\"floor\":"+Integer.parseInt(data[1])+"}");
			return jsonObject.toString();
		}catch(Exception e)
		{
			return null;
		}
	}
	
	@POST
	@Path("/cancel")
	public String cancelReservation(Book book)
	{
		try {
			HotelServerIntf server = RMIServer.getConnection();
			boolean res = server.cancelReservation(book.getId());
			System.out.println("Reservation Canceled: " + res);
			return "{\"response\":\"" + res + "\"}";
		}catch(Exception e)
		{
			return "{\"response\":\"false\"}";
		}
	}
	
	@POST
	@Path("/register")
	public String registerUser(Client client)
	{
		boolean response;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response  = server.registerUser(client.getEmail(), client.getPassword());
			System.out.println("Registered: " + response);
			return "{\"response\":\"" + response + "\"}";
		}catch(Exception e)
		{
			return "{\"response\":\"false\"}";
		}
	}
	
	@POST
	@Path("/login")
	public String loginUser(Client client)
	{
		boolean response;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response  = server.loginUser(client.getEmail(), client.getPassword());
			System.out.println("Login Sucessful: " + response);
			return "{\"response\":\"" + response + "\"}";
		}catch(Exception e)
		{
			return "{\"response\":\"false\"}";
		}
	}
	
	
	@POST
	@Path("/books")
	public String booksByEmail(Client client)
	{
		try {
			HotelServerIntf server = RMIServer.getConnection();
			String[] reservationIds = server.bookingsByUser(client.getEmail());
			List<JSONObject> details  = new ArrayList<>();
			for (String id: reservationIds)
			{
				String response = server.reservationDetails(id);
				String[] data = response.split(",");
				details.add(new JSONObject("{\"checkInDate\":\"" + data[0].trim()
						+ "\",\"checkOutDate\":\"" + data[1].trim() 
						+ "\",\"roomId\":"+ Integer.parseInt(data[2].trim())
						+",\"id\":\""+ id +"\"}"));
			}
			JSONArray json = new JSONArray(details);
			return json.toString();
		}catch(Exception e)
		{
			return null;
		}
	}
	
	@POST
	@Path("/pong")
	public Message pong(Message msg)
	{
		System.out.println(msg.getFrom() + " : " + msg.getMessage());
		return msg;
	}
	
	
	@GET
	  @Path("/ping")
	  public String ping()
	  {
		String response = null;
		try {
			HotelServerIntf server = RMIServer.getConnection();
			response = server.ping();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	  }
	
}
