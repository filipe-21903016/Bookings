import java.util.ArrayList;

public static class Saves {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();

    public static getRooms()
    {
        return rooms;
    }

    public static getClients()
    {
        return clients;
    }

    public static getBookings()
    {
        return bookings;
    }

    public static boolean importClients()
    {
        return true;
    }

    public static boolean importsRooms()
    {
        return false;
    }

    public static boolean importBookings()
    {
        return true;
    }

    public static boolean importAll(){
        importClients();
        importRooms();
        importBookings();
    }

    public static resetAll(){
        rooms = new ArrayList<>();
        clients = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public static boolean saveClients()
    {

    };

    public static boolean saveRooms(){

    };

    public static boolean saveBookings(){
        
    }
}
