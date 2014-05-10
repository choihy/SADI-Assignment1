import java.io.*;
import java.net.*;
import java.util.*;

public class PlayerThread extends Thread 
{
	private Socket player = null;
			
	public PlayerThread(Socket sock)
	{
		super("PlayerThread");
		player = sock;
	}
			
	public void run()
	{
		//awaiting player send username.
	}

}