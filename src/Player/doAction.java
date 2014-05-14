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
			GUI.p = new Player();
			switch(GUI.p.getConnection(GUI.username_text.getText())){
				case Command.connectSuccess:
					GUI.login.dispose();
					GUI.about.dispose();
					GUI.game.setVisible(true);
					GUI.game.setTitle("Game - Room No .");
					GUI.p.waitingServerObj();
					break;
			}
		}
	}
}
