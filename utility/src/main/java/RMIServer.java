import java.rmi.Naming;

public class RMIServer {
	static String serverIp = "172.17.109.90";
	
	public static HotelServerIntf getConnection()
	{
		try {
			String serverURL = "rmi://" + serverIp + "/HotelServer";
			HotelServerIntf server = (HotelServerIntf)Naming.lookup(serverURL);
			return server;
		}catch(Exception e)
		{
			return null;
		}	
	}
}
