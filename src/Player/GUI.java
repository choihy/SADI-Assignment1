package Player;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GUI {

	static JFrame login, about, menu, game;
	static JButton about_button, login_button, create_button, join_button, observe_button, menuSend_button, call_button, pass_button;
	static JLabel  message_label, playerName_label;
	static JTextField username_text, selectedRoom_text, menuMessage_text;
	static JTextArea menuMessages_text;
	static Player player;
	static JPanel rooms_panel;
	
	public GUI(){
		JPanel login_top, login_bottom, menu_left, menu_right, menu_bottom;
		JScrollPane rooms_scrollPane, menuMessages_scrollPane;
		JLabel username_label;
		JTextArea about_text;
		
		// Login Frame
		login = new JFrame();
		login.setLayout(new BorderLayout());
		
		login_top = new JPanel();
		login_top.setLayout(new FlowLayout());
		login_top.setPreferredSize(new Dimension(240,160));
		
		about_button = new JButton();
		about_button.setPreferredSize(new Dimension(240,160));
		about_button.setIcon(new ImageIcon("images/21.jpg"));
		about_button.addActionListener(new doAction());
		
		login_top.add(about_button);
		login.add(login_top, BorderLayout.NORTH);
		
		login_bottom = new JPanel();
		login_bottom.setLayout(null);
		login_bottom.setPreferredSize(new Dimension(400,300));
		
		username_label = new JLabel("Player : ");
		username_label.setBounds(10, 10, 60, 30);
		
		username_text = new JTextField();
		username_text.setBounds(70, 10, 150, 30);
		
		login_button = new JButton("Login");
		login_button.setBounds(120, 40, 100, 30);
		login_button.addActionListener(new doAction());
		
		message_label = new JLabel();
		message_label.setForeground(Color.red);
		message_label.setBounds(10, 70, 200, 40);
		
		login_bottom.add(username_label);
		login_bottom.add(username_text);
		login_bottom.add(login_button);
		login_bottom.add(message_label);
		login.add(login_bottom, BorderLayout.CENTER);
		
		login.setVisible(true);
		login.setSize(250,300);
		login.setLocation(700,100);
		login.setBackground(Color.WHITE);
		login.setTitle("Game - Login");
		login.setResizable(false);
		
		
		//About Frame
		about = new JFrame();
		about.setLayout(new FlowLayout());
		
		about_text = new JTextArea(""+
			"Choi Hong Yaip - 1001R77487\n"+
			"Frainkie Chiew - 1001\n"
		);
		about_text.setFocusable(false);
		about_text.setBounds(10, 10, 200, 150);
		about.add(about_text);
		
		about.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		about.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                about.setVisible(false);
            }
        });
		about.setSize(300,200);
		about.setLocation(200,100);
		about.setBackground(Color.WHITE);
		about.setTitle("Game - About");
		about.setResizable(false);
		
		//Menu Frame
		menu = new JFrame();
		menu.setLayout(new BorderLayout());
		
		menu_right = new JPanel();
		menu_right.setLayout(null);
		menu_right.setPreferredSize(new Dimension(200, 200));
		menu_right.setBackground(Color.GRAY);
		
		create_button = new JButton("Create");
		create_button.setBounds(25, 55, 150, 40);
		create_button.addActionListener(new doAction());
		
		join_button = new JButton("Join");
		join_button.setBounds(25, 105, 150, 40);
		join_button.addActionListener(new doAction());
		
		observe_button = new JButton("Observe");
		observe_button.setBounds(25, 155, 150, 40);
		observe_button.addActionListener(new doAction());
		
		menu_right.add(create_button);
		menu_right.add(join_button);
		menu_right.add(observe_button);
		
		menu_left = new JPanel();
		menu_left.setLayout(new FlowLayout());
		menu_left.setPreferredSize(new Dimension(300,200));
		menu_left.setBackground(Color.WHITE);
		
		selectedRoom_text = new JTextField("Room :");
		selectedRoom_text.setEditable(false);
		selectedRoom_text.setPreferredSize(new Dimension(300,40));
		
		rooms_panel = new JPanel();
		rooms_panel.setLayout(new FlowLayout());
		rooms_panel.setPreferredSize(new Dimension(280,1000));
		
//		for(int i=0 ; i<20 ; i++){
//			JButton b = new JButton("( "+i+" )");
//			b.setPreferredSize(new Dimension(280,40));
//			b.addActionListener(new doAction());
//			rooms_panel.add(b);
//		}
		
		rooms_scrollPane = new JScrollPane(rooms_panel);
		rooms_scrollPane.setPreferredSize(new Dimension(300,230));
		
		menu_left.add(selectedRoom_text);
		menu_left.add(rooms_scrollPane);
		
		menu_bottom = new JPanel();
		menu_bottom.setLayout(null);
		menu_bottom.setPreferredSize(new Dimension(600,350));
		menu_bottom.setBackground(Color.LIGHT_GRAY);
		
//		String text ="" , temp ="";
//		for(int i=0 ; i<100 ; i++){
//			temp += ", "+i+"";
//		}
//		for(int i=0 ; i<100 ; i++){
//			text += temp+"\n";
//		}
//		
//		menuMessages_text = new JTextArea(text);
		menuMessages_text = new JTextArea();
		menuMessages_text.setEditable(false);
		
		menuMessages_scrollPane = new JScrollPane(menuMessages_text);
		menuMessages_scrollPane.setBounds(0, 0, 500, 250);
		
		playerName_label = new JLabel("Player :");
		playerName_label.setBounds(20, 250, 400, 30);
		
		menuMessage_text = new JTextField(40);
		menuMessage_text.setBounds(10, 280, 480, 30);
		
		menuSend_button = new JButton("Send");
		menuSend_button.setBounds(390, 310, 100, 30);
		menuSend_button.addActionListener(new doAction());
		
		menu_bottom.add(menuMessages_scrollPane);
		menu_bottom.add(playerName_label);
		menu_bottom.add(menuMessage_text);
		menu_bottom.add(menuSend_button);
		
		menu.add(menu_right, BorderLayout.WEST);
		menu.add(menu_left, BorderLayout.EAST);
		menu.add(menu_bottom, BorderLayout.SOUTH);
		
		menu.setVisible(false);
		menu.setSize(500,650);
		menu.setLocation(300,200);
		menu.setTitle("Game - Menu");
		menu.setResizable(false);
		
		// Game Frame
		game = new JFrame();
		JLabel background = new JLabel(new ImageIcon("images/table.png"));  
		game.add(background);
		background.setLayout(null);
		ImageIcon img = new ImageIcon("images/101.png");
		
		JLabel card2 = new JLabel(new ImageIcon("images/500.png"));
		card2.setBounds(600, 20, img.getIconWidth(), img.getIconHeight());
		background.add(card2);
		
		JLabel card = new JLabel(img);
		card.setBounds(250, 20, img.getIconWidth(), img.getIconHeight());

		JLabel card1 = new JLabel(new ImageIcon("images/102.png"));
		card1.setBounds(265, 20, img.getIconWidth(), img.getIconHeight());
		background.add(card1);
		background.add(card);
		

		JLabel card3 = new JLabel(new ImageIcon("images/106.png"));
		card3.setBounds(100, 420, img.getIconWidth(), img.getIconHeight());
		background.add(card3);

		JLabel card4 = new JLabel(new ImageIcon("images/107.png"));
		card4.setBounds(420, 420, img.getIconWidth(), img.getIconHeight());
		background.add(card4);
		
		game.setVisible(false);
		game.setSize(700,600);
		game.setLocation(300,200);
		game.setTitle("Game - room");
		game.setResizable(false);
//		for (float i=10 ; i<500 ;i+=0.00001){
//			card.setBounds((int) i, 10, img.getIconWidth(), img.getIconHeight());
//			game.repaint();
//		}
	}
	
	public static void main(String[] args){
		new GUI();
	}
	
	public static void giveCardTo(JLabel card, int player){
		
	}
}
