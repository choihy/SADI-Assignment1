package Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Map.Entry;

public class PlayerThread extends Thread 
{
	private Socket player = null;
	private String playerName; 
	private ObjectOutputStream outToClient;
	private ObjectInputStream inFromClient;
	
			
	public PlayerThread(Socket sock)
	{
		super("PlayerThread");
		player = sock;
		try
		{
			outToClient = new ObjectOutputStream(player.getOutputStream());
			inFromClient = new ObjectInputStream(player.getInputStream());
			playerName = (String)inFromClient.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run()
	{
		int num;
		
		System.out.println("running.....");
		while((num = (Integer)receive()) != Command.stop)
		{
			System.out.println(num);
			switch(num)
			{
				case Command.join:
						Server.joinSessionRoom(playerName);
					break;
				case Command.send:
					String message = (String)receive();
					for (Entry<String, PlayerThread> item : Server.players.entrySet()) {
						  item.getValue().send(Command.send);
						  item.getValue().send(message);
						  System.out.println(item.getValue() + message);
					}
					
					break;
			}
		}
		Server.players.remove(playerName);
	}
	
	public void send(Object command)
	{
		try
		{
			outToClient.writeObject(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object receive()
	{
		try
		{
			return inFromClient.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return Command.stop;
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
}