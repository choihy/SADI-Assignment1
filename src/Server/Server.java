package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
	static ArrayList<Session> session_room = new ArrayList<Session>();
	static Session room;
	private Map<String, PlayerThread> playersName = new HashMap<String, PlayerThread>();
	private int count = 1;
	
	public static void main(String[] arguments)
	{
		new Server();
	}
   
	public Server()
	{
		  ServerSocket serv_socket = null;
		  room = null;
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
				if (player != null){
					PlayerThread pt = new PlayerThread(player);
					String playerName = pt.getPlayerName();
					if (!playersName.containsKey(playerName)){
						pt.start();
						playersName.put(playerName, pt);
						pt.send(Command.connectSuccess);
						System.out.println("PlayerThread " + count++ + " Started ...");
					}else{
						pt.send(Command.nameTaken);
					}
				}
			}
			 catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			 }
		  }
	}
}
