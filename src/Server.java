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
				serv_socket = new ServerSocket(4413);
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
				if (player != null){
					String playerName = "test";
					// player.getInputStream();
					if (!players.containsKey(playerName)){
						PlayerThread t = new PlayerThread(player);
						players.put(playerName, t);
						t.start();
						//System.out.println(t.getId());
						System.out.println("ClientThread " + count++ + " Started ...");
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
