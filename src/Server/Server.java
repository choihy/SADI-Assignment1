package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
	public static final int ip_port = 8071;
	static ArrayList<Session> session_room = new ArrayList<Session>();
	static String player1, player2;
	static Map<String, PlayerThread> players = new HashMap<String, PlayerThread>();
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
				serv_socket = new ServerSocket(ip_port);
				System.out.println("Blackjack server up and running ...");
		  } catch (Exception e) {
				System.err.println(e);
				System.exit(1);
		  }
		  
		  while (true)
		  {
			try
			{
				Socket player = serv_socket.accept();
				System.out.println("Socket Extablished...");
				if (player != null)
				{
					PlayerThread pt = new PlayerThread(player);
					String playerName = pt.getPlayerName();
					if (!players.containsKey(playerName))
					{
						players.put(playerName, pt);
						pt.send(Command.connectSuccess);
						System.out.println(playerName+" : PlayerThread " + count++ + " Started ...");
						pt.start();
					} else {
						pt.send(Command.nameTaken);
					}
				}
			} catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			 }
		  }
	}
	
	public static void joinSessionRoom(String name)
	{
		if (player1 != null)
		{
			player2 = name;
		} else if (player1 != null && player2 != null) {
			Session session = new Session(players.get(player1), players.get(player2));
			session.start();
			session_room.add(session);
			player1 = null;
			player2 = null;
		} else {
			player1 = name;
		}
	}
}
