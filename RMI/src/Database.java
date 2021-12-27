import javax.xml.crypto.Data;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    private static HashMap<Integer, Room> rooms = importRooms();
    private static HashMap<String, Client> clients = importClients();
    private static HashMap<String, Booking> bookings = importBookings();

    public static ArrayList<Room> getRooms()
    {
        return (ArrayList<Room>) rooms.values();
    }

    public static ArrayList<Client> getClients()
    {
        return (ArrayList<Client>) clients.values();
    }

    public static ArrayList<Booking> getBookings()
    {
        return (ArrayList<Booking>) bookings.values();
    }

    public static HashMap<String, Client> importClients()
    {
        HashMap<String, Client> clients = new HashMap<>();
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("../saves/clients.csv"));
            while ((line = br.readLine()) != null) {
                if(!line.equals(Client.getFileHeader()))
                {
                    String[] data = line.split(",");
                    clients.put(data[0], new Client(data[0], Client.hashPassword(data[1])));
                }
            }
            br.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return clients;
    }

    public static HashMap<Integer, Room> importRooms()
    {
        HashMap<Integer, Room> rooms = new HashMap<>();
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("../saves/rooms.csv"));
            while ((line = br.readLine()) != null) {
                if(!line.equals(Room.getFileHeader()))
                {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    int floor = Integer.parseInt(data[1]);
                    int capacity = Integer.parseInt(data[2]);
                    rooms.put(id , new Room(id, floor, capacity));
                }
            }
            br.close();
        }catch (IOException e)
        {
            System.out.println(e);
        }
        return rooms;
    }

    public static HashMap<String, Booking> importBookings()
    {
        HashMap<String, Booking> bookings = new HashMap<>();
        try{
            String line;
            BufferedReader br = new BufferedReader(new FileReader("../saves/bookings.csv"));
            while ((line = br.readLine()) != null) {
                if(!line.equals(Booking.getFileHeader()))
                {
                    String[] data = line.split(",");
                    String id = data[0];
                    LocalDate checkInDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/MM/yyyy"));
                    LocalDate checkOutDate = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("d/MM/yyyy"));
                    String clientId = data[3];
                    int numberOfPeople = Integer.parseInt(data[4]);
                    int roomId = Integer.parseInt(data[5]);

                    Booking booking = new Booking(id, checkInDate, checkOutDate, clientId, numberOfPeople, roomId);
                    bookings.put(id, booking);
                }
            }
            br.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }

        return bookings;
    }

    public static void resetAll(){
        rooms = new HashMap<>();
        clients = new HashMap<>();
        bookings = new HashMap<>();
    }

    public static boolean saveClients()
    {
       try{
           FileWriter fileWriter = new FileWriter("../saves/clients.csv");
           fileWriter.write(Client.getFileHeader() + "\n");
           for (Client client: clients.values())
           {
               fileWriter.write(client.toString() + "\n");
           }
           fileWriter.close();
           return true;
       }catch (Exception e)
       {
           System.out.println(e);
           return false;
       }
    }
    public static boolean saveBookings(){
        try{
            FileWriter fileWriter = new FileWriter("../saves/bookings.csv");
            fileWriter.write(Booking.getFileHeader() + "\n");
            for (Booking booking: bookings.values())
            {
                fileWriter.write(booking.toString() + "\n");
            }
            fileWriter.close();
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public static boolean registerClient(String email, String password){
        if (clients.containsKey(email))
        {
            return false;
        }
        Client client = new Client(email, Client.hashPassword(password));
        clients.put(client.getEmail(), client);
        saveClients();
        return true;
    }


	private static boolean roomIsFree(LocalDate in, LocalDate out, LocalDate in2, LocalDate out2)
	{
		return in.isAfter(out2) || out.isBefore(in2);
	}

    public static String registerBooking(String checkInDate, String checkOutDate
            , String clientEmail, int numberOfPeople, int roomId)
    {
        if (rooms.get(roomId).getCapacity() < numberOfPeople)
            return null;

        for (Booking booking: bookings.values())
        {
            if (booking.getRoomId() == roomId) {
                LocalDate in = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
                LocalDate out = LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
                LocalDate in2 = booking.getCheckInDate();
                LocalDate out2 = booking.getCheckOutDate();
				
				if (!roomIsFree(in, out, in2, out2))
					return null;
            }
        }

        Booking booking = new Booking(
                LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("d/MM/yyyy"))
                , LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("d/MM/yyyy"))
                , clientEmail
                , numberOfPeople
                , roomId);
        bookings.put(booking.getId(),booking);
        saveBookings();
        return booking.getId();
    }

    public static boolean cancelBooking(String reservationId)
    {
        if (bookings.containsKey(reservationId))
        {
            bookings.remove(reservationId);
            saveBookings();
            return true;
        }
        return false;
    }

	public static String[] getBookingsByEmail(String email)
	{
		ArrayList<String> bookingIds = new ArrayList<>();

		for (Booking booking: bookings.values())
		{
			if (booking.getClientEmail().equals(email))
				bookingIds.add(booking.getId());
		}
		return bookingIds.stream().toArray(String[]::new);
	}

    public static Client getClientByEmail(String email)
    {
        return clients.get(email);
    }

    public static void printClients(){
        clients.values().forEach(System.out::println);
    }

    public static void printBookings()
    {
        bookings.values().forEach(System.out::println);
    }

    public static void printRooms(){
        rooms.values().forEach(System.out::println);
    }

	public static String getReservationDetails(String id)
	{
		if (!bookings.containsKey(id))
			return null;
		Booking booking = bookings.get(id);
		return booking.getCheckInDate() + ","
			+ booking.getCheckOutDate() + ","
			+ booking.getRoomId();
	}

    public static String[] listAvailableRooms(String checkInDate, String checkOutDate)
    {
		List<Integer> occupiedRooms = new ArrayList<>();

		for (Booking booking : bookings.values())
		{
			LocalDate in = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
			LocalDate out = LocalDate.parse(checkOutDate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
			LocalDate in2 = booking.getCheckInDate();
			LocalDate out2 = booking.getCheckOutDate();
			if (!roomIsFree(in, out, in2, out2))
				occupiedRooms.add(booking.getRoomId());
		}
        List<Integer> roomIds = rooms.values().stream().map(Room::getId).collect(Collectors.toList());
        return (roomIds.stream().filter(id -> !occupiedRooms.contains(id)).map(Object::toString).toArray(String[]::new));
    }
	
	public static String getFloorAndCapacity(int roomId)
	{
		int capacity = rooms.get(roomId).getCapacity();
		int floor = rooms.get(roomId).getFloor();
		return capacity + "," + floor;
	}

}
