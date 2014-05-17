package Player;

import javax.swing.*;

public class Card extends JLabel{
	
	private int x, y;
	private int number;
	private ImageIcon image;
	
	public Card(int num){
		super(new ImageIcon("images/500.png"));
		image = new ImageIcon("images/"+num+".png");
		number = num%100;
	}
	
	public void setCoordinate(int X, int Y){
		this.setBounds(X, Y, image.getIconWidth(), image.getIconHeight());
	}
	
	public void show(){
		this.setIcon(image);
	}
	
	public int getNumber(){
		return number;
	}
}
