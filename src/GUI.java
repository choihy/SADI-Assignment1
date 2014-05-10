
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GUI {

	static JFrame login, about, game;
	static JButton about_button, login_button;
	static JLabel  message_label;
	
	public GUI(){
		JPanel login_top, login_bottom, waiting;
		JLabel username_label, waiting_label;
		JTextField username_text;
		JTextArea about_text;
		
		// Login Frame
		login = new JFrame();
		login.setLayout(new BorderLayout());
		
		login_top = new JPanel();
		login_top.setLayout(new FlowLayout());
		login_top.setPreferredSize(new Dimension(240,160));
		login.add(login_top, BorderLayout.NORTH);
		
		about_button = new JButton();
		about_button.setPreferredSize(new Dimension(140,160));
		about_button.setIcon(new ImageIcon("images/21.jpg"));
		about_button.addActionListener(new doAction());
		login_top.add(about_button);
		
		login_bottom = new JPanel();
		login_bottom.setLayout(null);
		login_bottom.setPreferredSize(new Dimension(400,300));
		login.add(login_bottom, BorderLayout.CENTER);
		
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
		
		login.setVisible(true);
		login.setSize(250,300);
		login.setLocation(700,100);
		login.setBackground(Color.WHITE);
		login.setTitle("Game - Login");
		
		
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
		
		//Game Frame
		game = new JFrame();
		
		game.setVisible(true);
		game.setSize(400,400);
		game.setLocation(300,200);
	}
	
	public static void main(String[] args){
		new GUI();
	}
}
