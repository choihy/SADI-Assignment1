package Player;

import java.io.*;
import java.net.*;
import java.util.*;

import Server.Command;
import Server.Server;

public class Player extends Thread
{
	private Socket connection;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private boolean inGame;
	private int playerNo, gamePoint, playerTurn;
	public static ArrayList<Card> player0Cards, player1Cards, player2Cards;
	
	public int getConnection(String username){
		String ip_address = "localhost"; //change to your preferred host.
			try {
				connection = new Socket(ip_address, Server.ip_port);
				System.out.println("Connected to server");
				
				outToServer = new ObjectOutputStream(connection.getOutputStream());
	            inFromServer = new ObjectInputStream(connection.getInputStream());
	            
	            outToServer.writeObject(username);
	            return (Integer)inFromServer.readObject();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			return Command.connectFail;
	}
	
	public void run(){
		inGame = false;
		playerNo = 0;
		gamePoint = 0;
		playerTurn = 0;
		player0Cards = new ArrayList<Card>();
		player1Cards = new ArrayList<Card>();
		player2Cards = new ArrayList<Card>();
		while(true){
			int command = receive();
			switch(command){
				case Command.observer:
				case Command.player1:
				case Command.player2:
					playerNo = command;
					inGame = true;
					break;
				case Command.win:
					gamePoint++;
					if(gamePoint >15){
						endGame();
					}else{
						nextTurn();
					}
					break;
				case Command.lose:
					gamePoint--;
					break;
				default :
					if (command<1000 && inGame){
						getCard(command);
					}
					break;
			}
		}
	}
	
	public void send(int command){
		try {
			outToServer.writeObject(command);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int receive(){
		try {
			return inFromServer.readInt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public void nextTurn(){
		player0Cards.clear();
		player1Cards.clear();
		player2Cards.clear();
		send(Command.start);
	}
	
	public void endGame(){
		inGame = false;
		playerNo = 0;
		gamePoint = 0;
		player0Cards.clear();
		player1Cards.clear();
		player2Cards.clear();
	}
	
	public void getCard(int card){
		
	}
}