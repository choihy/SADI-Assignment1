import java.io.*;
import java.net.*;
import java.util.*;

public class Player
{
	private static final int ip_port = 4413;
	
	public void getConnection(String username){
		Socket          socket;
		String          ip_address;
			
		ip_address = "localhost"; //change to your preferred host.
			
		try
		{
			socket = new Socket(ip_address, ip_port);
			System.out.println("Connected to server");
			
			//send username to server.
			// get server response
			
			
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
	
	public void getCard(int num){
		
	}
}