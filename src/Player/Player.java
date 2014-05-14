package Player;

import java.io.*;
import java.net.*;
import java.util.*;
import Server.Command;

public class Player
{
	private static final int ip_port = 4413;
	private Socket connection;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	
	public int getConnection(String username){
		Socket          socket;
		String          ip_address;
			
		ip_address = "localhost"; //change to your preferred host.
			
		try
		{
			connection = new Socket(ip_address, ip_port);
			System.out.println("Connected to server");
			
			outToServer = new ObjectOutputStream(connection.getOutputStream());
            inFromServer = new ObjectInputStream(connection.getInputStream());
            outToServer.writeObject(username);
            while(true){
				try {
					return inFromServer.readInt();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		return 0;
	}
	
	public void waitingServerObj(){
		while(true){
			//get serverobject
			//identify object with command
			//call doaction function.
		}
	}
}