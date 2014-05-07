import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
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
				ClientThread t = new ClientThread(serv_socket.accept());
				t.start();
				//System.out.println(t.getId());
				System.out.println("ClientThread " + count++ + " Started ...");

			}
			 catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			 }
		  }
	}
	
	/*
	class ClientThread extends Thread 
	{
		private Socket client = null;
			
		public ClientThread(Socket sock)
		{
			super("ClientThread");
			client = sock;
		}
			
		public void run()
		{
			
		}
	}
	*/
}
