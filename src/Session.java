import java.util.ArrayList;


public class Session {

	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public Session(){
	}
	
	public void cards(){
		list.clear();
		for(int o=100; o<=400; o+=100){
			for (int n=1; n<=13; n++){
				list.add(o+n);
			}
		}
	}
	
	public void giveCard(Player p){
		int num = (int) Math.random() % list.size(); 
		p.getCard(list.get(num));
		list.remove(num);
	}
	
	public void start(){
		
	}
}
