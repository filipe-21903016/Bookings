import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Message")
public class Message {
	private String from;
	private String message;
	
	
	//setters
	public void setFrom(String from)
	{
		this.from = from;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	//getters
	
	public String getMessage()
	{
		return this.message;
	}
	
	public String getFrom()
	{
		return this.from;
	}
}
