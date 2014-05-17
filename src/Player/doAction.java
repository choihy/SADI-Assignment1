package Player;

import java.awt.event.*;

import Server.Command;

public class doAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == GUI.about_button){
			GUI.about.setVisible(true);
		} else if (source == GUI.login_button){
			String name = GUI.username_text.getText();
			GUI.player = new Player();
			switch(GUI.player.getConnection(name)){
				case Command.connectSuccess:
					GUI.login.dispose();
					GUI.about.dispose();
					GUI.playerName_label.setText(name+" : ");
					GUI.menu.setVisible(true);
					break;
				case Command.nameTaken:
					GUI.message_label.setText("The name : ("+name+")is already in use.");
					break;
				case Command.connectFail:
					GUI.message_label.setText("Connection Fail.");
					break;
			}
		} else if (source == GUI.create_button){
			GUI.player.send(Command.create);
		} else if (source == GUI.join_button){
			GUI.player.send(Command.join);
		} else if (source == GUI.menuSend_button){
			GUI.player.send(Command.send);
			String message = GUI.playerName_label.getText()+""+GUI.menuMessage_text.getText() + "\n";
			GUI.menuMessages_text.append(message);
		} else if (source == GUI.observe_button){
			GUI.player.send(Command.observe);
			
		}
	}
}
