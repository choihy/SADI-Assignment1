import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread extends Thread 
{
	private Socket client = null;
			
	public ClientThread(Socket sock)
	{
		super("ClientThread");
		client = sock;
	}
			
	public void run()
	{
		//awaiting player send username.
	}

}