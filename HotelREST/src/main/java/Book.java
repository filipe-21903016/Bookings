import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
public class Book {
	private String checkInDate;
	private String checkOutDate;
	private String clientEmail;
	private int numberOfPeople;
	private int roomId;
	private String id;
	
	public String getId()
	{
		return this.id;
	}
	
	public String getCheckInDate()
	{
		return this.checkInDate;
	}
	
	public String getCheckOutDate()
	{
		return this.checkOutDate;
	}
	
	public String getClientEmail()
	{
		return this.clientEmail;
	}
	
	public int getNumberOfPeople()
	{
		return this.numberOfPeople;
	}
	
	public int getRoomId()
	{
		return this.roomId;
	}
	
	//setters
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	public void setCheckOutDate(String checkOutDate)
	{
		this.checkOutDate = checkOutDate;
	}
	
	public void setClientEmail(String clientEmail)
	{
		this.clientEmail = clientEmail;
	}
	
	public void setNumberOfPeople(int numberOfPeople)
	{
		this.numberOfPeople = numberOfPeople;
	}
	
	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}
	
}
