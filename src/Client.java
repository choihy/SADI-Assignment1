import java.io.*;
import java.net.*;
import java.util.*;
public class Client
{
	private static final int ip_port = 4413;
   
	public static void main(String[] args)
	{
		Socket          socket;
		String          ip_address;
			
		ip_address = "localhost"; //change to your preferred host.
			
		try
		{
			socket = new Socket(ip_address, ip_port);
			System.out.println("Connected to server");
			
			//send username to server.
			
			while(true)
			{
			}
			//socket.close();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
   }
}