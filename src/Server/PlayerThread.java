package Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

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
		try {
			outToClient = new ObjectOutputStream(player.getOutputStream());
			inFromClient = new ObjectInputStream(player.getInputStream());
			playerName = (String)inFromClient.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run()
	{
		while(player.isConnected()){
			switch(receive()){
				case Command.join:
						Server.joinSessionRoom(playerName);
					break;
			}
		}
	}
	
	public void send(int command){
		try {
			outToClient.writeObject(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int receive(){
		try {
			return inFromClient.readInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getPlayerName(){
		return playerName;
	}
}