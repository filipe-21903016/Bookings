public class Room {
    private int id;
    private int floor;
    private int capacity;
    private static String fileHeader = "id,floor,capacity";

    public Room(int id, int floor,int capacity){
        this.id = id;
        this.floor = floor;
        this.capacity = capacity;
    }

    public int getId()
    {
        return this.id;
    }

    public int getFloor()
    {
        return this.floor;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public static String getFileHeader() {
        return fileHeader;
    }

    @Override
    public String toString() {
        return id + "," + floor + "," + capacity;
    }
}
