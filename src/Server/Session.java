package Server;
import java.util.ArrayList;

import Player.Player;


public class Session {

	private ArrayList<Integer> list = new ArrayList<Integer>();
	private ArrayList<PlayerThread> players = new ArrayList<PlayerThread>();
	private int turn;
	
	public Session(PlayerThread p1 , PlayerThread p2){
		players.add(p1);
		players.add(p2);
		turn = 0;
	}
	
	public void addObsever(PlayerThread p){
		players.add(p);
	}
	
	public void cards(){
		list.clear();
		for(int o=100; o<=400; o+=100){
			for (int n=1; n<=13; n++){
				list.add(o+n);
			}
		}
	}
	
	public void giveCard(PlayerThread p){
		int num = (int) Math.random() % list.size();
		for(int i=0; i<players.size(); i++){
			players.get(i);
		}
		list.remove(num);
	}
	
	public void start(){
		
	}
}
