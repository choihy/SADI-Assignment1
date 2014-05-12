import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
	
	private Map<String, PlayerThread> players = new HashMap<String, PlayerThread>();
	private int count = 1;
	
	public static void main(String[] arguments)
	{
		new Server();
	}
   
	public Server()
	{
		  ServerSocket serv_socket = null;
		  try
		  {
				serv_socket = new ServerSocket(4430);
				System.out.println("Blackjack up and running ...");
		  }
		  catch (Exception e) {
				System.err.println(e);
				System.exit(1);
		  }
		  
		  while (true)
		  {
			try
			{
				Socket player = serv_socket.accept();
				System.out.println("Socket Extablished...");
				
				ObjectOutputStream outToClient = new ObjectOutputStream(player.getOutputStream());
	            ObjectInputStream inFromClient = new ObjectInputStream(player.getInputStream());
	            
				if (player != null){
					String playerName;
					try {
						playerName = (String)inFromClient.readObject();
						if (!players.containsKey(playerName)){
							PlayerThread t = new PlayerThread(player);
							players.put(playerName, t);
							t.start();
							System.out.println("ClientThread " + count++ + " Started ...");
							outToClient.writeObject(Command.pass);
						} else {
							outToClient.writeObject(Command.nameTaken);
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// return error message 
			}
			 catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			 }
		  }
	}
}
