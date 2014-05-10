import java.io.*;
import java.net.*;
public class Player
{
	private static final int ip_port = 4413;
	private Socket connection;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	
	public boolean getConnection(String username){
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
            	int commond = (Integer)inFromServer.readObject();
            	if (commond == Command.pass){
            		return true;
            	} else {
            		connection.close();
            		return false;
            	}
            }
		}
		catch (IOException e)
		{
			System.err.println(e);
			return false;
		}
	}
	
	public void getCard(int num){
		
	}
	
	public void waitingServerObj(){
		while(true){
			//get serverobject
			//identify object with command
			//call doaction function.
		}
	}
}